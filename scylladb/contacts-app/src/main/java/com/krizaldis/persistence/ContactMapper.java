package com.krizaldis.persistence;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;

@Mapper
public interface ContactMapper {
  @DaoFactory
  ContactRepository contactRepository();
}