package org.example;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Technology {
    private String technologyName;
    private String technologyDescription;

    public Technology(String technologyName, String technologyDescription) {
        this.technologyName = technologyName;
        this.technologyDescription = technologyDescription;
    }

}
