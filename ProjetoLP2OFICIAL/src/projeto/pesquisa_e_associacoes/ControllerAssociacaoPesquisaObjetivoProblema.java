package projeto.pesquisa_e_associacoes;

import Util.Validadora;
import projeto.objetivos_e_problemas.Objetivo;
import projeto.objetivos_e_problemas.Problema;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;

public class ControllerAssociacaoPesquisaObjetivoProblema {

	/** ControllerPesquisa do sistema
	 */
    private ControllerPesquisa controllerPesquisa;

    /** Repositorio que armazena todos os objetivos do sistema
	 */
    private RepositorioObjetivos repositorioObjetivos;

	/** Repositorio que armazena todos os problemas do sistema
	 */
    private RepositorioProblemas repositorioProblemas;

    /** Construto do ControllerAssociacaoPesquisaPesquisador que receber como parametro o repositorio de pesquisadores e o controller das pesquisas.
	 * @param controllerPesquisa ControllerPesquisa, que administra todas as acoes que envolvem uma pesquisa.
	 * @param repositorioProblemas RepositorioProblemas, que contem todos os problemas do sistem.
	 * @param repositorioObjetivos RepositorioObjetivios, que contem todos os objetivos do sistema.
	 */
    public ControllerAssociacaoPesquisaObjetivoProblema(ControllerPesquisa controllerPesquisa, RepositorioObjetivos repositorioObjetivos, RepositorioProblemas repositorioProblemas) {
        this.repositorioObjetivos = repositorioObjetivos;
        this.controllerPesquisa = controllerPesquisa;
        this.repositorioProblemas = repositorioProblemas;
    }

	/**
	 * Metodo que associa um problema a uma pesquisa. Uma pesquisa so pode ter um problema associado. Se tentar associar um problema a uma pesquisa que ja tem problema, dara erro.
	 * @param idPesquisa codigo que identifica a pesquisa
	 * @param idProblema codigo do problema que quer se associar a pesquisa
	 * @return true se houver a associacao e false se nao houver.
	 */
	public boolean associaProblema(String idPesquisa, String idProblema) {
		
		Validadora.verificaValorNullVazio(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(idProblema, "Campo idProblema nao pode ser nulo ou vazio.");
		
		Problema problema = this.repositorioProblemas.getProblema(idProblema);
		return this.controllerPesquisa.associaProblema(idPesquisa, problema);
	}

	/**
	 * Metodo que desassocia um problema de uma pesquisa.
	 * @param idPesquisa codigo que identifica a pesquisa
	 * @return Se nao houver nenhuma pesquisa ou a pesquisa estiver desativada, dara erro. Se  nao tiver esse problema retornara false
	 * . Se for bem sucedida, retornara true.
	 */
	public boolean desassociaProblema(String idPesquisa) {
		
		Validadora.verificaValorNullVazio(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		
		return this.controllerPesquisa.desassociaProblema(idPesquisa);
	}

	/**
	 * Metodo que associa um objetivo a uma pesquisa.
	 * @param idPesquisa codigo que identifica a pesquisa
	 * @param idObjetivo codigo do objeto problema que quer se associar a pesquisa
	 * @return true se houver a associacao e false se nao houver.
	 */
	public boolean associaObjetivo(String idPesquisa, String idObjetivo) {
		
		Validadora.verificaValorNullVazio(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		
		Objetivo objetivo = this.repositorioObjetivos.getObjetivo(idObjetivo);
		return this.controllerPesquisa.associaObjetivo(idPesquisa, objetivo);
	}

	/**
	 * Metodo que desassocia um objetivo de uma pesquisa.
	 * @param idPesquisa codigo que identifica a pesquisa
	 * @param idObjetivo codigo do objetivo que sera removido
	 * @return true se for bem sucedido, false se aquele objetivo nao estiver dentro da lista de objetivos da pesquisa. Sera lancada excecao
	 * se a pesquisa estiver desativada ou nao existir.
	 */
	public boolean desassociaObjetivo(String idPesquisa, String idObjetivo) {
		
		Validadora.verificaValorNullVazio(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		
		Objetivo objetivo = this.repositorioObjetivos.getObjetivo(idObjetivo);
		return this.controllerPesquisa.dessassociaObjetivo(idPesquisa, objetivo);
	}
	
	
}
