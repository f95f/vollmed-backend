package med.voll.api.domain.patient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.Address;

public record PatientUpdatingData(
        @NotNull
        Long id,
        String phone,
        String name,
        Address address
) {
}