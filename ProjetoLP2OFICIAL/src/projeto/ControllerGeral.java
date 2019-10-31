package projeto;

public class ControllerGeral {
    private ControllerPesquisa cp;

    public ControllerGeral(){
        this.cp = new ControllerPesquisa();
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



}
