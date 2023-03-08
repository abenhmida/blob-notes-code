package com.krizaldis.persistence;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;

@Dao
public interface ContactRepository {

  @Select
  PagingIterable<Contact> findAll();

  @Insert
  void update(Contact contact);
}
