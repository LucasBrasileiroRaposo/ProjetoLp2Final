package projeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;
import projeto.pesquisa_e_associacoes.ControllerAssociacaoPesquisaObjetivoProblema;
import projeto.pesquisa_e_associacoes.RepositorioPesquisa;

import static org.junit.jupiter.api.Assertions.*;

class ControllerAssociacaoPesquisaObjetivoProblemaTest {
    ControllerAssociacaoPesquisaObjetivoProblema CAPOP;
    RepositorioPesquisa repositorioPesquisa;
    RepositorioObjetivos repositorioObjetivos;
    RepositorioProblemas repositorioProblemas;

    @BeforeEach
    void Inicializa(){
        repositorioPesquisa = new RepositorioPesquisa();
        repositorioObjetivos = new RepositorioObjetivos();
        repositorioProblemas = new RepositorioProblemas();
        CAPOP = new ControllerAssociacaoPesquisaObjetivoProblema(repositorioPesquisa,repositorioObjetivos,repositorioProblemas);
    }

    @Test
    void associaProblema() {
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