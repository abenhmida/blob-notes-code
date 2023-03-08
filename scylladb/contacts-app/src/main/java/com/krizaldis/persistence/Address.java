package com.krizaldis.persistence;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PropertyStrategy;
import com.datastax.oss.driver.api.mapper.entity.naming.GetterStyle;

@Entity
@PropertyStrategy(mutable = false, getterStyle = GetterStyle.FLUENT)
public record Address(String street, String city, @CqlName("zipcode") String zipCode) {

}