package projeto.busca;

import Util.Validadora;
import projeto.atividades.RepositorioAtividade;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;
import projeto.pesquisa_e_associacoes.RepositorioPesquisa;
import projeto.pesquisadores.RepositorioPesquisador;

import java.util.ArrayList;
import java.util.List;

public class ControllerBusca {
    RepositorioPesquisa repositorioPesquisa= new RepositorioPesquisa();
    RepositorioPesquisador repositorioPesquisador = new RepositorioPesquisador();
    RepositorioProblemas repositorioProblemas = new RepositorioProblemas();
    RepositorioObjetivos repositorioObjetivos = new RepositorioObjetivos();
    RepositorioAtividade repositorioAtividade = new RepositorioAtividade();
    List<String> mensagemFinal = new ArrayList<>();

    public ControllerBusca(RepositorioPesquisa repositorioPesquisa, RepositorioPesquisador repositorioPesquisador, RepositorioProblemas repositorioProblemas, RepositorioObjetivos repositorioObjetivos,
                           RepositorioAtividade repositorioAtividade){
        this.repositorioPesquisa = repositorioPesquisa;
        this.repositorioPesquisador = repositorioPesquisador;
        this.repositorioProblemas = repositorioProblemas;
        this.repositorioObjetivos = repositorioObjetivos;
        this.repositorioAtividade = repositorioAtividade;

    }

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
