package com.krizaldis.service;

import com.krizaldis.persistence.Contact;
import com.krizaldis.persistence.ContactRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class ContactService {

  @Inject
  private final ContactRepository contactRepository;

  public void save(Contact fruit) {
    contactRepository.update(fruit);
  }

  public List<Contact> getAll() {
    return contactRepository.findAll().all();
  }

}
