package projeto.pesquisa_e_associacoes;

import Util.Validadora;
import projeto.atividades.Atividade;
import projeto.objetivos_e_problemas.Objetivo;
import projeto.objetivos_e_problemas.Problema;
import projeto.pesquisadores.Pesquisador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Classe que conecta a Facade com o repositorio das pesquisas
 */
public class ControllerPesquisa {

    /** RepositorioPesquisa que o controller vai operar.
     */
    private RepositorioPesquisa repositorioPesquisa;

    /** Construtor do controller, que recebe um RepositorioPesquisa como parametro
     * @param repositorioPesquisa represneta o RepositorioPesquisa no qual o Controller vai operar sob.
     */
    public ControllerPesquisa(RepositorioPesquisa repositorioPesquisa){
        this.repositorioPesquisa = repositorioPesquisa;
    }

    /** Metodo responsavel que repassa o comando para cadastrar uma pesquisa.
     *
     * @param descricao String, que representa a descricao sobre o que é a pesquisa.
     * @param campoDeInteresse String, que representa o  campo de interesse da pesquisa.
     * @return o codigo identificador da pesquisa, formado pelas 3 primeiras letra do campo de interrese, maiusculas e o numero de pesquisas desse campo.
     */
    public String cadastraPesquisa(String descricao, String campoDeInteresse) {
        return this.repositorioPesquisa.cadastraPesquisa(descricao, campoDeInteresse);
    }

    /**
     * Método responsável por alterar o status de uma pesquisa
     *
     * @param codigo codigo identificador da pesquisa
     * @param motivo motivo de encerramento de uma pesquisa
     */
    public void encerraPesquisa(String codigo, String motivo) {
        this.repositorioPesquisa.encerraPesquisa(codigo, motivo);
    }

    /**
     * Método responsável por alterar o status de uma pesquisa
     *
     * @param codigo codigo identificador de uma pesquisa
     */
    public void ativaPesquisa(String codigo) {
        this.repositorioPesquisa.ativaPesquisa(codigo);
    }

