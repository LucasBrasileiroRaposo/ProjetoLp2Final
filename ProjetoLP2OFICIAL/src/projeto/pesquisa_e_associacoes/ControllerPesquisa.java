package projeto.pesquisa_e_associacoes;

import Util.Validadora;
import projeto.atividades.Atividade;
import projeto.objetivos_e_problemas.Objetivo;
import projeto.objetivos_e_problemas.Problema;
import projeto.pesquisadores.Pesquisador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControllerPesquisa {

    private RepositorioPesquisa repositorioPesquisa;

    public ControllerPesquisa(RepositorioPesquisa repositorioPesquisa){
        this.repositorioPesquisa = repositorioPesquisa;
    }

    public String cadastraPesquisa(String descricao, String campoDeInteresse) {
        return this.repositorioPesquisa.cadastraPesquisa(descricao, campoDeInteresse);
    }

    public void encerraPesquisa(String codigo, String motivo) {
        this.repositorioPesquisa.encerraPesquisa(codigo, motivo);
    }


    public void ativaPesquisa(String codigo) {
        this.repositorioPesquisa.ativaPesquisa(codigo);
    }

    public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
        this.repositorioPesquisa.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
    }

    public String exibePesquisa(String codigo) {
        return this.repositorioPesquisa.exibePesquisa(codigo);
    }

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

    public boolean adicionaAtividade(String codigoPesquisa, Atividade atividade) {
        return this.repositorioPesquisa.adicionaAtividade(codigoPesquisa, atividade);
    }

    public boolean removeAtividade(String codigoPesquisa, String codigoAtividade) {
        return this.repositorioPesquisa.removeAtividade(codigoPesquisa,codigoAtividade);
    }


    public boolean associaProblema(String idPesquisa, Problema problema) {
        return this.repositorioPesquisa.associaProblema(idPesquisa, problema);
    }

    public boolean desassociaProblema(String idPesquisa) {
        return this.repositorioPesquisa.desassociaProblema(idPesquisa);
    }

    public boolean associaObjetivo(String idPesquisa, Objetivo objetivo) {
        return this.repositorioPesquisa.associaObjetivo(idPesquisa,objetivo);
    }

    public boolean dessassociaObjetivo(String idPesquisa, Objetivo objetivo) {
        return this.repositorioPesquisa.dessassociaObjetivo(idPesquisa, objetivo);
    }

    public boolean associaPesquisador(String idPesquisa, Pesquisador pesquisador) {
        return this.repositorioPesquisa.associaPesquisador(idPesquisa, pesquisador);
    }

    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
        return this.repositorioPesquisa.desassociaPesquisador(idPesquisa, emailPesquisador);
    }
}
