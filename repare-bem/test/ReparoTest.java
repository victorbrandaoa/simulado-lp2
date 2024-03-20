import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReparoTest {

    @Test
    void reajustarPrecoReparo() {
        Reparo r = new Reparo("test1", "conserta ziper", 50.0);
        assertEquals("50.0", String.format("%.1f", r.getPreco()));
        r.reajustarPreco(1.1);
        assertEquals("55.0", String.format("%.1f", r.getPreco()));
    }
}
