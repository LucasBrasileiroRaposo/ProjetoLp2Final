package projeto.pesquisadores;

import java.io.Serializable;

public class Pesquisador implements Serializable {
    /** nome do pesquisador
     */
    protected String nome;

    /** especialidade do pesquisador.
     */
    protected Especialidade especialidade;

    /** funcao do pesquisador
     */
    protected String funcao;

    /** biografia do pesquisador
     */
    protected String biografia;

    /** email do pesquisador
     */
    protected String email;

    /** link para uma foto do pesquisador.
     */
    protected String fotoURL;

    /** status do  pesquisador.
     */
    protected String status;

    /**
     * Construtor de pesquisadores responsável por armazenar os dados.
     * @param nome nome do pesquisador
     * @param funcao função do pesquisador
     * @param biografia biografia do pesquisador
     * @param email email do pesquisador
     * @param fotoURL link URL da foto do pesquisador
     */
    public Pesquisador(String nome, String funcao, String biografia, String email, String fotoURL){
        this.nome = nome;
        this.biografia = biografia;
        this.email = email;
        this.fotoURL = fotoURL;
        this.status = "ATIVADO";
        this.funcao = funcao;

    }
    /**
     * Representação de um pesquisador
     * @return retorna a representação do pesquisador
     */
    public String toString() {
        return this.nome +" ("+this.funcao+") - "+this.biografia+" - "+this.email+" - "+this.fotoURL
                + ((this.especialidade != null) ? this.especialidade.toString() : "");
    }

    public void alteraPesquisador(String atributo, String novoValor){
        this.especialidade.alteraPesquisador(atributo,novoValor);
    }
    public void setEspecialidade(Especialidade especialidade){
        this.especialidade = especialidade;
    }
    public Especialidade getEspecialidade(){
        return this.especialidade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setFuncao(String funcao){
        this.funcao = funcao;
    }
    public void setBiografia(String biografia){
        this.biografia = biografia;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setFotoURL(String fotoURL){
        this.fotoURL = fotoURL;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public String getEmail() {
        return this.email;
    }

    public String getFuncao(){
        return this.funcao;
    }

    public String getNome() {
        return this.nome;
    }

    public String getBiografia() {
        return this.biografia;
    }

    public String getFotoURL() {
        return this.fotoURL;
    }


}
