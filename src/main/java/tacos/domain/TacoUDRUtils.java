package tacos.domain;

public class TacoUDRUtils {
    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }
        var ingredientUDT = new IngredientUDT();
        ingredientUDT.setName(ingredient.getName());
        ingredientUDT.setType(ingredient.getType());
        return ingredientUDT;
    }

    public static TacoUDT toTacoUdt(Taco taco) {
        var tacoUDT = new TacoUDT();
        tacoUDT.setName(taco.getName());
        tacoUDT.setIngredients(taco.getIngredients());
        return tacoUDT;
    }
}
