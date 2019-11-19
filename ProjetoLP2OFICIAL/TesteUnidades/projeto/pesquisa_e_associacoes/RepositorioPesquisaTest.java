package projeto.pesquisa_e_associacoes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.atividades.Atividade;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioPesquisaTest{
    private RepositorioPesquisa repositorioPesquisa;

    @BeforeEach
    public void setup() {
        this.repositorioPesquisa = new RepositorioPesquisa();
    }

    @Test
    void cadastraPesquisa() {
        assertEquals("COM1", this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao agropecuaria", "Computacao, agro"));
        assertEquals("COM2", this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre ensino da computacao nas escolas", "computacao, escolas"));
        try {
            this.repositorioPesquisa.cadastraPesquisa("  ", "Computacao");
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.cadastraPesquisa("", "Computacao");
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", " ");
            fail("Formato do campo de interesse invalido.");
        } catch (NullPointerException e) {

        }
        try {
            this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", null);
            fail("Formato do campo de interesse invalido.");
        } catch (NullPointerException e) {

        }
        try {
            this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "spaodksapodasposapodas asodksapodkaspodkaspdokaspodk aspdokaspodksapodksapok aspodksapodksapokdsapokdsopakdpoaskodpáspldpasldosdfpoksdpfosdkpfosdkpfosdkpfosdkfopdfogkdfpoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo ");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, , saude");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao na saude", "Computacao, ,sa");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {
        }

    }


    @Test
    void encerraPesquisa() {
        assertEquals("COM1", this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao nos estadios", "Computacao, saude"));
        assertEquals("COM2", this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao nos presidios", "computacao, maritima"));
        this.repositorioPesquisa.encerraPesquisa("COM1", "Qualque um");
        assertFalse(this.repositorioPesquisa.verificaSeAtiva("COM1"));

        try {
            this.repositorioPesquisa.encerraPesquisa("", "Qualquer um");
            fail("Pesquisa desativada.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.repositorioPesquisa.encerraPesquisa("      ", "Qualquer um");
            fail("Pesquisa desativada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.encerraPesquisa("COM2", null);
            fail("Motivo nao pode ser nulo ou vazio.");
        } catch (NullPointerException e) {
        }
        try {
            this.repositorioPesquisa.encerraPesquisa("COM2", "");
            fail("Motivo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.encerraPesquisa("COM1", "Qualquer um");
            fail("Pesquisa desativada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.encerraPesquisa("COM3", "Qualquer um");
            fail("Pesquisa não encontrada.");
        } catch (IllegalArgumentException e) {
        }

    }


    @Test
    void ativaPesquisa() {
        assertEquals("COM1", this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao nas estradas", "Computacao, estradas"));
        assertEquals("COM2", this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao nas geleiras", "computacao, geleiras"));
        this.repositorioPesquisa.encerraPesquisa("COM1", "Qualque um");
        try {
            this.repositorioPesquisa.ativaPesquisa("COM3");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.repositorioPesquisa.ativaPesquisa("COM2");
            fail("Pesquisa ja ativada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.ativaPesquisa("   ");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.ativaPesquisa("");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void alteraPesquisa() {
        assertEquals("COM1", this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao no deserto", "Computacao, deserto"));
        assertEquals("COM2", this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));
        try {
            this.repositorioPesquisa.alteraPesquisa("   ", "descricao", "qualquer uma");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.alteraPesquisa("", "descricao", "qualquer uma");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.alteraPesquisa("COM3", "descricao", "qualquer uma");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.repositorioPesquisa.alteraPesquisa("COM1", "   ", "qualquer uma");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.repositorioPesquisa.alteraPesquisa("COM1", "", "qualquer uma");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.repositorioPesquisa.alteraPesquisa("COM1", "Pesquisadores", "qualquer uma");
            fail("Nao e possivel alterar esse valor de pesquisa.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.repositorioPesquisa.alteraPesquisa("COM1", "DESCRICAO", null);
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (NullPointerException e) {
        }
        try {
            this.repositorioPesquisa.alteraPesquisa("COM1", "DESCRICAO", "    ");
            fail("Descricao nao pode ser nula ou vazia.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.repositorioPesquisa.alteraPesquisa("COM1", "CAMPO", null);
            fail("Formato do campo de interesse invalido.");
        } catch (NullPointerException e) {
        }
        try {
            this.repositorioPesquisa.alteraPesquisa("COM1", "CAMPO", "");
            fail("Formato do campo de interesse invalido.");
        } catch (NullPointerException e) {

        }
        try {
            this.repositorioPesquisa.alteraPesquisa("COM1", "CAMPO", "spaodksapodasposapooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiidas asodksapodkaspodkaspdokaspodk aspdokaspodksapodksapok aspodksapodksapokdsapokdsopakdpoaskodpáspldpasldosdfpoksdpfosdkpfosdkpfosdkpfosdkfopdfogkdfpoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.alteraPesquisa("COM1", "CAMPO", "Computacao, ,saude");
            fail("Formato do campo de interesse invalido.");
        } catch (IllegalArgumentException e) {

        }

    }

    @Test
    void exibePesquisa() {
        assertEquals("COM1", this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao na segunda guerra", "Computacao, guerra"));
        assertEquals("COM2", this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao no egito antigo", "computacao, egito"));

        try {
            this.repositorioPesquisa.exibePesquisa("COM3");
            fail("Pesquisa nao econtrada.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.exibePesquisa("     ");
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {

        }
        try {
            this.repositorioPesquisa.exibePesquisa("");
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {

        }

    }

    @Test
    void verificaSeAtiva() {
        assertEquals("COM1", this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao antes de Cristo", "Computacao, Cristo"));
        assertEquals("COM2", this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao maritima", "computacao, maritima"));

        try {
            this.repositorioPesquisa.verificaSeAtiva("");
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.repositorioPesquisa.verificaSeAtiva(null);
            fail("Codigo nao pode ser nulo ou vazio.");
        } catch (NullPointerException e) {

        }
        try {
            this.repositorioPesquisa.verificaSeAtiva("COM3");
            fail("Pesquisa nao encontrada.");
        } catch (IllegalArgumentException e) {
        }
    }



    @Test
    void adicionaAtividade() {
        this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao agropecuaria", "Computacao, agro");
        Atividade atividade = new Atividade("tomar uma cana pós projeto","ALTO","pois so volto morto para casa");
        Atividade atividade2 = new Atividade("qualquer coisa homi","MEDIO","pode dar errado");
        assertTrue(this.repositorioPesquisa.adicionaAtividade("COM1",atividade));
        assertFalse(this.repositorioPesquisa.adicionaAtividade("COM1",atividade));
        try{
            this.repositorioPesquisa.adicionaAtividade("COM2",atividade2);
            fail("Pesquisa nao encontrada.");
        }catch (IllegalArgumentException e){
        }
        this.repositorioPesquisa.encerraPesquisa("COM1","acabouu");
        try{
            this.repositorioPesquisa.adicionaAtividade("COM1",atividade2);
            fail("Pesquisa desativada.");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void removeAtividade(){
        this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao agropecuaria", "Computacao, agro");
        Atividade atividade = new Atividade("tomar uma cana pós projeto","ALTO","pois so volto morto para casa");
        this.repositorioPesquisa.adicionaAtividade("COM1",atividade);
        try{
            this.repositorioPesquisa.removeAtividade("COM2","A1");
            fail("Pesquisa nao encontrada.");
        }catch (IllegalArgumentException e){
        }
        assertTrue(this.repositorioPesquisa.removeAtividade("COM1","A1"));
        this.repositorioPesquisa.encerraPesquisa("COM1","acabouu");
        try{
            this.repositorioPesquisa.removeAtividade("COM2","A1");
            fail("Pesquisa desativada.");
        }catch (IllegalArgumentException e){
        }
    }
    @Test
    void associaProblema(){
        this.repositorioPesquisa.cadastraPesquisa("pesquisa sobre computacao agropecuaria", "Computacao, agro");

    }

}