package projeto;

import projeto.atividades.RepositorioAtividade;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;
import projeto.pesquisa_e_associacoes.RepositorioPesquisa;
import projeto.pesquisadores.RepositorioPesquisador;

import java.io.IOException;
import java.io.Serializable;

public class controllerDados implements Serializable {
    RepositorioAtividade repositorioAtividade;
    RepositorioObjetivos repositorioObjetivos;
    RepositorioProblemas repositorioProblemas;
    RepositorioPesquisa repositorioPesquisa;
    RepositorioPesquisador repositorioPesquisador;

    public controllerDados(RepositorioAtividade ra, RepositorioObjetivos ro, RepositorioProblemas rprob, RepositorioPesquisa rpesquisa,
                           RepositorioPesquisador rpesquisador){
        this.repositorioAtividade = ra;
        this.repositorioObjetivos = ro;
        this.repositorioProblemas = rprob;
        this.repositorioPesquisa = rpesquisa;
        this.repositorioPesquisador = rpesquisador;
    }
    public void salvar() {
        repositorioAtividade.salvar();
        repositorioObjetivos.salvar();
        repositorioProblemas.salvar();
        repositorioPesquisa.salvar();
        repositorioPesquisador.salvar();
    }

    public void carregar(){
        repositorioAtividade.carregar();
        repositorioObjetivos.carregar();
        repositorioProblemas.carregar();
        repositorioPesquisa.carregar();
        repositorioPesquisador.carregar();
    }
}