    /**
     * Método responsável por editar as informações de uma pesquisa
     *
     * @param codigo               codigo identificador de uma pesquisa
     * @param conteudoASerAlterado qual a opcao a ser alterada na pesquisa
     * @param novoConteudo         novo conteudo a ser inseirdo na pesquisa
     */
    public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
        this.repositorioPesquisa.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
    }

    /**
     * Método responsável por retornar a representação textual de uma pesquisa
     *
     * @param codigo codigo identificador de uma pesquisa
     * @return toString de uma pesquisa
     */
    public String exibePesquisa(String codigo) {
        return this.repositorioPesquisa.exibePesquisa(codigo);
    }

    /**
     * Método responsável por vefirificar se o status de uma pesquisa está "Ativa"
     *
     * @param codigo codigo identificador de uma pesquisa
     * @return retorna um boolean true ou false
     */
    public boolean verificaSeAtiva(String codigo) {
        return this.repositorioPesquisa.verificaSeAtiva(codigo);
    }


    /**
     * Metodo que lista as pesquisas de acordo com o parametro que é passado. Se a ordem for por pesquisa, a listagem sera das pesquisas
     * de Maior ID para as que tem menor ID. Se a ordem for por problema, a listagem sera das pesquisas de maior ID que tem
     * problema associado para o de menor ID, depois sera das pesquisas de Maior ID para as de menor das pesquisas que nao tem problema
     * associado.
     * Se a ordem for por objetivo, a listagem sera das pesquisas que tem mais objetivos associados para as de menos. Se for igual ou nao
     * tiver nenhum objetivo associado dentro da pesquisa, a ordenacao sera das pesquisas de maior ID para as de menor ID.
     * @param ordem a ordem de ordenacao desejada
     * @return representacao em String dos dados da pesquisa, seu codigo, sua descricao e campo de interesse.
     */
    public String listaPesquisas(String ordem) {
        Validadora.verificaValorNullVazio(ordem, "Valor invalido da ordem");
        if(!(ordem.toUpperCase().equals("PROBLEMA")) && !(ordem.toUpperCase().equals("OBJETIVOS")) && !(ordem.toUpperCase().equals("PESQUISA"))) {
            throw new IllegalArgumentException("Valor invalido da ordem");
        }

        List<Pesquisa> listaPesquisas = new ArrayList();
        listaPesquisas.addAll(this.repositorioPesquisa.getMapaPesquisas().values());
        String listar = "";

        if (ordem.toUpperCase().equals("PESQUISA")) {

            Collections.sort (listaPesquisas);

            for(Pesquisa pesquisa: listaPesquisas) {
                listar += pesquisa.getCodigo() + pesquisa.toString() + " | ";
            }
            listar = listar.substring(0, listar.length()-3);
            return listar;
        }
        else if (ordem.toUpperCase().equals("PROBLEMA")) {


            Collections.sort (listaPesquisas);

            for(Pesquisa pesquisa: listaPesquisas) {
                if(pesquisa.getListaProblema().size() == 1) {
                    listar += pesquisa.getCodigo() + pesquisa.toString() + " | ";
                }
            }
            for(Pesquisa pesquisa: listaPesquisas) {
                if (pesquisa.getListaProblema().size() == 0) {
                    listar += pesquisa.getCodigo() + pesquisa.toString() + " | ";
                }

            }
            listar = listar.substring(0, listar.length() -3);
            return listar;

        } else {  /**
         *            ordem == "OBJETIVO";
         */

            ObjetivoComparator objetivoComparator = new ObjetivoComparator();

            Collections.sort (listaPesquisas, objetivoComparator );
            for(Pesquisa pesquisa: listaPesquisas) {
                if(pesquisa.getListaObjetivos().size() != 0) {
                    listar += pesquisa.getCodigo() + pesquisa.toString() + " | ";
                }
            }

            Collections.sort(listaPesquisas);

            for (Pesquisa pesquisa: listaPesquisas) {
                if(pesquisa.getListaObjetivos().size() == 0) {
                    listar += pesquisa.getCodigo() + pesquisa.toString() + " | ";
                }
            }
            listar = listar.substring(0, listar.length()-3);
            return listar;

        }
    }

    /** Metodo responsavel por adicionar determianda atividade em uma pesquisa.
     * @param codigoPesquisa String,que representa a chave da pesquisa que o usuário deseja que tenha uma Atividade adicionada nela.
     * @param atividade objeto do tipo Atividade , que é a atividade a ser associada a pesquisa.
     * @return True ou False dependendo do resultado da operação.
     */
    public boolean adicionaAtividade(String codigoPesquisa, Atividade atividade) {
        return this.repositorioPesquisa.adicionaAtividade(codigoPesquisa, atividade);
    }

    /** Metodo responsavel por remover uma atividade de uma pesquisa.
     * @param codigoPesquisa String,que representa a chave da pesquisa que o usuário deseja que tenha uma Atividade removida dela.
     * @param codigoAtividade String, que representa o codigo da atividade que o usuario deseja remover da pesquisa.
     * @return True ou False dependendo do resultado da operação.
     */
    public boolean removeAtividade(String codigoPesquisa, String codigoAtividade) {
        return this.repositorioPesquisa.removeAtividade(codigoPesquisa,codigoAtividade);
    }

    /**
     * Metodo que associa um problema a uma pesquisa. Uma pesquisa so pode ter um problema associado. Se tentar associar um problema a uma pesquisa que ja tem problema, dara erro.
     * @param idPesquisa codigo que identifica a pesquisa
     * @param problema objeto problema que quer se associar a pesquisa
     * @return true se houver a associacao e false se nao houver.
     */
    public boolean associaProblema(String idPesquisa, Problema problema) {
        return this.repositorioPesquisa.associaProblema(idPesquisa, problema);
    }

    /**
     * Metodo que desassocia um problema de uma pesquisa.
     * @param idPesquisa codigo que identifica a pesquisa
     * @return Se nao houver nenhuma pesquisa ou a pesquisa estiver desativada, dara erro. Se  nao tiver esse problema retornara false
     * . Se for bem sucedida, retornara true.
     */
    public boolean desassociaProblema(String idPesquisa) {
        return this.repositorioPesquisa.desassociaProblema(idPesquisa);
    }

    /**
     * Metodo que associa um objetivo a uma pesquisa.
     * @param idPesquisa codigo que identifica a pesquisa
     * @param objetivo objeto Objetivo que quer se associar a pesquisa
     * @return true se houver a associacao e false se nao houver.
     */
    public boolean associaObjetivo(String idPesquisa, Objetivo objetivo) {
        return this.repositorioPesquisa.associaObjetivo(idPesquisa,objetivo);
    }

    /**
     * Metodo que desassocia um objetivo de uma pesquisa.
     * @param idPesquisa codigo que identifica a pesquisa
     * @param objetivo Objeto objetivo que sera removido
     * @return true se for bem sucedido, false se aquele objetivo nao estiver dentro da lista de objetivos da pesquisa. Sera lancada excecao
     * se a pesquisa estiver desativada ou nao existir.
     */
    public boolean dessassociaObjetivo(String idPesquisa, Objetivo objetivo) {
        return this.repositorioPesquisa.dessassociaObjetivo(idPesquisa, objetivo);
    }

    /** Metodo responsavel por adicionar um objeto Pesquisador em uma pesquisa determinada pelo usuario
     *
     * @param idPesquisa String, que representa a chave da pesquisa que o usuário deseja que tenha um Pesquisador acessado nele.
     * @param pesquisador objeto do tipo Pesquisador, que eh o pesquisador a ser adionado no mapa de pesquisadores de uma pesquisa.
     * @return True ou False dependendo se a operacao foi realizada com sucesso ou nao.
     */
    public boolean associaPesquisador(String idPesquisa, Pesquisador pesquisador) {
        return this.repositorioPesquisa.associaPesquisador(idPesquisa, pesquisador);
    }

    /** Metodo responsavel por remover um Objeto Pesquisador de uma pesquisa selecionada pelo usuario.
     *
     * @param idPesquisa String,que representa a chave da pesquisa que o usuário deseja que tenha um Pesquisador removida dela.
     * @param emailPesquisador String, que representa o email do pesquisador que o usuario deseja que seja removido do mapa dos pesquisadores dentro da pesquisa.
     * @return True ou False, caso a operação tenha sido realizado com sucesso ou não.
     */
    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
        return this.repositorioPesquisa.desassociaPesquisador(idPesquisa, emailPesquisador);
    }

    /** Configura a estrategia de exibicao de atividades de uma pesquisa.
     * @param estrategia String, que representa o parametro que deve ser considerado para a organizacao dessa pesquisa.
     */
    public void configuraEstrategia(String estrategia) {
	       Validadora.verificaValorNullVazio(estrategia,"Estrategia nao pode ser nula ou vazia.");
	       Validadora.verificaEstrategia(estrategia, "Valor invalido da estrategia");
	       for( Pesquisa p : this.repositorioPesquisa.getMapaPesquisas().values()){
	           p.configuraEstragia(estrategia);
	           
	       }
    }

    /** Pega a proxima atividade dependendo de qual estrategia de organizacao das atividades o usuario escolheu.
     * @param codigoPesquisa String, que representa o codigo da pesquisa que o usuario deseja ver a proxima atividade a ser executada na ordem.
     * @return String, com o codigo da atividade que vem em seguida nessa ordem, configurada pelo usuario.
     */
    public String proximaAtividade(String codigoPesquisa) {
        Validadora.verificaValorNullVazio(codigoPesquisa,"Pesquisa nao pode ser nula ou vazia.");

        if(this.repositorioPesquisa.getMapaPesquisas().containsKey(codigoPesquisa)) {
            Pesquisa pesquisa = this.repositorioPesquisa.getMapaPesquisas().get(codigoPesquisa);
            if(pesquisa.getStatus()) {
                return pesquisa.proximaAtividade();
            }

            throw new IllegalArgumentException("Pesquisa desativada.");

        }

        throw new IllegalArgumentException("Pesquisa nao encontrada.");

    }
}
