package projeto.pesquisadores;

public class PesquisadorProfessor extends Pesquisador {
    private String formacao;
    private String unidade;
    private String data;
    /**
     * Construtor de pesquisadores responsável por armazenar os dados.
     *
     * @param nome      nome do pesquisador
     * @param funcao    função do pesquisador
     * @param biografia biografia do pesquisador
     * @param email     email do pesquisador
     * @param fotoURL   link URL da foto do pesquisador
     */
    public PesquisadorProfessor(String nome, String funcao, String biografia, String email, String fotoURL, String formacao, String unidade, String data) {
        super(nome, funcao, biografia, email, fotoURL);
        this.data = data;
        this.formacao = formacao;
        this.unidade = unidade;
    }
    /**
     * Representação de um pesquisador
     * @return retorna a representação do pesquisador
     */
    @Override
    public String toString(){
        return this.nome+" ("+this.funcao+") - "+this.biografia+" - "+this.email+" - "+this.fotoURL + " - " + this.formacao + " - " + this.unidade + " - " + this.data;
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
