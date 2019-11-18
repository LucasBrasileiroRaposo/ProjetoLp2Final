package projeto.pesquisa_e_associacoes;

import Util.Validadora;
import projeto.pesquisadores.Pesquisador;
import projeto.pesquisadores.RepositorioPesquisador;

public class ControllerAssociacaoPesquisaPesquisador {

    private ControllerPesquisa controllerPesquisa;

    private RepositorioPesquisador repositorioPesquisador;

    public ControllerAssociacaoPesquisaPesquisador(ControllerPesquisa controllerPesquisa, RepositorioPesquisador repositorioPesquisador){
        this.controllerPesquisa = controllerPesquisa;
        this.repositorioPesquisador = repositorioPesquisador;
    }

    public boolean associaPesquisador(String idPesquisa, String emailPesquisador) {
        Validadora.verificaValorNullVazio(idPesquisa,"Campo idPesquisa nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(emailPesquisador,"Campo emailPesquisador nao pode ser nulo ou vazio.");

        Pesquisador pesquisador = this.repositorioPesquisador.pegaPesquisador(emailPesquisador);

        return this.controllerPesquisa.associaPesquisador(idPesquisa, pesquisador);
    }
    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
        Validadora.verificaValorNullVazio(idPesquisa,"Campo idPesquisa nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(emailPesquisador,"Campo emailPesquisador nao pode ser nulo ou vazio.");
        return this.controllerPesquisa.desassociaPesquisador(idPesquisa,emailPesquisador) ;
    }
    
}
