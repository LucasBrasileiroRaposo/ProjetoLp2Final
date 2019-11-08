package projeto;

import org.junit.jupiter.api.Test;
import projeto.pesquisadores.ControllerPesquisador;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    private ControllerPesquisa controllerPesquisa;

    private ControllerObjetivos controllerObjetivos;

    private ControllerProblemas controllerProblemas;

    private ControllerAtividade controleAtividade;

    private ControllerPesquisador controllerPesquisadores;



    public void setup(){
        this.controllerPesquisa = new ControllerPesquisa();
        this.controllerObjetivos = new ControllerObjetivos();
        this.controllerProblemas = new ControllerProblemas();
        this.controleAtividade = new ControllerAtividade();
        this.controllerPesquisadores = new ControllerPesquisador();
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
        assertEquals("A1", this.controleAtividade.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo"));
        assertEquals("A2",this.controleAtividade.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo"));
        try {
            this.controleAtividade.cadastraAtividade("","MEDIO","se nao lançar exececao complica");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraAtividade(null,"MEDIO","se nao lançar execao complica2");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraAtividade("                ","MEDIO","se nao lançar exececao complica");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Nada","","Lança excecao pf");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Nada","            ","Lança excecao pf");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Nada",null,"Lança excecao pf");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Nada","BAIXO","");
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Nada","MEDIO","           ");
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Nada","ALTO",null);
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Nada","alto","Lança excecao pf");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Nada","ALTISSIMO","Lança excecao pf");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Nada","BAIXo","Lança excecao pf");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }

    }

    @Test
    void apagaAtividade() {
        assertEquals("A1",this.controleAtividade.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo"));
        assertEquals("A2",this.controleAtividade.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo"));
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo)",this.controleAtividade.exibeAtividade("A1"));
        assertEquals("Commitar pro git (MEDIO - Se commitar a pasta errada bagunça tudo)",this.controleAtividade.exibeAtividade("A2"));
        this.controleAtividade.apagaAtividade("A1");
        try{
            this.controleAtividade.apagaAtividade("A1");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controleAtividade.apagaAtividade("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.apagaAtividade("          ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.apagaAtividade(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
    }

    @Test
    void cadastraItem() {
        this.controleAtividade.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        this.controleAtividade.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo");
        this.controleAtividade.cadastraItem("A1","testar uso de caso 1");
        this.controleAtividade.cadastraItem("A1","testar uso de caso 2");
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo) | PENDENTE - testar uso de caso 1 | PENDENTE - testar uso de caso 2", this.controleAtividade.exibeAtividade("A1"));
        try {
            this.controleAtividade.cadastraItem("","paralelepipedo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem("        ","paralelepipedo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem(null,"paralelepipedo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem("A50","paralelepipedo");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try {
            this.controleAtividade.cadastraItem("A1","");
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem("A1","       ");
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem("A1",null);
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }


    }

    @Test
    void exibeAtividade() {
        this.controleAtividade.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo)",this.controleAtividade.exibeAtividade("A1"));
        this.controleAtividade.cadastraItem("A1","testar uso de caso 1");
        this.controleAtividade.cadastraItem("A1","testar uso de caso 2");
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo) | PENDENTE - testar uso de caso 1 | PENDENTE - testar uso de caso 2", this.controleAtividade.exibeAtividade("A1"));
        try {
            this.controleAtividade.exibeAtividade("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.exibeAtividade("      ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.exibeAtividade(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.exibeAtividade("A55");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void contaItensPendentes() {
        this.controleAtividade.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        this.controleAtividade.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo");
        this.controleAtividade.cadastraItem("A1","testar uso de caso 1.");
        this.controleAtividade.cadastraItem("A1","testar uso de caso 2.");
        this.controleAtividade.cadastraItem("A1","testar uso de caso 3.");
        assertEquals(3, this.controleAtividade.contaItensPendentes("A1"));
        assertEquals(0, this.controleAtividade.contaItensPendentes("A2"));
        try{
            this.controleAtividade.contaItensPendentes("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.contaItensPendentes("           ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.contaItensPendentes(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.contaItensPendentes("B20");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controleAtividade.contaItensPendentes("aabb");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        } try{
            this.controleAtividade.contaItensPendentes("A0");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }

    }

    @Test
    void contaItensRealizados() {
        this.controleAtividade.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        this.controleAtividade.cadastraItem("A1","testar uso de caso 1.");
        this.controleAtividade.cadastraItem("A1","testar uso de caso 2.");
        this.controleAtividade.cadastraItem("A1","testar uso de caso 3.");
        assertEquals(0,this.controleAtividade.contaItensRealizados("A1"));
        try{
            this.controleAtividade.contaItensRealizados("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.contaItensRealizados("          ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.contaItensRealizados(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.contaItensRealizados("B20");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controleAtividade.contaItensRealizados("Lucas");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        } try{
            this.controleAtividade.contaItensRealizados("A0");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
    }
}