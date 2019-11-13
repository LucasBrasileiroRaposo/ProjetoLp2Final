package projeto;

import java.util.HashMap;
import java.util.Map;

import Util.Validadora;
/**
 *  Classe responsavel por controlar as operacoes dos objetivos, alem de cadastrar, remover e exibir os objetivos.
 * @author Matheus Bezerra Andrade
 *
 */
public class ControllerObjetivos {
	/**
	 * Mapa de objetivos que tem a chave formada por "O" + numero da posicao de cadastro no mapa.
	 */
	private Map<String , Objetivo> mapaObjetivos;
	/**
	 * Atributo que controla a posicao da insercao no mapa, para prosteriormente ser usado como codigo.
	 */
	private int contaObjetivos;
	
	/**
	 * Constroi um novo HashMap e um novo contador de problemas que se inicia pela posicao 1.
	 */
	public ControllerObjetivos() {
		this.mapaObjetivos = new HashMap<>();
		this.contaObjetivos = 1;
	}
	/**
	 * Metodo privado que vefifica se existe um objeto Objetivo no mapa de objetivos.
		 * @param codigo codigo identificador do Mapa
		 * @return true, se existir, false se nao existir.
	 *
	 */
	private boolean existeObjetivo(String codigo) {
		if(this.mapaObjetivos.containsKey(codigo)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Metodo que pega um objeto Objetivo do mapa.
		 * @param codigo codigo identificador do Mapa.
		 * @return um Objeto Objetivo
	 * 
	 */
	private Objetivo pegaObjetivo(String codigo) {
		return this.mapaObjetivos.get(codigo);
	}
	/**
	 * cadastra um objetivo no mapa de objetivos e incrementa uma unidade no contador de objetivos
	 * @param tipo tipo do objetivo, que deve ser GERAL ou ESPECIFICO
	 * @param descricao descricao do objetivo
	 * @param aderencia aderencia do objetivo
	 * @param viabilidade viabilidade do objetivo
	 */
	public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
		Validadora.verificaValorNullVazio(descricao, "Campo descricao nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(descricao, "Campo descricao nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(tipo, "Campo tipo nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(tipo, "Campo tipo nao pode ser nulo ou vazio.");
		if (!(tipo.toUpperCase().equals("GERAL")) && !(tipo.toUpperCase().equals("ESPECIFICO"))) {
			throw new IllegalArgumentException("Valor invalido de tipo.");
		}
		Validadora.verificaViabilidade_Aderencia(viabilidade, "Valor invalido de viabilidade.");
		Validadora.verificaViabilidade_Aderencia(aderencia, "Valor invalido de aderencia");
		
		String codigo = "O"+ this.contaObjetivos;
		Objetivo objetivo = new Objetivo(tipo, descricao, aderencia, viabilidade,codigo);
		this.mapaObjetivos.put(codigo, objetivo);
		this.contaObjetivos ++;
		return codigo;
	}
	/**
	 * Metodo que remove um objetivo do mapa de objetivos.
		 * @param codigo identificador do mapa.
	 * 
	 */
	public void apagarObjetivo(String codigo) {
		Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (existeObjetivo(codigo)){
			this.mapaObjetivos.remove(codigo);
			
		} else {
		throw new IllegalArgumentException("Objetivo nao encontrado");
		}
	}
	/**
	 * 
	 * Metodo que exibe uma representacao textual dos dados de um determinado objetivo
		 * @param codigo codigo identificador do mapa.
		 * @return String com a representacao textual dos dados do objetivo
	 */
	public String exibeObjetivo(String codigo) {
		Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		
		if (existeObjetivo(codigo)) {
			Objetivo objetivo = pegaObjetivo(codigo);
			return objetivo.toString();
		} else {
			throw new IllegalArgumentException("Objetivo nao encontrado");
		}
	}
}