package projeto;
/**
 * Classe que representa um Objetivo.
 * @author Matheus Bezerra Andrade
 *
 */
public class Objetivo {
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
	}
	/**
	 * Representacao em String dos dados do Objetivo.
	 * @return  representacao em String dos dados do Objetivo
	 */
	@Override
	public String toString() {
		return this.codigo + " - " + this.tipo + " - " + this.descricao + " - "+ this.valor;
	}



}
