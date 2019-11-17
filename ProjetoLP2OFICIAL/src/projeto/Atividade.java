package projeto;

import java.util.LinkedHashMap;
import java.util.Map;

/** Classe que representa uma atividade
 */
public class Atividade{

    /**
     * representa a descricao da atividade;
     */
    private String descricao;

    /**
     * Mapa com todos os itens dessa atividade;
     */
    private Map<Integer, Item> resultados;

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
        this.resultados = new LinkedHashMap<>();
        this.contadorDeItensRealizados = 0;
        this.contadorDeItensPendentes = 0;
        this.contadorDeItens = 1;
    }

    /**
     * Quando chamado, esse metodo retorna a representacao textual de um objeto do tipo Atividade.
     *
     * @return as informacoes de cada atividade cadastrada, além dos seus itens e os seus status.
     */
    public String toString() {
        String saida = this.descricao + " (" + this.nivelDeRisco + " - " + this.descricaoDeRisco + ") | ";
        for (Item i : this.resultados.values()) {
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
        this.resultados.put(this.contadorDeItens, itemNovo);
        this.contadorDeItens++;
    }

    /**
     * Quando chamado conta os itens que possuem os status PENDENTE.
     *
     * @return o numero de itens com status PENDENTE;
     */
    public int contaItensPendentes() {
        for (Item i : this.resultados.values()) {
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
        for (Item j : this.resultados.values()) {
            if (j.getEstadoItem().equals("REALIZADO")) {
                this.contadorDeItensRealizados++;
            }
        }
        return this.contadorDeItensRealizados;
    }
}