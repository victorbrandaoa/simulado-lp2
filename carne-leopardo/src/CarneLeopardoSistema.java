public class CarneLeopardoSistema {
    private Contribuinte[] contribuintes;
    private int indexProxContribuinte;
    private Tributo[] tributos;

    public CarneLeopardoSistema() {
        this.contribuintes = new Contribuinte[100];
        this.tributos = new Tributo[60];
        this.indexProxContribuinte = 0;
    }

    private Contribuinte buscaContribuinte(String cpfContribuinte) {
        for (int i=0; i < this.indexProxContribuinte; i++) {
            Contribuinte c = this.contribuintes[i];
            if (cpfContribuinte.equals(c.getCpf())) {
                return c;
            }
        }
        return null;
    }

    public String cadastrarContribuinte(String cpf, String nome, String contato) {
        if (this.buscaContribuinte(cpf) != null) {
            throw new IllegalArgumentException("Contribuinte já cadastrado!");
        }
        Contribuinte c = new Contribuinte(cpf, nome, contato);
        this.contribuintes[this.indexProxContribuinte] = c;
        this.indexProxContribuinte++;
        return cpf;
    }

    public String[] listarContribuintes() {
        String[] listagemContribuintes = new String[this.indexProxContribuinte];
        for (int i=0; i < this.indexProxContribuinte; i++) {
            listagemContribuintes[i] = this.contribuintes[i].toString();
        }
        return listagemContribuintes;
    }

    public int cadastrarTributo(int codigoTributo, String descricao, double valor, int ano) {
        if (codigoTributo < 1 || codigoTributo > 60) {
            throw new IndexOutOfBoundsException("A faixa disponível para códigos tributarios é de 1 a 60!");
        }
        if (this.tributos[codigoTributo-1] != null) {
            throw new IllegalArgumentException("O código já está sendo utilizado por outro tributo!");
        }
        Tributo t = new Tributo(codigoTributo, descricao, ano, valor);
        this.tributos[codigoTributo-1] = t;
        return codigoTributo;
    }

    public String[] listarTributos() {
        String[] listagemTributos = new String[this.tributos.length];
        for (int i=0; i < this.tributos.length; i++) {
            if (this.tributos[i] != null) {
                listagemTributos[i] = this.tributos[i].toString();
            }
        }
        return listagemTributos;
    }

    public double reajustarTributo(int codigoTributo, int ano, double percentual) {
        if (codigoTributo < 1 || codigoTributo > 60 || this.tributos[codigoTributo-1] != null || this.tributos[codigoTributo-1].getAno() == ano) {
            return 0;
        }
        this.tributos[codigoTributo-1].reajustaValor(percentual);
        return this.tributos[codigoTributo-1].getValor();
    }

    public String atributirTributoAoContribuinte(int codigoTributo, String cpfContribuinte) {
        Contribuinte c = this.buscaContribuinte(cpfContribuinte);
        if (c == null || codigoTributo < 1 || codigoTributo > 60 || this.tributos[codigoTributo-1] == null) {
            return "TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO";
        }
        Tributo t = this.tributos[codigoTributo-1];
        Tributo novoTributo = new Tributo(t.getCodigo(), t.getDescricao(), t.getAno(), t.getValor());
        c.atribuirTributo(novoTributo);
        return "TRIBUTO ADICIONADO COM SUCESSO";
    }

    public String pagarTributo(String cpfContribuinte, int codigoTributo) {
        Contribuinte c = this.buscaContribuinte(cpfContribuinte);
        if (c == null || codigoTributo < 1 || codigoTributo > 60 || this.tributos[codigoTributo-1] == null) {
            return "TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO";
        }
        this.tributos[codigoTributo-1].pagar();
        return "TRIBUTO PAGO COM SUCESSO";
    }

    public String emitirExtratoDeTributos(String cpfContribuinte) {
        Contribuinte c = this.buscaContribuinte(cpfContribuinte);
        if (c != null) {
            return c.emitirExtrato();
        }
        return "";
    }

    public double totalPagoEmTributos(String cpfContribuinte, int ano) {
        Contribuinte c = this.buscaContribuinte(cpfContribuinte);
        if (c == null) {
            return -1;
        }
        return c.totalPago(ano);
    }

}
