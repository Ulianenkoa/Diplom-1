package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    private final Bun bun;
    private final Ingredient firstIngredient;
    private final Ingredient secondIngredient;
    private final float expectedPrice;


    public BurgerParameterizedTest(Bun bun, Ingredient firstIngredient, Ingredient secondIngredient, float expectedPrice) {
        this.bun = bun;
        this.firstIngredient = firstIngredient;
        this.secondIngredient = secondIngredient;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
        public static Object[][] getPriceData(){
        return new Object[][]{
                {new Bun("black bun",100), new Ingredient(IngredientType.FILLING, "cutlet",100),new Ingredient(IngredientType.SAUCE, "hot sauce",100), 400},
                {new Bun("white bun",200), new Ingredient(IngredientType.FILLING, "sausage",300),new Ingredient(IngredientType.SAUCE, "sour cream",200), 900},
                {new Bun("red bun",300), new Ingredient(IngredientType.FILLING, "dinosaur",200),new Ingredient(IngredientType.SAUCE, "chili sauce",300), 1100},
                {new Bun("red bun",300), new Ingredient(IngredientType.FILLING, "dinosaur",200),new Ingredient(IngredientType.SAUCE, "chili sauce",300), 1100},
        };
    }

    @Test
        public void getPriceBurgerTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        assertEquals(expectedPrice,burger.getPrice(),0);
    }

    @Test
    public void getReceiptBurgerTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        String expectedResult =
                String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("= %s %s =%n", firstIngredient.getType().toString().toLowerCase(), firstIngredient.name) +
                        String.format("= %s %s =%n", secondIngredient.getType().toString().toLowerCase(), secondIngredient.name) +
                        String.format("(==== %s ====)%n", bun.getName()) +
                        String.format("%nPrice: %f%n", (bun.getPrice() * 2 + firstIngredient.price + secondIngredient.price));
        assertEquals("Рецепт напечат неверно", expectedResult, burger.getReceipt());
    }
}
