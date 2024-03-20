import java.util.Objects;

public class Reparo {

    private String id;
    private String descricao;
    private double preco;

    public Reparo(String id, String descricao, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reparo reparo = (Reparo) o;
        return Objects.equals(id, reparo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void reajustarPreco(double percentual) {
        this.preco = this.preco * percentual;
    }
}
