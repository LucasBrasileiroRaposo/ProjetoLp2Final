package projeto.atividades;

/** Classe que representa um item.
 */
public class Item {

	private int duracao;
    /** String que representa o status/estado do item.
     */
    private String estadoItem;

    /** String que representa o nome do item.
     */
    private String nomeItem;

    /** Constroi um objeto do tipo Item, recebendo o nome dele e ja estabelece seu estado como PENDENTE.
     * @param item String, que representa como o item eh nomeado pelo usuário.
     */
    public Item(String item){
        this.nomeItem = item;
        this.estadoItem = "PENDENTE";
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
}
