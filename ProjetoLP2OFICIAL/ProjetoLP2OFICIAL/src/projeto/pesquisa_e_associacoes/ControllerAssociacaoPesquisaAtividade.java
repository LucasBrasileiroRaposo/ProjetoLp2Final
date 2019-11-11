package projeto.pesquisa_e_associacoes;

import projeto.atividades.RepositorioAtividade;

public class ControllerAssociacaoPesquisaAtividade {

    private RepositorioPesquisa repositorioPesquisa;

    private RepositorioAtividade repositorioAtividade;

    public ControllerAssociacaoPesquisaAtividade(RepositorioPesquisa repositorioPesquisa, RepositorioAtividade repositorioAtividade) {
        this.repositorioAtividade = repositorioAtividade;
        this.repositorioPesquisa = repositorioPesquisa;
    }

}
