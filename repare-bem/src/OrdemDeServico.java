import java.util.Arrays;

public class OrdemDeServico {

    private String cliente;
    private String telefone;
    private String roupa;
    private Reparo[] reparos;
    private int indiceReparo;
    private String status;

    public OrdemDeServico(String cliente, String telefone, String roupa) {
        this.cliente = cliente;
        this.telefone = telefone;
        this.roupa = roupa;
        this.reparos = new Reparo[10];
        this.indiceReparo = 0;
        this.status = "Não iniciado";
    }

    public double calculaPrecoTotal() {
        double precoTotal = 0;
        for (int i=0; i < this.reparos.length; i++) {
            Reparo r = this.reparos[i];
            if (r != null) {
                precoTotal += r.getPreco();
            }
        }
        return precoTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {System.out.println("Hello world!");
        this.status = status;
    }

    @Override
    public String toString() {
        double precoTotal = this.calculaPrecoTotal();
        return String.format("cliente: %s; roupa: %s; reparos: %d; total: R$%.2f", this.cliente, this.roupa, this.indiceReparo, precoTotal);
    }

    public void incluirReparo(Reparo r) {
        this.reparos[this.indiceReparo] = r;
        this.indiceReparo++;
    }
}
