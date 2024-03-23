import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TributoTest {

    @Test
    void reajustaValor() {
        Tributo t = new Tributo(1, "um imposto qualquer", 2020, 500.0);
        assertEquals("500,00", String.format("%.2f", t.getValor()));
        t.reajustaValor(1.1);
        assertEquals("550,00", String.format("%.2f", t.getValor()));
    }
}