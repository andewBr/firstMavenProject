package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MyJakartaTest {

    Faker faker = new Faker();
    private String filePath = "src/main/resources/writeToJson.json";


    @SneakyThrows
    @Test
    void writeToJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        MyJakarta myJakartaObject = objectMapper.readValue(new File(filePath), MyJakarta.class);
        assertNotNull(myJakartaObject);
    }

    @SneakyThrows
    @Test
    void readFromJson() {

        Technology newTechnology = new Technology(faker.pokemon().name(), faker.pokemon().location());
        MyJakarta myJakarta = new MyJakarta();
        ObjectMapper objectMapper = new ObjectMapper();

        myJakarta.updateTechnology(newTechnology);

        MyJakarta actualData = objectMapper.readValue(new File(filePath), new TypeReference<>() {});
        assertEquals(Arrays.asList(newTechnology), actualData.getTechtologies());
    }







}