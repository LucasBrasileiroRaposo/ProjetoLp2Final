package projeto.atividades;


import Util.Validadora;
import projeto.busca.Busca;

import java.util.*;

/** Classe que permite a comunicacao entre a Facade e a classe Atividade.
 */
public class RepositorioAtividade implements Busca{

    /**
     * Mapa de das atividades.
     */
    private Map<String, Atividade> atividades;

    /**
     * Contador de atividades cadastradas.
     */
    private int contadorDeAtividades;

    /**
     * Inicializa o controlador das atividades, com o mapa das atividades e o contador.
     */
    public RepositorioAtividade() {
        this.atividades = new HashMap<>();
        this.contadorDeAtividades = 1;
    }

    /**
     * Chamado no cadastro de uma Atividade, criando um objeto do tipo Atividade se todos os campos forem passados
     * corretamente.
     *
     * @param descricaoAtividade String, que representa a descrição da atividade.
     * @param nivelRisco         String, que representa o nivel de risco da atividade.
     * @param descricaoRisco     String, que representa a descrição do nivel de risco.
     * @return o codigo gerado, formado pela letra A que tem  em seguida o número que indica quantos itens cadastrados
     * vão ter .
     */
    public String cadastraAtividade(String descricaoAtividade, String nivelRisco, String descricaoRisco) {
        Validadora.verificaValorNullVazio(descricaoAtividade, "Campo Descricao nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(nivelRisco, "Campo nivelRisco nao pode ser nulo ou vazio.");
        Validadora.validaAtividadeChecaOpçoesNivelderisco(nivelRisco, "Valor invalido do nivel do risco.");
        Validadora.verificaValorNullVazio(descricaoRisco, "Campo descricaoRisco nao pode ser nulo ou vazio.");

        Atividade atividade = new Atividade(descricaoAtividade, nivelRisco, descricaoRisco);
        atividade.setCodigo("A" + this.contadorDeAtividades);
        this.atividades.put(atividade.getCodigo(), atividade);
        this.contadorDeAtividades++;
        return atividade.getCodigo();
    }

    /**
     * Quando chamado, esse metodo recebe como parametro o codigo identificador da atividade, e se tudo ocorrer como esperado
     * a atividade do determinado codigo eh removida.
     *
     * @param codigo String, que representa a identetificação da Atividade que o usuario deseja remover.
     */
    public void apagaAtividade(String codigo) {
        Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");

        if (!this.atividades.containsKey(codigo)) {
            throw new IllegalArgumentException("Atividade nao encontrada");
        } else {
            this.atividades.remove(codigo);
        }
    }

    /**
     * Chamado para o cadastro do item, no caso os itens necessarios para composicao dos resultados da ativade, passando o
     * codigo identificador da Atividade e o item que vai ser cadastrado nessa atividade.
     *
     * @param codigo String, que representa o identificador de cada atividade;
     * @param item   String, que representa o nome do item;
     */
    public void cadastraItem(String codigo, String item) {
        Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(item, "Item nao pode ser nulo ou vazio.");

        if (!this.atividades.containsKey(codigo)) {
            throw new IllegalArgumentException("Atividade nao encontrada");
        } else {
            this.atividades.get(codigo).cadastraItem(item);
        }
    }

    /**
     * Quando chamado, recebe o código da atividade que o usuário que tenha sua representacao textual exibida.
     *
     * @param codigo String, que identifica a atividade no mapa de atividades.
     * @return a representacao textual dessa atividade, com informações desta e de seus itens.
     */
    public String exibeAtividade(String codigo) {
        Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");

        if (!this.atividades.containsKey(codigo)) {
            throw new IllegalArgumentException("Atividade nao encontrada");
        } else {
            return this.atividades.get(codigo).toString();
        }
    }

    /**
     * Quando chamado, recebe o codigo da atividade, que o sistema vai checar quantos itens ainda estao pendentes para cumprimento
     * da atividade.
     *
     * @param codigo String, que identifica a atividade no mapa de atividades.
     * @return valor em int que representa essa quantidade de itens com estado PENDENTE.
     */
    public int contaItensPendentes(String codigo) {
        Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");

        if (!this.atividades.containsKey(codigo)) {
            throw new IllegalArgumentException("Atividade nao encontrada");
        } else {
            return this.atividades.get(codigo).contaItensPendentes();
        }
    }

    /**
     * Quando chamado, recebe o codigo referente a atividade que o sistema vai chechar quantos de seus itens ja estão
     * marcados como REALIZADO.
     *
     * @param codigo String, que identifica a atividade no mapa de atividades.
     * @return valor em int que representa essa quantidade de itens com estado REALIZADO.
     */
    public int contaItensRealizados(String codigo) {
        Validadora.verificaValorNullVazio(codigo, "Campo codigo nao pode ser nulo ou vazio.");

        if (!this.atividades.containsKey(codigo)) {
            throw new IllegalArgumentException("Atividade nao encontrada");
        } else {
            return this.atividades.get(codigo).contaItensRealizados();
        }
    }
    @Override
    public String busca(String termo){
        Validadora.verificaValorNullVazio(termo,"Campo termo nao pode ser nulo ou vazio.");
        String msg = "";
        List<Atividade> listaDeAtividades = new ArrayList<>();
        listaDeAtividades.addAll(this.atividades.values());
        Collections.sort(listaDeAtividades);
        for(Atividade a : listaDeAtividades){
            if(a.getDescricao().contains(termo)) {
                msg += a.getCodigo() +": "+a.getDescricao() + " | ";
            }
            if(a.getDescricaoDeRisco().contains(termo)){
                msg += a.getCodigo() + ": "+a.getDescricaoDeRisco()+ " | ";
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
