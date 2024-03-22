import java.util.Objects;

public class Contribuinte {
    private String cpf;
    private String nome;
    private String contato;
    private Tributo[] tributos;
    private int indexProxTributo;

    public Contribuinte(String cpf, String nome, String contato) {
        this.cpf = cpf;
        this.nome = nome;
        this.contato = contato;
        this.tributos = new Tributo[60];
        this.indexProxTributo = 0;
    }


    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return String.format("| Contribuinte: %s - CPF: %s - Contato: %s |", this.nome, this.cpf, this.contato);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contribuinte that = (Contribuinte) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    public void atribuirTributo(Tributo novoTributo) {
        this.tributos[this.indexProxTributo] = novoTributo;
        this.indexProxTributo++;
    }

    public String emitirExtrato() {
        String cabecalho = String.format("| Pago? %s\n", this.toString());
        String tributosFormatados = "";
        for (int i=0; i < this.tributos.length; i++) {
            Tributo t = this.tributos[i];
            if (t != null) {
                String pago = "NÃO";
                if (t.isPago()) {
                    pago = "SIM";
                }
                tributosFormatados += String.format("| %s %s\n", pago, t.toString());
            }
        }
        if ("".equals(tributosFormatados)) {
            return "| EXTRATO VAZIO |";
        }
        return cabecalho + tributosFormatados;
    }

    public double totalPago(int ano) {
        double total = 0;
        for (int i=0; i < this.tributos.length; i++) {
            Tributo t = this.tributos[i];
            if (t.getAno() == ano) {
                total += t.getValor();
            }
        }
        return total;
    }
}
