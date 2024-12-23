package med.voll.api.domain.doctor;

import med.voll.api.domain.address.Address;

public record DoctorDetailsData(
        Long id,
        String name,
        String email,
        String phone,
        String crm,
        Speciality speciality,
        Address address
) {

    public DoctorDetailsData(Doctor doctor) {
        this(
            doctor.getId(),
            doctor.getName(),
            doctor.getEmail(),
            doctor.getPhone(),
            doctor.getCrm(),
            doctor.getSpeciality(),
            doctor.getAddress()
        );
    }
}
