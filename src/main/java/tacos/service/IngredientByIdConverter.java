package tacos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.data.IngredientRepository;
import tacos.domain.IngredientUDT;
import tacos.domain.TacoUDRUtils;

@Component
@RequiredArgsConstructor
public class IngredientByIdConverter implements Converter<String, IngredientUDT> {

    private final IngredientRepository ingredientRepository;

    @Override
    public IngredientUDT convert(String source) {
        var ingredient = ingredientRepository.findById(source).orElse(null);
        return TacoUDRUtils.toIngredientUDT(ingredient);
    }
}
