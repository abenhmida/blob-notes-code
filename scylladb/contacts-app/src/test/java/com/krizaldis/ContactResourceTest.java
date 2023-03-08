package com.krizaldis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.krizaldis.persistence.Address;
import com.krizaldis.persistence.Contact;
import io.quarkus.test.junit.QuarkusTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ContactResourceTest {

    @Test
    @Disabled
    public void listContacts() {
        given()
          .when().get("/contacts")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }


    @SneakyThrows
    @Test
    public void test_serialization(){
        var mapper = new ObjectMapper();

        var contact = new Contact("John", "Doe", 60,
            new Address("lunar street", "the moon", "445R555T56"));

        System.out.println(mapper.writeValueAsString(contact));
    }




}