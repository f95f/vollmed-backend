package med.voll.api.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<DoctorDetailsData> createDoctor(@RequestBody @Valid DoctorCreatingData request, UriComponentsBuilder uriBuilder) {
        Doctor doctor = new Doctor(request);
        repository.save(doctor);
        URI uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DoctorDetailsData(doctor));
    }


    @GetMapping
    public ResponseEntity<Page<DoctorListingData>> listDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {
        Page<DoctorListingData> pagedDoctorList = repository
                                                    .findAllByActiveTrue(page)
                                                    .map(DoctorListingData::new);

        return ResponseEntity.ok(pagedDoctorList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        return ResponseEntity.ok(doctor);
    }


    @PutMapping
    @Transactional
    public ResponseEntity<DoctorDetailsData> updateDoctor(@RequestBody @Valid DoctorUpdatingData request){
        Doctor doctor = repository.findById(request.id()).get();
        doctor.updateDoctorData(request);

        return ResponseEntity.ok(new DoctorDetailsData(doctor));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        Doctor doctor = repository.findById(id).get();
        doctor.deactivate();

        return ResponseEntity.noContent().build();
    }
}
