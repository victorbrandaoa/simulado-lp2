import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepareBemTest {

    private RepareBem rb;

    @BeforeEach
    void setUp() {
        this.rb = new RepareBem();
    }

    @Test
    void testMudarStatusOrdemDeServicoIdInvalido() {
        try {
            rb.mudarStatusOrdemDeServico(0, "completo");
        } catch (IllegalArgumentException e) {}
    }
}
