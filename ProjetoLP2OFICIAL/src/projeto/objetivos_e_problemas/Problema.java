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
		Problema other = (Problema) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}

