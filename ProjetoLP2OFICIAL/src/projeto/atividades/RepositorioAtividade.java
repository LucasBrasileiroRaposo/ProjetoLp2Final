package projeto.atividades;


import Util.Validadora;
import projeto.busca.Busca;

import java.io.*;
import java.util.*;

/** Classe que permite a comunicacao entre a Facade e a classe Atividade.
 */
public class RepositorioAtividade implements Busca, Serializable {

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
        Validadora.validaAtividadeChecaOpcoesNivelderisco(nivelRisco, "Valor invalido do nivel do risco.");
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

    /** Quando chamado o metodo deve checa se essa atividade existe no mapa de atividade e caso exista deve retorna-la.
     * @param codigoAtividade String, que representa a chave identificadora de uma atividade, no mapa das atividades.
     * @return um objeto do tipo Atividade, que no caso vai ser a atividade selecionada.
     */
    public Atividade retornaAtividade(String codigoAtividade) {
    	if(!this.atividades.containsKey(codigoAtividade)) {
    		throw new IllegalArgumentException("Atividade nao encontrada");
    	}
    	else {
		return this.atividades.get(codigoAtividade);
    }
    }

    /** Metodo responsavel por checar se existe alguma atividade cadastrada com o codigo passado.
     * @param codigoAtividade String, que representa o codigo identificar da atividade.
     * @return True ou False, caso exista ou não, respectivamente.
     */
	public boolean atividadeExiste(String codigoAtividade) {
		return this.atividades.containsKey(codigoAtividade);
	}

    /**
     * Metodo que executa uma atividade, no caso, altera o estado do item para
     * concluido se a operacao for realizada com sucesso e ainda eh setada uma
     * duracao para ela.
     *
     * @param codigoAtividade String, que representa o id da atividade que deve ter seu item executado;
     * @param item    inteiro que representa o id do item que deve ser executado;
     * @param duracao inteiro, que representa a duracao em segundos da execucao de
     *                tal item;
     * @return true, caso a operação tive sido realizada com sucesso.
     */
	public boolean executaAtividade(String codigoAtividade, int item, int duracao) {
	    if(this.atividades.get(codigoAtividade).getControlaPesquisasAtividade() == 0) {
            throw new IllegalArgumentException("Atividade sem associacoes com pesquisas.");
        }else if(item < 1) {
			throw new NullPointerException("Item nao pode ser nulo ou negativo.");
		}
		else if(duracao < 1) {
			throw new NullPointerException("Duracao nao pode ser nula ou negativa.");
		}
		else {
			return this.atividades.get(codigoAtividade).executaAtividade(item, duracao);
		}
	}

