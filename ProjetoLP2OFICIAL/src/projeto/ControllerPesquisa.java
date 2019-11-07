package projeto;

/**
 * Classe responsável por por manipular e fazer as operações sobre o objeto Pesquisa
 */
import Util.Validadora;
import java.util.HashMap;

public class ControllerPesquisa implements Busca{
    /**
     * pesquisas Mapa responsável por associar um objeto pesquisa ao seu código
     * gerado
     */
    private HashMap<String, Pesquisa> pesquisas;

    public ControllerPesquisa() {
        this.pesquisas = new HashMap<>();
    }

    /**
     * Método responsável por cadastrar uma nova pesquisa e gerar seu código de
     * identificação
     *
     * @param descricao        descricao de uma pesquisa
     * @param campoDeInteresse campo de interesse de uma pesquisa
     * @return codigo de identificacao de uma pesquisa
     */

    public void cadastraPesquisa(String descricao, String campoDeInteresse) {
        Validadora.verificaValorNullVazio(descricao, "Descricao nao pode ser nula ou vazia.");
        Validadora.validaEntradaCampo(campoDeInteresse);
        Pesquisa pesquisa = new Pesquisa(descricao, campoDeInteresse);
        pesquisa.setCodigo(geraCodigo(campoDeInteresse.substring(0,3),1));
        this.pesquisas.put(pesquisa.getCodigo(), pesquisa);

    }

    /**
     * Método responsável por alterar o status de uma pesquisa
     *
     * @param codigo codigo identificador da pesquisa
     * @param motivo motivo de encerramento de uma pesquisa
     */
    public void encerraPesquisa(String codigo, String motivo) {
        if (this.pesquisas.containsKey(codigo)) {
            Validadora.verificaValorNullVazio(motivo, "Motivo nao pode ser nulo ou vazio.");
            if (pesquisas.get(codigo).getStatus() == true) {
                pesquisas.get(codigo).setStatus();
            } else {
                throw new IllegalArgumentException("Pesquisa desativada.");
            }
        } else {
            throw new IllegalArgumentException("Pesquisa nao encontrada.");
        }
    }

    /**
     * Método responsável por alterar o status de uma pesquisa
     *
     * @param codigo codigo identificador de uma pesquisa
     */
    public void ativaPesquisa(String codigo) {
        if (this.pesquisas.containsKey(codigo)) {
            if (pesquisas.get(codigo).getStatus() == false) {
                pesquisas.get(codigo).setStatus();
            } else {
                throw new IllegalArgumentException("Pesquisa ja ativada.");
            }
        } else {
            throw new IllegalArgumentException("Pesquisa nao encontrada.");
        }

    }

    /**
     * Método responsável por editar as informações de uma pesquisa
     *
     * @param codigo               codigo identificador de uma pesquisa
     * @param conteudoASerAlterado qual a opcao a ser alterada na pesquisa
     * @param novoConteudo         novo conteudo a ser inseirdo na pesquisa
     */
    public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
        if (this.pesquisas.containsKey(codigo)) {
            if (conteudoASerAlterado.equals("DESCRICAO")) {
                Validadora.verificaValorNullVazio(novoConteudo, "Descricao nao pode ser nula ou vazia.");
                if (verificaSeAtiva(codigo)) {
                    pesquisas.get(codigo).setDescricao(novoConteudo);
                } else {
                    throw new IllegalArgumentException("Pesquisa desativada.");
                }

            } else if (conteudoASerAlterado.equals("CAMPO")) {
                Validadora.validaEntradaCampo(novoConteudo);
                    if (verificaSeAtiva(codigo)) {
                        pesquisas.get(codigo).setCampoInteresse(novoConteudo);
                    } else {
                        throw new IllegalArgumentException("Pesquisa desativada.");
                    }
            } else {
                throw new IllegalArgumentException("Nao e possivel alterar esse valor de pesquisa.");
            }

        } else {
            throw new IllegalArgumentException("Pesquisa nao encontrada.");
        }
    }

    /**
     * Método responsável por retornar a representação textual de uma pesquisa
     *
     * @param codigo codigo identificador de uma pesquisa
     * @return toString de uma pesquisa
     */
    public String exibePesquisa(String codigo) {
        if (this.pesquisas.containsKey(codigo)) {
            return codigo + pesquisas.get(codigo).toString();
        } else {
            throw new IllegalArgumentException("Pesquisa nao encontrada.");
        }
    }

    /**
     * Método responsável por vefirificar se o status de uma pesquisa está "Ativa"
     *
     * @param codigo codigo identificador de uma pesquisa
     * @return retorna um boolean true ou false
     */
    public boolean verificaSeAtiva(String codigo) {
        Validadora.verificaValorNullVazio(codigo, "Codigo nao pode ser nulo ou vazio.");
        if (!this.pesquisas.containsKey(codigo)) {
            throw new IllegalArgumentException("Pesquisa nao encontrada.");
        } else {
            if (pesquisas.get(codigo).getStatus()) {
                return true;

            } else {
                return false;
            }
        }
    }

    /**
     * Método auxiliar da classe CadastraPesquisa() para gerar o codigo
     * identificador da pesquisa
     *
     * @param codigo as trés letras iniciais do campo de interesse
     * @param i      inteiro auxiliar do codigo
     * @return retorna codigo identificador da pesquisa
     */
    private String geraCodigo(String codigo, Integer i) {
        String codigoFinal = codigo.toUpperCase() + i;
        if (pesquisas.containsKey(codigoFinal)) {
            i++;
            return geraCodigo(codigo, i);
        }
        return codigoFinal;
    }

    @Override
    public String buscaSubString(String palavra){
        String descricaoValida = "";
        for(Pesquisa p : this.pesquisas.values()){
        if(p.getDescricao().contains(palavra)) {
            descricaoValida += p.getCodigo() +": "+p.getDescricao() + " | ";
            }
        if(p.getCampoInteresse().contains(palavra)){
            descricaoValida += p.getCodigo() + ": "+p.getCampoInteresse()+ " | ";
            }
        }
        return descricaoValida;
    }
    @Override
    public int contaResultadosBusca(String termo, String descricao){
        int contador = 0;
        for(String s: descricao.split(" | ")){
            contador +=1;
        }
        return contador;
    }
}