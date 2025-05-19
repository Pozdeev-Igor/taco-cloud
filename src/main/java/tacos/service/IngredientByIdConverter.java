package tacos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.data.IngredientRepository;
import tacos.domain.Ingredient;
import tacos.domain.Ingredients;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient convert(String source) {
        return ingredientRepository.findById(source).orElse(null);
    }
}
