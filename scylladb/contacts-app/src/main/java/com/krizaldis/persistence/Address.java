package com.krizaldis.persistence;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PropertyStrategy;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Entity
@RequiredArgsConstructor
@PropertyStrategy(mutable = false)
public class Address {

  private final String street;
  private final String city;
  @CqlName("zipcode")
  private final String zipCode;
}