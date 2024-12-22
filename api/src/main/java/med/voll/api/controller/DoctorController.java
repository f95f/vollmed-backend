package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorCreatingData;
import med.voll.api.doctor.DoctorListingData;
import med.voll.api.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void createDoctor(@RequestBody @Valid DoctorCreatingData request) {
        repository.save(new Doctor(request));
    }

    @GetMapping
    public Page<DoctorListingData> listDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {
        return repository
                .findAll(page)
                .map(DoctorListingData::new);
    }


}
