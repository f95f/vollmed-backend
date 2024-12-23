package med.voll.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.Address;

public record DoctorUpdatingData(
        @NotNull
        Long id,
        String phone,
        String name,
        Address address
) {
}
