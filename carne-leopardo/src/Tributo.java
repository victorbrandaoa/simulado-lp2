public class Tributo {

    private int codigo;
    private String descricao;
    private int ano;
    private double valor;
    private boolean pago;

    public Tributo(int codigo, String descricao, int ano, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.ano = ano;
        this.valor = valor;
        this.pago = false;
    }

    public boolean isPago() {
        return pago;
    }

    public int getCodigo() {
        return codigo;
    }

    public void pagar() {
        this.pago = true;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getAno() {
        return ano;
    }

    public double getValor() {
        return valor;
    }

    public void reajustaValor(double percentual) {
        this.valor *= percentual;
    }

    @Override
    public String toString() {
        return String.format("| Tributo: (%d) %s - Valor: R$%.2f; Ano Base: %d |", this.codigo, this.descricao, this.valor, this.ano);
    }
}
