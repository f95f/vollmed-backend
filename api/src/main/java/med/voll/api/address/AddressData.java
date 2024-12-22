package med.voll.api.address;

public record AddressData(
        String street,
        String neighborhood,
        String zipcode,
        String city,
        String state,
        String addressAdditions,
        String number
) {
    public static class Address {
    }
}
