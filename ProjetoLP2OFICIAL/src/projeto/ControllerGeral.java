package projeto;

public class ControllerGeral {

    private ControllerPesquisa cp;

    private ControllerObjetivos controllerObjetivos;

    private ControllerProblemas controllerProblemas;

    private ControllerAtividade controleAtividade;
	
    private ControllerPesquisadores controllerPesquisadores;

    public ControllerGeral(){
        this.cp = new ControllerPesquisa();
        this.controllerObjetivos = new ControllerObjetivos();
        this.controllerProblemas = new ControllerProblemas();
        this.controleAtividade = new ControllerAtividade();
	this.controllerPesquisadores = new ControllerPesquisadores();
        
    }

    /**
     * Método responsável por cadastrar uma nova pesquisa e gerar seu código de
     * identificação
     *
     * @param descricao        descricao de uma pesquisa
     * @param campoDeInteresse campo de interesse de uma pesquisa
     * @return codigo de identificacao de uma pesquisa
     */
    public String cadastraPesquisa(String descricao, String campoDeInteresse) {
        return cp.cadastraPesquisa(descricao, campoDeInteresse);
    }

    /**
     * Método responsável por alterar o status de uma pesquisa
     *
     * @param codigo codigo identificador da pesquisa
     * @param motivo motivo de encerramento de uma pesquisa
     */
    public void encerraPesquisa(String codigo, String motivo) {
        cp.encerraPesquisa(codigo, motivo);
    }

    /**
     * Método responsável por alterar o status de uma pesquisa
     *
     * @param codigo codigo identificador de uma pesquisa
     */
    public void ativaPesquisa(String codigo) {
        cp.ativaPesquisa(codigo);
    }

