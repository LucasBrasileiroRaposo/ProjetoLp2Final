package projeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.objetivos_e_problemas.Objetivo;
import projeto.objetivos_e_problemas.Problema;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;
import projeto.pesquisa_e_associacoes.ControllerAssociacaoPesquisaObjetivoProblema;
import projeto.pesquisa_e_associacoes.Pesquisa;
import projeto.pesquisa_e_associacoes.RepositorioPesquisa;

import static org.junit.jupiter.api.Assertions.*;

class ControllerAssociacaoPesquisaObjetivoProblemaTest {
    ControllerAssociacaoPesquisaObjetivoProblema CAPOP;
    RepositorioPesquisa repositorioPesquisa;
    RepositorioObjetivos repositorioObjetivos;
    RepositorioProblemas repositorioProblemas;
    Objetivo o1;
    Pesquisa p1;
    Problema problema;

    @BeforeEach
    void Inicializa(){
        repositorioPesquisa = new RepositorioPesquisa();
        repositorioObjetivos = new RepositorioObjetivos();
        repositorioProblemas = new RepositorioProblemas();
        CAPOP = new ControllerAssociacaoPesquisaObjetivoProblema(repositorioPesquisa,repositorioObjetivos,repositorioProblemas);
        o1 = new Objetivo("GERAL","oi",1,2,"O1");
        p1 = new Pesquisa("Pesquisa Florestal","Floresta","FLO1");
        problema = new Problema("Problema Social",2,"PRO1");
        repositorioPesquisa.cadastraPesquisa(p1.getDescricao(),p1.getCampoInteresse());
        repositorioProblemas.cadastraProblema(problema.getDescricao(),2);
        repositorioObjetivos.cadastraObjetivo("ESPECIFICO","ola",2,4);
    }

    @Test
    void associaProblema() {
        assertTrue(CAPOP.associaProblema(p1.getCodigo(),problema.getCodigo()));
        assertThrows(IllegalArgumentException.class, ()->
                CAPOP.associaProblema("FLO2","PRO1"));
        assertThrows(IllegalArgumentException.class, ()->
                CAPOP.associaProblema("FLO2","PRO@"));
        assertThrows(IllegalArgumentException.class, () ->
                CAPOP.associaProblema("joau","jureg"));

    }

    @Test
    void desassociaProblema() {
        CAPOP.associaProblema(p1.getCodigo(),problema.getCodigo());
        assertTrue(CAPOP.desassociaProblema(p1.getCodigo()));
        assertThrows(IllegalArgumentException.class, ()->
                CAPOP.desassociaObjetivo("oi","ola"));
        assertThrows(IllegalArgumentException.class,()->
                CAPOP.desassociaObjetivo("oi","O1"));
        assertThrows(IllegalArgumentException.class,()->
                CAPOP.desassociaObjetivo("FLO!","jureg"));
    }

    @Test
    void associaObjetivo() {
        assertTrue(CAPOP.associaObjetivo(p1.getCodigo(),o1.getCodigo()));
        assertThrows(IllegalArgumentException.class, ()->
                CAPOP.associaObjetivo("FLO1",""));
        assertThrows(IllegalArgumentException.class, ()->
                CAPOP.associaObjetivo("","O1"));
        assertThrows(IllegalArgumentException.class, ()->
                CAPOP.associaObjetivo("",""));
    }

    @Test
    void desassociaObjetivo() {
        CAPOP.associaObjetivo(p1.getCodigo(),o1.getCodigo());
        assertTrue(CAPOP.desassociaObjetivo(p1.getCodigo(),o1.getCodigo()));
        assertThrows(IllegalArgumentException.class, ()->
                CAPOP.desassociaObjetivo("FLO1",""));
        assertThrows(IllegalArgumentException.class, ()->
                CAPOP.desassociaObjetivo("","O1"));
        assertThrows(IllegalArgumentException.class, ()->
                CAPOP.desassociaObjetivo("",""));

    }
}