package com.krizaldis.persistence;

import static java.lang.String.format;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import com.datastax.oss.driver.api.mapper.annotations.PropertyStrategy;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@PropertyStrategy(mutable = false)
public class Contact {

  @PartitionKey(value = 0)
  @CqlName("first_name")
  private final String firstName;
  @PartitionKey(value = 1)
  @CqlName("last_name")
  private final String lastName;
  private final int age;
  private final Address address;

  public String address() {

    return format("%s %s %s",
        address.getStreet(), address.getCity(), address.getZipCode());
  }
}

