package med.voll.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.Address;

public record DoctorUpdatingData(
        @NotNull
        Long id,
        String phone,
        String name,
        Address address
) {
}
