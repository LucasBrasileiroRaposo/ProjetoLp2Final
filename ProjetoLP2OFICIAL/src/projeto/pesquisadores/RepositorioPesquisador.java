package projeto.pesquisadores;

import Util.Validadora;
import projeto.busca.Busca;


import java.util.HashMap;
import java.util.Map;

public class RepositorioPesquisador implements Busca {
    private Map<String, Pesquisador> mapaDePesquisadores;

    /**
     * Construtor responsável por inicializar o armazenamento de pesquisadores
     */
    public RepositorioPesquisador() {
        mapaDePesquisadores = new HashMap<>();
    }

    /**
     * Método responsável por cadastrar os dados de um pesquisador
     * @param nome nome do pesquisador
     * @param funcao função do pesquisador
     * @param biografia biografia do pesquisador
     * @param email email do pesquisador
     * @param foto fotoURL do pesquisador
     */
    public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto) {
        Validadora.verificaValorNullVazio(nome, "Campo nome nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(funcao, "Campo funcao nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(biografia, "Campo biografia nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(email, "Campo email nao pode ser nulo ou vazio.");
        Validadora.validaEmail(email,"Formato de email invalido.");
        Validadora.verificaValorNullVazio(foto, "Campo fotoURL nao pode ser nulo ou vazio.");
        Validadora.validaFoto(foto,"Formato de foto invalido.");

        Pesquisador P = new Pesquisador(nome, funcao, biografia, email, foto);
        this.mapaDePesquisadores.put(email, P);
    }

    /**
     * Altera um determinado dado por um novo valor
     * @param email email do pesquisador
     * @param atributo atributo do pesquisador
     * @param novoValor novo valor a ser inserido
     */
    public void alteraPesquisador(String email, String atributo, String novoValor) {
        Validadora.verificaValorNullVazio(atributo,"Atributo nao pode ser vazio ou nulo.");
        Validadora.verificaPesquisador(mapaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");
        if (atributo.equals("NOME")) {
            Validadora.verificaValorNullVazio(novoValor,"Campo nome nao pode ser nulo ou vazio.");
            this.mapaDePesquisadores.get(email).setNome(novoValor);
        }
        else if (atributo.equals("FUNCAO")) {
            Validadora.verificaValorNullVazio(novoValor,"Campo funcao nao pode ser nulo ou vazio.");
            mapaDePesquisadores.get(email).setFuncao(novoValor);
        }
        else if (atributo.equals("BIOGRAFIA")) {
            Validadora.verificaValorNullVazio(novoValor,"Campo biografia nao pode ser nulo ou vazio.");
            mapaDePesquisadores.get(email).setBiografia(novoValor);
        }
        else if (atributo.equals("EMAIL")) {
            Validadora.verificaValorNullVazio(novoValor,"Campo email nao pode ser nulo ou vazio.");
            Validadora.validaEmail(novoValor,"Formato de email invalido.");
            mapaDePesquisadores.get(email).setEmail(novoValor);
            mapaDePesquisadores.put(novoValor, mapaDePesquisadores.get(email));
            mapaDePesquisadores.remove(email);
        }
        else if (atributo.equals("FOTO")) {
            Validadora.verificaValorNullVazio(novoValor,"Campo fotoURL nao pode ser nulo ou vazio.");
            Validadora.validaFoto(novoValor,"Formato de foto invalido.");
            mapaDePesquisadores.get(email).setFotoURL(novoValor);
        }else{
            if (this.mapaDePesquisadores.get(email).getEspecialidade() instanceof PesquisadorAluno){
                if(atributo.equals("IEA")){
                    this.mapaDePesquisadores.get(email).alteraPesquisador("IEA",novoValor);
                }else if(atributo.equals("SEMESTRE")){
                    this.mapaDePesquisadores.get(email).alteraPesquisador("SEMESTRE",novoValor);
                }
            }else if (this.mapaDePesquisadores.get(email).getEspecialidade()instanceof PesquisadorProfessor){
                if (atributo.equals("UNIDADE")){
                    Validadora.verificaValorNullVazio(novoValor,"");
                    this.mapaDePesquisadores.get(email).alteraPesquisador("UNIDADE",novoValor);
                }else if(atributo.equals("FORMACAO")){
                    Validadora.verificaValorNullVazio(novoValor,"");
                    this.mapaDePesquisadores.get(email).alteraPesquisador("FORMACAO",novoValor);
                }else if(atributo.equals("DATA")){
                    Validadora.verificaFormatoData(novoValor,"");
                    this.mapaDePesquisadores.get(email).alteraPesquisador("DATA",novoValor);
                }
            }else{
                Validadora.validaAtributo(atributo,"Atributo invalido.");
            }
        }

    }

    /**
     * Desativa um pesquisador
     * @param email email de um pesquisador
     */
    public void desativaPesquisador(String email) {
        Validadora.verificaValorNullVazio(email, "Campo email nao pode ser nulo ou vazio.");
        Validadora.validaEmail(email,"Formato de email invalido.");
        Validadora.verificaPesquisador(mapaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");
        Validadora.verificaPesquisadorAtivo(mapaDePesquisadores.get(email).getStatus().equals("DESATIVADO"),"Pesquisador inativo.");
        if (mapaDePesquisadores.containsKey(email)) {
            mapaDePesquisadores.get(email).setStatus("DESATIVADO");
        }
    }

    /**
     * Ativa um pesquisador
     * @param email email do pesquisador
     */
    public void ativaPesquisador(String email) {
        Validadora.verificaValorNullVazio(email, "Campo EMAIL nao pode ser nulo ou vazio.");
        Validadora.validaEmail(email,"Formato de email invalido.");
        Validadora.verificaPesquisador(mapaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");
        Validadora.verificaPesquisadorAtivo(mapaDePesquisadores.get(email).getStatus().equals("ATIVADO"),"Pesquisador ja ativado.");
        if (mapaDePesquisadores.containsKey(email)) {
            mapaDePesquisadores.get(email).setStatus("ATIVADO");
        }
    }

    /**
     * Exibe um determinado pesquisador apartir de um email
     * @param email email do pesquisador
     * @return retorna se o pesquisador está Ativado ou Desativado
     */
    public String exibePesquisador(String email){
        Validadora.verificaValorNullVazio(email, "Campo email nao pode ser nulo ou vazio.");
        Validadora.validaEmail(email,"Formato de email invalido.");
        Validadora.verificaPesquisador(mapaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");
        String msg = "";
        if (this.mapaDePesquisadores.containsKey(email)){
            if(this.mapaDePesquisadores.get(email).getStatus().equals("ATIVADO")){
                return this.mapaDePesquisadores.get(email).toString();
            }else{
                msg = "PESQUISADOR DESATIVADO!";
                return msg;
            }
        }else{
            msg = "PESQUISADOR NÃO CADASTRADO!";
            return msg;
        }
    }

    /**
     * Verifica se o pesquisador é Ativo
     * @param email email do pesquisador
     * @return retorna True se o pesquisador é ativo e False se não.
     */
    public boolean pesquisadorEhAtivo(String email){
        Validadora.verificaValorNullVazio(email, "Email nao pode ser vazio ou nulo.");
        Validadora.validaEmail(email,"Formato de email invalido.");
        Validadora.verificaPesquisador(mapaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");
        if(mapaDePesquisadores.get(email).getStatus().equals("ATIVADO")){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Quando,chamado o metodo retorna um determinado pesquisador quando for necessario a associação de um deles com uma Pesquisa.
     * @param email String, que vai funcionar como identificador do pesquisador que o usuario deseja que seja retornado seu objeto.
     * @return determinado Objeto do tipo Pesquisador que
     */
    public Pesquisador pegaPesquisador(String email){
        Validadora.verificaPesquisador(mapaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");

        return this.mapaDePesquisadores.get(email);
    }

    /**
     * Metodo utilizado para cadastra um pesquisador como pesquisador professor, recebendo o email do pesquisador "normal" e os dados exclusivos de um objeto PesquisadorProfessor.
     * @param email String, que funciona como identificador do objeto Pesquisador, no mapa de todos os pesquisadores cadastrados.
     * @param formacao String, que representa o grau de formacao do professor.
     * @param unidade String, que representa a instituicao que o professor frequentou ou frequenta.
     * @param data String, que representa a data .
     */
    public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data) {
        Validadora.verificaValorNullVazio(email,"Campo email nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(formacao,"Campo formacao nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(unidade,"Campo unidade nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(data,"Campo data nao pode ser nulo ou vazio.");
        Validadora.verificaFormatoData(data,"Atributo data com formato invalido.");

        if (!this.mapaDePesquisadores.containsKey(email)) {
            throw new IllegalArgumentException("Pesquisadora nao encontrada.");
        }
        else{
            if(!this.mapaDePesquisadores.get(email).getFuncao().equals("professor")){
                throw new IllegalArgumentException("Pesquisador nao compativel com a especialidade.");
            }
            Especialidade pesquisadorProfessor = new PesquisadorProfessor(formacao,unidade,data);
            this.mapaDePesquisadores.get(email).setEspecialidade(pesquisadorProfessor);

        }
    }

    /**
     * Metodo utilizado para cadastrar um estudante como pesquisador aluno, recebendo o email do pesquisador "normal" e os dados exclusivos de um objeto PesquisadorAluno.
     * @param email String, que funciona como identificador do objeto Pesquisador, no mapa de todos os pesquisadores cadastrados.
     * @param semestre int, que representa o semestre que o aluno esta.
     * @param iea double , que representa o indice de eficiencia academica do aluno.
     */
    public void cadastraEspecialidadeAluno(String email, int semestre, double iea) {
        Validadora.verificaValorNullVazio(email,"Campo email nao pode ser nulo ou vazio.");
        if(semestre < 1 ){
            throw new IllegalArgumentException("Atributo semestre com formato invalido.");
        }else if (iea > 10 || iea < 0){
            throw new IllegalArgumentException("Atributo IEA com formato invalido.");
        }else if(!this.mapaDePesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisadora nao encontrada.");
        }else {
            if(!this.mapaDePesquisadores.get(email).getFuncao().equals("estudante")){
                throw new IllegalArgumentException("Pesquisador nao compativel com a especialidade.");
            }
            Especialidade pesquisadorAluno = new PesquisadorAluno(semestre,iea);
            this.mapaDePesquisadores.get(email).setEspecialidade(pesquisadorAluno);

        }
    }

    /**
     * Metodo responsavel por listar todos os pesquisadores de determinada funcao.
     * @param tipo String, que representao o tipo dos pesquisadores que o usuario quer que seja exibido sua representacao textual.
     * @return String, que é a representacao textual do pesquisador de tal funcao, podendo ser essa: externo,estudante ou professor.
     */
    public String listaPesquisadores(String tipo) {
        Validadora.verificaValorNullVazio(tipo,"Campo tipo nao pode ser nulo ou vazio.");
        if(!tipo.equals("EXTERNO") && !tipo.equals("PROFESSOR") && !tipo.equals("ALUNO")){
            throw new IllegalArgumentException("Tipo " + tipo + " inexistente.");
        }else{
            String saida = "";
            for (Pesquisador p: this.mapaDePesquisadores.values()){
                if(tipo.equals("EXTERNO") && p.getFuncao().equals("externo")){
                    saida += p.toString() + " | ";
                }else if (tipo.equals("ALUNO") && p.getFuncao().equals("estudante")){
                    saida += p.toString() + " | ";
                }else if(tipo.equals("PROFESSOR") && p.getFuncao().equals("professor")){
                    saida += p.toString() + " | ";
                }
            }
            return saida.substring(0,saida.length() - 3);
        }
    }
    @Override
    public String busca(String termo) {
        Validadora.verificaValorNullVazio(termo,"Campo termo nao pode ser nulo ou vazio.");
        String msg = "";
        for(Pesquisador pesquisador : this.mapaDePesquisadores.values()){
            if(pesquisador.getBiografia().contains(termo)) {
                msg += pesquisador.getEmail() +": "+pesquisador.getBiografia() + " | ";
            }
        }
        return msg;
    }


    @Override
    public int contaResultadosBusca(String termo) {
        Validadora.verificaValorNullVazio(termo,"Campo termo nao pode ser nulo ou vazio.");
        int cont = 0;
        for(String palavra: busca(termo).split(" | ")){
            if(termo.contains(palavra)) {
                cont += 1;
            }
        }
        return cont;
    }
}