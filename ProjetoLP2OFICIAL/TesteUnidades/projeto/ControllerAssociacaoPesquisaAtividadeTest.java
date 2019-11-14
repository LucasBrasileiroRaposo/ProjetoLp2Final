package projeto;

import org.junit.jupiter.api.BeforeEach;
import projeto.atividades.Atividade;
import projeto.atividades.RepositorioAtividade;
import projeto.pesquisa_e_associacoes.ControllerAssociacaoPesquisaAtividade;
import projeto.pesquisa_e_associacoes.ControllerPesquisa;
import projeto.pesquisa_e_associacoes.Pesquisa;
import projeto.pesquisa_e_associacoes.RepositorioPesquisa;

import static org.junit.jupiter.api.Assertions.*;

class ControllerAssociacaoPesquisaAtividadeTest {
    Pesquisa p1;
    Atividade a1;
    RepositorioPesquisa Rp1;
    RepositorioAtividade Ra1;
    ControllerPesquisa cp1;
    ControllerAssociacaoPesquisaAtividade CAPA;
    String descricaoPesquisa,descricaoAtividade,campoDeInteresse,nivelRisco,descricaoRisco,codigoAtividade;
    @BeforeEach
    void criaPesquisaAtividade(){
        p1 = new Pesquisa("Pesquisa de campo","Natureza","PDC");
        a1 = new Atividade("Atividade de Campo","MEDIO", "Aventuras Macabras");
        Rp1 = new RepositorioPesquisa();
        Ra1 = new RepositorioAtividade();
        cp1 = new ControllerPesquisa(Rp1);

        CAPA = new ControllerAssociacaoPesquisaAtividade(cp1,Ra1);
        descricaoPesquisa = "Pesquisa de Campo";
        descricaoAtividade = "Atividade de Campo";
        campoDeInteresse = "Natureza";
        nivelRisco = "MEDIO";
        descricaoRisco = "Aventuras Macabras";
        CAPA.associaAtividade(Rp1.cadastraPesquisa(descricaoPesquisa,campoDeInteresse),Ra1.cadastraAtividade(descricaoAtividade,nivelRisco,descricaoRisco));
        codigoAtividade = Ra1.cadastraAtividade(descricaoAtividade,nivelRisco,descricaoRisco);
    }

    @org.junit.jupiter.api.Test
    void associaAtividade() {
        assertEquals(CAPA.associaAtividade(Rp1.cadastraPesquisa(descricaoPesquisa,campoDeInteresse),Ra1.cadastraAtividade(descricaoAtividade,nivelRisco,descricaoRisco)),true);
        assertThrows(IllegalArgumentException.class, ()->
                this.CAPA.associaAtividade(Rp1.cadastraPesquisa(descricaoPesquisa,campoDeInteresse),Ra1.cadastraAtividade(descricaoAtividade,"oi",descricaoRisco)));
        assertThrows(IllegalArgumentException.class, ()->
                this.CAPA.associaAtividade(Rp1.cadastraPesquisa("","Natureza"),Ra1.cadastraAtividade("Atividade de Campo","oi","Aventuras Macabras")));
    }

    @org.junit.jupiter.api.Test
    void desassociaAtividade() {
        CAPA.associaAtividade(Rp1.cadastraPesquisa("Pesquisa de Campo","Natureza"),Ra1.cadastraAtividade("Atividade de Campo","MEDIO","Aventuras Macabras"));
        assertEquals(CAPA.desassociaAtividade(Rp1.cadastraPesquisa("Pesquisa de Campo","Natureza"),Ra1.cadastraAtividade("Atividade de Campo","MEDIO","Aventuras Macabras")),false);
        assertThrows(IllegalArgumentException.class, ()->
                this.CAPA.associaAtividade(Rp1.cadastraPesquisa("Pesquisa de Campo","Natureza"),Ra1.cadastraAtividade("Atividade de Campo","oi","Aventuras Macabras")));
        assertThrows(IllegalArgumentException.class, ()->
                this.CAPA.associaAtividade(Rp1.cadastraPesquisa("","Natureza"),Ra1.cadastraAtividade("Atividade de Campo","oi","Aventuras Macabras")));

        assertThrows(NullPointerException.class, ()->
                this.CAPA.associaAtividade(Rp1.cadastraPesquisa("Pesquisa c1",""),Ra1.cadastraAtividade("Atividade de Campo","oi","Aventuras Macabras")));}

    @org.junit.jupiter.api.Test
    void executaAtividade() {
        assertThrows(NullPointerException.class, ()->
                CAPA.executaAtividade(Rp1.cadastraPesquisa("Pesquisa de Campo","Natureza"),1,1));
        assertThrows(NullPointerException.class, ()->
                CAPA.executaAtividade(Rp1.cadastraPesquisa("Pesquisa de Campo","Natureza"),0,1));
        assertThrows(NullPointerException.class, ()->
                CAPA.executaAtividade(Rp1.cadastraPesquisa("Pesquisa de Campo","Natureza"),1,0));
        Rp1.cadastraPesquisa("Pesquisa sobre baleias jubartes","Baleias");
        Ra1.cadastraAtividade("caçar baleias","ALTO","risco do ibama pegar");
        Ra1.cadastraItem("A1","primeiro passo de muitos");
        this.CAPA.associaAtividade("BAL1","A1");
        assertTrue(CAPA.executaAtividade("A1",1,1));
    }

    @org.junit.jupiter.api.Test
    void removeResultado() {
    }

    @org.junit.jupiter.api.Test
    void cadastraResultado() {
    }

    @org.junit.jupiter.api.Test
    void listaResultados() {
    }
}