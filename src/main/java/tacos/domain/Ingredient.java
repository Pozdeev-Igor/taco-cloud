package tacos.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Ingredient {

    @Id
    private String id;
    private String name;
    private IngredientType type;
}
