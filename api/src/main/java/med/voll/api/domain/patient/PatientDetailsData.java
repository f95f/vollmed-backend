package med.voll.api.domain.patient;

import med.voll.api.domain.address.Address;

public record PatientDetailsData(
        Long id,
        String name,
        String email,
        String phone,
        String cpf,
        Address address
) {

    public PatientDetailsData(Patient patient) {
        this(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getCpf(),
                patient.getAddress()
        );
    }
}