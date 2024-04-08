package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class MyJakarta {
    private String version;
    private String description;
    private List<Technology> techtologies;

//    {
//        readFromJson("src/main/resources/writeToJson.json");
//    }

    public MyJakarta(String version, String description, List<Technology> techtologies) {
        this.version = version;
        this.description = description;
        this.techtologies = techtologies;
    }

    public void writeToJson(String path,  MyJakarta technologies) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File(path), technologies);
            System.out.println("Data has been written :)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    static MyJakarta readFromJson(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = MyJakarta.class.getClassLoader().getResourceAsStream(path)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: " + path);
            }

            MyJakarta technologies = objectMapper.readValue(inputStream, MyJakarta.class);

            return technologies;
        }
    }

        public void updateTechnology(Technology technology ) {
        try {
            ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            MyJakarta existingData;
            File jsonFile = new File("src/main/resources/writeToJson.json");
            existingData = objectMapper.readValue(jsonFile, new TypeReference<MyJakarta>() {});

            existingData.getTechtologies().set(0, technology);

            objectMapper.writeValue(jsonFile, existingData);
            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Technology> getTechtologies() {
        return techtologies;
    }

    public void setTechtologies(List<Technology> techtologies) {
        this.techtologies = techtologies;
    }
}