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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

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
    return new ContactQueryResponse().setFirstName(contact.getFirstName())
        .setLastName(contact.getLastName()).setAddress(contact.address()).setAge(contact.getAge());
  }

  private Contact convertFromDto(ContactCommand dto) {
    return new Contact(dto.getFirstName(), dto.getLastName(), dto.getAge(),
        new Address(dto.getAddress().getStreet(), dto.getAddress().getCity(),
            dto.getAddress().getZipcode()));
  }
}

@Data
@Accessors(chain = true)
class ContactQueryResponse {

  private String firstName;
  private String lastName;
  private Integer age;
  private String address;
}

@Data
@Accessors(chain = true)
class ContactCommand {

  private String firstName;
  private String lastName;
  private Integer age;
  private AddressDto address;
}

@Setter
@Getter
@Accessors(chain = true)
@NoArgsConstructor
class AddressDto {

  private String city;
  private String street;
  private String zipcode;
}