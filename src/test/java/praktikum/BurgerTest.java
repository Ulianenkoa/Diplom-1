package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
        public void setBunsBurgerTest(){
        burger.setBuns(bun);
        assertEquals("Не соотвветствует ожидаемому результату, ",bun,burger.bun);
    }

    @Test
        public void addIngredientBurgerTest(){
        burger.addIngredient(ingredient);
        assertTrue("Не соотвветствует ожидаемому результату, ингридиент не добавлен", burger.ingredients.contains(ingredient));
    }
    
    @Test
    public void removeIngredientBurgerTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Количество ингридиентов не соотвествует ожидаемому, ингридиент не удален",1,burger.ingredients.size());
    }

    @Test
    public void moveIngredientBurgerTest(){
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, ingredient.name, ingredient.price);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, ingredient.name, ingredient.price);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1,0);
        assertEquals("Порядок ингридиентов не соотвествует ожидаемому, ингридиент не был перемещен", List.of(secondIngredient, firstIngredient), burger.ingredients);
    }
}
