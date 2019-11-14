package projeto.atividades;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/** Classe que representa uma atividade
 */
public class Atividade implements Comparable<Atividade> {

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
     * Contador de itens realizado;
     */
    private int contadorDeItensRealizados;

    /**
     * Contador de itens pendentes;
     */
    private int contadorDeItensPendentes;

    /**
     * Contador de itens;
     */
    private int contadorDeItens;

    /**
     * Duracao da atividade;
     */
    private int duracaoAtividade;
    
    private String codigoIdentificador;
    
    private int controlaPesquisasAtividade;

    private String codigo;

    /**
     * Constrou um objeto do tipo Atividade, com descricao, nivel de risco da atividade e a descricao desse risco;
     *
     * @param descricao        String, que representa a descricao da atividade;
     * @param nivelDeRisco     String, que representa o nivel de risco da atividade;
     * @param descricaoDeRisco String, que representa a descricao do nivel de risco citado anteriormente.
     */
    public Atividade(String descricao, String nivelDeRisco, String descricaoDeRisco) {
        this.descricao = descricao;
        this.nivelDeRisco = nivelDeRisco;
        this.descricaoDeRisco = descricaoDeRisco;
        this.itens = new LinkedHashMap<>();
        this.contadorDeItensRealizados = 0;
        this.contadorDeItensPendentes = 0;
        this.contadorDeItens = 1;
        this.controlaPesquisasAtividade = 0;
        this.resultadosItens = new HashMap<>();
    }

    /**
     * Quando chamado, esse metodo retorna a representacao textual de um objeto do tipo Atividade.
     *
     * @return as informacoes de cada atividade cadastrada, além dos seus itens e os seus status.
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

        Item itemNovo = new Item(item);
        this.itens.put(this.contadorDeItens, itemNovo);
        this.contadorDeItens++;
    }

    /**
     * Quando chamado conta os itens que possuem os status PENDENTE.
     *
     * @return o numero de itens com status PENDENTE;
     */
    public int contaItensPendentes() {
    	this.contadorDeItensPendentes = 0;
    
        for (Item i : this.itens.values()) {
            if (i.getEstadoItem().equals("PENDENTE")) {
                this.contadorDeItensPendentes++;
            }
        }
        return this.contadorDeItensPendentes;
    }

    /**
     * Quando chamado conta  os itens que possuem os status REALIZADO.
     *
     * @return o numero de itens que costam com o status REALIZADO.
     */
    public int contaItensRealizados() {
    	this.contadorDeItensRealizados = 0;
        for (Item j : this.itens.values()) {
            if (j.getEstadoItem().equals("REALIZADO")) {
                this.contadorDeItensRealizados++;
            }
        }
        return this.contadorDeItensRealizados;
    }

	public void controlaDestinoAtividade(boolean valor){
        if(valor){
	    this.controlaPesquisasAtividade += 1;
    }else{
            this.controlaPesquisasAtividade -=1;
        }
    }


	public boolean executaAtividade(int item, int duracao) {
		if(!this.itens.containsKey(item)) {
			throw new IllegalArgumentException("Item nao encontrado.");
		}
		else {
			if(this.itens.get(item).getDuracao() !=0) {
				throw new IllegalArgumentException("Item ja executado.");
			}
			else {
			    this.itens.get(item).setEstadoItem("REALIZADO");
				this.itens.get(item).alteraDuracao(duracao);
				return true;
			}				
	}
	}

	public int getControlaPesquisasAtividade(){
	    return this.controlaPesquisasAtividade;
    }
	
	public boolean veriricaResultado(int codigoResultado) {
		if(!this.resultadosItens.containsKey(codigoResultado)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public boolean removeResultado(int numeroResultado) {
		if(!this.resultadosItens.containsKey(numeroResultado)) {
    		return false;
    	}
    	else {
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

	public int getDuracaoAtividade() {
		for(Item i: itens.values()){
	        this.duracaoAtividade += i.getDuracao();
        }
		return this.duracaoAtividade;
	}
	
	public void setDuracaoAtividade(int duracaoAtividade) {
		this.duracaoAtividade = duracaoAtividade;
	}
	
	public int retornaDuracao(int codigoItem) {
		return this.itens.get(codigoItem).getDuracao();
	}
    public String getDescricao() {
        return this.descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricaoDeRisco() {
        return descricaoDeRisco;
    }

    @Override
    public int compareTo(Atividade atividade) {
        return atividade.getCodigo().compareTo(this.codigo);
    }
	
	
}
	
	
