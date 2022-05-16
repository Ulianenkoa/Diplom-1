package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;
    private final String expected;

    public IngredientTypeTest(IngredientType type, String expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypeData() {
        return new Object[][]{
                {IngredientType.FILLING, "FILLING"},
                {IngredientType.SAUCE, "SAUCE"},
        };
    }

    @Test
    public void checkIngredientTypeTest() {
        assertEquals(type.name(), expected);
    }
}
