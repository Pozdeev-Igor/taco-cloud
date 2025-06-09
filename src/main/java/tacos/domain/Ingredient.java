package tacos.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "ingredients")
public class Ingredient {

    @Id
    private String id;
    private String name;
    private IngredientType type;
}
