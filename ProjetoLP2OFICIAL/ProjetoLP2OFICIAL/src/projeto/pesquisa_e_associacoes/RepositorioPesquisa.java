package projeto.pesquisa_e_associacoes;

/**
 * Classe responsável por por manipular e fazer as operações sobre o objeto Pesquisa
 */
import Util.Validadora;
import projeto.Busca;
import projeto.objetivos_e_problemas.Objetivo;
import projeto.objetivos_e_problemas.RepositorioProblemas;
import projeto.pesquisa_e_associacoes.ObjetivoComparator;
import projeto.objetivos_e_problemas.Problema;
import projeto.pesquisa_e_associacoes.Pesquisa;
import projeto.pesquisadores.Pesquisador;

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
    private RepositorioPesquisa controladorPesquisa;

    public RepositorioPesquisa() {
        this.pesquisas = new HashMap<>();
        this.controladorPesquisa = new RepositorioPesquisa();
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
		Pesquisa pesquisa = new Pesquisa(descricao, campoDeInteresse);
		pesquisa.setCodigo(geraCodigo(campoDeInteresse.substring(0,3),1));
		this.pesquisas.put(pesquisa.getCodigo(), pesquisa);

		return pesquisa.getCodigo();

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
	
	/**
	 * Metodo que lista as pesquisas de acordo com o parametro que é passado. Se a ordem for por pesquisa, a listagem sera das pesquisas
	 * de Maior ID para as que tem menor ID. Se a ordem for por problema, a listagem sera das pesquisas de maior ID que tem  
	 * problema associado para o de menor ID, depois sera das pesquisas de Maior ID para as de menor das pesquisas que nao tem problema
	 * associado.
	 * Se a ordem for por objetivo, a listagem sera das pesquisas que tem mais objetivos associados para as de menos. Se for igual ou nao
	 * tiver nenhum objetivo associado dentro da pesquisa, a ordenacao sera das pesquisas de maior ID para as de menor ID.
	 * @param ordem a ordem de ordenacao desejada
	 * @return representacao em String dos dados da pesquisa, seu codigo, sua descricao e campo de interesse.
	 */

	public String listaPesquisas(String ordem) {
		
		Validadora.verificaValorNullVazio(ordem, "Valor invalido da ordem");
		if(!(ordem.toUpperCase().equals("PROBLEMA")) && !(ordem.toUpperCase().equals("OBJETIVOS")) && !(ordem.toUpperCase().equals("PESQUISA"))) {
			throw new IllegalArgumentException("Valor invalido da ordem");
		}
		
		List<Pesquisa> listaPesquisas = new ArrayList();
		listaPesquisas.addAll(this.pesquisas.values());
		String listar = "";
		
		if (ordem.toUpperCase().equals("PESQUISA")) {
			
			Collections.sort (listaPesquisas);
			
			for(Pesquisa pesquisa: listaPesquisas) {
				listar += pesquisa.getCodigo() + pesquisa.toString() + " | ";
			}
			listar = listar.substring(0, listar.length()-3);
			return listar;
		}
		else if (ordem.toUpperCase().equals("PROBLEMA")) {
			
			
			Collections.sort (listaPesquisas);
			
			for(Pesquisa pesquisa: listaPesquisas) {
				if(pesquisa.getListaProblema().size() == 1) {
					listar += pesquisa.getCodigo() + pesquisa.toString() + " | ";
				}
			}
			for(Pesquisa pesquisa: listaPesquisas) {
				if (pesquisa.getListaProblema().size() == 0) {
					listar += pesquisa.getCodigo() + pesquisa.toString() + " | ";
				}
				
			}
			listar = listar.substring(0, listar.length() -3);
			return listar;
			
		} else {  /**
		*            ordem == "OBJETIVO";
		*/
			
			ObjetivoComparator objetivoComparator = new ObjetivoComparator();
			
			Collections.sort (listaPesquisas, objetivoComparator );
			for(Pesquisa pesquisa: listaPesquisas) {
				if(pesquisa.getListaObjetivos().size() != 0) {
				listar += pesquisa.getCodigo() + pesquisa.toString() + " | ";
				}
			}
			
			  Collections.sort(listaPesquisas);
			 
			for (Pesquisa pesquisa: listaPesquisas) {
				if(pesquisa.getListaObjetivos().size() == 0) {
					listar += pesquisa.getCodigo() + pesquisa.toString() + " | ";
				}
			}
			listar = listar.substring(0, listar.length()-3);
			return listar;
			
		}
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
		for(String palavra: controladorPesquisa.busca(termo).split(" | ")){
			if(termo.contains(palavra)) {
				cont += 1;
			}
		}
		return cont;
	}

	@Override
	public String busca(String termo, int numeroDoResultado) {
		Validadora.verificaValorNullVazio(termo,"Campo termo nao pode ser nulo ou vazio.");
		int cont = 0;
		if(termo.contains(controladorPesquisa.busca(termo))){
			for(String palavra: controladorPesquisa.busca(termo).split(" | ")){
				cont +=1;
				if(cont == numeroDoResultado){
					return palavra.substring(0,palavra.length()-3);
				}
			}
		}
		return null;
	}
}