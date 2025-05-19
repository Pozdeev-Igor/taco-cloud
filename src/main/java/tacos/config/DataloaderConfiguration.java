package tacos.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tacos.data.IngredientRepository;
import tacos.domain.Ingredient;
import tacos.domain.Ingredients;

@Configuration
public class DataloaderConfiguration {

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo) {
        return args -> {
            for (Ingredients i : Ingredients.values()) {
                var ingredient = new Ingredient();
                ingredient.setId(i.name());
                ingredient.setName(i.getDescription());
                ingredient.setType(i.getType());
                repo.save(ingredient);
            }
        };
    }
}
