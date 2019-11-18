package projeto.pesquisa_e_associacoes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.pesquisadores.Pesquisador;
import projeto.pesquisadores.PesquisadorSimples;
import projeto.pesquisadores.RepositorioPesquisador;

import static org.junit.jupiter.api.Assertions.*;

class ControllerAssociacaoPesquisaPesquisadorTest {
    Pesquisa p1;
    Pesquisador pesquisador;
    ControllerAssociacaoPesquisaPesquisador CAPP;
    ControllerPesquisa controllerPesquisa;
    RepositorioPesquisa repositorioPesquisa;
    RepositorioPesquisador repositorioPesquisador;
    @BeforeEach
    void setUp(){
        this.p1 = new Pesquisa("Pesquisa Florestal","Floresta","FLO1");
        this.pesquisador = new PesquisadorSimples("4Lan", "Estudante", "Estudante pesquisador", "4lan@hotmail.com", "http://www.foto.com");
        this.repositorioPesquisa = new RepositorioPesquisa();
        this.repositorioPesquisador = new RepositorioPesquisador();
        this.controllerPesquisa = new ControllerPesquisa(repositorioPesquisa);

        CAPP = new ControllerAssociacaoPesquisaPesquisador(controllerPesquisa,repositorioPesquisador);
        repositorioPesquisador.cadastraPesquisador("4Lan", "Estudante", "Estudante pesquisador", "4lan@hotmail.com", "http://www.foto.com");
        repositorioPesquisa.cadastraPesquisa("Pesquisa Florestal","Floresta");

    }

    @Test
    void associaPesquisador() {

        assertTrue(CAPP.associaPesquisador("FLO1","4lan@hotmail.com"));
        assertThrows(IllegalArgumentException.class, ()->
                CAPP.associaPesquisador("",""));
        assertThrows(NullPointerException.class, ()->
                CAPP.associaPesquisador(null,null));
    }

    @Test
    void desassociaPesquisador() {
        CAPP.associaPesquisador("FLO1","4lan@hotmail.com");
        assertTrue(CAPP.desassociaPesquisador("FLO1","4lan@hotmail.com"));
        assertThrows(IllegalArgumentException.class,()->
                CAPP.desassociaPesquisador("","4lan@hotmail.com"));
        assertThrows(NullPointerException.class,()->
                CAPP.desassociaPesquisador("FLO1",null));
        assertThrows(NullPointerException.class,()->
                CAPP.desassociaPesquisador(null,"4lan@hotmail.com"));
        assertThrows(IllegalArgumentException.class,()->
                CAPP.desassociaPesquisador("FLO1",""));

    }
}