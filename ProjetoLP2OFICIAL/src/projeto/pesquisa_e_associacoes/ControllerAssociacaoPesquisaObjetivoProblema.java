package projeto.pesquisa_e_associacoes;

import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;

public class ControllerAssociacaoPesquisaObjetivoProblema {

    private RepositorioPesquisa repositorioPesquisa;

    private RepositorioObjetivos repositorioObjetivos;

    private RepositorioProblemas repositorioProblemas;

    public ControllerAssociacaoPesquisaObjetivoProblema(RepositorioPesquisa repositorioPesquisa, RepositorioObjetivos repositorioObjetivos, RepositorioProblemas repositorioProblemas) {
        this.repositorioObjetivos = repositorioObjetivos;
        this.repositorioPesquisa = repositorioPesquisa;
        this.repositorioProblemas = repositorioProblemas;
    }
}
