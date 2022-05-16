package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final Bun bun;
    private final String expectedNameBun;
    private final float expectedPriceBun;


    public BunTest(Bun bun, String expectedNameBun, float expectedPriceBun) {
        this.bun = bun;
        this.expectedNameBun = expectedNameBun;
        this.expectedPriceBun = expectedPriceBun;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {new Bun("red bun", 300), "red bun", 300},
                {new Bun("white bun", 200), "white bun", 200},
                {new Bun("red bun", 300), "red bun", 300},
        };
    }

    @Test
    public void getNameBunShouldBeCorrect() {
        assertEquals("Некорректное наименование булочки", expectedNameBun, bun.getName());
    }

    @Test
    public void getPriceBunShouldBeCorrect() {
        assertEquals(expectedPriceBun, bun.getPrice(), 0);
    }
}
