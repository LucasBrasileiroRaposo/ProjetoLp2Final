package projeto.pesquisa_e_associacoes;

import Util.Validadora;
import projeto.atividades.Atividade;
import projeto.atividades.RepositorioAtividade;

public class ControllerAssociacaoPesquisaAtividade {

    private RepositorioPesquisa repositorioPesquisa;

    private RepositorioAtividade repositorioAtividade;

    public ControllerAssociacaoPesquisaAtividade(RepositorioPesquisa repositorioPesquisa, RepositorioAtividade repositorioAtividade) {
        this.repositorioAtividade = repositorioAtividade;
        this.repositorioPesquisa = repositorioPesquisa;
    }

	public boolean associaAtividade(String codigoPesquisa, String codigoAtividade) {
		Validadora.verificaValorNullVazio(codigoPesquisa, "Campo codigoPesquisa nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
    	
		Atividade atividade = this.repositorioAtividade.retornaAtividade(codigoAtividade);
    	return this.repositorioPesquisa.adicionaAtividade(codigoPesquisa, atividade);
	}

	public boolean desassociaAtividade(String codigoPesquisa, String codigoAtividade) {
		Validadora.verificaValorNullVazio(codigoPesquisa, "Campo codigoPesquisa nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		if(!this.repositorioAtividade.atividadeExiste(codigoAtividade)){
			throw new IllegalArgumentException("Atividade nao encontrada");
		}
		else{
			return this.repositorioPesquisa.removeAtividade(codigoPesquisa, codigoAtividade);
		}
	}

	public boolean executaAtividade(String codigoAtividade, int item, int duracao) {
		Validadora.verificaValorNullVazio(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		return this.repositorioAtividade.executaAtividade(codigoAtividade, item, duracao);
	}

}
