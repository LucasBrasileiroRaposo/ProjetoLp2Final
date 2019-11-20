package projeto.atividades;

import java.io.Serializable;
import java.util.*;

/**
 * Classe que representa uma atividade
 */
public class Atividade implements Comparable<Atividade>, Serializable {

	/**
	 * representa a descricao da atividade;
	 */
	private String descricao;

	private HashMap<Integer, String> resultadosItens;

	/**
	 * Mapa com todos os itens dessa atividade;
	 */
	private Map<Integer, Item> itens;

	/**
	 * Nivel de risco da atividade;
	 */
	private String nivelDeRisco;

	/**
	 * Descricao do risco da atividade;
	 */
	private String descricaoDeRisco;

	/**
	 * Contador de itens;
	 */
	private int contadorDeItens;

	/**
	 * Duracao da atividade;
	 */
	private int duracaoAtividade;

	/**
	 * Contador de pesquisas que essa atividade esta associada;
	 */
	private int controlaPesquisasAtividade;

	/**
	 * Codigo identidicador da atividade;
	 */
	private String codigo;

	/**
	 * Proxima pesquisa que é sugerida de ser executada pos a atual;
	 */
	private Atividade proximaAtividade;

	/**
	 * Lista de atividades que esta atividade atual aponta,precede;
	 */
	private List<Atividade> listadeOrdemAtividades;

	/**
	 * Constrou um objeto do tipo Atividade, com descricao, nivel de risco da
	 * atividade e a descricao desse risco;
	 *
	 * @param descricao        String, que representa a descricao da atividade;
	 * @param nivelDeRisco     String, que representa o nivel de risco da atividade;
	 * @param descricaoDeRisco String, que representa a descricao do nivel de risco
	 *                         citado anteriormente.
	 */
	public Atividade(String descricao, String nivelDeRisco, String descricaoDeRisco) {
		this.descricao = descricao;
		this.nivelDeRisco = nivelDeRisco;
		this.descricaoDeRisco = descricaoDeRisco;
		this.itens = new LinkedHashMap<>();
		this.contadorDeItens = 1;
		this.controlaPesquisasAtividade = 0;
		this.resultadosItens = new HashMap<>();
		this.listadeOrdemAtividades = new ArrayList<>();
	}

	/**
	 * Quando chamado, esse metodo retorna a representacao textual de um objeto do
	 * tipo Atividade.
	 *
	 * @return as informacoes de cada atividade cadastrada, além dos seus itens e os
	 *         seus status.
	 */
	public String toString() {
		String saida = this.descricao + " (" + this.nivelDeRisco + " - " + this.descricaoDeRisco + ") | ";
		for (Item i : this.itens.values()) {
			saida += i.toString() + " | ";
		}
		return saida.substring(0, saida.length() - 3);
	}

	/**
	 * Auxilia na construcao ne um novo objeto do tipo Item.
	 *
	 * @param item String, que representa o nome do item.
	 */
	public void cadastraItem(String item) {

		Item itemNovo = new Item(item, this.contadorDeItens);
		this.itens.put(this.contadorDeItens, itemNovo);
		this.contadorDeItens++;
	}

	/**
	 * Quando chamado conta os itens que possuem os status PENDENTE.
	 *
	 * @return o numero de itens com status PENDENTE;
	 */
	public int contaItensPendentes() {
		/**
		 * Contador de itens pendentes;
		 */
		int contadorDeItensPendentes = 0;

		for (Item i : this.itens.values()) {
			if (i.getEstadoItem().equals("PENDENTE")) {
				contadorDeItensPendentes++;
			}
		}
		return contadorDeItensPendentes;
	}

	/**
	 * Quando chamado conta os itens que possuem os status REALIZADO.
	 *
	 * @return o numero de itens que costam com o status REALIZADO.
	 */
	public int contaItensRealizados() {
		/**
		 * Contador de itens realizado;
		 */
		int contadorDeItensRealizados = 0;
		for (Item j : this.itens.values()) {
			if (j.getEstadoItem().equals("REALIZADO")) {
				contadorDeItensRealizados++;
			}
		}
		return contadorDeItensRealizados;
	}

