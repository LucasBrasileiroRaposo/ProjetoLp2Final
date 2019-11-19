package projeto.pesquisa_e_associacoes;

/**
 * Classe responsável por por manipular e fazer as operações sobre o objeto Pesquisa
 */
import Util.Validadora;
import projeto.atividades.Atividade;
import projeto.busca.Busca;
import projeto.objetivos_e_problemas.Objetivo;
import projeto.objetivos_e_problemas.Problema;
import projeto.pesquisadores.Pesquisador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RepositorioPesquisa implements Busca{
    /**
     * pesquisas Mapa responsável por associar um objeto pesquisa ao seu código
     * gerado
     */
    private HashMap<String, Pesquisa> pesquisas;

    public RepositorioPesquisa() {
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

    public String cadastraPesquisa(String descricao, String campoDeInteresse) {
        Validadora.verificaValorNullVazio(descricao, "Descricao nao pode ser nula ou vazia.");
        Validadora.validaEntradaCampo(campoDeInteresse);
      
        String codigo = geraCodigo(campoDeInteresse.substring(0, 3), 1);
        Pesquisa pesquisa = new Pesquisa(descricao, campoDeInteresse, codigo);
        this.pesquisas.put(codigo, pesquisa);

        return codigo;

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
                pesquisas.get(codigo).desativaPesquisa();
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
                pesquisas.get(codigo).ativaPesquisa();
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


    /**
     * Metodo que associa um problema a uma pesquisa. Uma pesquisa so pode ter um problema associado. Se tentar associar um problema a uma pesquisa que ja tem problema, dara erro.
     * @param codigo codigo que identifica a pesquisa
     * @param problema objeto problema que quer se associar a pesquisa
     * @return true se houver a associacao e false se nao houver.
     */
	public boolean associaProblema(String codigo, Problema problema) {
		
		if (this.pesquisas.containsKey(codigo)) {
			if (verificaSeAtiva(codigo)) {
			
				Pesquisa pesquisa = this.pesquisas.get(codigo);
				return pesquisa.associaProblema(problema);
			} else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}
		} else {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
	}

	/**
	 * Metodo que desassocia um problema de uma pesquisa.
	 * @param codigo codigo que identifica a pesquisa
	 * @return Se nao houver nenhuma pesquisa ou a pesquisa estiver desativada, dara erro. Se  nao tiver esse problema retornara false
	 * . Se for bem sucedida, retornara true.
	 */
	public boolean desassociaProblema(String codigo) {
		
		if (this.pesquisas.containsKey(codigo)) {
			if (verificaSeAtiva(codigo)) {
				Pesquisa pesquisa = this.pesquisas.get(codigo);
				return pesquisa.desassociaProblema();
			} else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}
			
			}
		else {
				throw new IllegalArgumentException("Pesquisa nao encontrada.");
			}
		
	}
	/**
     * Metodo que associa um problema a uma pesquisa. Uma pesquisa so pode ter um problema associado. Se tentar associar um problema a uma pesquisa que ja tem problema, dara erro.
     * @param codigo codigo que identifica a pesquisa
     * @param objetivo objeto problema que quer se associar a pesquisa
     * @return true se houver a associacao e false se nao houver.
     */
	
	public boolean associaObjetivo(String codigo, Objetivo objetivo) {

		
		
		if (this.pesquisas.containsKey(codigo)) {
			if (verificaSeAtiva(codigo)) {
				Pesquisa pesquisa = this.pesquisas.get(codigo);
				return pesquisa.associaObjetivo(objetivo);
			} else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}
		} else {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		
	}
	/**
	 * Metodo que desassocia um objetivo de uma pesquisa.
	 * @param codigo codigo que identifica a pesquisa
	 * @param objetivo Objeto objetivo que sera removido
	 * @return true se for bem sucedido, false se aquele objetivo nao estiver dentro da lista de objetivos da pesquisa. Sera lancada excecao
	 * se a pesquisa estiver desativada ou nao existir.
	 */

	public boolean dessassociaObjetivo(String codigo, Objetivo objetivo) {
		
		
		if (this.pesquisas.containsKey(codigo)) {
			if (verificaSeAtiva(codigo)) {
				Pesquisa pesquisa = this.pesquisas.get(codigo);
				return pesquisa.desassociaObjetivo(objetivo);
			} else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}
		} else {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
	}
	


	public HashMap<String, Pesquisa> getMapaPesquisas() {
		return this.pesquisas;
	}
	
	
	/**
	 * PARTE 6!
	 */
	/**
	 * 
	 * @param idPesquisa
	 * @param pesquisador
	 * @return
	 */

    public boolean associaPesquisador(String idPesquisa, Pesquisador pesquisador){
        if (!this.pesquisas.containsKey(idPesquisa)){
            throw new IllegalArgumentException("Pesquisa nao encontrada.");
        }else {
            if(!this.pesquisas.get(idPesquisa).getStatus()){
                throw new IllegalArgumentException("Pesquisa desativada.");
            }else{
                return this.pesquisas.get(idPesquisa).associaPesquisador(pesquisador);}
        }
    }

    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
        if (!this.pesquisas.containsKey(idPesquisa)){
            throw new IllegalArgumentException("Pesquisa nao encontrada.");
        }else{
            if(!this.pesquisas.get(idPesquisa).getStatus()){
                throw new IllegalArgumentException("Pesquisa desativada.");
            }else{
                return this.pesquisas.get(idPesquisa).desassociaPesquisador(emailPesquisador);
            }
        }
    }

	public boolean adicionaAtividade(String codigo, Atividade atividade) {
		if (!this.pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		} 
		else if (!this.pesquisas.get(codigo).getStatus()) {
				throw new IllegalArgumentException("Pesquisa desativada.");
		}
		else{
			return this.pesquisas.get(codigo).cadastraAtividade(atividade);
		}
	}
	
	public boolean removeAtividade(String codigoPesquisa, String codigoAtividade) {
		if (!this.pesquisas.containsKey(codigoPesquisa)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		} else if (!this.pesquisas.get(codigoPesquisa).getStatus()) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		else {
			return this.pesquisas.get(codigoPesquisa).removeAtividade(codigoAtividade);
		}
	
	}
	@Override
	public String busca(String termo){
		Validadora.verificaValorNullVazio(termo,"Campo termo nao pode ser nulo ou vazio.");
		String msg = "";
		for(Pesquisa p : this.pesquisas.values()){
			if(p.getDescricao().contains(termo)) {
				msg += p.getCodigo() +": "+p.getDescricao() + " | ";
			}
			if(p.getCampoInteresse().contains(termo)){
				msg += p.getCodigo() + ": "+p.getCampoInteresse()+ " | ";
			}
		}
		return msg;
	}
	@Override
	public int contaResultadosBusca(String termo){
		Validadora.verificaValorNullVazio(termo,"Campo termo nao pode ser nulo ou vazio.");
		int cont = 0;
		for(String palavra: busca(termo).split(" \\| ")){
			if(termo.contains(palavra)) {
				cont += 1;
			}
		}
		return cont;
	}
	
	/**
	 * Metodo responsavel por criar um arquivo e escrever informa��es da pesquisa no arquivo
	 * @param codigoPesquisa codigo da pesquisa em quest�o
	 * @return arquivo txt contendo informa��es da pesquisa
	 */
	public void geraTxt(String codigoPesquisa) {
		Validadora.verificaValorNullVazio(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
        if (!this.pesquisas.containsKey(codigoPesquisa)) {
            throw new IllegalArgumentException("Pesquisa nao encontrada.");
        }
        else {
		Pesquisa pesquisa = this.pesquisas.get(codigoPesquisa);
		String txt = pesquisa.geraTxt();
		try {
			String nomeArquivo = "_" + codigoPesquisa + ".txt";
			FileWriter arq = new FileWriter(nomeArquivo);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.print(txt);
			gravarArq.close();
		}catch(IOException e) {
			e.printStackTrace();
			}
        }
		
	}

	/**
	 * Metodo responsavel por criar um arquivo e escrever resultados da pesquisa no arquivo
	 * @param codigoPesquisa codigo da pesquisa em quest�o
	 * @return arquivo txt contendo resultados
	 */
	public void geraTxtResultados(String codigoPesquisa) {
		Validadora.verificaValorNullVazio(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
        if (!this.pesquisas.containsKey(codigoPesquisa)) {
            throw new IllegalArgumentException("Pesquisa nao encontrada.");
        }
        else {
		Pesquisa pesquisa = this.pesquisas.get(codigoPesquisa);
		String txt = pesquisa.geraTxtResultadoss();
		try {
			String nomeArquivo = codigoPesquisa + "-" + "Resultados.txt";
			FileWriter arq2 = new FileWriter(nomeArquivo);
			PrintWriter gravarArq = new PrintWriter(arq2);
			gravarArq.print(txt);
			gravarArq.close();
		}catch(IOException e) {
			e.printStackTrace();
			}
        }
	}
}
