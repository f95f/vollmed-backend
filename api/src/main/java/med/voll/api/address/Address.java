package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
public class Address {
   private String street;
   private String neighborhood;
   private String zipcode;
   private String city;
   private String state;
   private String addressAdditions;
   private String number;

   public Address(){}

   public Address(AddressData address) {
      this.street = address.street();
      this.addressAdditions = address.addressAdditions();
      this.city = address.city();
      this.number = address.number();
      this.state = address.state();
      this.neighborhood = address.neighborhood();
      this.zipcode = address.zipcode();
   }
}
