package projeto.pesquisadores;

public class PesquisadorProfessor implements Especialidade {
    private String formacao;
    private String unidade;
    private String data;

    public PesquisadorProfessor(String formacao, String unidade, String data) {
        this.formacao = formacao;
        this.unidade = unidade;
        this.data = data;
    }


    @Override
    public void alteraPesquisador(String atributo, String novoValor) {
        if (atributo.equals("FORMACAO")) {
            setFormacao(novoValor);
        } else if (atributo.equals("UNIDADE")) {
            setUnidade(novoValor);
        }else if (atributo.equals("DATA")){
            setData(novoValor);
        }
    }

    /**
     * Representação de um pesquisador
     * @return retorna a representação do pesquisador
     */
    @Override
    public String toString(){
        return " - " + this.formacao + " - " + this.unidade + " - " + this.data;
    }
    
   

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setData(String data) {
        this.data = data;
    }
}
