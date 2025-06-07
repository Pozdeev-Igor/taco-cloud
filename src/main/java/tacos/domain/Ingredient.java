package tacos.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("ingredients")
public class Ingredient {

    @PrimaryKey
    private String id;
    private String name;
    private IngredientType type;
}
