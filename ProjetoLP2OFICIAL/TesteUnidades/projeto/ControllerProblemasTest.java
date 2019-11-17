package projeto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.objetivos_e_problemas.RepositorioProblemas;

class ControllerProblemasTest {
	
	private RepositorioProblemas controllerProblemas;
	
	@BeforeEach
	void setup() {
		this.controllerProblemas = new RepositorioProblemas();
		
		this.controllerProblemas.cadastraProblema("O alcool no cotidiano", 4);
		this.controllerProblemas.cadastraProblema("Os vicios dos jogos celulares", 5);
		
		
	}
	
	@Test
	void testCadastraProblema() {
		assertEquals( "P3", this.controllerProblemas.cadastraProblema("Violencia no Brasil", 4));
		assertEquals( "P4", this.controllerProblemas.cadastraProblema("Os altos impostos no Brasil", 5));
		
		assertThrows( IllegalArgumentException.class, ()->
		this.controllerProblemas.cadastraProblema("", 5));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerProblemas.cadastraProblema(null, 5));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerProblemas.cadastraProblema("O problema do VAR no Brasil", 6));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerProblemas.cadastraProblema("O problema do VAR no Brasil", -1));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerProblemas.cadastraProblema("O problema do VAR no Brasil", 0));
	}

	@Test
	void testApagarProblema() {
		this.controllerProblemas.apagarProblema("P1");
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerProblemas.exibeProblema("P1"));
		
		assertThrows( IllegalArgumentException.class, ()->
		this.controllerProblemas.apagarProblema(""));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerProblemas.apagarProblema(null));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerProblemas.apagarProblema("P7"));
		
		
	}

	@Test
	void testExibeProblema() {
		
		assertEquals( "P1 - O alcool no cotidiano - 4", this.controllerProblemas.exibeProblema("P1"));
		
		assertThrows( IllegalArgumentException.class, ()->
		this.controllerProblemas.exibeProblema(""));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerProblemas.exibeProblema(null));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerProblemas.exibeProblema("P7"));
	}

}
