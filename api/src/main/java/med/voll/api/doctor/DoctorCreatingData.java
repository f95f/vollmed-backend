package med.voll.api.doctor;

import med.voll.api.address.AddressData;

public record DoctorCreatingData(
        String name,
        String email,
        String crm,
        String phone,
        Speciality speciality,
        AddressData address

) {
}
