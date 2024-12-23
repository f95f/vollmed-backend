package med.voll.api.domain.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.AddressData;

public record PatientCreatingData (
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String cpf,

        String phone,

        @NotNull
        @Valid
        AddressData address

) {}