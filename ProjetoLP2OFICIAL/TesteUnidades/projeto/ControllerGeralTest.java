package projeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerGeralTest {
    private ControllerGeral controllerGeral;

    @BeforeEach
    public void setup(){
        this.controllerGeral = new ControllerGeral();
    }

    /** Testes US1
     */
    @Test
    void cadastraPesquisa() {
        assertEquals("COM1", this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, saude"));
        assertEquals("COM2", this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));
        try {
            this.controllerGeral.cadastraPesquisa("  ", "Computaçao");
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.cadastraPesquisa("", "Computacao");
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao na saude", " ");
            fail("Formato do campo de interesse invalido.");
        } catch (NullPointerException e) {

        }
        try {
            this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao na saude", "");
            fail("Formato do campo de interesse invalido.");
        } catch (NullPointerException e) {

        }
        try {
            this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao na saude", "spaodksapodasposapodas asodksapodkaspodkaspdokaspodk aspdokaspodksapodksapok aspodksapodksapokdsapokdsopakdpoaskodpáspldpasldosdfpoksdpfosdkpfosdkpfosdkpfosdkfopdfogkdfpoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo ");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, , saude");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, ,sa");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {
        }

    }


    @Test
    void encerraPesquisa() {
        assertEquals("COM1", this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, saude"));
        assertEquals("COM2", this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));
        this.controllerGeral.encerraPesquisa("COM1", "Qualque um");
        assertFalse(this.controllerGeral.pesquisaEhAtiva("COM1"));

        try {
            this.controllerGeral.encerraPesquisa("", "Qualquer um");
            fail("Pesquisa desativada.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerGeral.encerraPesquisa("      ", "Qualquer um");
            fail("Pesquisa desativada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.encerraPesquisa("COM2", "    ");
            fail("Motivo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerGeral.encerraPesquisa("COM2", "");
            fail("Motivo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.encerraPesquisa("COM1", "Qualquer um");
            fail("Pesquisa desativada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.encerraPesquisa("COM3", "Qualquer um");
            fail("Pesquisa não encontrada.");
        } catch (IllegalArgumentException e) {
        }

    }


    @Test
    void ativaPesquisa() {
        assertEquals("COM1", this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, saude"));
        assertEquals("COM2", this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));
        this.controllerGeral.encerraPesquisa("COM1", "Qualque um");
        try {
            this.controllerGeral.ativaPesquisa("COM3");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerGeral.ativaPesquisa("COM2");
            fail("Pesquisa ja ativada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.ativaPesquisa("   ");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.ativaPesquisa("");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void alteraPesquisa() {
        assertEquals("COM1", this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, saude"));
        assertEquals("COM2", this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));
        try {
            this.controllerGeral.alteraPesquisa("   ", "descricao", "qualquer uma");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.alteraPesquisa("", "descricao", "qualquer uma");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.alteraPesquisa("COM3", "descricao", "qualquer uma");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerGeral.alteraPesquisa("COM1", "   ", "qualquer uma");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerGeral.alteraPesquisa("COM1", "", "qualquer uma");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerGeral.alteraPesquisa("COM1", "Pesquisadores", "qualquer uma");
            fail("Nao e possivel alterar esse valor de pesquisa.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerGeral.alteraPesquisa("COM1", "DESCRICAO", null);
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (NullPointerException e) {
        }
        try {
            this.controllerGeral.alteraPesquisa("COM1", "DESCRICAO", null);
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (NullPointerException e) {
        }
        try {
            this.controllerGeral.alteraPesquisa("COM1", "CAMPO", null);
            fail("Formato do campo de interesse invalido.");
        } catch (NullPointerException e) {
        }
        try {
            this.controllerGeral.alteraPesquisa("COM1", "CAMPO", null);
            fail("Formato do campo de interesse invalido.");
        } catch (NullPointerException e) {

        }
        try {
            this.controllerGeral.alteraPesquisa("COM1", "CAMPO", "spaodksapodasposapooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiidas asodksapodkaspodkaspdokaspodk aspdokaspodksapodksapok aspodksapodksapokdsapokdsopakdpoaskodpáspldpasldosdfpoksdpfosdkpfosdkpfosdkpfosdkfopdfogkdfpoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.alteraPesquisa("COM1", "CAMPO", "Computacao, ,saude");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }

    }

    @Test
    void exibePesquisa() {
        assertEquals("COM1", this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, saude"));
        assertEquals("COM2", this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));

        try {
            this.controllerGeral.exibePesquisa("COM3");
            fail("Pesquisa nao econtrada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.exibePesquisa("     ");
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerGeral.exibePesquisa("");
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {

        }

    }

    @Test
    void verificaSeAtiva() {
        assertEquals("COM1", this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, saude"));
        assertEquals("COM2", this.controllerGeral.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));

        try {
            this.controllerGeral.pesquisaEhAtiva("");
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerGeral.pesquisaEhAtiva(null);
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (NullPointerException e) {

        }
        try {
            this.controllerGeral.pesquisaEhAtiva("COM3");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {
        }
    }











    /** TESTES US4
     */
    @Test
    void cadastraAtividade() {
        assertEquals("A1", this.controllerGeral.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo"));
        assertEquals("A2",this.controllerGeral.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo"));
        try {
            this.controllerGeral.cadastraAtividade("","MEDIO","se nao lançar exececao complica");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.controllerGeral.cadastraAtividade(null,"MEDIO","se nao lançar execao complica2");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.cadastraAtividade("                ","MEDIO","se nao lançar exececao complica");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada",null,"Lança excecao pf");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","            ","Lança excecao pf");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada",null,"Lança excecao pf");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","BAIXO","");
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","MEDIO","           ");
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","ALTO",null);
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","alto","Lança excecao pf");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","ALTISSIMO","Lança excecao pf");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","BAIXo","Lança excecao pf");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }

    }

    @Test
    void apagaAtividade() {
        assertEquals("A1",this.controllerGeral.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo"));
        assertEquals("A2",this.controllerGeral.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo"));
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo)",this.controllerGeral.exibeAtividade("A1"));
        assertEquals("Commitar pro git (MEDIO - Se commitar a pasta errada bagunça tudo)",this.controllerGeral.exibeAtividade("A2"));
        this.controllerGeral.apagaAtividade("A1");
        try{
            this.controllerGeral.apagaAtividade("A1");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.apagaAtividade(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.apagaAtividade("          ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.apagaAtividade("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void cadastraItem() {
        this.controllerGeral.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        this.controllerGeral.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 1");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 2");
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo) | PENDENTE - testar uso de caso 1 | PENDENTE - testar uso de caso 2", this.controllerGeral.exibeAtividade("A1"));
        try {
            this.controllerGeral.cadastraItem("","paralelepipedo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.controllerGeral.cadastraItem("        ","paralelepipedo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.controllerGeral.cadastraItem(null,"paralelepipedo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.cadastraItem("A50","paralelepipedo");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try {
            this.controllerGeral.cadastraItem("A1","");
            fail("Item nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.controllerGeral.cadastraItem("A1","       ");
            fail("Item nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.controllerGeral.cadastraItem("A1",null);
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }


    }

    @Test
    void exibeAtividade() {
        this.controllerGeral.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo)",this.controllerGeral.exibeAtividade("A1"));
        this.controllerGeral.cadastraItem("A1","testar uso de caso 1");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 2");
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo) | PENDENTE - testar uso de caso 1 | PENDENTE - testar uso de caso 2", this.controllerGeral.exibeAtividade("A1"));
        try {
            this.controllerGeral.exibeAtividade("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.controllerGeral.exibeAtividade("      ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.controllerGeral.exibeAtividade(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.exibeAtividade("A55");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void contaItensPendentes() {
        this.controllerGeral.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        this.controllerGeral.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 1.");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 2.");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 3.");
        assertEquals(3, this.controllerGeral.contaItensPendentes("A1"));
        assertEquals(0, this.controllerGeral.contaItensPendentes("A2"));
        try{
            this.controllerGeral.contaItensPendentes("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.contaItensPendentes("           ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.contaItensPendentes(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.contaItensPendentes("B20");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.contaItensPendentes("aabb");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        } try{
            this.controllerGeral.contaItensPendentes("A0");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }

    }

    @Test
    void contaItensRealizados() {
        this.controllerGeral.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 1.");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 2.");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 3.");
        assertEquals(0,this.controllerGeral.contaItensRealizados("A1"));
        try{
            this.controllerGeral.contaItensRealizados("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.contaItensRealizados("          ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.contaItensRealizados(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.contaItensRealizados("B20");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.contaItensRealizados("Lucas");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        } try{
            this.controllerGeral.contaItensRealizados("A0");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
    }

}
