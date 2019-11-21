package projeto.pesquisadores;

public class PesquisadorAluno implements Especialidade{

    /** Semestre de ingresso de aluno na pesquisa
     */
    private Integer semestreIngresso;

    /** Indice estudantil academico
     */
    private double iea;

    public PesquisadorAluno(int semestreIngresso, double iea){
        this.iea = iea;
        this.semestreIngresso = semestreIngresso;
    }

    @Override
    public void alteraPesquisador(String atributo, String novoValor) {
        if(atributo.equals("IEA")){
            setIea(Double.parseDouble(novoValor));
        }else if(atributo.equals("SEMESTRE")){
            setSemestreIngresso(Integer.parseInt(novoValor));
        }

    }

    /**
     * Representação de um pesquisador
     * @return retorna a representação do pesquisador
     */
    @Override
    public String toString() {
        return " - " + this.semestreIngresso + "o SEMESTRE"  +  " - " + this.iea;
    }
    public void setSemestreIngresso(Integer semestreIngresso){
        this.semestreIngresso = semestreIngresso;
    }

    public void setIea(double iea){
        this.iea = iea;
    }

	
}
