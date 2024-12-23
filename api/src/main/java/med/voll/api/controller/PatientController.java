package med.voll.api.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @Autowired
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<PatientDetailsData> createPatient(
            @RequestBody @Valid PatientCreatingData request,
            UriComponentsBuilder uriBuilder) {

        Patient patient = new Patient(request);
        repository.save(patient);
        URI uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new PatientDetailsData(patient));
    }


    @GetMapping
    public ResponseEntity<Page<PatientListingData>> listPatients(
            @PageableDefault(size = 10, sort = {"name"}) Pageable page) {

        Page<PatientListingData> pagedPatientList = repository
                .findAllByActiveTrue(page)
                .map(PatientListingData::new);

        return ResponseEntity.ok(pagedPatientList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        return ResponseEntity.ok(patient);
    }


    @PutMapping
    @Transactional
    public ResponseEntity<PatientDetailsData> updatePatient(@RequestBody @Valid PatientUpdatingData request){
        Patient patient = repository.findById(request.id()).get();
        patient.updatePatientData(request);

        return ResponseEntity.ok(new PatientDetailsData(patient));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        Patient patient = repository.findById(id).get();
        patient.deactivate();

        return ResponseEntity.noContent().build();
    }

}
