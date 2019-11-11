package projeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.pesquisa_e_associacoes.RepositorioPesquisa;

import static org.junit.jupiter.api.Assertions.*;

class ControllerPesquisaTest {
    private RepositorioPesquisa controllerPesquisa;

    @BeforeEach
    public void setup() {
        this.controllerPesquisa = new RepositorioPesquisa();
    }

    @Test
    void cadastraPesquisa() {
        assertEquals("COM1", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre computacao agropecuaria", "Computacao, agro"));
        assertEquals("COM2", this.controllerPesquisa.cadastraPesquisa("pesquisa sobre ensino da computacao nas escolas", "computacao, escolas"));
        try {
            this.controllerPesquisa.cadastraPesquisa("  ", "Computacao");
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


}