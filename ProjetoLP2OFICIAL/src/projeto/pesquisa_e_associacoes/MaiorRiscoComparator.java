package projeto.pesquisa_e_associacoes;

import java.util.Comparator;

import projeto.atividades.Atividade;

public class MaiorRiscoComparator implements Comparator<Atividade> {

	@Override
	public int compare(Atividade atividade1, Atividade atividade2) {
		int nivelAtividade1 = 0;
		int nivelAtividade2 = 0;
		
		if( atividade1.getNivelDeRisco().equals("ALTO")) {
			nivelAtividade1 = 1;
		}
		else if( atividade1.getNivelDeRisco().equals("BAIXO")) {
			nivelAtividade1 = -1;
		}
		
		if(atividade2.getNivelDeRisco().equals("ALTO")) {
			nivelAtividade2 = 1;
		} 
		else if (atividade2.getNivelDeRisco().equals("BAIXO")) {
			nivelAtividade2 = -1;
		}
		
		return nivelAtividade2 - nivelAtividade1;
	}

}