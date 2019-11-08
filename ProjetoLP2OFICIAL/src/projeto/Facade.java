package projeto;

import easyaccept.EasyAccept;
import projeto.pesquisadores.ControllerPesquisador;

public class Facade {

    private ControllerPesquisa controllerPesquisa;

    private ControllerObjetivos controllerObjetivos;

    private ControllerProblemas controllerProblemas;

    private ControllerAtividade controleAtividade;

    private ControllerPesquisador controllerPesquisadores;
    private ControllerAssociacao controllerAssociacao;


    public static void main(String[] args) {
        args = new String[]{"projeto.Facade", "ProjetoLP2OFICIAL/TestesAceitacao/use_case_1.txt", "ProjetoLP2OFICIAL/TestesAceitacao/use_case_2.txt", "ProjetoLP2OFICIAL/TestesAceitacao/use_case_3.txt", "ProjetoLP2OFICIAL/TestesAceitacao/use_case_4.txt", "ProjetoLP2OFICIAL/TestesAceitacao/use_case_6.txt"};
        EasyAccept.main(args);
    }

    public Facade() {
        this.controllerPesquisa = new ControllerPesquisa();
        this.controllerObjetivos = new ControllerObjetivos();
        this.controllerProblemas = new ControllerProblemas();
        this.controleAtividade = new ControllerAtividade();
        this.controllerPesquisadores = new ControllerPesquisador();
        this.controllerAssociacao = new ControllerAssociacao();
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
                controllerPesquisa.ativaPesquisa(codigo);
    }

    public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
        controllerPesquisa.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
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
        this.controllerPesquisadores.cadastraPesquisador(nome,funcao,biografia,email,fotoURL);
    }
   
    public void alteraPesquisador(String email, String atributo, String novoValor){
        this.controllerPesquisadores.alteraPesquisador(email,atributo,novoValor);
    }
    
    public void desativaPesquisador(String email){
        this.controllerPesquisadores.desativaPesquisador(email);
    }
    
    public void ativaPesquisador(String email){
        this.controllerPesquisadores.ativaPesquisador(email);
    }
    
    public String exibePesquisador(String email){
       return this.controllerPesquisadores.exibePesquisador(email);
    }
    
    public boolean pesquisadorEhAtivo(String email){
        return this.controllerPesquisadores.pesquisadorEhAtivo(email);
    }

    /** Parte 3
     */
    public String cadastraProblema(String descricao, int viabilidade) {
        return this.controllerProblemas.cadastraProblema(descricao, viabilidade);
    }

    public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
        return this.controllerObjetivos.cadastraObjetivo(tipo, descricao, aderencia,viabilidade);
    }
    		
    public void apagarProblema(String codigo) {
        this.controllerProblemas.apagarProblema(codigo);
    }

    public void apagarObjetivo(String codigo) {
        this.controllerObjetivos.apagarObjetivo(codigo);
    }

    public String exibeProblema(String codigo) {
        return this.controllerProblemas.exibeProblema(codigo);
    }

    public String exibeObjetivo(String codigo) {
        return this.controllerObjetivos.exibeObjetivo(codigo);
    }

    /** Parte 4
     */
    public String cadastraAtividade(String Descricao, String nivelRisco, String descricaoRisco){
        return this.controleAtividade.cadastraAtividade(Descricao, nivelRisco, descricaoRisco);
    }
    public void apagaAtividade(String codigo){
        this.controleAtividade.apagaAtividade(codigo);
    }

    public void cadastraItem(String codigo, String item){
        this.controleAtividade.cadastraItem(codigo,item);
    }

    public String exibeAtividade(String codigo){
        return this.controleAtividade.exibeAtividade(codigo);
    }

    public int contaItensPendentes(String codigo){
        return this.controleAtividade.contaItensPendentes(codigo);
    }

    public int contaItensRealizados(String codigo){
        return this.controleAtividade.contaItensRealizados(codigo);
    }

    /**Parte 5
     */

    /** Parte 6
     */

    public boolean associaPesquisador(String idPesquisa, String emailPesquisador){
        return this.controllerAssociacao.associaPesquisador(idPesquisa, emailPesquisador);
    }

    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador){return false;}

    public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data){}
    public void cadastraEspecialidadeAluno(String email, int semestre, double IEA){}
    public String listaPesquisadores(String tipo){return "";}



}
