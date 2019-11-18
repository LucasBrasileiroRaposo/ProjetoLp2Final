package projeto.pesquisa_e_associacoes;

import projeto.atividades.Atividade;
import projeto.objetivos_e_problemas.Objetivo;
import projeto.pesquisa_e_associacoes.Pesquisa;
import projeto.objetivos_e_problemas.Problema;
import projeto.pesquisadores.Pesquisador;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Classe responsável por representar um objeto Pesquisa.
 */

public class Pesquisa implements Comparable<Pesquisa>{
	
	/**
	 * descricao da pesquisa.
	 */
	private String descricao;
	/**
	 * campo de interesse da pesquisa
	 */
    private String campoInteresse;
    /**
     * status da pesquisa, se for True, a pesquisa esta ativada, se nao, a pesquisa esta desativada.
     */
    private boolean status;
    
    /**
     * Mapa de pesquisadores da pesquisa.
     */
    private Map<String, Pesquisador> pesquisadoresDaPesquisa;
    
    /**
     * Lista que contem o problema associado a esta pesquisa.
     */
    private ArrayList<Problema> listaProblema;
    /**
     * Lista que contem os objetivos associados a esta pesquisa.
     */
    private ArrayList<Objetivo> listaObjetivos;
    /**
     * Codigo da pesquisa
     */
    private String codigo;
    
    private Map<String, Atividade> atividadesDaPesquisa;

    /**
     * Método responsável por criar um novo objeto pesquisa
     * @param descricao descricao de uma pesquisa
     * @param campo campo de interre de uma pesquisa
     */

    public Pesquisa(String descricao, String campo, String codigo) {
        this.campoInteresse = campo;
        this.descricao = descricao;
        this.status = true;
        this.pesquisadoresDaPesquisa = new LinkedHashMap<>();
        
        this.listaProblema = new ArrayList<Problema>();
        this.listaObjetivos= new ArrayList<Objetivo>();
        this.codigo = codigo;
        this.atividadesDaPesquisa = new HashMap<>();
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
     * Método responsável para desativar a pesquisa
     */

    public void desativaPesquisa() {
        this.status = false;
    }

    /**
     * Método responsável para ativar a pesquisa
     */
    public void ativaPesquisa(){
        this.status = true;
    }


    /**
     * Método resposável por retornar representação textual de uma pesquisa
     * @return string com informações da pesquisa
     */
    public String toString() {
        return " - " + this.descricao + " - " + campoInteresse;
    }
    
    /**
     * Associa o problema na pesquisa
     * @param problema objeto problema
     * @return true se for bem sucedido, false se nao.
     */

	public boolean associaProblema(Problema problema) {
		
		if (this.listaProblema.size() == 0) {
			this.listaProblema.add(problema);
			return true;
		} else if (this.listaProblema.contains(problema)){
			return false;
			
		}
		throw new IllegalArgumentException("Pesquisa ja associada a um problema.");
	}


	/**
	 * metodo que desassocia um problema da pesquisa
	 * @return
	 */
	public boolean desassociaProblema() {
		
		if (this.listaProblema.size() != 0) {
			this.listaProblema.remove(0);
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que associa um Objetivo a uma pesquisa
	 * @param objetivo Objeto Objetivo que sera associado
	 * @return true se for bem sucedido, false se nao.
	 */

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


	/**
	 * Metodo que desassocia um objetivo de uma pesquisa
	 * @param objetivo objeto objetivo que sera associado
	 * @return true se for bem sucedido, false se nao.
	 */
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
	
	/**
	 * PARTE 6!
	 */
    /**
     * 
     * @param pesquisador
     * @return
     */
	 public boolean associaPesquisador(Pesquisador pesquisador){
	        if (this.pesquisadoresDaPesquisa.containsKey(pesquisador.getEmail())){
	            return false;
	        }else{
	            this.pesquisadoresDaPesquisa.put(pesquisador.getEmail(),pesquisador);
	            return true;
	        }
	    }
    public boolean desassociaPesquisador(String emailPesquisador) {
        if (!this.pesquisadoresDaPesquisa.containsKey(emailPesquisador)){
            return false;
        }else{
            this.pesquisadoresDaPesquisa.remove(emailPesquisador);
            return true;
        }
    }


	public boolean cadastraAtividade(Atividade atividade) {
		if(this.atividadesDaPesquisa.containsKey(atividade.getCodigo())) {
    		return false;
    	}else {
    		this.atividadesDaPesquisa.put(atividade.getCodigo(), atividade);
    		this.atividadesDaPesquisa.get(atividade.getCodigo()).controlaDestinoAtividade(true);
    		return true;
    	 }
	}
	public boolean removeAtividade(String codigoAtividade) {
    	if(!atividadesDaPesquisa.containsKey(codigoAtividade)) {
    		return false;
    	}
    	else {
    		this.atividadesDaPesquisa.get(codigoAtividade).controlaDestinoAtividade(false);
    		this.atividadesDaPesquisa.remove(codigoAtividade);
    		return true;
    	}
    	
    }
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}