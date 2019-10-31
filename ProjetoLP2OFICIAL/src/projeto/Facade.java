package projeto;

import easyaccept.EasyAccept;

public class Facade {

    private ControllerGeral controllerGeral;

    public static void main(String[] args){
        args = new String[]{"projeto.Facade",  "TestesAceitacao/use_case_1.txt"};
        EasyAccept.main(args);}

            public Facade() {
                this.controllerGeral = new ControllerGeral();
            }
            public String cadastraPesquisa(String descricao, String campoDeInteresse) {
                return controllerGeral.cadastraPesquisa(descricao, campoDeInteresse);
            }
            public void encerraPesquisa(String codigo, String motivo) {
                controllerGeral.encerraPesquisa(codigo, motivo);
            }

            public void ativaPesquisa(String codigo) {
                controllerGeral.ativaPesquisa(codigo);
            }

            public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
                controllerGeral.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
            }

            public String exibePesquisa(String codigo) {
                return controllerGeral.exibePesquisa(codigo);
            }

            public boolean pesquisaEhAtiva(String codigo) {
                return controllerGeral.pesquisaEhAtiva(codigo);
            }

        }
