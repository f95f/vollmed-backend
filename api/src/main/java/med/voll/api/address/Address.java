package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
   private String street;
   private String neighborhood;
   private String zipcode;
   private String city;
   private String state;
   private String addressAdditions;
   private String number;

   public Address(AddressData address) {
      this.street = address.street();
      this.addressAdditions = address.addressAdditions();
      this.city = address.city();
      this.number = address.number();
      this.state = address.state();
      this.neighborhood = address.neighborhood();
      this.zipcode = address.zipcode();
   }

   public void updateAddressInfo(Address address) {

      if(address.street != null) {
         this.street = address.street;
      }

      if(address.addressAdditions != null) {
         this.addressAdditions = address.addressAdditions;
      }

      if(address.city != null) {
         this.city = address.city;
      }

      if(address.number != null) {
         this.number = address.number;
      }

      if(address.state != null) {
         this.state = address.state;
      }

      if(address.neighborhood != null) {
         this.neighborhood = address.neighborhood;
      }

      if(address.zipcode != null) {
         this.zipcode = address.zipcode;
      }

   }
}