    /**
     * Método responsável por editar as informações de uma pesquisa
     *
     * @param codigo               codigo identificador de uma pesquisa
     * @param conteudoASerAlterado qual a opcao a ser alterada na pesquisa
     * @param novoConteudo         novo conteudo a ser inseirdo na pesquisa
     */
    public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
        cp.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
    }

    /**
     * Método responsável por retornar a representação textual de uma pesquisa
     *
     * @param codigo codigo identificador de uma pesquisa
     * @return toString de uma pesquisa
     */
    public String exibePesquisa(String codigo) {
        return cp.exibePesquisa(codigo);
    }

    /**
     * Método responsável por vefirificar se o status de uma pesquisa está "Ativa"
     *
     * @param codigo codigo identificador de uma pesquisa
     * @return retorna um boolean true ou false
     */
    public boolean pesquisaEhAtiva(String codigo) {
        return cp.verificaSeAtiva(codigo);
    }


    /**
     * Cadastra Pesquisador
     * @param nome nome do pesquisador
     * @param funcao função do pesquisador
     * @param biografia biografia do pesquisador
     * @param email email do pesquisador
     * @param fotoURL link da foto do pesquisador
     */
    public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String fotoURL){
        ControllerPesquisadores.cadastraPesquisador(nome,funcao,biografia,email,fotoURL);
    }
    /**
     * Altera um determinado dado por um novo valor
     * @param email email do pesquisador
     * @param atributo atributo do pesquisador
     * @param novoValor novo valor a ser inserido
     */
    public void alteraPesquisador(String email, String atributo, String novoValor){
        ControllerPesquisadores.alteraPesquisador(email,atributo,novoValor);
    }
    /**
     * Desativa um pesquisador
     * @param email email de um pesquisador
     */
    public void desativaPesquisador(String email){
        ControllerPesquisadores.desativaPesquisador(email);
    }
    /**
     * Ativa um pesquisador
     * @param email email do pesquisador
     */
    public void ativaPesquisador(String email){
        ControllerPesquisadores.ativaPesquisador(email);
    }
    /**
     * Exibe um determinado pesquisador apartir de um email
     * @param email email do pesquisador
     * @return retorna se o pesquisador está Ativado ou Desativado
     */
    public String exibePesquisador(String email){
       return ControllerPesquisadores.exibePesquisador(email);
    }
    /**
     * Verifica se o pesquisador é Ativo
     * @param email email do pesquisador
     * @return retorna True se o pesquisador é ativo e False se não.
     */
    public boolean pesquisadorEhAtivo(String email){
        return ControllerPesquisadores.pesquisadorEhAtivo(email);
    }

    /**
     * cadastra um problema no mapa de problemas e incrementa uma unidade no contador de problemas
     * @param descricao descricao do problema
     * @param viabilidade viabilidade do problema
     */
    public String cadastraProblema(String descricao, int viabilidade) {
		return this.controllerProblemas.cadastraProblema(descricao, viabilidade);
	}

    /**
     * cadastra um objetivo no mapa de objetivos e incrementa uma unidade no contador de objetivos
     * @param tipo tipo do objetivo, que deve ser GERAL ou ESPECIFICO
     * @param descricao descricao do objetivo
     * @param aderencia aderencia do objetivo
     * @param viabilidade viabilidade do objetivo
     */

	public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
		return this.controllerObjetivos.cadastraObjetivo(tipo, descricao, aderencia,viabilidade);
	}

    /**
     * Metodo que remove um problema do mapa de problemas.
     * @param codigo identificador do mapa.
     */
	public void apagarProblema(String codigo) {
		this.controllerProblemas.apagarProblema(codigo);
	}

    /**
     * Metodo que remove um objetivo do mapa de objetivos.
     * @param codigo identificador do mapa.
     *
     */
	public void apagarObjetivo(String codigo) {
		this.controllerObjetivos.apagarObjetivo(codigo);
	}

    /**
     * Metodo que exibe uma representacao textual dos dados de um determinado problema
     * @param codigo codigo identificador do mapa.
     * @return String com a representacao textual dos dados do Problema
     */
	public String exibeProblema(String codigo) {
		return this.controllerProblemas.exibeProblema(codigo);
	}

    /**
     *
     * Metodo que exibe uma representacao textual dos dados de um determinado objetivo
     * @param codigo codigo identificador do mapa.
     * @return String com a representacao textual dos dados do objetivo
     */
	public String exibeObjetivo(String codigo) {
		return this.controllerObjetivos.exibeObjetivo(codigo);
	}

    /**
     * Chamado no cadastro de uma Atividade, criando um objeto do tipo Atividade se todos os campos forem passados
     * corretamente.
     *
     * @param Descricao String, que representa a descrição da atividade.
     * @param nivelRisco         String, que representa o nivel de risco da atividade.
     * @param descricaoRisco     String, que representa a descrição do nivel de risco.
     * @return o codigo gerado, formado pela letra A que tem  em seguida o número que indica quantos itens cadastrados
     * vão ter .
     */
    public String cadastraAtividade(String Descricao, String nivelRisco, String descricaoRisco){
        return this.controleAtividade.cadastraAtividade(Descricao, nivelRisco, descricaoRisco);
    }

    /**
     * Quando chamado, esse metodo recebe como parametro o codigo identificador da atividade, e se tudo ocorrer como esperado
     * a atividade do determinado codigo eh removida.
     *
     * @param codigo String, que representa a identetificação da Atividade que o usuario deseja remover.
     */
    public void apagaAtividade(String codigo){
        this.controleAtividade.apagaAtividade(codigo);
    }

    /**
     * Chamado para o cadastro do item, no caso os itens necessarios para composicao dos resultados da ativade, passando o
     * codigo identificador da Atividade e o item que vai ser cadastrado nessa atividade.
     *
     * @param codigo String, que representa o identificador de cada atividade;
     * @param item   String, que representa o nome do item;
     */
    public void cadastraItem(String codigo, String item){
        this.controleAtividade.cadastraItem(codigo,item);
    }

    /**
     * Quando chamado, recebe o código da atividade que o usuário que tenha sua representacao textual exibida.
     *
     * @param codigo String, que identifica a atividade no mapa de atividades.
     * @return a representacao textual dessa atividade, com informações desta e de seus itens.
     */
    public String exibeAtividade(String codigo){
        return this.controleAtividade.exibeAtividade(codigo);
    }

    /**
     * Quando chamado, recebe o codigo da atividade, que o sistema vai checar quantos itens ainda estao pendentes para cumprimento
     * da atividade.
     *
     * @param codigo String, que identifica a atividade no mapa de atividades.
     * @return valor em int que representa essa quantidade de itens com estado PENDENTE.
     */
    public int contaItensPendentes(String codigo){
        return this.controleAtividade.contaItensPendentes(codigo);
    }

    /**
     * Quando chamado, recebe o codigo referente a atividade que o sistema vai chechar quantos de seus itens ja estão
     * marcados como REALIZADO.
     *
     * @param codigo String, que identifica a atividade no mapa de atividades.
     * @return valor em int que representa essa quantidade de itens com estado REALIZADO.
     */
    public int contaItensRealizados(String codigo){
        return this.controleAtividade.contaItensRealizados(codigo);
    }
}
