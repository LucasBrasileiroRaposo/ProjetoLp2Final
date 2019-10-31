package projeto;

import easyaccept.EasyAccept;

public class Facade {

    private ControllerGeral controllerGeral;

    public static void main(String[] args){
        args = new String[]{"projeto.Facade",  "TestesAceitacao/use_case_1.txt", "TestesAceitacao/use_case_3.txt"};
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

            
            
            
            /**
             *  PARTE DE KAIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO ////////////////////////// US2 //////
             *  
             *  
             */
            
            public String cadastraProblema(String descricao, int viabilidade) {
    			return this.controllerGeral.cadastraProblema(descricao, viabilidade);
    		}
    		
    		public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
    			return this.controllerGeral.cadastraObjetivo(tipo, descricao, aderencia,viabilidade);
    		}
    		
    		public void apagarProblema(String codigo) {
    			this.controllerGeral.apagarProblema(codigo);
    		}
    		public void apagarObjetivo(String codigo) {
    			this.controllerGeral.apagarObjetivo(codigo);
    		}
    		public String exibeProblema(String codigo) {
    			return this.controllerGeral.exibeProblema(codigo);
    		}
    		public String exibeObjetivo(String codigo) {
    			return this.controllerGeral.exibeObjetivo(codigo);
    		}
            
}
