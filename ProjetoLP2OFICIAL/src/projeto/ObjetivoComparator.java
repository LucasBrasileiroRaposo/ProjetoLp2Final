package projeto;

import java.util.Comparator;

public class ObjetivoComparator implements Comparator<Pesquisa> {

	@Override
	public int compare(Pesquisa pesquisa1, Pesquisa pesquisa2) {
		
		return pesquisa2.getListaObjetivos().size() - pesquisa1.getListaObjetivos().size();		
		
	}
		
}

	

	
	


