 package projeto;


import easyaccept.EasyAccept;
import projeto.atividades.RepositorioAtividade;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;
import projeto.pesquisa_e_associacoes.RepositorioPesquisa;
import projeto.pesquisa_e_associacoes.ControllerPesquisa;
import projeto.pesquisa_e_associacoes.ControllerAssociacaoPesquisaObjetivoProblema;
import projeto.pesquisa_e_associacoes.ControllerAssociacaoPesquisaAtividade;
import projeto.pesquisa_e_associacoes.ControllerAssociacaoPesquisaPesquisador;
import projeto.pesquisadores.RepositorioPesquisador;
import projeto.busca.ControllerBusca;

import java.io.IOException;

 public class Facade {

    private RepositorioAtividade repositorioAtividades;

    private RepositorioPesquisador repositorioPesquisadores;

    private RepositorioPesquisa repositorioPesquisa;

    private RepositorioProblemas repositorioProblemas;

    private RepositorioObjetivos repositorioObjetivos;

    private ControllerAssociacaoPesquisaObjetivoProblema controllerAssociacaoPesquisaObjetivoProblema;

    private ControllerAssociacaoPesquisaAtividade controllerAssociacaoPesquisaAtividade;

    private ControllerAssociacaoPesquisaPesquisador controllerAssociacaoPesquisaPesquisador;

    private ControllerPesquisa controllerPesquisa;

    private ControllerBusca controllerBusca;

    private ControllerDados controllerDados;



    public static void main(String[] args){
        args = new String[]{"projeto.Facade", /**"easyaccept/use_case_1.txt", "easyaccept/use_case_2.txt","easyaccept/use_case_3.txt",
        		"easyaccept/use_case_4.txt",
        		"easyaccept/use_case_5.txt", "easyaccept/use_case_6.txt","easyaccept/use_case_7.txt",
        		"easyaccept/use_case_8.txt","easyaccept/use_case_9.txt",
        		"easyaccept/use_case_10.txt", "easyaccept/use_case_11.txt",*//**
                "easyaccept/use_case_12SALVAR.txt",*/"easyaccept/use_case_12CARREGAR.txt"};
        EasyAccept.main(args);
    }

    public Facade() {
        this.repositorioAtividades = new RepositorioAtividade();
        this.repositorioPesquisadores = new RepositorioPesquisador();
        this.repositorioPesquisa = new RepositorioPesquisa();
        this.controllerPesquisa = new ControllerPesquisa(this.repositorioPesquisa);
        this.repositorioObjetivos = new RepositorioObjetivos();
        this.repositorioProblemas = new RepositorioProblemas();
        this.controllerAssociacaoPesquisaPesquisador = new ControllerAssociacaoPesquisaPesquisador(this.controllerPesquisa,this.repositorioPesquisadores);
        this.controllerAssociacaoPesquisaAtividade = new ControllerAssociacaoPesquisaAtividade(this.controllerPesquisa,this.repositorioAtividades);
        this.controllerAssociacaoPesquisaObjetivoProblema = new ControllerAssociacaoPesquisaObjetivoProblema(this.controllerPesquisa,this.repositorioObjetivos,this.repositorioProblemas);
        this.controllerBusca = new ControllerBusca(this.repositorioPesquisa,this.repositorioPesquisadores,this.repositorioProblemas,this.repositorioObjetivos,this.repositorioAtividades);
        this.controllerDados = new ControllerDados(this.repositorioAtividades,this.repositorioObjetivos,this.repositorioProblemas,this.repositorioPesquisa,this.repositorioPesquisadores);

    }

    /** Parte 1
     */
    public String cadastraPesquisa(String descricao, String campoDeInteresse) {
        return this.controllerPesquisa.cadastraPesquisa(descricao, campoDeInteresse);
    }

    public void encerraPesquisa(String codigo, String motivo) {
        this.controllerPesquisa.encerraPesquisa(codigo, motivo);
    }

    public void ativaPesquisa(String codigo) {
        this.controllerPesquisa.ativaPesquisa(codigo);
    }

    public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
        this.controllerPesquisa.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
    }

    public String exibePesquisa(String codigo) {
                return controllerPesquisa.exibePesquisa(codigo);
    }

    public boolean pesquisaEhAtiva(String codigo) {
                return controllerPesquisa.verificaSeAtiva(codigo);
    }

    /** Parte 2
     */
    public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String fotoURL){
        this.repositorioPesquisadores.cadastraPesquisador(nome,funcao,biografia,email,fotoURL);
    }
   
    public void alteraPesquisador(String email, String atributo, String novoValor){
        this.repositorioPesquisadores.alteraPesquisador(email,atributo,novoValor);
    }
    
    public void desativaPesquisador(String email){
        this.repositorioPesquisadores.desativaPesquisador(email);
    }
    
    public void ativaPesquisador(String email){
        this.repositorioPesquisadores.ativaPesquisador(email);
    }
    
    public String exibePesquisador(String email){
       return this.repositorioPesquisadores.exibePesquisador(email);
    }
    
    public boolean pesquisadorEhAtivo(String email){
        return this.repositorioPesquisadores.pesquisadorEhAtivo(email);
    }

    /** Parte 3
     */
    public String cadastraProblema(String descricao, int viabilidade) {
        return this.repositorioProblemas.cadastraProblema(descricao, viabilidade);
    }

    public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
        return this.repositorioObjetivos.cadastraObjetivo(tipo, descricao, aderencia,viabilidade);
    }
    		
    public void apagarProblema(String codigo) {
        this.repositorioProblemas.apagarProblema(codigo);
    }

    public void apagarObjetivo(String codigo) {
        this.repositorioObjetivos.apagarObjetivo(codigo);
    }

    public String exibeProblema(String codigo) {
        return this.repositorioProblemas.exibeProblema(codigo);
    }

    public String exibeObjetivo(String codigo) {
        return this.repositorioObjetivos.exibeObjetivo(codigo);
    }

    /** Parte 4
     */
    public String cadastraAtividade(String Descricao, String nivelRisco, String descricaoRisco){
        return this.repositorioAtividades.cadastraAtividade(Descricao, nivelRisco, descricaoRisco);
    }
    public void apagaAtividade(String codigo){
        this.repositorioAtividades.apagaAtividade(codigo);
    }

    public void cadastraItem(String codigo, String item){
        this.repositorioAtividades.cadastraItem(codigo,item);
    }

    public String exibeAtividade(String codigo){
        return this.repositorioAtividades.exibeAtividade(codigo);
    }

    public int contaItensPendentes(String codigo){
        return this.repositorioAtividades.contaItensPendentes(codigo);
    }

    public int contaItensRealizados(String codigo){
        return this.repositorioAtividades.contaItensRealizados(codigo);
    }

    /**Parte 5
     */
    
    public boolean associaProblema(String idPesquisa, String idProblema) {
    	
    	return this.controllerAssociacaoPesquisaObjetivoProblema.associaProblema(idPesquisa, idProblema);
    	
    }
    
    public boolean desassociaProblema(String idPesquisa) {
    
    	return this.controllerAssociacaoPesquisaObjetivoProblema.desassociaProblema(idPesquisa);
    }
    
    public boolean associaObjetivo(String idPesquisa, String idObjetivo) {
    	return this.controllerAssociacaoPesquisaObjetivoProblema.associaObjetivo(idPesquisa, idObjetivo);
    }
    
    public boolean desassociaObjetivo(String idPesquisa, String idObjetivo) {
    	return this.controllerAssociacaoPesquisaObjetivoProblema.desassociaObjetivo(idPesquisa, idObjetivo);
    }
    
    public String listaPesquisas(String ordem) {
    	
    	return this.controllerPesquisa.listaPesquisas(ordem);
    }

    /** Parte 6
     */

    public boolean associaPesquisador(String idPesquisa, String emailPesquisador){
        return this.controllerAssociacaoPesquisaPesquisador.associaPesquisador(idPesquisa, emailPesquisador);
    }

    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador){
    	return this.controllerAssociacaoPesquisaPesquisador.desassociaPesquisador(idPesquisa, emailPesquisador);
    	}

    public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data){
        this.repositorioPesquisadores.cadastraEspecialidadeProfessor(email,formacao,unidade,data);
    }
    public void cadastraEspecialidadeAluno(String email, int semestre, double IEA){
        this.repositorioPesquisadores.cadastraEspecialidadeAluno(email,semestre,IEA);
    }
    public String listaPesquisadores(String tipo){return this.repositorioPesquisadores.listaPesquisadores(tipo);}

    
    /** Parte 7
     */
    
    public boolean associaAtividade(String codigoPesquisa, String codigoAtividade) {
    	return this.controllerAssociacaoPesquisaAtividade.associaAtividade(codigoPesquisa, codigoAtividade);
    }
    
    public boolean desassociaAtividade(String codigoPesquisa, String codigoAtividade) {
    	return this.controllerAssociacaoPesquisaAtividade.desassociaAtividade(codigoPesquisa, codigoAtividade);
    }
    
    public int cadastraResultado(String codigoAtividade, String resultado) {
    	return this.controllerAssociacaoPesquisaAtividade.cadastraResultado(codigoAtividade, resultado);
    }
    public boolean executaAtividade(String codigoAtividade, int item, int duracao) {
    	return this.controllerAssociacaoPesquisaAtividade.executaAtividade(codigoAtividade, item, duracao);
    }
    
    public boolean removeResultado(String codigoAtividade, int numeroResultado) {
    	return this.controllerAssociacaoPesquisaAtividade.removeResultado(codigoAtividade, numeroResultado);
    }
    public String listaResultados(String codigoAtividade) {
    	return this.controllerAssociacaoPesquisaAtividade.listaResultados(codigoAtividade);
    }
    public int getDuracao(String codigoAtividade) {
    	return this.controllerAssociacaoPesquisaAtividade.getDuracao(codigoAtividade);
    }
    /**Parte 8
     *
     */
    public String busca(String termo){
        return controllerBusca.busca(termo);
    }
    public String busca(String termo,int numeroDoResultado){
        return controllerBusca.busca(termo,numeroDoResultado);
    }
    public int contaResultadosBusca(String termo){
        return controllerBusca.contaResultadosBusca(termo);
    }

    /** Parte 9
     */

    public void defineProximaAtividade(String idPrecedente, String idSubsquente){
        this.repositorioAtividades.defineProximaAtividade(idPrecedente,idSubsquente);
    }

    public void tiraProximaAtividade(String idPrecedente){
        this.repositorioAtividades.tiraProximaAtividade(idPrecedente);
    }
    public int contaProximos(String idPrecedente){
        return this.repositorioAtividades.contaProximos(idPrecedente);
    }
    public String pegaProximo(String idAtividade, int enesimaAtividade){
        return this.repositorioAtividades.pegaProximo(idAtividade,enesimaAtividade);
    }
    public String pegaMaiorRiscoAtividades(String idAtividade){
        return this.repositorioAtividades.pegaMaiorRiscoAtividades(idAtividade);
    }
    
    /**
     * Parte 10
     */
    
    public void configuraEstrategia(String estrategia) {
 	   
 	   this.controllerPesquisa.configuraEstrategia(estrategia);
 	   
    }
    
    public String proximaAtividade(String codigoPesquisa) {
 	    return this.controllerPesquisa.proximaAtividade(codigoPesquisa);
    }
    
    /**
     * Parte 11
     */
    
    public void gravarResumo(String codigoPesquisa) {
    	this.repositorioPesquisa.geraTxt(codigoPesquisa);
    }
    public void gravarResultados(String codigoPesquisa) {
    	this.repositorioPesquisa.geraTxtResultados(codigoPesquisa);
    }

     /**
      * Parte 12
      */
     public void salvar() { this.controllerDados.salvar();}

     public void carregar(){ this.controllerDados.carregar();}
}
