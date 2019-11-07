package projeto;

import projeto.pesquisadores.Pesquisador;

import java.util.HashSet;

/**
 * Método responsável por representar um objeto pesquisa
 */

public class Pesquisa {private String descricao;
    private String campoInteresse;
    private boolean status;
    private HashSet<Pesquisador> pesquisadoresDaPesquisa;

    /**
     * Método responsável por criar um novo objeto pesquisa
     * @param descricao descricao de uma pesquisa
     * @param campo campo de interre de uma pesquisa
     */

    public Pesquisa(String descricao, String campo) {
        this.campoInteresse = campo;
        this.descricao = descricao;
        this.status = true;
        this.pesquisadoresDaPesquisa = new HashSet<>();
    }


    /**
     * Método responsável por retornar uma descricao
     * @return descricao da pesquisa
     */
    public String getDescricao() {
        return descricao;
    }


    /**
     * Método responsável por alterar a descricao da pesquisa
     * @param descricao nova descricao da pesquisa
     */

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Método responsável por retornar o status
     * @return status da pesquisa
     */
    public boolean getStatus() {
        return this.status;
    }

    /**
     * Método responsável por retornar um campo de interesse
     * @return campo de interesse da pesquisa
     */
    public String getCampoInteresse() {
        return campoInteresse;
    }

    /**
     * Método responsável por alterar o campo de interesse da pesquisa
     * @param campoInteresse novo campo de interesse da pesquisa
     */
    public void setCampoInteresse(String campoInteresse) {
        this.campoInteresse = campoInteresse;
    }

    /**
     * Método responsável por alterar o status da pesquisa
     */

    public void setStatus() {
        this.status = false;
    }

    /**
     * Método resposável por retornar representação textual de uma pesquisa
     * @return string com informações da pesquisa
     */
    public String toString() {
        return " - " + this.descricao + " - " + campoInteresse;
    }

    public boolean associaPesquisador(Pesquisador pesquisador){
        if (this.pesquisadoresDaPesquisa.contains(pesquisador)){
            return false;
        }else{
            this.pesquisadoresDaPesquisa.add(pesquisador);
            return true;
        }
    }
}