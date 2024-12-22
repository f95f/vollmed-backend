package med.voll.api.doctor;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.address.Address;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Embedded
    private Address address;

    public Doctor(DoctorCreatingData request) {
        this.name = request.name();
        this.email = request.email();
        this.crm = request.crm();
        this.phone = request.phone();
        this.speciality = request.speciality();
        this.address = new Address(request.address());
    }
}
