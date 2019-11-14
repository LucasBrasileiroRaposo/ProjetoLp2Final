package projeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;
import projeto.pesquisa_e_associacoes.ControllerAssociacaoPesquisaObjetivoProblema;
import projeto.pesquisa_e_associacoes.ControllerPesquisa;
import projeto.pesquisa_e_associacoes.RepositorioPesquisa;

import static org.junit.jupiter.api.Assertions.*;

class ControllerAssociacaoPesquisaObjetivoProblemaTest {
    ControllerAssociacaoPesquisaObjetivoProblema CAPOP;
    ControllerPesquisa controllerPesquisa;
    RepositorioObjetivos repositorioObjetivos;
    RepositorioProblemas repositorioProblemas;
    RepositorioPesquisa repositorioPesquisa;

    @BeforeEach
    void Inicializa(){
        this.repositorioPesquisa = new RepositorioPesquisa();
        this.controllerPesquisa = new ControllerPesquisa(repositorioPesquisa);
        this.repositorioObjetivos = new RepositorioObjetivos();
        this.repositorioProblemas = new RepositorioProblemas();
        this.CAPOP = new ControllerAssociacaoPesquisaObjetivoProblema(controllerPesquisa,repositorioObjetivos,repositorioProblemas);
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