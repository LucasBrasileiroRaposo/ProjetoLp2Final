package projeto;

import easyaccept.EasyAccept;

public class Facade {

    private ControllerGeral controllerGeral;

    public static void main(String[] args){
        args = new String[]{"projeto.Facade",  "TestesAceitacao/use_case_1.txt", "TestesAceitacao/use_case_2.txt","TestesAceitacao/use_case_3.txt", "TestesAceitacao/use_case_4.txt", "TestesAceitacao/use_case_7.txt"};
        EasyAccept.main(args);
    }

    public Facade() {
        this.controllerGeral = new ControllerGeral();
    }

    /** Parte 1
     */
    public String cadastraPesquisa(String descricao, String campoDeInteresse) {
        return controllerGeral.cadastraPesquisa(descricao, campoDeInteresse);
    }

    public void encerraPesquisa(String codigo, String motivo) {
        controllerGeral.encerraPesquisa(codigo, motivo);
    }

    public void ativaPesquisa(String codigo) {
                controllerGeral.ativaPesquisa(codigo);
    }

    public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
        controllerGeral.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
    }

    public String exibePesquisa(String codigo) {
                return controllerGeral.exibePesquisa(codigo);
    }

    public boolean pesquisaEhAtiva(String codigo) {
                return controllerGeral.pesquisaEhAtiva(codigo);
    }

    /** Parte 2
     */
    public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String fotoURL){
        controllerGeral.cadastraPesquisador(nome,funcao,biografia,email,fotoURL);
    }
   
    public void alteraPesquisador(String email, String atributo, String novoValor){
        this.controllerGeral.alteraPesquisador(email,atributo,novoValor);
    }
    
    public void desativaPesquisador(String email){
        this.controllerGeral.desativaPesquisador(email);
    }
    
    public void ativaPesquisador(String email){
        this.controllerGeral.ativaPesquisador(email);
    }
    
    public String exibePesquisador(String email){
       return this.controllerGeral.exibePesquisador(email);
    }
    
    public boolean pesquisadorEhAtivo(String email){
        return this.controllerGeral.pesquisadorEhAtivo(email);
    }

    /** Parte 3
     */
    public String cadastraProblema(String descricao, int viabilidade) {
        return this.controllerGeral.cadastraProblema(descricao, viabilidade);
    }

    public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
        return this.controllerGeral.cadastraObjetivo(tipo, descricao, aderencia,viabilidade);
    }
    		
    public void apagarProblema(String codigo) {
        this.controllerGeral.apagarProblema(codigo);
    }

    public void apagarObjetivo(String codigo) {
        this.controllerGeral.apagarObjetivo(codigo);
    }

    public String exibeProblema(String codigo) {
        return this.controllerGeral.exibeProblema(codigo);
    }

    public String exibeObjetivo(String codigo) {
        return this.controllerGeral.exibeObjetivo(codigo);
    }

    /** Parte 4
     */
    public String cadastraAtividade(String Descricao, String nivelRisco, String descricaoRisco){
        return this.controllerGeral.cadastraAtividade(Descricao, nivelRisco, descricaoRisco);
    }
    public void apagaAtividade(String codigo){
        this.controllerGeral.apagaAtividade(codigo);
    }

    public void cadastraItem(String codigo, String item){
        this.controllerGeral.cadastraItem(codigo,item);
    }

    public String exibeAtividade(String codigo){
        return this.controllerGeral.exibeAtividade(codigo);
    }

    public int contaItensPendentes(String codigo){
        return this.controllerGeral.contaItensPendentes(codigo);
    }

    public int contaItensRealizados(String codigo){
        return this.controllerGeral.contaItensRealizados(codigo);
    }
    public boolean associaAtividade(String codigoPesquisa, String codigoAtividade) {
    	return this.controllerGeral.associaAtividade(codigoPesquisa, codigoAtividade);
    }
    public boolean desassociaAtividade(String codigoPesquisa, String codigoAtividade) {
    	return this.controllerGeral.desassociaAtividade(codigoPesquisa, codigoAtividade);
    }
    
    public int cadastraResultado(String codigoAtividade, String resultado) {
    	return this.controllerGeral.cadastraResultado(codigoAtividade, resultado);
    }
    
    public boolean executaAtividade(String codigoAtividade, int item, int duracao) {
    	return this.controllerGeral.executaAtividade(codigoAtividade, item, duracao);
    }
    public boolean removeResultado(String codigoAtividade, int numeroResultado) {
    	return this.controllerGeral.removeResultado(codigoAtividade, numeroResultado);
    }
    public String listaResultados(String codigoAtividade) {
    	return this.controllerGeral.listaResultados(codigoAtividade);
    }
    public int getDuracao(String codigoAtividade) {
    	return this.controllerGeral.getDuracao(codigoAtividade);
    }
}
