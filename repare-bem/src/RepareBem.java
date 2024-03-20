public class RepareBem {

    private Reparo[] reparos;

    private OrdemDeServico[] ordensDeServico;

    private int indiceOrdemDeServico;

    private int indiceReparo;

    public RepareBem() {
        this.reparos = new Reparo[100];
        this.ordensDeServico = new OrdemDeServico[500];
        this.indiceReparo = 0;
        this.indiceOrdemDeServico = 0;
    }

    private boolean existeReparo(Reparo reparo) {
        for (int i=0; i < this.reparos.length; i++) {
            Reparo r = this.reparos[i];
            if (r != null) {
                if (r.equals(reparo)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Reparo buscaReparo(String id) {
        for (int i=0; i < this.reparos.length; i++) {
            Reparo r = this.reparos[i];
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public void cadastraRepraro(String id, String descricao, double preco) {
        Reparo reparo = new Reparo(id, descricao, preco);
        if (!existeReparo(reparo)) {
            this.reparos[this.indiceReparo] = reparo;
            this.indiceReparo++;
        }
    }

    public void reajustarPrecoReparo(String idReparo, double percentual) {
        Reparo r = this.buscaReparo(idReparo);
        if (r != null) {
            r.reajustarPreco(percentual);
        }
    }

    public int cadastarOrdemDeServico(String cliente, String telefone, String roupa) {
        this.ordensDeServico[this.indiceOrdemDeServico] = new OrdemDeServico(cliente, telefone, roupa);
        this.indiceOrdemDeServico++;
        return this.indiceOrdemDeServico;
    }

    public String exibirOrdemDeServico(int idOS) {
        if (idOS < 1 || idOS >= this.indiceOrdemDeServico) {
            throw new IllegalArgumentException("mana não faz isso");
        }
        OrdemDeServico os = this.ordensDeServico[idOS-1];
        return String.format("#%d; %s", idOS, os.toString());
    }

    public void incluirReparoOrdemDeServico(int idOS, String idReparo) {
        if (idOS < 1 || idOS >= this.indiceOrdemDeServico) {
            throw new IllegalArgumentException("mana não faz isso");
        }
        OrdemDeServico os = this.ordensDeServico[idOS-1];
        Reparo r = this.buscaReparo(idReparo);
        os.incluirReparo(r);
    }

    public void mudarStatusOrdemDeServico(int idOS, String status) {
        if (idOS < 1 || idOS >= this.indiceOrdemDeServico) {
            throw new IllegalArgumentException("mana não faz isso");
        }
        OrdemDeServico os = this.ordensDeServico[idOS-1];
        os.setStatus(status);
    }

    public double obterValorOrdemServico(int idOS) {
        if (idOS < 1 || idOS >= this.indiceOrdemDeServico) {
            throw new IllegalArgumentException("mana não faz isso");
        }
        OrdemDeServico os = this.ordensDeServico[idOS-1];
        return os.calculaPrecoTotal();
    }

    public String listarOrdemDeServico() {
        String listagem = "";
        for (int i=0; i < this.ordensDeServico.length; i++) {
            OrdemDeServico os = this.ordensDeServico[i];
            if (os != null) {
                listagem += String.format("#%d; %s\n", i+1, os.toString());
            }
        }
        return listagem;
    }

    public String listarOrdemDeServico(String status) {
        String listagem = "";
        for (int i=0; i < this.ordensDeServico.length; i++) {
            OrdemDeServico os = this.ordensDeServico[i];
            if (os != null) {
                if (status.equals(os.getStatus())) {
                    listagem += String.format("#%d; %s\n", i+1, os.toString());
                }
            }
        }
        if ("".equals(listagem)) {
            listagem = String.format("Não há ordens de serviço do tipo %s", status);
        } else {
            listagem = String.format("Ordens de Serviços - %s\n%s", status, listagem);
        }
        return listagem;
    }
}
