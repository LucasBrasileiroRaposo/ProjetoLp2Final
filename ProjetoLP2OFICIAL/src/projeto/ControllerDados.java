package projeto;

import projeto.atividades.RepositorioAtividade;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;
import projeto.pesquisa_e_associacoes.RepositorioPesquisa;
import projeto.pesquisadores.RepositorioPesquisador;

import java.io.*;

/**
 * Controller responsável por controlar o armazenamento e carregamento de dados do sistema.
 */
public class ControllerDados implements Serializable {

    private static final long serialVersionUID = 1;
    private RepositorioAtividade repositorioAtividade;
    private RepositorioObjetivos repositorioObjetivos;
    private RepositorioProblemas repositorioProblemas;
    private RepositorioPesquisa repositorioPesquisa;
    private RepositorioPesquisador repositorioPesquisador;


    /**
     * Construtor responsável por gerar os repositórios para armazenamento e carregamento dos arquivos
     * @param repositorioAtividade repositório de atividade.
     * @param repositorioObjetivos repositório de Objetivos.
     * @param repositorioProblemas repositório de Problemas.
     * @param repositorioPesquisa repositório de Pesquisa.
     * @param repositorioPesquisador repositório de Pesquisador.
     */
    public ControllerDados(RepositorioAtividade repositorioAtividade, RepositorioObjetivos repositorioObjetivos,
                           RepositorioProblemas repositorioProblemas, RepositorioPesquisa repositorioPesquisa,
                           RepositorioPesquisador repositorioPesquisador){
        this.repositorioAtividade = repositorioAtividade;
        this.repositorioObjetivos = repositorioObjetivos;
        this.repositorioProblemas = repositorioProblemas;
        this.repositorioPesquisa = repositorioPesquisa;
        this.repositorioPesquisador = repositorioPesquisador;
    }
    /**
     * Salva uma atividade.
     */
    private void salvarAtividade(){
        try{
            FileOutputStream arquivoDeSaida = new FileOutputStream("src/Atividade.txt");
            ObjectOutputStream saida = new ObjectOutputStream(arquivoDeSaida);
            saida.writeObject(this.repositorioAtividade);
            saida.close();
        }catch (IOException e){
            e.printStackTrace();;
        }

    }
    /**
     * Salva Objetivos.
     */
    private void salvarObjetivos(){
        try{
            FileOutputStream arquivoDeSaida = new FileOutputStream("src/Objetivos.txt");
            ObjectOutputStream saida = new ObjectOutputStream(arquivoDeSaida);
            saida.writeObject(this.repositorioObjetivos);
            saida.close();
        }catch (IOException e){
            e.printStackTrace();;
        }

    }
    /**
     * Salva uma Problemas.
     */
    private void salvarProblemas(){
        try{
            FileOutputStream arquivoDeSaida = new FileOutputStream("src/Problemas.txt");
            ObjectOutputStream saida = new ObjectOutputStream(arquivoDeSaida);
            saida.writeObject(this.repositorioProblemas);
            saida.close();
        }catch (IOException e){
            e.printStackTrace();;
        }

    }
    /**
     * Salva uma Pesquisa.
     */
    private void salvarPesquisa(){
        try{
            FileOutputStream arquivoDeSaida = new FileOutputStream("src/Pesquisa.txt");
            ObjectOutputStream saida = new ObjectOutputStream(arquivoDeSaida);
            saida.writeObject(this.repositorioPesquisa);
            saida.close();
        }catch (IOException e){
            e.printStackTrace();;
        }

    }
    /**
     * Salva um Pesquisador.
     */
    private void salvarPesquisador(){
        try{
            FileOutputStream arquivoDeSaida = new FileOutputStream("src/Pesquisador.txt");
            ObjectOutputStream saida = new ObjectOutputStream(arquivoDeSaida);
            saida.writeObject(this.repositorioPesquisador);
            saida.close();
        }catch (IOException e){
            e.printStackTrace();;
        }

    }
    /**
     * Invoca todos os métodos para salvar os Objetos.
     */
    public void salvar() {
        salvarAtividade();
        salvarObjetivos();
        salvarProblemas();
        salvarPesquisa();
        salvarPesquisador();
    }

    /**
     * Carrega Objetos de atividade salvos.
     */
  private void carregarAtividade(){
        try{
            FileInputStream entradaDoArquivo = new FileInputStream("src/Atividade.txt");
            ObjectInputStream entrada = new ObjectInputStream(entradaDoArquivo);
            this.repositorioAtividade = (RepositorioAtividade) entrada.readObject();
            entrada.close();
            entradaDoArquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

  }
    /**
     * Carrega Objetos de Objetivos salvos.
     */
    private void carregarObjetivos(){
        try{
            FileInputStream entradaDoArquivo = new FileInputStream("src/Objetivos.txt");
            ObjectInputStream entrada = new ObjectInputStream(entradaDoArquivo);
            this.repositorioObjetivos = (RepositorioObjetivos) entrada.readObject();
            entrada.close();
            entradaDoArquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

    }
    /**
     * Carrega Objetos de Problemas salvos.
     */
    private void carregarProblemas(){
        try{
            FileInputStream entradaDoArquivo = new FileInputStream("src/Problemas.txt");
            ObjectInputStream entrada = new ObjectInputStream(entradaDoArquivo);
            this.repositorioProblemas = (RepositorioProblemas) entrada.readObject();
            entrada.close();
            entradaDoArquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

    }
    /**
     * Carrega Objetos de Pesquisa salvos.
     */
    private void carregarPesquisa(){
        try{
            FileInputStream entradaDoArquivo = new FileInputStream("src/Pesquisa.txt");
            ObjectInputStream entrada = new ObjectInputStream(entradaDoArquivo);
            this.repositorioPesquisa = (RepositorioPesquisa) entrada.readObject();
            entrada.close();
            entradaDoArquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

    }
    /**
     * Carrega Objetos de Pesquisador salvos.
     */
    private void carregarPesquisador(){
        try{
            FileInputStream entradaDoArquivo = new FileInputStream("src/Pesquisador.txt");
            ObjectInputStream entrada = new ObjectInputStream(entradaDoArquivo);
            this.repositorioPesquisador = (RepositorioPesquisador) entrada.readObject();
            entrada.close();
            entradaDoArquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

    }
    /**
     * Invoca todos os métodos carregar do sistema.
     */
    public void carregar(){
        carregarAtividade();
        carregarObjetivos();
        carregarProblemas();
        carregarPesquisa();
        carregarPesquisador();
    }
}
