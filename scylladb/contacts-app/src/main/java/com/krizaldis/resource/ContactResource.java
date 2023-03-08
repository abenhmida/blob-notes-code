package com.krizaldis.resource;

import com.krizaldis.persistence.Address;
import com.krizaldis.persistence.Contact;
import com.krizaldis.service.ContactService;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class ContactResource {

  @Inject
  private final ContactService contactService;

  @GET
  public List<ContactQueryResponse> getAll() {
    return contactService.getAll().stream().map(this::toContactQueryResponse)
        .collect(Collectors.toList());
  }

  @POST
  public void add(ContactCommand dto) {
    contactService.save(convertFromDto(dto));
  }

  private ContactQueryResponse toContactQueryResponse(Contact contact) {
    return new ContactQueryResponse(
        contact.getFirstName(),
        contact.getLastName(),
        contact.getAge(),
        contact.address());
  }

  private Contact convertFromDto(ContactCommand dto) {
    return new Contact(dto.firstName(), dto.lastName(), dto.age(),
        new Address(dto.address().street(), dto.address().city(),
            dto.address().zipcode()));
  }
}

record ContactQueryResponse(String firstName,
                            String lastName,
                            Integer age,
                            String address) {

}

record ContactCommand(String firstName,
                      String lastName,
                      Integer age,
                      AddressDto address) {

}

record AddressDto(String city, String street, String zipcode) {

}