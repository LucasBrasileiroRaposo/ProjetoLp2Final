package projeto.objetivos_e_problemas;

	
import java.util.HashMap;
import java.util.Map;

import projeto.Util.Validadora;

/**
	 * Classe responsavel por controlar a colecao de problemas, alem de cadastrar, apagar e exibir os problemas.
	 * @author Matheus Bezerra Andrade
	 *
	 */
	public class RepositorioProblemas {
		/**
		 * Mapa que contem os problemas. A sua chave eh formada por "P"+ o numero da posicao da insercao no mapa.
		 */
		private Map< String , Problema> mapaProblemas;
		/**
		 * Atributo que controla a posicao da insercao no mapa, para prosteriormente ser usado como codigo.
		 * 
		 */
		private int contaProblemas;
	
		/**
		 * Constroi um novo HashMap e um novo contador de problemas que se inicia pela posicao 1.
		 */
		public RepositorioProblemas() {
			this.mapaProblemas = new HashMap< >();
			
			
			this.contaProblemas = 1;
			
		}
		/**
		 * Metodo privado que vefifica se existe um objeto Problema no mapa de problemas.
		 * @param codigo codigo identificador do Mapa
		 * @return true, se existir, false se nao existir.
		 */
		private boolean existeProblema(String codigo) {
			if(this.mapaProblemas.containsKey(codigo)) {
				return true;
			} else {
				return false;
			}
		}
		/**
		 * Metodo que pega um objeto Problema do mapa.
		 * @param codigo codigo identificador do Mapa.
		 * @return um Objeto Problema
		 */
		private Problema pegaProblema(String codigo) {
			return this.mapaProblemas.get(codigo);
		}
		/**
		 * cadastra um problema no mapa de problemas e incrementa uma unidade no contador de problemas
		 * @param descricao descricao do problema
		 * @param viabilidade viabilidade do problema
		 */
		public String cadastraProblema(String descricao, int viabilidade) {
			Validadora.verificaValorNullVazio(descricao, "Campo descricao nao pode ser nulo ou vazio.");
			Validadora.verificaValorNullVazio(descricao, "Campo descricao nao pode ser nulo ou vazio.");
			Validadora.verificaViabilidade_Aderencia(viabilidade, "Valor invalido de viabilidade.");
			
			
			String codigo = "P" + this.contaProblemas;
			Problema problema = new Problema(descricao, viabilidade,codigo);
			this.mapaProblemas.put(codigo, problema);
			
			this.contaProblemas ++;
			return codigo;
		}
		/**
		 * Metodo que remove um problema do mapa de problemas.
		 * @param codigo identificador do mapa.
		 */
		public void apagarProblema(String codigo) {
			Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");
			Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");
			
			if (existeProblema(codigo)) {
				this.mapaProblemas.remove(codigo);
				}
			else {
				throw new IllegalArgumentException("Problema nao encontrado");
			}
			
		}
		/**
		 * Metodo que exibe uma representacao textual dos dados de um determinado problema
		 * @param codigo codigo identificador do mapa.
		 * @return String com a representacao textual dos dados do Problema
		 */
		public String exibeProblema(String codigo) {
			Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");
			Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");
			
			if (existeProblema(codigo)){
				Problema problema = pegaProblema(codigo);
					return problema.toString();
				}
			else {
				throw new IllegalArgumentException("Problema nao encontrado");
			}
		}		
		
}