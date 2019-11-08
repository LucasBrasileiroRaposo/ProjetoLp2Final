package projeto.pesquisadores;

import Util.Validadora;
import projeto.pesquisadores.Pesquisador;
import projeto.pesquisadores.PesquisadorSimples;

import java.util.HashMap;
import java.util.Map;

public class ControllerPesquisador {
    private Map<String, Pesquisador> listaDePesquisadores;

    /**
     * Construtor responsável por inicializar o armazenamento de pesquisadores
     */
    public ControllerPesquisador() {
        listaDePesquisadores = new HashMap<>();
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
        listaDePesquisadores.put(email, P);
    }

    /**
     * Altera um determinado dado por um novo valor
     * @param email email do pesquisador
     * @param atributo atributo do pesquisador
     * @param novoValor novo valor a ser inserido
     */
    public void alteraPesquisador(String email, String atributo, String novoValor) {
        Validadora.verificaValorNullVazio(atributo,"Atributo nao pode ser vazio ou nulo.");
        Validadora.validaAtributo(atributo,"Atributo invalido.");
        Validadora.verificaPesquisador(listaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");
        if (atributo.toUpperCase().equals("NOME")) {
            Validadora.verificaValorNullVazio(novoValor,"Campo nome nao pode ser nulo ou vazio.");
            listaDePesquisadores.get(email).setNome(novoValor);
        }
        else if (atributo.toUpperCase().equals("FUNCAO")) {
            Validadora.verificaValorNullVazio(novoValor,"Campo funcao nao pode ser nulo ou vazio.");
            listaDePesquisadores.get(email).setFuncao(novoValor);
        }
        else if (atributo.toUpperCase().equals("BIOGRAFIA")) {
            Validadora.verificaValorNullVazio(novoValor,"Campo biografia nao pode ser nulo ou vazio.");
            listaDePesquisadores.get(email).setBiografia(novoValor);
        }
        else if (atributo.toUpperCase().equals("EMAIL")) {
            Validadora.verificaValorNullVazio(novoValor,"Campo email nao pode ser nulo ou vazio.");
            Validadora.validaEmail(novoValor,"Formato de email invalido.");
            listaDePesquisadores.get(email).setEmail(novoValor);
            listaDePesquisadores.put(novoValor,listaDePesquisadores.get(email));
            listaDePesquisadores.remove(email);
        }
        else if (atributo.toUpperCase().equals("FOTO")) {
            Validadora.verificaValorNullVazio(novoValor,"Campo fotoURL nao pode ser nulo ou vazio.");
            Validadora.validaFoto(novoValor,"Formato de foto invalido.");
            listaDePesquisadores.get(email).setFotoURL(novoValor);
            }
    }

    /**
     * Desativa um pesquisador
     * @param email email de um pesquisador
     */
    public void desativaPesquisador(String email) {
        Validadora.verificaValorNullVazio(email, "Campo email nao pode ser nulo ou vazio.");
        Validadora.validaEmail(email,"Formato de email invalido.");
        Validadora.verificaPesquisador(listaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");
        Validadora.verificaPesquisadorAtivo(listaDePesquisadores.get(email).getStatus().equals("DESATIVADO"),"Pesquisador inativo.");
        if (listaDePesquisadores.containsKey(email)) {
            listaDePesquisadores.get(email).setStatus("DESATIVADO");
        }
    }

    /**
     * Ativa um pesquisador
     * @param email email do pesquisador
     */
    public void ativaPesquisador(String email) {
        Validadora.verificaValorNullVazio(email, "Campo EMAIL nao pode ser nulo ou vazio.");
        Validadora.validaEmail(email,"Formato de email invalido.");
        Validadora.verificaPesquisador(listaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");
        Validadora.verificaPesquisadorAtivo(listaDePesquisadores.get(email).getStatus().equals("ATIVADO"),"Pesquisador ja ativado.");
        if (listaDePesquisadores.containsKey(email)) {
            listaDePesquisadores.get(email).setStatus("ATIVADO");
        }
    }

    /**
     * Exibe um determinado pesquisador apartir de um email
     * @param email email do pesquisador
     * @return retorna se o pesquisador está Ativado ou Desativado
     */
    public String exibePesquisador(String email){
        Validadora.verificaValorNullVazio(email, "Campo EMAIL nao pode ser nulo ou vazio.");
        Validadora.validaEmail(email,"Formato de email invalido.");
        Validadora.verificaPesquisador(listaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");
        String msg = "";
        if (listaDePesquisadores.containsKey(email)){
            if(listaDePesquisadores.get(email).getStatus().equals("ATIVADO")){
                return listaDePesquisadores.get(email).toString();
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
        Validadora.verificaPesquisador(listaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");
        if(listaDePesquisadores.get(email).getStatus().equals("ATIVADO")){
            return true;
        }else{
            return false;
        }
    }
    public Pesquisador pegaPesquisador(String email){
        Validadora.verificaPesquisador(listaDePesquisadores.containsKey(email),"Pesquisador nao encontrado");

        return this.listaDePesquisadores.get(email);
    }

    public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data) {
        Validadora.verificaValorNullVazio(email,"Campo email nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(formacao,"Campo formacao nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(unidade,"Campo unidade nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(data,"Campo data nao pode ser nulo ou vazio.");
        Validadora.verificaFormatoData(data,"Atributo data com formato invalido.");

        if (!this.listaDePesquisadores.containsKey(email)) {
            throw new IllegalArgumentException("Pesquisadora nao encontrada.");
        }
        else{
            this.listaDePesquisadores.get(email);/** composição*/
        }
    }
}