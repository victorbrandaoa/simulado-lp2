import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrdemDeServicoTest {

    private OrdemDeServico os;

    @BeforeEach
    void setUp() {
        this.os = new OrdemDeServico("victor", "8833667788", "camisa");
    }

    @Test
    void testMudaStatusParaConcluida() {
        assertEquals("Não iniciado", os.getStatus());
        os.setStatus("Concluida");
        assertEquals("Concluida", os.getStatus());
    }

    @Test
    void testMudaStatusParaEmAndamento() {
        assertEquals("Não iniciado", os.getStatus());
        os.setStatus("Em andamento");
        assertEquals("Em andamento", os.getStatus());
    }

    @Test
    void testStatus() {
        assertEquals("Não iniciado", os.getStatus());
    }
}
