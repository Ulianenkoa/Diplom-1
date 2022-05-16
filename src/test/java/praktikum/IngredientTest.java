package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final String ingredientName;
    private final float ingredientPrice;
    private final IngredientType ingredientType;

    public IngredientTest(String ingredientName, float ingredientPrice, IngredientType ingredientType) {
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][]{
                {"sour cream", 200, SAUCE},
                {"dinosaur", 200, FILLING},
        };
    }

    @Test
    public void getNameIngShouldBeCorrect() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals("Некорректное название ингридента", ingredientName, ingredient.getName());
    }

    @Test
    public void getPriceIngShouldBeCorrect() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeIngShouldBeCorrect() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals("Некорректный тип ингридиента", ingredientType, ingredient.getType());
    }
}
