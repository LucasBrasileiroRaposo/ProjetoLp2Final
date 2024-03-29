package projeto.atividades;

import java.io.Serializable;

/** Classe que representa um item.
 */
public class Item implements Serializable {

	private int duracao;
    /** String que representa o status/estado do item.
     */
    private String estadoItem;

    /** String que representa o nome do item.
     */
    private String nomeItem;
    
    private int codigoItem;

    /** Constroi um objeto do tipo Item, recebendo o nome dele e ja estabelece seu estado como PENDENTE.
     * @param item String, que representa como o item eh nomeado pelo usuário.
     * @param codigoItem, int, que representa o numero desse item.
     */
    public Item(String item, int codigoItem){
        this.nomeItem = item;
        this.estadoItem = "PENDENTE";
        this.codigoItem = codigoItem;
        
    }

    /** Quando chamado retorna o estado do item.
     *
     * @return String do estado do item.
     */
    public String getEstadoItem(){
        return this.estadoItem;
    }
    
    public String getNomeItem() {
    	return this.nomeItem;
    }

    /** Quando chamado retorna a representacao textual do Item.
     *
     * @return String, com o estado e o nome do item.
     */
    public String toString(){
        return this.estadoItem + " - " + this.nomeItem;
    }

    public int getDuracao() {
		return duracao;
	}
    public void setEstadoItem(String estadoItem){
        this.estadoItem = estadoItem;
    }
    
    public void alteraDuracao(int duracao) {
		this.duracao = duracao;
		
	}
    public int getCodigoItem() {
    	return this.codigoItem;
    }
    
    public String retornaTxt() {
    	return this.estadoItem + " - " + "ITEM"+ this.codigoItem;
    }
}
