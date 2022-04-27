package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameBunShouldBeCorrect(){
        Bun bun = new Bun("red bun", 300);
        assertEquals("Некорректное наименование булочки", "red bun", bun.getName());
    }

    @Test
    public void getPriceBunShouldBeCorrect(){
        Bun bun = new Bun("red bun", 300);
        assertEquals( 300, bun.getPrice(),0);
    }
}