	/**
	 * Metodo que vai ajudar a detectar se a atividade esta sendo utilizada em uma
	 * pesquisa ou nao;
	 * 
	 * @param valor recebe True, caso esteja sendo adicionada em uma pesquisa, ou
	 *              False caso esteja sendo desassociada;
	 */
	public void controlaDestinoAtividade(boolean valor) {
		if (valor) {
			this.controlaPesquisasAtividade += 1;
		} else if (!valor) {
			this.controlaPesquisasAtividade -= 1;
		}
	}

	/**
	 * Metodo que executa uma atividade, no caso, altera o estado do item para
	 * concluido se a operacao for realizada com sucesso e ainda eh setada uma
	 * duracao para ela.
	 * 
	 * @param item    inteiro que representa o id do item que deve ser executado;
	 * @param duracao inteiro, que representa a duracao em segundos da execucao de
	 *                tal item;
	 * @return true, caso a operação tive sido realizada com sucesso.
	 */
	public boolean executaAtividade(int item, int duracao) {
		if (!this.itens.containsKey(item)) {
			throw new IllegalArgumentException("Item nao encontrado.");
		} else {
			if (this.itens.get(item).getDuracao() != 0) {
				throw new IllegalArgumentException("Item ja executado.");
			} else {
				this.itens.get(item).setEstadoItem("REALIZADO");
				this.itens.get(item).alteraDuracao(duracao);
				return true;
			}
		}
	}

	/**
	 * Quando chamado retorna o numero de pesquisas que a atividade esta associada.
	 * 
	 * @return int, o numero de pesquisas que a atividade esta associada.
	 */
	public int getControlaPesquisasAtividade() {
		return this.controlaPesquisasAtividade;
	}


