package projeto.pesquisa_e_associacoes;

import projeto.Util.Validadora;
import projeto.pesquisadores.Pesquisador;
import projeto.pesquisadores.RepositorioPesquisador;

public class ControllerAssociacaoPesquisaPesquisador {

    private RepositorioPesquisa repositorioPesquisa;

    private RepositorioPesquisador repositorioPesquisador;

    public ControllerAssociacaoPesquisaPesquisador(RepositorioPesquisa repositorioPesquisa, RepositorioPesquisador repositorioPesquisador){
        this.repositorioPesquisa = repositorioPesquisa;
        this.repositorioPesquisador = repositorioPesquisador;
    }

    public boolean associaPesquisador(String idPesquisa, String emailPesquisador) {
        Validadora.verificaValorNullVazio(idPesquisa,"Campo idPesquisa nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(emailPesquisador,"Campo emailPesquisador nao pode ser nulo ou vazio.");

        Pesquisador pesquisador = this.repositorioPesquisador.pegaPesquisador(emailPesquisador);

        return this.repositorioPesquisa.associaPesquisador(idPesquisa, pesquisador);
    }
    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
        Validadora.verificaValorNullVazio(idPesquisa,"Campo idPesquisa nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(emailPesquisador,"Campo emailPesquisador nao pode ser nulo ou vazio.");
        return this.repositorioPesquisa.desassociaPesquisador(idPesquisa,emailPesquisador) ;
    }
}
