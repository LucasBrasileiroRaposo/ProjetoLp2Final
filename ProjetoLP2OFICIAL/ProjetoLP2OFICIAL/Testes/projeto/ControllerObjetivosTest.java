package projeto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerObjetivosTest {
	
	private ControllerObjetivos controllerObjetivos;
	
	@BeforeEach
	void setup() {
		
		this.controllerObjetivos = new ControllerObjetivos();
		
		this.controllerObjetivos.cadastraObjetivo("GERAL", "Preservar a Amazonia", 5, 4);
		this.controllerObjetivos.cadastraObjetivo("Especifico", "Salvar as Andorinhas", 2 , 3);
		
	}

	@Test
	void testCadastraObjetivo() {
		assertEquals( "O3", this.controllerObjetivos.cadastraObjetivo("ESPECIFICO", "Salvar o mundo", 5 , 1));
		assertEquals( "O4", this.controllerObjetivos.cadastraObjetivo("GERAL", "Melhorar as Universidades", 4 , 3));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerObjetivos.cadastraObjetivo("Xablau", "Salvar o Xablau", 3 , 5));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerObjetivos.cadastraObjetivo("", "Salvar o Xablau", 3 , 5));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerObjetivos.cadastraObjetivo(null, "Salvar o Xablau", 3 , 5));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerObjetivos.cadastraObjetivo("GERAL", "", 3 , 5));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerObjetivos.cadastraObjetivo("GERAL", null, 3 , 5));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerObjetivos.cadastraObjetivo("GERAL", "Salvar o Xablau", 6 , 2));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerObjetivos.cadastraObjetivo("GERAL", "Salvar o Xablau", 2 , -4));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerObjetivos.cadastraObjetivo("GERAL", "Salvar o Xablau", 2 , 0));
	}

	@Test
	
	void testApagarObjetivo() {
		this.controllerObjetivos.apagarObjetivo("O1");
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerObjetivos.exibeObjetivo("O1"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerObjetivos.apagarObjetivo("O9"));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerObjetivos.apagarObjetivo(""));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerObjetivos.apagarObjetivo(null));
		
		
		
	}

	@Test
	void testExibeObjetivo() {
		assertEquals( "O1 - GERAL - Preservar a Amazonia - 9", this.controllerObjetivos.exibeObjetivo("O1"));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerObjetivos.exibeObjetivo(null));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerObjetivos.exibeObjetivo(""));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerObjetivos.exibeObjetivo("O5"));
		
		
	}

}
