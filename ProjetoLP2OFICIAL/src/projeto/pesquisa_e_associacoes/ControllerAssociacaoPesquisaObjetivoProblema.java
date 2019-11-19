package projeto.pesquisa_e_associacoes;

import Util.Validadora;
import projeto.objetivos_e_problemas.Objetivo;
import projeto.objetivos_e_problemas.Problema;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;

public class ControllerAssociacaoPesquisaObjetivoProblema {

    private RepositorioPesquisa repositorioPesquisa;

    private RepositorioObjetivos repositorioObjetivos;

    private RepositorioProblemas repositorioProblemas;

    public ControllerAssociacaoPesquisaObjetivoProblema(RepositorioPesquisa repositorioPesquisa, RepositorioObjetivos repositorioObjetivos, RepositorioProblemas repositorioProblemas) {
        this.repositorioObjetivos = repositorioObjetivos;
        this.repositorioPesquisa = repositorioPesquisa;
        this.repositorioProblemas = repositorioProblemas;
    }
    
public boolean associaProblema(String idPesquisa, String idProblema) {
		
		Validadora.verificaValorNullVazio(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(idProblema, "Campo idProblema nao pode ser nulo ou vazio.");
		
		Problema problema = this.repositorioProblemas.getProblema(idProblema);
		return this.repositorioPesquisa.associaProblema(idPesquisa, problema);
	}

	
	public boolean desassociaProblema(String idPesquisa) {
		
		Validadora.verificaValorNullVazio(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		
		return this.repositorioPesquisa.desassociaProblema(idPesquisa);
	}

	public boolean associaObjetivo(String idPesquisa, String idObjetivo) {
		
		Validadora.verificaValorNullVazio(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		
		Objetivo objetivo = this.repositorioObjetivos.getObjetivo(idObjetivo);
		return this.repositorioPesquisa.associaObjetivo(idPesquisa, objetivo);
	}

	public boolean desassociaObjetivo(String idPesquisa, String idObjetivo) {
		
		Validadora.verificaValorNullVazio(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		
		Objetivo objetivo = this.repositorioObjetivos.getObjetivo(idObjetivo);
		return this.repositorioPesquisa.dessassociaObjetivo(idPesquisa, objetivo);
	}
	
	
}
