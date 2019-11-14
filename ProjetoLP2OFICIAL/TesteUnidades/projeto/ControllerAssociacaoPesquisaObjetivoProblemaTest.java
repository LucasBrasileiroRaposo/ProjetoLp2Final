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
    }

    @Test
    void associaProblema() {

        assertTrue(CAPOP.associaProblema("FLO1","PRO1"));
        assertThrows(IllegalArgumentException.class, ()->
                CAPOP.associaProblema("ORI1","PRO1"));
        assertThrows(IllegalArgumentException.class, ()->
                CAPOP.associaProblema("FLO1","PRO2"));


    }

    @Test
    void desassociaProblema() {
    }

    @Test
    void associaObjetivo() {
    }

    @Test
    void desassociaObjetivo() {
    }
}