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

	public boolean removeResultado(String codigoAtividade, int numeroResultado) {
		Validadora.verificaValorNullVazio(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		if(numeroResultado < 1) {
			throw new IllegalArgumentException("numeroResultado nao pode ser nulo ou negativo.");
		}
		else {
			return this.repositorioAtividade.removeResultado(codigoAtividade, numeroResultado);
		}
	}

	public int cadastraResultado(String codigoAtividade, String resultado) {
		Validadora.verificaValorNullVazio(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(resultado, "Resultado nao pode ser nulo ou vazio.");
		return this.repositorioAtividade.cadastraResultado(codigoAtividade, resultado);
	}

	public String listaResultados(String codigoAtividade) {
		Validadora.verificaValorNullVazio(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		return this.repositorioAtividade.exibeResultados(codigoAtividade);
	}

	public int getDuracao(String codigoAtividade) {
		Validadora.verificaValorNullVazio(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		return this.repositorioAtividade.getDuracao(codigoAtividade);
	}

}
