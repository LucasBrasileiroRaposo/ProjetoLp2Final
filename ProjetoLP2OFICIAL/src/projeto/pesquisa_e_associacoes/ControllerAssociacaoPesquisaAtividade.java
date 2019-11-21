package projeto.pesquisa_e_associacoes;

import Util.Validadora;
import projeto.atividades.Atividade;
import projeto.atividades.RepositorioAtividade;

public class ControllerAssociacaoPesquisaAtividade {

	/** ControllerPesquisa do sistema
	 */
    private ControllerPesquisa controllerPesquisa;

	/** Repositorio que armazena todas as ativiades do sistema
	 */
    private RepositorioAtividade repositorioAtividade;

    /** Construto do ControllerAssociacaoPesquisaAtividade que recebe como parametro o repositorio de atividades e o controller das pesquisas.
	 * @param controllerPesquisa ControllerPesquisa, que administra todas as acoes que envolvem uma pesquisa.
	 * @param repositorioAtividade RepositorioAtividade, que contem todos as atividades do sistema.
	 */
    public ControllerAssociacaoPesquisaAtividade(ControllerPesquisa controllerPesquisa, RepositorioAtividade repositorioAtividade) {
        this.repositorioAtividade = repositorioAtividade;
        this.controllerPesquisa = controllerPesquisa;
    }

	/** Metodo responsavel por adicionar uma atividades em uma pesquisa determinada pelo usuario
	 *
	 * @param codigoPesquisa String, que representa a chave da pesquisa que o usuário deseja que tenha uma Atividade nele.
	 * @param codigoAtividade String,que represneta o codigo da atividade a ser adionada no mapa de atividades de uma pesquisa.
	 * @return True ou False dependendo se a operacao foi realizada com sucesso ou nao.
	 */
	public boolean associaAtividade(String codigoPesquisa, String codigoAtividade) {
		Validadora.verificaValorNullVazio(codigoPesquisa, "Campo codigoPesquisa nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
    	
		Atividade atividade = this.repositorioAtividade.retornaAtividade(codigoAtividade);
    	return this.controllerPesquisa.adicionaAtividade(codigoPesquisa, atividade);
	}

	/** Metodo responsavel por remover uma atividade de uma pesquisa selecionada pelo usuario.
	 *
	 * @param codigoPesquisa String,que representa a chave da pesquisa que o usuário deseja que tenha um Pesquisador removida dela.
	 * @param codigoAtividade String, que representa o codigo da atividade que o usuario deseja que seja removido do mapa das atividades dentro da pesquisa.
	 * @return True ou False, caso a operação tenha sido realizado com sucesso ou não.
	 */
	public boolean desassociaAtividade(String codigoPesquisa, String codigoAtividade) {
		Validadora.verificaValorNullVazio(codigoPesquisa, "Campo codigoPesquisa nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		if(!this.repositorioAtividade.atividadeExiste(codigoAtividade)){
			throw new IllegalArgumentException("Atividade nao encontrada");
		}
		else{
			return this.controllerPesquisa.removeAtividade(codigoPesquisa, codigoAtividade);
		}
	}

	/**
	 * Metodo que executa uma atividade, no caso, altera o estado do item para
	 * concluido se a operacao for realizada com sucesso e ainda eh setada uma
	 * duracao para ela.
	 *
	 * @param codigoAtividade String, que representa o id da atividade que deve ter seu item executado;
	 * @param item    inteiro que representa o id do item que deve ser executado;
	 * @param duracao inteiro, que representa a duracao em segundos da execucao de
	 *                tal item;
	 * @return true, caso a operação tive sido realizada com sucesso.
	 */
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

	/** Quando chamado deve retornar a duracao da atividade, pedida pelo usuario.
	 * @param codigoAtividade String, que representao o id da atividade, que o usuario deseja que tenha sua duracao retornada.
	 * @return int, que representa a duracao da atividade.
	 */
	public int getDuracao(String codigoAtividade) {
		Validadora.verificaValorNullVazio(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		return this.repositorioAtividade.getDuracao(codigoAtividade);
	}

}
