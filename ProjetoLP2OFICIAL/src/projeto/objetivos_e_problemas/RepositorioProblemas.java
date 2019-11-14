package projeto.objetivos_e_problemas;

	
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import projeto.busca.Busca;
import Util.Validadora;
import projeto.objetivos_e_problemas.Problema;

/**
	 * Classe responsavel por controlar a colecao de problemas, alem de cadastrar, apagar e exibir os problemas.
	 * @author Matheus Bezerra Andrade
	 *
	 */
	public class RepositorioProblemas implements Busca{
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
			this.mapaProblemas = new LinkedHashMap<>();
			
			
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
		public Problema getProblema(String codigo) {
			if(existeProblema(codigo)) {
				return this.mapaProblemas.get(codigo);
			}
			throw new IllegalArgumentException("Problema nao existe.");
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
				Problema problema = getProblema(codigo);
					return problema.toString();
				}
			else {
				throw new IllegalArgumentException("Problema nao encontrado");
			}
		}
	@Override
	public String busca(String termo) {
		Validadora.verificaValorNullVazio(termo,"Campo termo nao pode ser nulo ou vazio.");
		String msg = "";
		List<Problema> listaDeProblemas = new ArrayList<>();
		listaDeProblemas.addAll(this.mapaProblemas.values());
		Collections.sort(listaDeProblemas);
		for(Problema problema : listaDeProblemas){
			if(problema.getDescricao().contains(termo)) {
				msg += problema.getCodigo() +": "+problema.getDescricao() + " | ";
			}
		}
		return msg;
	}


	@Override
	public int contaResultadosBusca(String termo) {
		Validadora.verificaValorNullVazio(termo,"Campo termo nao pode ser nulo ou vazio.");
		int cont = 0;
		for(String palavra: busca(termo).split(" | ")){
			if(termo.contains(palavra)) {
				cont += 1;
			}
		}
		return cont;
	}}