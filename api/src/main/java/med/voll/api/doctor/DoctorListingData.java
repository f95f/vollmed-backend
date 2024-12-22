package med.voll.api.doctor;

public record DoctorListingData(
        Long id,
        String name,
        String email,
        String crm,
        Speciality speciality
) {

    public DoctorListingData(Doctor doctor) {
        this(
            doctor.getId(),
            doctor.getName(),
            doctor.getEmail(),
            doctor.getCrm(),
            doctor.getSpeciality()
        );
    }

}