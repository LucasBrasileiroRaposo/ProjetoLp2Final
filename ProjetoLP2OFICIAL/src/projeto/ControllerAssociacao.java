package projeto;

import Util.Validadora;
import projeto.pesquisadores.ControllerPesquisador;
import projeto.pesquisadores.Pesquisador;

public class ControllerAssociacao {

    private ControllerPesquisa controllerPesquisa;

    private ControllerObjetivos controllerObjetivos;

    private ControllerProblemas controllerProblemas;

    private ControllerAtividade controleAtividade;

    private ControllerPesquisador controllerPesquisadores;

    public ControllerAssociacao(ControllerPesquisa controllerPesquisa, ControllerPesquisador controllerPesquisadores, ControllerAtividade controleAtividade, ControllerObjetivos controllerObjetivos, ControllerProblemas controllerProblemas){
        this.controllerPesquisa = controllerPesquisa;
        this.controllerObjetivos = controllerObjetivos;
        this.controllerProblemas = controllerProblemas;
        this.controleAtividade = controleAtividade;
        this.controllerPesquisadores = controllerPesquisadores;
    }

    /** Parte US6
     *
     * @param idPesquisa
     * @param emailPesquisador
     * @return
     */
    public boolean associaPesquisador(String idPesquisa, String emailPesquisador){
        Validadora.verificaValorNullVazio(idPesquisa,"Campo idPesquisa nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(emailPesquisador,"Campo emailPesquisador nao pode ser nulo ou vazio.");

        Pesquisador pesquisador = this.controllerPesquisadores.pegaPesquisador(emailPesquisador);

        return this.controllerPesquisa.associaPesquisador(idPesquisa, pesquisador);
    }

    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
        Validadora.verificaValorNullVazio(idPesquisa,"Campo idPesquisa nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(emailPesquisador,"Campo emailPesquisador nao pode ser nulo ou vazio.");
        return this.controllerPesquisa.desassociaPesquisador(idPesquisa,emailPesquisador) ;
    }
}