	public boolean veriricaResultado(int codigoResultado) {
		if (!this.resultadosItens.containsKey(codigoResultado)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean removeResultado(int numeroResultado) {
		if (!this.resultadosItens.containsKey(numeroResultado)) {
			return false;
		} else {
			this.resultadosItens.remove(numeroResultado);
			return true;
		}

	}

	int i = 0;

	public int cadastraResultado(String resultado) {
		i += 1;
		this.resultadosItens.put(i, resultado);
		return i;
	}

	public String exibeResultados() {
		String saida = "";
		for (String i : this.resultadosItens.values()) {
			saida += i.toString() + " | ";
		}
		return saida.substring(0, saida.length() - 3);
	}

	/** Metodo que soma a duracao de todos os itens e logo esse valor representa a duracao da atividade.
	 *
	 * @return int, que representa o tempo ,em segundos, necessario para execucao dessa atividade.
	 */
	public int getDuracaoAtividade() {
		for (Item i : itens.values()) {
			this.duracaoAtividade += i.getDuracao();
		}
		return this.duracaoAtividade;
	}

	/** Quando chamado deve retorna uma String.
	 * @return String, que representa a descricao da atividade.
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/** Quando chamado retorna uma String.
	 * @return String, que representa o codigo identificador da atividade.
	 */
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/** Quando chamado retorna uma String.
	 * @return String, que representa  a descricaoDeRisco da atividade.
	 */
	public String getDescricaoDeRisco() {
		return descricaoDeRisco;
	}

	@Override
	public int compareTo(Atividade atividade) {
		return atividade.getCodigo().compareTo(this.codigo);
	}

	/** Quando chamado, retorna uma String.
	 * @return String que representa o nivel de risco da atividade.
	 */
	public String getNivelDeRisco() {
		return nivelDeRisco;
	}

	/** Quando chamado esse metodo, adiciona em uma lista a atividade que "aponta" para a atividade atual.
	 * @param atividade1 atividade que aponta para atividade atual.
	 */
	public void criaPrecedente(Atividade atividade1) {
		this.listadeOrdemAtividades.add(atividade1);
	}

	/**  Esse metodo funciona, para colocar como proximaAtividade a tividade que foi passada como parametro.
	 *
	 * @param atividade2 eh a atividade para qual a atividade atual "aponta";
	 * @return True, caso a operacao tenha sido realizada com sucesso, ou False caso nao.
	 */
	public boolean apontaPara(Atividade atividade2) {
		if (this.proximaAtividade != null) {
			return false;
		} else {
			for (Atividade a : this.listadeOrdemAtividades) {
				if (a.equals(proximaAtividade)) {
					throw new IllegalArgumentException("Criacao de loops negada.");
				}
				a.checaAnterior(atividade2);
			}
			this.proximaAtividade = atividade2;
			return true;
		}
	}

	/** Metodo, responsavel por checar se esta ocorrendo um looping na ordem de execucao das atividade, no caso vendo se uma possivel proxima atividade ja esta
	 * apontando para atividade atual ou nao.
	 * @param atividade atividade que vai ser checada, se ja aponta para essa atividade ou para alguma de suas precedentes.
	 */
	private void checaAnterior(Atividade atividade) {
		for (Atividade a : this.listadeOrdemAtividades) {
			if (a.equals(atividade)) {
				throw new IllegalArgumentException("Criacao de loops negada.");
			}
			a.checaAnterior(atividade);
		}
	}

	/** Metodo, que vai quebrar uma sequencia, retirando a atividade da sequencia, no caso tornando o atributo proximaAtividade novamente vazio,
	 *  e acessando a lista de precedentes da Atividade proximaAtividade e removendo a atividade atual dela.
	 *
	 */
	public void tiraSubsquente() {
		if (this.proximaAtividade != null) {
			this.proximaAtividade.removePrecedente(this);
			this.proximaAtividade = null;
		}

	}

	/** Metodo que remove uma atividade da lista de atividade que "apontam" para atividade atual.
	 * @param atividade atividade que deve ser removida da lista de precedentes.
	 */
	private void removePrecedente(Atividade atividade) {
		this.listadeOrdemAtividades.remove(atividade);
	}

	/** Metodo que conta quantas atividades estão ordenadas para serem executadas depois da atual.
	 * @return inteiro que representa esse valor.
	 */
	public int contaProximos() {
		if (this.proximaAtividade == null) {
			return 0;
		} else {
			return 1 + this.proximaAtividade.contaProximos();
		}
	}

	/** Metodo que retorna o codigo da atividade que o usuario deseja que seja exibida,quando sua ordem.
	 *
	 * @param enesimaAtividade é o valor que representa a atividade, na ordem de execucao, no caso a enesima atividade a ser executada apos a atual.
	 * @return o codigo dessa determinada atividade ou a mensagem que não existe, caso não exista enesimo fator.
	 */
	public String pegaProximo(int enesimaAtividade) {
		if (this.proximaAtividade == null) {
			throw new IllegalArgumentException("Atividade inexistente.");
		}
		if (enesimaAtividade == 1) {
			return this.proximaAtividade.getCodigo();
		} else {
			return this.proximaAtividade.pegaProximo(enesimaAtividade - 1);
		}

	}

	/** Metodo responsavel por retornar a atividade que possui o maio nivel de risco em uma sequencia.
	 *
	 * @param atividadeEscolhida é uma atividade passada como parametro que sera comparada com aproxima, e dependendo do nivel, ou sera substituida por essa
	 *                           atividade comparada ou manter a atividade antiga passada como parametro.
	 * @return o codigo da atividade com o maior risco da sequencia.
	 */
	public String pegaMaiorRiscoAtividades(Atividade atividadeEscolhida) {
		if (this.proximaAtividade == null) {
			return atividadeEscolhida.getCodigo();
		} else if (atividadeEscolhida.getNivelDeRisco().equals(this.proximaAtividade.getNivelDeRisco())) {
			return this.proximaAtividade.pegaMaiorRiscoAtividades(proximaAtividade);
		} else if (atividadeEscolhida.getNivelDeRisco().equals("BAIXO") && this.proximaAtividade.getNivelDeRisco().equals("MEDIO")) {
			return this.proximaAtividade.pegaMaiorRiscoAtividades(proximaAtividade);
		} else if (this.proximaAtividade.getNivelDeRisco().equals("ALTO")) {
			return this.proximaAtividade.pegaMaiorRiscoAtividades(proximaAtividade);
		} else {
			return this.proximaAtividade.pegaMaiorRiscoAtividades(atividadeEscolhida);
		}
	}

	/** Metodo que retorna a proximaAtividade em relacao a atividade atual.
	 * @return um objeto do tipo Atividade, que representa a atividade subsequente a atual.
	 */
	public Atividade getProximaAtiviade() {
		return this.proximaAtividade;
	}

	public void setDuracaoAtividade(int duracaoAtividade) {
		this.duracaoAtividade = duracaoAtividade;
	}

	public int retornaDuracao(int codigoItem) {
		return this.itens.get(codigoItem).getDuracao();
	}

	/**
	 * Metodo responsavel por retornar texto com as informacoes referentes aos itens
	 * 
	 * @return string com as informacoes do itens
	 */
	public String retornaTxt() {
		int contador = 1;
		String saida = "     - " + this.descricao + " (" + this.nivelDeRisco + " - " + this.descricaoDeRisco + ")"
				+ "\r\n";
		for (Item i : this.itens.values()) {
			if (this.itens.size() == contador) {
				saida += "        - " + i.retornaTxt() + "\r\n ";
			} else {
				saida += "        - " + i.retornaTxt() + "\r\n ";
				contador++;
			}
		}
		return saida;
	}

	public String retornaTxtFinal() {
		int contador = 1;
		String saida = "     - " + this.descricao + " (" + this.nivelDeRisco + " - " + this.descricaoDeRisco + ")"
				+ "\r\n";
		for (Item i : this.itens.values()) {
			if (this.itens.size() == contador) {
				saida += "        - " + i.retornaTxt();
			} else {
				saida += "        - " + i.retornaTxt() + "\r\n ";
				contador++;
			}
		}
		return saida;

	}

	/**
	 * Metodo responsavel por retorna representacao textual para o arquivo txt
	 * 
	 * @return String com informacoes de Itens
	 */
	public String retornaItensRealizados() {
		int contador = 1;
		String saida = "- " + this.getDescricao() + "\r\n ";
		for (Item i : this.itens.values()) {
			if (i.getEstadoItem().contentEquals("REALIZADO")) {
				saida += "         - " + "ITEM" + i.getCodigoItem() + " - " + i.getDuracao() + "\r\n ";
			}
		}
		for (String i : this.resultadosItens.values()) {
			if (this.resultadosItens.size() == contador) {
				saida += "         - " + i + "\r\n ";
			} else {
				saida += "         - " + i + "\r\n ";
				contador++;
			}
		}
		return saida;
	}

	public String retornaItensRealizadosFinal() {
		int contadorItens = 1;
		int contadorResultados = 1;
		String saida = "- " + this.getDescricao();
		for (Item i : this.itens.values()) {
			if (this.itens.size() == contadorItens) {
				if (i.getEstadoItem().equals("REALIZADO") && this.resultadosItens.size() == 0) {
					saida += "\r\n " + "         - " + "ITEM" + i.getCodigoItem() + " - " + i.getDuracao();
				}
				else if(i.getEstadoItem().equals("REALIZADO")) {
					saida += "\r\n " + "         - " + "ITEM" + i.getCodigoItem() + " - " + i.getDuracao();
				}
			}
				 else {
					if (i.getEstadoItem().equals("REALIZADO")) {
						saida += "\r\n " + "         - " + "ITEM" + i.getCodigoItem() + " - " + i.getDuracao();
					}
				}
				contadorItens++;
			}
		

		for (String i : this.resultadosItens.values()) {
			if (this.resultadosItens.size() == contadorResultados) {
				saida += "         - " + i;
			} else {
				saida += "\r\n" + "         - " + i + "\r\n ";
				contadorResultados++;
			}
		}
		return saida;
	}

}
