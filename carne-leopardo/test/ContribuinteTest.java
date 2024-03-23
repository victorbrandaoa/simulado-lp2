import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContribuinteTest {

    private Contribuinte c;

    @BeforeEach
    void setUp() {
        this.c = new Contribuinte("12345678900", "Jonas", "(83)988990011");
    }

    @Test
    void totalPagoContribuidorSemNenhumTributo() {
        assertEquals("0,00", String.format("%.2f", c.totalPago(2020)));
    }

    @Test
    void totalPagoContribuidorComUmTributo() {
        Tributo t = new Tributo(1, "um imposto qualquer", 2020, 500.0);
        c.atribuirTributo(t);
        assertEquals("500,00", String.format("%.2f", c.totalPago(2020)));
    }

    @Test
    void totalPagoContribuidorComMultiplosTributos() {
        Tributo t = new Tributo(1, "um imposto qualquer", 2020, 500.0);
        Tributo t2 = new Tributo(2, "um imposto de casa qualquer", 2020, 50.0);
        Tributo t3 = new Tributo(3, "um imposto de carro qualquer", 2020, 600.0);
        c.atribuirTributo(t);
        c.atribuirTributo(t2);
        c.atribuirTributo(t3);
        assertEquals("1150,00", String.format("%.2f", c.totalPago(2020)));
    }

    @Test
    void totalPagoContribuidorComMultiplosTributosAnosDistintos() {
        Tributo t = new Tributo(1, "um imposto qualquer", 2020, 500.0);
        Tributo t2 = new Tributo(2, "um imposto de casa qualquer", 2020, 50.0);
        Tributo t3 = new Tributo(3, "um imposto de carro qualquer", 2021, 600.0);
        c.atribuirTributo(t);
        c.atribuirTributo(t2);
        c.atribuirTributo(t3);
        assertEquals("550,00", String.format("%.2f", c.totalPago(2020)));
        assertEquals("600,00", String.format("%.2f", c.totalPago(2021)));
    }

    @Test
    void totalPagoContribuidorComMultiplosTributosAnoInexistente() {
        Tributo t = new Tributo(1, "um imposto qualquer", 2020, 500.0);
        Tributo t2 = new Tributo(2, "um imposto de casa qualquer", 2020, 50.0);
        Tributo t3 = new Tributo(3, "um imposto de carro qualquer", 2021, 600.0);
        c.atribuirTributo(t);
        c.atribuirTributo(t2);
        c.atribuirTributo(t3);
        assertEquals("0,00", String.format("%.2f", c.totalPago(2019)));
    }
}