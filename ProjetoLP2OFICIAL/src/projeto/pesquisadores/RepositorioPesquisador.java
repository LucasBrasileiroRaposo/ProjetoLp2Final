package projeto.pesquisadores;

import Util.Validadora;

import java.util.HashMap;
import java.util.Map;

public class RepositorioPesquisador {
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

        Pesquisador P = new PesquisadorSimples(nome, funcao, biografia, email, foto);
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
            if (this.mapaDePesquisadores.get(email) instanceof PesquisadorAluno){
                if(atributo.equals("IEA")){
                    ((PesquisadorAluno) this.mapaDePesquisadores.get(email)).setIea(Double.parseDouble(novoValor));
                }else if(atributo.equals("SEMESTRE")){
                    ((PesquisadorAluno) this.mapaDePesquisadores.get(email)).setSemestreIngresso(Integer.parseInt(novoValor));
                }
            }else if (this.mapaDePesquisadores.get(email)instanceof PesquisadorProfessor){
                if (atributo.equals("UNIDADE")){
                    Validadora.verificaValorNullVazio(novoValor,"");
                    ((PesquisadorProfessor) this.mapaDePesquisadores.get(email)).setUnidade(novoValor);
                }else if(atributo.equals("FORMACAO")){
                    Validadora.verificaValorNullVazio(novoValor,"");
                    ((PesquisadorProfessor) this.mapaDePesquisadores.get(email)).setFormacao(novoValor);
                }else if(atributo.equals("DATA")){
                    Validadora.verificaFormatoData(novoValor,"");
                    ((PesquisadorProfessor) this.mapaDePesquisadores.get(email)).setData(novoValor);
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
    public Pesquisador pegaPesquisador(String email){
        Validadora.verificaPesquisador(mapaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");

        return this.mapaDePesquisadores.get(email);
    }

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
            this.mapaDePesquisadores.get(email);/** composição*/
        }
    }

    public void cadastraEspecialidadeAluno(String email, int semestre, double iea) {
        Validadora.verificaValorNullVazio(email,"Campo email nao pode ser nulo ou vazio.");
    }

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
}