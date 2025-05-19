package tacos.domain;

import lombok.Getter;

import static tacos.domain.IngredientType.*;

@Getter
public enum Ingredients {
    FLTO("Flour Tortilla", WRAP),
    COTO("Corn Tortilla", WRAP),
    GRBF("Ground Beef", PROTEIN),
    CARN("Carnitas", PROTEIN),
    TMTO("Diced Tomatoes", VEGGIES),
    LETC("Lettuce", VEGGIES),
    CHED("Cheddar", CHEESE),
    JACK("Monterrey Jack", CHEESE),
    SLSA("Salsa", SAUCE),
    SRCR("Sour Cream", SAUCE),
    ;


    Ingredients(String description, IngredientType type) {
        this.description = description;
        this.type = type;
    }

    private final String description;
    private final IngredientType type;
}
