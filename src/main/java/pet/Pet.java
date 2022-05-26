package pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Pet {
    @Id
    private String id;
    private String name;
    private Boolean hasVaccineUpdated;
    private String birthDate;
    private String race;
}
