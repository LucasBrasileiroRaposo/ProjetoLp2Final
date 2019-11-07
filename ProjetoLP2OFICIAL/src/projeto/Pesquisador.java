package projeto;
public  class Pesquisador {
    private String nome;
    private String funcao;
    private String biografia;
    private String email;
    private String fotoURL;
    private String status;

    /**
     * Construtor de pesquisadores responsável por armazenar os dados.
     * @param nome nome do pesquisador
     * @param funcao função do pesquisador
     * @param biografia biografia do pesquisador
     * @param email email do pesquisador
     * @param fotoURL link URL da foto do pesquisador
     */
    public Pesquisador(String nome,String funcao,String biografia, String email, String fotoURL){
        this.nome = nome;
        this.biografia = biografia;
        this.funcao = funcao;
        this.email = email;
        this.fotoURL = fotoURL;
        this.status = "ATIVADO";

    }

    /**
     * Representação de um pesquisador
     * @return retorna a representação do pesquisador
     */
    @Override
    public String toString(){
        return this.nome+" ("+this.funcao+") - "+this.biografia+" - "+this.email+" - "+this.fotoURL;
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


}
