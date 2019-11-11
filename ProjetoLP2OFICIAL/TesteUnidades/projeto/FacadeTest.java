package projeto;

import org.junit.jupiter.api.Test;
import projeto.atividades.RepositorioAtividade;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;
import projeto.pesquisa_e_associacoes.RepositorioPesquisa;
import projeto.pesquisadores.RepositorioPesquisador;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    private RepositorioPesquisa controllerPesquisa;

    private RepositorioObjetivos controllerObjetivos;

    private RepositorioProblemas controllerProblemas;

    private RepositorioAtividade repositorioAtividade;

    private RepositorioPesquisador repositorioPesquisadores;



    public void setup(){
        this.controllerPesquisa = new RepositorioPesquisa();
        this.controllerObjetivos = new RepositorioObjetivos();
        this.controllerProblemas = new RepositorioProblemas();
        this.repositorioAtividade = new RepositorioAtividade();
        this.repositorioPesquisadores = new RepositorioPesquisador();
    }
    @Test
    void cadastraPesquisa() {
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, saude"));
        assertEquals("COM2", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));
        try {
            this.controllerPesquisa.cadastraPesquisa("  ", "Computaçao");
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (NullPointerException e) {

        }
        try {
            this.controllerPesquisa.cadastraPesquisa("", "Computacao");
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (NullPointerException e) {

        }
        try {
            this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", " ");
            fail("Formato do campo de interesse invalido.");
        } catch (NullPointerException e) {

        }
        try {
            this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "");
            fail("Formato do campo de interesse invalido.");
        } catch (NullPointerException e) {

        }
        try {
            this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "spaodksapodasposapodas asodksapodkaspodkaspdokaspodk aspdokaspodksapodksapok aspodksapodksapokdsapokdsopakdpoaskodpáspldpasldosdfpoksdpfosdkpfosdkpfosdkpfosdkfopdfogkdfpoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo ");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, , saude");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, ,sa");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {
        }

    }


    @Test
    void encerraPesquisa() {
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, saude"));
        assertEquals("COM2", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));
        this.controllerPesquisa.encerraPesquisa("COM1", "Qualque um");
        assertFalse(this.controllerPesquisa.verificaSeAtiva("COM1"));

        try {
            this.controllerPesquisa.encerraPesquisa("", "Qualquer um");
            fail("Pesquisa desativada.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerPesquisa.encerraPesquisa("      ", "Qualquer um");
            fail("Pesquisa desativada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.encerraPesquisa("COM2", "    ");
            fail("Motivo nao pode ser nulo ou vazio.");
        } catch (NullPointerException e) {
        }
        try {
            this.controllerPesquisa.encerraPesquisa("COM2", "");
            fail("Motivo nao pode ser nulo ou vazio.");
        } catch (NullPointerException e) {

        }
        try {
            this.controllerPesquisa.encerraPesquisa("COM1", "Qualquer um");
            fail("Pesquisa desativada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.encerraPesquisa("COM3", "Qualquer um");
            fail("Pesquisa não encontrada.");
        } catch (IllegalArgumentException e) {
        }

    }


    @Test
    void ativaPesquisa() {
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, saude"));
        assertEquals("COM2", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));
        this.controllerPesquisa.encerraPesquisa("COM1", "Qualque um");
        try {
            this.controllerPesquisa.ativaPesquisa("COM3");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerPesquisa.ativaPesquisa("COM2");
            fail("Pesquisa ja ativada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.ativaPesquisa("   ");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.ativaPesquisa("");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void alteraPesquisa() {
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, saude"));
        assertEquals("COM2", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));
        try {
            this.controllerPesquisa.alteraPesquisa("   ", "descricao", "qualquer uma");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.alteraPesquisa("", "descricao", "qualquer uma");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM3", "descricao", "qualquer uma");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM1", "   ", "qualquer uma");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM1", "", "qualquer uma");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM1", "Pesquisadores", "qualquer uma");
            fail("Nao e possivel alterar esse valor de pesquisa.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM1", "DESCRICAO", "");
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (NullPointerException e) {
        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM1", "DESCRICAO", "    ");
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (NullPointerException e) {
        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM1", "CAMPO", "    ");
            fail("Formato do campo de interesse invalido.");
        } catch (NullPointerException e) {
        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM1", "CAMPO", "");
            fail("Formato do campo de interesse invalido.");
        } catch (NullPointerException e) {

        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM1", "CAMPO", "spaodksapodasposapooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiidas asodksapodkaspodkaspdokaspodk aspdokaspodksapodksapok aspodksapodksapokdsapokdsopakdpoaskodpáspldpasldosdfpoksdpfosdkpfosdkpfosdkpfosdkfopdfogkdfpoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM1", "CAMPO", "Computacao, ,saude");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }

    }

    @Test
    void exibePesquisa() {
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, saude"));
        assertEquals("COM2", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));

        try {
            this.controllerPesquisa.exibePesquisa("COM3");
            fail("Pesquisa nao econtrada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.exibePesquisa("     ");
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.exibePesquisa("");
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {

        }

    }

    @Test
    void verificaSeAtiva() {
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, saude"));
        assertEquals("COM2", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));

        try {
            this.controllerPesquisa.verificaSeAtiva("");
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (NullPointerException e) {
        }
        try {
            this.controllerPesquisa.verificaSeAtiva("   ");
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (NullPointerException e) {

        }
        try {
            this.controllerPesquisa.verificaSeAtiva("COM3");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {
        }
    }











    /** TESTES US4
     */
    @Test
    void cadastraAtividade() {
        assertEquals("A1", this.repositorioAtividade.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo"));
        assertEquals("A2",this.repositorioAtividade.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo"));
        try {
            this.repositorioAtividade.cadastraAtividade("","MEDIO","se nao lançar exececao complica");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.cadastraAtividade(null,"MEDIO","se nao lançar execao complica2");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.cadastraAtividade("                ","MEDIO","se nao lançar exececao complica");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Nada","","Lança excecao pf");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Nada","            ","Lança excecao pf");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Nada",null,"Lança excecao pf");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Nada","BAIXO","");
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Nada","MEDIO","           ");
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Nada","ALTO",null);
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Nada","alto","Lança excecao pf");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Nada","ALTISSIMO","Lança excecao pf");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Nada","BAIXo","Lança excecao pf");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }

    }

    @Test
    void apagaAtividade() {
        assertEquals("A1",this.repositorioAtividade.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo"));
        assertEquals("A2",this.repositorioAtividade.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo"));
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo)",this.repositorioAtividade.exibeAtividade("A1"));
        assertEquals("Commitar pro git (MEDIO - Se commitar a pasta errada bagunça tudo)",this.repositorioAtividade.exibeAtividade("A2"));
        this.repositorioAtividade.apagaAtividade("A1");
        try{
            this.repositorioAtividade.apagaAtividade("A1");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.apagaAtividade("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.apagaAtividade("          ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.apagaAtividade(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
    }

    @Test
    void cadastraItem() {
        this.repositorioAtividade.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        this.repositorioAtividade.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo");
        this.repositorioAtividade.cadastraItem("A1","testar uso de caso 1");
        this.repositorioAtividade.cadastraItem("A1","testar uso de caso 2");
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo) | PENDENTE - testar uso de caso 1 | PENDENTE - testar uso de caso 2", this.repositorioAtividade.exibeAtividade("A1"));
        try {
            this.repositorioAtividade.cadastraItem("","paralelepipedo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("        ","paralelepipedo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.cadastraItem(null,"paralelepipedo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("A50","paralelepipedo");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("A1","");
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("A1","       ");
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("A1",null);
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }


    }

    @Test
    void exibeAtividade() {
        this.repositorioAtividade.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo)",this.repositorioAtividade.exibeAtividade("A1"));
        this.repositorioAtividade.cadastraItem("A1","testar uso de caso 1");
        this.repositorioAtividade.cadastraItem("A1","testar uso de caso 2");
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo) | PENDENTE - testar uso de caso 1 | PENDENTE - testar uso de caso 2", this.repositorioAtividade.exibeAtividade("A1"));
        try {
            this.repositorioAtividade.exibeAtividade("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.exibeAtividade("      ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.exibeAtividade(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.exibeAtividade("A55");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void contaItensPendentes() {
        this.repositorioAtividade.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        this.repositorioAtividade.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo");
        this.repositorioAtividade.cadastraItem("A1","testar uso de caso 1.");
        this.repositorioAtividade.cadastraItem("A1","testar uso de caso 2.");
        this.repositorioAtividade.cadastraItem("A1","testar uso de caso 3.");
        assertEquals(3, this.repositorioAtividade.contaItensPendentes("A1"));
        assertEquals(0, this.repositorioAtividade.contaItensPendentes("A2"));
        try{
            this.repositorioAtividade.contaItensPendentes("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.contaItensPendentes("           ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.contaItensPendentes(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.contaItensPendentes("B20");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.contaItensPendentes("aabb");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        } try{
            this.repositorioAtividade.contaItensPendentes("A0");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }

    }

    @Test
    void contaItensRealizados() {
        this.repositorioAtividade.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        this.repositorioAtividade.cadastraItem("A1","testar uso de caso 1.");
        this.repositorioAtividade.cadastraItem("A1","testar uso de caso 2.");
        this.repositorioAtividade.cadastraItem("A1","testar uso de caso 3.");
        assertEquals(0,this.repositorioAtividade.contaItensRealizados("A1"));
        try{
            this.repositorioAtividade.contaItensRealizados("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.contaItensRealizados("          ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.contaItensRealizados(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.contaItensRealizados("B20");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.contaItensRealizados("Lucas");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        } try{
            this.repositorioAtividade.contaItensRealizados("A0");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
    }
}