    /** metodo responsavel por remover um resultado de uma atividade.
     * @param codigoAtividade String, que presenta o codigo da atividade que o usuario deseja que tenha um resultado removido dela;
     * @param numeroResultado int, que represent ao codigo do resultado a ser removido.
     * @return true, caso a operação tive sido realizada com sucesso, ou False caso não.
     */
	public boolean removeResultado(String codigoAtividade, int numeroResultado) {
		if(!(this.atividades.containsKey(codigoAtividade))) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		}
		else if(!this.atividades.get(codigoAtividade).veriricaResultado(numeroResultado)) {
			throw new NullPointerException("Resultado nao encontrado.");
		}
		else {
			return this.atividades.get(codigoAtividade).removeResultado(numeroResultado);
		}
	}

    /** metodo responsavel por cadastrar um resultado em uma atividade.
     * @param codigoAtividade String, que presenta o codigo da atividade que o usuario deseja que tenha um resultado cadastrado nela;
     * @param resultado String, que representa o resultado a ser adicionado em uma atividade
     * @return int, que representa o codigo daquele resultado.
     */
	public int cadastraResultado(String codigoAtividade, String resultado) {
		int i = 0;
    	i = this.atividades.get(codigoAtividade).cadastraResultado(resultado);
    	return i;
	}
    /** Metodo responsavel por retornar todos os resultados cadastrados em uma atividade quando o usuario pedir.
     * @param codigoAtividade String, que representa o codigo da atividade que o usuario deseja que tenha seus resultados exibidos.
     * @return String, com todos os resultados cadastrados em uma atividade.
     */
	public String exibeResultados(String codigoAtividade) {
		if(!(this.atividades.containsKey(codigoAtividade))) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		}
		else {
		return this.atividades.get(codigoAtividade).exibeResultados();
		}
	}

    /** Quando chamado deve retornar a duracao da atividade, pedida pelo usuario.
     * @param codigoAtividade String, que representao o id da atividade, que o usuario deseja que tenha sua duracao retornada.
     * @return int, que representa a duracao da atividade.
     */
	public int getDuracao(String codigoAtividade) {
		if(!(this.atividades.containsKey(codigoAtividade))) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		}
		else {
			return this.atividades.get(codigoAtividade).getDuracaoAtividade();
		}
	}
    /**
     * Método responsável por buscar um termo na descrição e na descrição de risco de uma Atividade.
     * @param termo termo a ser buscado.
     * @return retorna um conjunto de Strings com o termo contido.
     */
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
    /**
     * Método responsável por contar a quantidade de termos encontrados na descrição e na descrição de risco de uma
     * Atividade.
     * @param termo termo a ser contado.
     * @return retorna a quantidade de termos encontrados.
     */
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

    /** Metodo que define a ordem de execucao das atividade, recebendo o id de uma atividade anterior e o da subsequente a ela.
     * @param idPrecedente String, que representa o codigo da atividade que vem primeiro.
     * @param idSubsquente String, que representa o cofigo da atividade que vem depois da passada antes.
     */
    public void defineProximaAtividade(String idPrecedente, String idSubsquente) {
        Validadora.verificaValorNullVazio(idPrecedente,"Atividade nao pode ser nulo ou vazio.");
        Validadora.verificaValorNullVazio(idSubsquente,"Atividade nao pode ser nulo ou vazio.");
        if (!this.atividades.containsKey(idPrecedente) || !this.atividades.containsKey(idSubsquente)){
            throw new IllegalArgumentException("Atividade nao encontrada.");
        }
        Atividade atividade1 = this.atividades.get(idPrecedente);
        Atividade atividade2 = this.atividades.get(idSubsquente);
        if(atividade1.apontaPara(atividade2)){
            atividade2.criaPrecedente(atividade1);
        }else{
            throw new IllegalArgumentException("Atividade ja possui uma subsequente.");
        }
    }

    /** Metodo responsavel por quebrar uma sequencia removendo a atividade que viria depois da que é passada como parametro
     * @param idPrecedente String, que representa o codigo da atividade que tera sua subsequente removida.
     */
    public void tiraProximaAtividade(String idPrecedente) {
        Validadora.verificaValorNullVazio(idPrecedente,"Atividade nao pode ser nulo ou vazio.");
        if(!this.atividades.containsKey(idPrecedente)){
            throw  new IllegalArgumentException("Atividade nao encontrada.");
        }
        this.atividades.get(idPrecedente).tiraSubsquente();
    }

    /** Metodo responsavel por contar as atividade que vem apos a atividade passada como parametro na sequencia atual.
     * @param idPrecedente String, que representa o codigo da atividade passada como referencia
     * @return int, que representa a quantidade de atividades que estão para ser executadas na sequencia.
     */
    public int contaProximos(String idPrecedente) {
        Validadora.verificaValorNullVazio(idPrecedente,"Atividade nao pode ser nulo ou vazio.");
        if(!this.atividades.containsKey(idPrecedente)){
            throw  new IllegalArgumentException("Atividade nao encontrada.");
        }
        return this.atividades.get(idPrecedente).contaProximos();
    }

    /** Metodo que retorna uma enesima atividade de um sequencia, apos uma determinada atividade passada como parametro.
     * @param idAtividade String, que representa o codigo da atividade passada como referencia.
     * @param enesimaAtividade int, é o valor que representa a atividade, na ordem de execucao, no caso a enesima atividade a ser executada apos a passada como parametro.
     * @return o codigo dessa determinada atividade ou a mensagem que não existe, caso não exista enesimo fator.
     */
    public String pegaProximo(String idAtividade, int enesimaAtividade) {
        Validadora.verificaValorNullVazio(idAtividade,"Atividade nao pode ser nulo ou vazio.");
        if (enesimaAtividade < 1){
            throw new IllegalArgumentException("EnesimaAtividade nao pode ser negativa ou zero.");
        } else if(!this.atividades.containsKey(idAtividade)){
            throw  new IllegalArgumentException("Atividade nao encontrada.");
        }
        return this.atividades.get(idAtividade).pegaProximo(enesimaAtividade);
    }

    /** Metodo responsavel por retornar a atividade que possui o maio nivel de risco em uma sequencia.
     *
     * @param idAtividade é o codigo de uma atividade atividade passada como parametro, que tera seu objeto Ativiade comparado com aproximo, e dependendo do nivel, ou sera substituida por essa
     *                           atividade comparada ou manter a atividade antiga passada como parametro.
     * @return o codigo da atividade com o maior risco da sequencia.
     */
    public String pegaMaiorRiscoAtividades(String idAtividade) {
        Validadora.verificaValorNullVazio(idAtividade,"Atividade nao pode ser nulo ou vazio.");
        if(!this.atividades.containsKey(idAtividade)){
            throw  new IllegalArgumentException("Atividade nao encontrada.");
        }else if(this.atividades.get(idAtividade).getProximaAtiviade() == null){
            throw new IllegalArgumentException("Nao existe proxima atividade.");
        }
        return this.atividades.get(idAtividade).pegaMaiorRiscoAtividades(this.atividades.get(idAtividade).getProximaAtiviade());
    }
    /**
     * Método responsável por ordenar uma lista
     * @return retorna lista Ordenada
     */
    public List OrdenaLista(){
        List listaAtividadesOrndenada = new ArrayList();
        listaAtividadesOrndenada.addAll(this.atividades.values());
        Collections.sort(listaAtividadesOrndenada);
        return  listaAtividadesOrndenada;
    }

}
