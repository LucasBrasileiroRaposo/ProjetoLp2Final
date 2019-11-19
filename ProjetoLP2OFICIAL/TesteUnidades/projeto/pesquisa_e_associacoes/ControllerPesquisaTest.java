package projeto.pesquisa_e_associacoes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.atividades.Atividade;
import projeto.atividades.RepositorioAtividade;
import projeto.objetivos_e_problemas.Problema;

import static org.junit.jupiter.api.Assertions.*;

class ControllerPesquisaTest {
    private ControllerPesquisa controllerPesquisa;
    private RepositorioPesquisa repositorioPesquisa;
    private RepositorioAtividade repositorioAtividade;

    @BeforeEach
    public void setup() {
        this.repositorioPesquisa = new RepositorioPesquisa();
        this.controllerPesquisa = new ControllerPesquisa(this.repositorioPesquisa);
        this.repositorioAtividade = new RepositorioAtividade();

    }


    @Test
    void cadastraPesquisa() {
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao agropecuaria", "Computacao, agro"));
        assertEquals("COM2", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre ensino da computacao nas escolas", "computacao, escolas"));
        try {
            this.controllerPesquisa.cadastraPesquisa("  ", "Computacao");
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.cadastraPesquisa("", "Computacao");
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", " ");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

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
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao nos estadios", "Computacao, saude"));
        assertEquals("COM2", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao nos presidios", "computacao, maritima"));
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
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerPesquisa.encerraPesquisa("COM2", "");
            fail("Motivo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {

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
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao nas estradas", "Computacao, estradas"));
        assertEquals("COM2", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao nas geleiras", "computacao, geleiras"));
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
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao no deserto", "Computacao, deserto"));
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
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM1", "DESCRICAO", "    ");
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM1", "CAMPO", "    ");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerPesquisa.alteraPesquisa("COM1", "CAMPO", "");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

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
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao na segunda guerra", "Computacao, guerra"));
        assertEquals("COM2", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao no egito antigo", "computacao, egito"));

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
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao antes de Cristo", "Computacao, Cristo"));
        assertEquals("COM2", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));

        try {
            this.controllerPesquisa.verificaSeAtiva("");
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.controllerPesquisa.verificaSeAtiva("   ");
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.controllerPesquisa.verificaSeAtiva("COM3");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void listaPesquisas() {
    }

    @Test
    void adicionaAtividade() {
        this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao agropecuaria", "Computacao, agro");
        Atividade atividade = new Atividade("tomar uma cana pós projeto","ALTO","pois so volto morto para casa");
        Atividade atividade2 = new Atividade("qualquer coisa homi","MEDIO","pode dar errado");
        assertTrue(this.controllerPesquisa.adicionaAtividade("COM1",atividade));
        assertFalse(this.controllerPesquisa.adicionaAtividade("COM1",atividade));
        try{
            this.controllerPesquisa.adicionaAtividade("COM2",atividade2);
            fail("Pesquisa nao encontrada.");
        }catch (IllegalArgumentException e){
        }
        this.controllerPesquisa.encerraPesquisa("COM1","acabouu");
        try{
            this.controllerPesquisa.adicionaAtividade("COM1",atividade2);
            fail("Pesquisa desativada.");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void removeAtividade() {
        this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao agropecuaria", "Computacao, agro");
        Atividade atividade = new Atividade("tomar uma cana pós projeto","ALTO","pois so volto morto para casa");
        this.controllerPesquisa.adicionaAtividade("COM1",atividade);
        try{
            this.controllerPesquisa.removeAtividade("COM2","A1");
            fail("Pesquisa nao encontrada.");
        }catch (IllegalArgumentException e){
        }
        assertTrue(this.controllerPesquisa.removeAtividade("COM1","A1"));
        this.controllerPesquisa.encerraPesquisa("COM1","acabouu");
        try{
            this.controllerPesquisa.removeAtividade("COM2","A1");
            fail("Pesquisa desativada.");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void associaProblema() {
        this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao agropecuaria", "Computacao, agro");
        Problema problema = new Problema("fazer testes do projeto",0,"P1");
        Problema problema2 = new Problema("terminar todos os casos de uso",2, "P2");
        assertTrue(this.controllerPesquisa.associaProblema("COM1",problema));
        assertFalse(this.controllerPesquisa.associaProblema("COM1",problema));
        try{
            this.controllerPesquisa.associaProblema("COM240",problema2);
            fail("Pesquisa nao encontrada.");
        }catch (IllegalArgumentException e){
        }
        this.controllerPesquisa.encerraPesquisa("COM1","finalizada");
        try{
            this.controllerPesquisa.associaProblema("COM1",problema2);
            fail("Pesquisa desativada.");
        }catch (IllegalArgumentException e){
        }
        this.controllerPesquisa.ativaPesquisa("COM1");
        try{
            this.controllerPesquisa.associaProblema("COM1",problema2);
            fail("Pesquisa ja associada a um problema.");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void desassociaProblema() {
    }

    @Test
    void associaObjetivo() {
    }

    @Test
    void dessassociaObjetivo() {
    }

    @Test
    void associaPesquisador() {
    }

    @Test
    void desassociaPesquisador() {
    }

    @Test
    void configuraEstrategia() {
    }

    @Test
    void proximaAtividade() {
    }
}
