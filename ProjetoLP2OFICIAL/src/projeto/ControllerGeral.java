package projeto;

public class ControllerGeral {
    private ControllerPesquisa cp;
    private ControllerObjetivos controllerObjetivos;
    private ControllerProblemas controllerProblemas;

    public ControllerGeral(){
        this.cp = new ControllerPesquisa();
        this.controllerObjetivos = new ControllerObjetivos();
        this.controllerProblemas = new ControllerProblemas();
        
    }

    public String cadastraPesquisa(String descricao, String campoDeInteresse) {
        return cp.cadastraPesquisa(descricao, campoDeInteresse);
    }
    public void encerraPesquisa(String codigo, String motivo) {
        cp.encerraPesquisa(codigo, motivo);
    }

    public void ativaPesquisa(String codigo) {
        cp.ativaPesquisa(codigo);
    }

    public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
        cp.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
    }

    public String exibePesquisa(String codigo) {
        return cp.exibePesquisa(codigo);
    }

    public boolean pesquisaEhAtiva(String codigo) {
        return cp.verificaSeAtiva(codigo);
    }


    /**
     *  PARTE DE KAIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO/////////////////////////////////
     * 
     * 
     */
    
    public String cadastraProblema(String descricao, int viabilidade) {
		return this.controllerProblemas.cadastraProblema(descricao, viabilidade);
	}
	
	public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
		return this.controllerObjetivos.cadastraObjetivo(tipo, descricao, aderencia,viabilidade);
	}
	
	public void apagarProblema(String codigo) {
		this.controllerProblemas.apagarProblema(codigo);
	}
	public void apagarObjetivo(String codigo) {
		this.controllerObjetivos.apagarObjetivo(codigo);
	}
	public String exibeProblema(String codigo) {
		return this.controllerProblemas.exibeProblema(codigo);
	}
	public String exibeObjetivo(String codigo) {
		return this.controllerObjetivos.exibeObjetivo(codigo);
	}
}
