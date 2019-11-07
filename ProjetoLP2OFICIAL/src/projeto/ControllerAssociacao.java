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

    public ControllerAssociacao(){
        this.controllerPesquisa = new ControllerPesquisa();
        this.controllerObjetivos = new ControllerObjetivos();
        this.controllerProblemas = new ControllerProblemas();
        this.controleAtividade = new ControllerAtividade();
        this.controllerPesquisadores = new ControllerPesquisador();
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
}
