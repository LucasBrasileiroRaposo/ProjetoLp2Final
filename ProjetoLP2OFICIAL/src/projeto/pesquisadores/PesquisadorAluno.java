package projeto.pesquisadores;

import projeto.pesquisadores.Pesquisador;

public class PesquisadorAluno extends Pesquisador {

    private Integer semestreIngresso;
    private double iea;

    /**
     * Construtor de pesquisadores responsável por armazenar os dados.
     *
     * @param nome      nome do pesquisador
     * @param funcao    função do pesquisador
     * @param biografia biografia do pesquisador
     * @param email     email do pesquisador
     * @param fotoURL   link URL da foto do pesquisador
     */
    public PesquisadorAluno(String nome, String funcao, String biografia, String email, String fotoURL, Integer semestreIngresso,double iea) {
        super(nome, funcao, biografia, email, fotoURL);
        this.iea = iea;
        this.semestreIngresso = semestreIngresso;
    }

    /**
     * Representação de um pesquisador
     * @return retorna a representação do pesquisador
     */
    @Override
    public String toString() {
        return this.nome+" ("+this.funcao+") - "+this.biografia+" - "+this.email+" - "+this.fotoURL + " - " + this.semestreIngresso + "o SEMESTRE"  +  " - " + this.iea;
    }
    public void setSemestreIngresso(Integer semestreIngresso){
        this.semestreIngresso = semestreIngresso;
    }
    public void setIea(double iea){
        this.iea = iea;
    }

	
}
