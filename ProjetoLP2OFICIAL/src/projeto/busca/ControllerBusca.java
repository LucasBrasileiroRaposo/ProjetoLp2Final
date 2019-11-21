package projeto.busca;

import Util.Validadora;
import projeto.atividades.RepositorioAtividade;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;
import projeto.pesquisa_e_associacoes.ControllerPesquisa;
import projeto.pesquisa_e_associacoes.RepositorioPesquisa;
import projeto.pesquisadores.RepositorioPesquisador;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por controlar o sistema de busca de todo o sistema
 */
public class ControllerBusca {
    RepositorioPesquisa repositorioPesquisa= new RepositorioPesquisa();
    RepositorioPesquisador repositorioPesquisador = new RepositorioPesquisador();
    RepositorioProblemas repositorioProblemas = new RepositorioProblemas();
    RepositorioObjetivos repositorioObjetivos = new RepositorioObjetivos();
    RepositorioAtividade repositorioAtividade = new RepositorioAtividade();
    List<String> mensagemFinal = new ArrayList<>();

    /**
     * Construtor da classe ControllerBusca, onde irá inicializar os repositórios
     * @param repositorioPesquisa Repositório de Pesquisa
     * @param repositorioPesquisador Repositório de pesquisador
     * @param repositorioProblemas repositório de problemas
     * @param repositorioObjetivos repositório de Objetivos
     * @param repositorioAtividade repositório de Atividade
     */
    public ControllerBusca(RepositorioPesquisa repositorioPesquisa, RepositorioPesquisador repositorioPesquisador, RepositorioProblemas repositorioProblemas, RepositorioObjetivos repositorioObjetivos,
                           RepositorioAtividade repositorioAtividade){
        this.repositorioPesquisa = repositorioPesquisa;
        this.repositorioPesquisador = repositorioPesquisador;
        this.repositorioProblemas = repositorioProblemas;
        this.repositorioObjetivos = repositorioObjetivos;
        this.repositorioAtividade = repositorioAtividade;

    }

    /**
     * Método responsável por receber de todas as classes os termos encontrados pela busca
     * @param termo termo que deseja procurar no sistema
     * @return retorna todos os termos encontrados no sistema
     */
    public String busca(String termo){
        Validadora.verificaValorNullVazio(termo,"Campo termo nao pode ser nulo ou vazio.");
        String resultado = "";
        mensagemFinal.clear();
        mensagemFinal.add(repositorioPesquisa.busca(termo));
        mensagemFinal.add(repositorioPesquisador.busca(termo));
        mensagemFinal.add(repositorioProblemas.busca(termo));
        mensagemFinal.add(repositorioObjetivos.busca(termo));
        mensagemFinal.add(repositorioAtividade.busca(termo));

        for(String s : mensagemFinal){
            resultado += s;
        }
        if(resultado.equals("")){
            return resultado;
        }else{
        return resultado.substring(0,resultado.length()-3);
        }

    }

    /**
     * Método responsável por exibir um termo específico encontrado no sistema
     * @param termo termo a ser procurado
     * @param numeroDoResultado posição em que o termo se encontra na exibição de todos os termos encontrados
     * @return retorna o termo encontrado ou null se não existir
     */
    public String busca(String termo, int numeroDoResultado){
        Validadora.verificaValorNullVazio(termo,"Campo termo nao pode ser nulo ou vazio.");
        Validadora.verificaSeNumeroNegativo(numeroDoResultado,"Numero do resultado nao pode ser negativo");
        Validadora.verificaSeNumeroMaiorQueResultados(numeroDoResultado,contaResultadosBusca(termo),"Entidade nao encontrada.");
        int cont =0;
        for(String s: busca(termo).split(" \\| ")){
            cont+=1;
            if(cont == numeroDoResultado){
                return s;
            }
        }
        return null;
    }

    /**
     * Conta a quantidade de termos encontrados em todo o sistema
     * @param termo termo a ser contabilizado
     * @return retorna a quantidade de vezes que ele apareceu
     */
    public int contaResultadosBusca(String termo){
        Validadora.verificaValorNullVazio(termo,"Campo termo nao pode ser nulo ou vazio.");
        String msg = busca(termo);
        int cont = 0;
        if(termo.contains(msg)){
            throw new IllegalArgumentException("Nenhum resultado encontrado");
        }else{
            for(String s: msg.split(" \\| ")){
                if(s.contains(termo)){
                    cont+=1;
                }
            }
        }
        return cont;
    }
}
