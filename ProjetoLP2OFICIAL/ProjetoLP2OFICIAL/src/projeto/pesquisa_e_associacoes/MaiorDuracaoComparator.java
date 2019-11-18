package projeto.pesquisa_e_associacoes;

import java.util.Comparator;

import projeto.atividades.Atividade;


public class MaiorDuracaoComparator implements Comparator<Atividade> {

	@Override
	public int compare(Atividade atividade1, Atividade atividade2) {
		
		return atividade2.getDuracaoAtividade() - atividade1.getDuracaoAtividade();
	}

}