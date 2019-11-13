package projeto.objetivos_e_problemas;
/**
 * Classe que representa um Problema.
 * @author Matheus Bezerra Andrade
 *
 */
public class Problema implements Comparable<Problema>{
	/**
	 * Codigo do problema. O qual eh formado por "P" + numero da posicao em que foi guardado no mapa.
	 */
		private String codigo;
		/**
		 * descricao do problema.
		 */
		private String descricao;
		/**
		 * viabilidade do problema.
		 */
		private int viabilidade;
		
		/**
		 * Constroi um problema a partir da descricao, viabilidade e o seu codigo.
		 * @param descricao descricao do problema
		 * @param viabilidade viabilidade do problema 
		 * @param codigo codigo do problema
		 */
		public Problema( String descricao, int viabilidade, String codigo) {
			
			this.codigo = codigo;
			this.descricao = descricao;
			this.viabilidade = viabilidade;
		}

		/**
		 * Representacao em String dos dados do Problema.
		 * @return uma representacao em String dos dados do Problema.
		 */
		@Override
		public String toString() {
			return this.codigo +" - " + this.descricao + " - " + this.viabilidade;
		}

	public String getDescricao() {
		return this.descricao;
	}

	public String getCodigo() {
		return this.codigo;
	}


	@Override
	public int compareTo(Problema problema) {
		return problema.getCodigo().compareTo(this.codigo);
	}
	}