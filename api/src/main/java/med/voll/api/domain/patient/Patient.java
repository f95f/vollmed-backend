package med.voll.api.domain.patient;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;
import med.voll.api.domain.doctor.DoctorCreatingData;
import med.voll.api.domain.doctor.DoctorUpdatingData;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private Boolean active;

    @Embedded
    private Address address;


    public Patient(PatientCreatingData request) {
        this.name = request.name();
        this.email = request.email();
        this.cpf = request.cpf();
        this.phone = request.phone();
        this.active = true;
        this.address = new Address(request.address());
    }


    public void updatePatientData(@Valid PatientUpdatingData request) {

        if(request.name() != null) {
            this.name = request.name();
        }

        if(request.phone() != null) {
            this.phone = request.phone();
        }

        if(request.address() != null) {
            this.address.updateAddressInfo(request.address());
        }
    }


    public void deactivate() {
        this.active = false;
    }
}
