package projeto.atividades;

import java.util.*;

/**
 * Classe que representa uma atividade
 */
public class Atividade implements Comparable<Atividade> {

	/**
	 * representa a descricao da atividade;
	 */
	private String descricao;
	/**
	 * Mapa com os resultados de um item
	 */
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
	private Atividade atividade;

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

	/**
	 * Metodo responsavel por verificar se um resultado esta no mapa de resultados dos itens
	 * @param codigoResultado inteiro referente a um resultado
	 * @return retorna true ou false
	 */
	public boolean veriricaResultado(int codigoResultado) {
		if (!this.resultadosItens.containsKey(codigoResultado)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Metodo responsavel por remover um resultado de um item
	 * @param numeroResultado inteiro referente a um resultado
	 * @return retorna true ou false
	 */
	public boolean removeResultado(int numeroResultado) {
		if (!this.resultadosItens.containsKey(numeroResultado)) {
			return false;
		} else {
			this.resultadosItens.remove(numeroResultado);
			return true;
		}

	}


	int i = 0;
	/**
	 * Metodo responsavel por colocar um resultado dentro do mapa de resultados dos itens;		
	 * @param resultado resultado a ser colocado dentro do mapa;
	 * @return retorna o inteiro que se refere ao resultado;
	 */
	public int cadastraResultado(String resultado) {
		i += 1;
		this.resultadosItens.put(i, resultado);
		return i;
	}
	
	/**
	 * Metodo responsavel por retornar os resultados dos itens
	 * @return retorna uma string com os resultados
	 */
	public String exibeResultados() {
		String saida = "";
		for (String i : this.resultadosItens.values()) {
			saida += i.toString() + " | ";
		}
		return saida.substring(0, saida.length() - 3);
	}
	
	/**
	 * Metodo responsavel por retornar a duracao da atividade
	 * @return retorna o inteiro da duracao
	 */
	public int getDuracaoAtividade() {
		for (Item i : itens.values()) {
			this.duracaoAtividade += i.getDuracao();
		}
		return this.duracaoAtividade;
	}

	/**
	 * Metodo responsavel por retornar a descricao da atividade
	 * @return retorna a descricao
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Metodo responsavel por retornar o codigo de uma atividade
	 * @return retorna o codigo
	 */
	public String getCodigo() {
		return this.codigo;
	}
	/**
	 * Metodo responsavel por altera o codigo de uma atividade
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo responsavel por retorna a descricao de risco de uma atividade
	 * @return retorna a descricao de risco da atividade
	 */
	public String getDescricaoDeRisco() {
		return descricaoDeRisco;
	}

	@Override
	public int compareTo(Atividade atividade) {
		return atividade.getCodigo().compareTo(this.codigo);
	}

	public String getNivelDeRisco() {
		return nivelDeRisco;
	}

	public void criaPrecedente(Atividade atividade1) {
		this.listadeOrdemAtividades.add(atividade1);
	}

	public boolean apontaPara(Atividade atividade2) {
		if (this.atividade != null) {
			return false;
		} else {
			for (Atividade a : this.listadeOrdemAtividades) {
				if (a.equals(atividade)) {
					throw new IllegalArgumentException("Criacao de loops negada.");
				}
				a.checaAnterior(atividade2);
			}
			this.atividade = atividade2;
			return true;
		}
	}

	private void checaAnterior(Atividade atividade) {
		for (Atividade a : this.listadeOrdemAtividades) {
			if (a.equals(atividade)) {
				throw new IllegalArgumentException("Criacao de loops negada.");
			}
			a.checaAnterior(atividade);
		}
	}

	public void tiraSubsquente() {
		if (this.atividade != null) {
			this.atividade.removePrecedente(this);
			this.atividade = null;
		}

	}

	private void removePrecedente(Atividade atividade) {
		this.listadeOrdemAtividades.remove(atividade);
	}

	public int contaProximos() {
		if (this.atividade == null) {
			return 0;
		} else {
			return 1 + this.atividade.contaProximos();
		}
	}

	public String pegaProximo(int enesimaAtividade) {
		if (this.atividade == null) {
			throw new IllegalArgumentException("Atividade inexistente.");
		}
		if (enesimaAtividade == 1) {
			return this.atividade.getCodigo();
		} else {
			return this.atividade.pegaProximo(enesimaAtividade - 1);
		}

	}

	public String pegaMaiorRiscoAtividades(Atividade atividadeEscolhida) {
		if (this.atividade == null) {
			return this.getCodigo();
		} else if (atividadeEscolhida.getNivelDeRisco().equals(this.atividade.getNivelDeRisco())) {
			return this.atividade.pegaMaiorRiscoAtividades(atividade);
		} else if (atividadeEscolhida.getNivelDeRisco().equals("BAIXO")
				&& this.atividade.getNivelDeRisco().equals("MEDIO")) {
			return this.atividade.pegaMaiorRiscoAtividades(atividade);
		} else if (this.atividade.getNivelDeRisco().equals("ALTO")) {
			return this.atividade.pegaMaiorRiscoAtividades(atividade);
		} else {
			return this.atividade.pegaMaiorRiscoAtividades(atividadeEscolhida);
		}
	}

	public Atividade getProximaAtiviade() {
		return this.atividade;
	}

	public void setDuracaoAtividade(int duracaoAtividade) {
		this.duracaoAtividade = duracaoAtividade;
	}

	public int retornaDuracao(int codigoItem) {
		return this.itens.get(codigoItem).getDuracao();
	}

	/**
	 * Metodo responsavel por retornar texto com as informacoes referentes aos itens
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

	/**
	 * Metodo responsavel por retornar um texto com as informacoes referente aos itens da ULTIMA atividade
	 * @return retorna string com as informacoes dos itens de uma atividade
	 */
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
	 * Metodo responsavel por retornar itens e resultados para representacao textual do arquivo txt
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

	/**
	 * Metodo responsavel por retornar itens e resultados da ULTIMA atividade para representacao textual do arquivo txt
	 * @return String com informacoes de Itens e resultados
	 */
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
