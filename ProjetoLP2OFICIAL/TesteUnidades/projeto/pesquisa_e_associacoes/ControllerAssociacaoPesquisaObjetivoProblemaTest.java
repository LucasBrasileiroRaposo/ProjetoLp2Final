package projeto.pesquisa_e_associacoes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projeto.objetivos_e_problemas.Objetivo;
import projeto.objetivos_e_problemas.Problema;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;

class ControllerAssociacaoPesquisaObjetivoProblemaTest {
	
		private RepositorioPesquisa repositorioPesquisa;
	   private ControllerPesquisa controllerPesquisa;

	    private RepositorioObjetivos repositorioObjetivos;

	    private RepositorioProblemas repositorioProblemas;
	    
	    private ControllerAssociacaoPesquisaObjetivoProblema CAPOP;
	    
	    
	    
	    @BeforeEach
	 	void setup() {
		 this.repositorioPesquisa = new RepositorioPesquisa();
		 this.repositorioObjetivos = new RepositorioObjetivos();
		 this.repositorioProblemas = new RepositorioProblemas();
		 this.repositorioPesquisa.cadastraPesquisa("Teste de sanidade mental dos alunos de LP2", "computacao");
		 this.repositorioProblemas.cadastraProblema("Uso do Java", 3);
		 this.repositorioProblemas.cadastraProblema("Computadores do LCC2", 5);
		 this.repositorioObjetivos.cadastraObjetivo("GERAL", "Salvas os alunos de LP2", 3, 2);
		 this.repositorioObjetivos.cadastraObjetivo("ESPECIFICO", "Acabar com funcao recursiva no mundo", 2, 1);
		 this.repositorioPesquisa.cadastraPesquisa("As razoes dos monitores de LP2 serem tao lindos", "computacao");
		 
		 this.controllerPesquisa = new ControllerPesquisa(this.repositorioPesquisa);

		 
		 this.CAPOP = new ControllerAssociacaoPesquisaObjetivoProblema( this.controllerPesquisa,this.repositorioObjetivos,
				 this.repositorioProblemas);
		 
	    }

	@Test
	void testAssociaProblema() {
		Problema p1 = this.repositorioProblemas.getProblema("P1");
		Problema p2 = this.repositorioProblemas.getProblema("P2");

		assertEquals(true, this.controllerPesquisa.associaProblema("COM1", p1));
		assertEquals(false, this.controllerPesquisa.associaProblema("COM1", p1));

		
		assertThrows(IllegalArgumentException.class, ()->
        this.controllerPesquisa.associaProblema("COM1", p2));
		
		assertThrows(IllegalArgumentException.class, ()->
        this.controllerPesquisa.associaProblema("", p2));
		
		assertThrows(IllegalArgumentException.class, ()->
        this.controllerPesquisa.associaProblema(null, p2));

		
	}

	@Test
	void testDesassociaProblema() {
		
		Problema p1 = this.repositorioProblemas.getProblema("P1");
		this.controllerPesquisa.associaProblema("COM1", p1);
		assertEquals(true, this.controllerPesquisa.desassociaProblema("COM1"));
		assertEquals(false, this.controllerPesquisa.desassociaProblema("COM1"));
		
		assertThrows(IllegalArgumentException.class, ()->
        this.controllerPesquisa.associaProblema("", p1));
		
		assertThrows(IllegalArgumentException.class, ()->
        this.controllerPesquisa.associaProblema(null, p1));
		


		
	}

	@Test
	void testAssociaObjetivo() {
		Objetivo o1 = this.repositorioObjetivos.getObjetivo("O1");
		
		assertEquals(true, this.controllerPesquisa.associaObjetivo("COM1", o1));
		
		assertEquals(false, this.controllerPesquisa.associaObjetivo("COM1", o1));
		
		assertThrows(IllegalArgumentException.class, ()->
        this.controllerPesquisa.associaObjetivo("COM2", o1));
		
		assertThrows(IllegalArgumentException.class, ()->
        this.controllerPesquisa.associaObjetivo("", o1));
		
		assertThrows(IllegalArgumentException.class, ()->
        this.controllerPesquisa.associaObjetivo(null, o1));
		
		

		
		
	}

	@Test
	void testDesassociaObjetivo() {
		Objetivo o1 = this.repositorioObjetivos.getObjetivo("O1");
		this.controllerPesquisa.associaObjetivo("COM1", o1);
		
		assertEquals(true, this.controllerPesquisa.dessassociaObjetivo("COM1", o1));
		
		assertEquals(false, this.controllerPesquisa.dessassociaObjetivo("COM1", o1));
		
		assertThrows(IllegalArgumentException.class, ()->
        this.controllerPesquisa.dessassociaObjetivo("", o1));
		
		assertThrows(IllegalArgumentException.class, ()->
        this.controllerPesquisa.dessassociaObjetivo(null, o1));
		
		
		

		
		
		
	}

}
