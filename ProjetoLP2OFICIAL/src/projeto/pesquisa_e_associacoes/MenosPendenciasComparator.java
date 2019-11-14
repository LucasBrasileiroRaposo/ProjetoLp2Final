package projeto.pesquisa_e_associacoes;

import projeto.atividades.Atividade;
import java.util.Comparator;

public class MenosPendenciasComparator  implements Comparator<Atividade> {

	@Override
	public int compare(Atividade atividade1, Atividade atividade2) {
		
		return  atividade1.getContadorDeItensPendentes() - atividade2.getContadorDeItensPendentes();
	}
}
