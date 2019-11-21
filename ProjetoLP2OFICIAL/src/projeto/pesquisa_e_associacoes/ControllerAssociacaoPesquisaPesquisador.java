package projeto.pesquisa_e_associacoes;

import Util.Validadora;
import projeto.pesquisadores.Pesquisador;
import projeto.pesquisadores.RepositorioPesquisador;

public class ControllerAssociacaoPesquisaPesquisador {

    /** ControllerPesquisa do sistema
     */
    private ControllerPesquisa controllerPesquisa;

    /** Repositorio que armazena todos os pesquisadores do sistema
     */
    private RepositorioPesquisador repositorioPesquisador;

    /** Construto do ControllerAssociacaoPesquisaPesquisador que receber como parametro o repositorio de pesquisadores e o controller das pesquisas.
     * @param controllerPesquisa ControllerPesquisa, que administra todas as acoes que envolvem uma pesquisa.
     * @param repositorioPesquisador RepositorioPesquisador, que contem todos os pesquisadores do sistem.
     */
    public ControllerAssociacaoPesquisaPesquisador(ControllerPesquisa controllerPesquisa, RepositorioPesquisador repositorioPesquisador){
        this.controllerPesquisa = controllerPesquisa;
        this.repositorioPesquisador = repositorioPesquisador;
    }

    /** Metodo responsavel por adicionar um pesquisador em uma pesquisa determinada pelo usuario
     *
     * @param idPesquisa String, que representa a chave da pesquisa que o usuário deseja que tenha um Pesquisador acessado nele.
     * @param emailPesquisador String,que represneta o email do pesquisador a ser adionado no mapa de pesquisadores de uma pesquisa.
     * @return True ou False dependendo se a operacao foi realizada com sucesso ou nao.
     */
    public boolean associaPesquisador(String idPesquisa, String emailPesquisador) {
        Validadora.verificaValorNullVazio(idPesquisa,"Campo idPesquisa nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(emailPesquisador,"Campo emailPesquisador nao pode ser nulo ou vazio.");

        Pesquisador pesquisador = this.repositorioPesquisador.pegaPesquisador(emailPesquisador);

        return this.controllerPesquisa.associaPesquisador(idPesquisa, pesquisador);
    }

    /** Metodo responsavel por remover um pesquisador de uma pesquisa selecionada pelo usuario.
     *
     * @param idPesquisa String,que representa a chave da pesquisa que o usuário deseja que tenha um Pesquisador removida dela.
     * @param emailPesquisador String, que representa o email do pesquisador que o usuario deseja que seja removido do mapa dos pesquisadores dentro da pesquisa.
     * @return True ou False, caso a operação tenha sido realizado com sucesso ou não.
     */
    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
        Validadora.verificaValorNullVazio(idPesquisa,"Campo idPesquisa nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(emailPesquisador,"Campo emailPesquisador nao pode ser nulo ou vazio.");
        return this.controllerPesquisa.desassociaPesquisador(idPesquisa,emailPesquisador) ;
    }
    
}
