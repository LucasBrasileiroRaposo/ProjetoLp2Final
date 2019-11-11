package projeto;

import java.awt.List;
import java.util.ArrayList;

/**
 * Método responsável por representar um objeto pesquisa
 */

public class Pesquisa implements Comparable<Pesquisa> {
	
	private String descricao;
    private String campoInteresse;
    private boolean status;
    private ArrayList<Problema> listaProblema;
    private ArrayList<Objetivo> listaObjetivos;
    private String codigo;
    
    

    /**
     * Método responsável por criar um novo objeto pesquisa
     * @param descricao descricao de uma pesquisa
     * @param campo campo de interre de uma pesquisa
     */

    public Pesquisa(String descricao, String campo, String codigo) {
    	
        this.campoInteresse = campo;
        this.descricao = descricao;
        this.status = true;
        this.listaProblema = new ArrayList<Problema>();
        this.listaObjetivos= new ArrayList<Objetivo>();
        this.codigo = codigo;
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
     * Método responsável por desativar o status da pesquisa
     */

    public void desativaStatus() {
        this.status = false;
    }
    
    /**
     * Metodo responsavel por ativar o status da pesquisa
     */
    
    public void ativaStatus() {
    	this.status = true;
    }
    

    /**
     * Método resposável por retornar representação textual de uma pesquisa
     * @return string com informações da pesquisa
     */
    public String toString() {
        return " - " + this.descricao + " - " + campoInteresse;
    }



	public boolean associaProblema(Problema problema) {
		
		if (this.listaProblema.size() == 0) {
			this.listaProblema.add(problema);
			return true;
		} else if (this.listaProblema.contains(problema)){
			return false;
			
		}
		
		throw new IllegalArgumentException("Pesquisa ja associada a um problema.");
	}



	public boolean desassociaProblema() {
		
		if (this.listaProblema.size() != 0) {
			this.listaProblema.remove(0);
			return true;
		}
		return false;
	}



	public boolean associaObjetivo(Objetivo objetivo) {
		
		if(this.listaObjetivos.contains(objetivo)) {
			return false;
		}
		

		else if(objetivo.getAssociado()) {
			throw new IllegalArgumentException("Objetivo ja associado a uma pesquisa.");
		}
		
		this.listaObjetivos.add(objetivo);
		objetivo.associaObjetivo();
		return true;
	}



	public boolean desassociaObjetivo(Objetivo objetivo) {
		
		if(!this.listaObjetivos.contains(objetivo)) {
			return false;
		}
		this.listaObjetivos.remove(objetivo);
		objetivo.desassociaObjetivo();
		return true;
	}



	public String getCodigo() {
		return codigo;
	}



	@Override
	public int compareTo(Pesquisa outraPesquisa) {
		
		return outraPesquisa.getCodigo().compareTo(this.codigo);
	}



	public ArrayList<Problema> getListaProblema() {
		return listaProblema;
	}



	public ArrayList<Objetivo> getListaObjetivos() {
		return listaObjetivos;
	}
	
}