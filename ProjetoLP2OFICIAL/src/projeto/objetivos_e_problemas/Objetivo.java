package projeto.objetivos_e_problemas;
/**
 * Classe que representa um Objetivo.
 * @author Matheus Bezerra Andrade
 *
 */
public class Objetivo implements Comparable<Objetivo>{
	/**
	 * Tipo do objetivo. O tipo só pode ser Geral ou Especifico.
	 */
	private String tipo;
	/**
	 * Descricao do objetivo.
	 */
	private String descricao;
	/**
	 * Aderencia do objetivo.
	 */
	private int aderencia;
	/**
	 * Viabilidade do objetivo.
	 */
	private int viabilidade;
	/**
	 * Codigo do Objetivo. Formado por "O" + numero da posicao em que foi guardado no mapa.
	 */
	private String codigo;
	/**
	 * Valor do objetivo, o qual é a soma da aderencia e da viabilidade.
	 */
	private int valor;
	
	/**
	 * Metodo que indica se este objetivo ja esta associado a uma pesquisa, ou nao.
	 */
	private boolean associado;
	
	/**
	 * 
	 * Constroi um objetivo a partir do seu tipo, descricao, aderencia, viabilidade e codigo.
	 * @param tipo tipo do objetivo (Especifico ou Geral)
	 * @param descricao descricao do objetivo
	 * @param aderencia aderencia do objetivo
	 * @param viabilidade  viabilidade do objetivo
	 * @param codigo codigo do objetivo
	 */
	public Objetivo(String tipo, String descricao, int aderencia, int viabilidade, String codigo) {
		this.tipo = tipo;
		this.descricao = descricao;
		this.aderencia = aderencia;
		this.codigo = codigo;
		this.viabilidade = viabilidade;
		this.valor = this.viabilidade + this.aderencia;
		this.associado = false;
	}
	/**
	 * Representacao em String dos dados do Objetivo.
	 * @return  representacao em String dos dados do Objetivo
	 */
	@Override
	public String toString() {
		return this.codigo + " - " + this.tipo + " - " + this.descricao + " - "+ this.valor;
	}
	
	/**
	 * metodo que indica que o objetivo foi associado a uma pesquisa.
	 */
	public void associaObjetivo() {
		this.associado = true;
		
	}
	
	public boolean getAssociado() {
		return this.associado;
		
	}
	
	/**
	 *  metodo que indica que o objetivo foi desassociado de  uma pesquisa.
	 */
	public void desassociaObjetivo() {
		
		this.associado = false;
		
	}

	public String getDescricao() {
		return this.descricao;
	}

	public String getCodigo() {
		return codigo;
	}


	@Override
	public int compareTo(Objetivo objetivo) {
		return objetivo.getCodigo().compareTo(this.codigo);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objetivo other = (Objetivo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	/**
	 * Metodo respons�vel por retorna representa��o textual para o arquivo txt
	 * @return String com informacoes do objetivo
	 */
	public String retornaTxt() {
		return "      - " + this.codigo + " - " + this.descricao + " - "+ this.valor;
	}
	
	

}
