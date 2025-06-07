package tacos.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import tacos.data.IngredientRepository;
import tacos.domain.Ingredient;
import tacos.domain.IngredientType;
import tacos.domain.Taco;
import tacos.domain.TacoOrder;

import java.util.List;
import java.util.stream.Collectors;

import static tacos.util.LoggerUtil.toJson;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(
            @Valid @ModelAttribute Taco taco,
            Errors errors,
            @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) {
            return "design";
        }
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", toJson(taco));
        return "redirect:/orders/current";
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        var ingredients = ingredientRepo.findAll();
        log.info("Ингредиенты получены из БД: {}", ingredients);
        filterByType(model, ingredients);
    }

    private void filterByType(Model model, List<Ingredient> list) {
        for (IngredientType i : IngredientType.values()) {
            model.addAttribute(i.name().toLowerCase(), filterIngredients(list, i));
        }
    }

    private List<Ingredient> filterIngredients(List<Ingredient> list, IngredientType i) {
        return list.stream().filter(x -> x.getType().equals(i)).collect(Collectors.toList());
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }
}
