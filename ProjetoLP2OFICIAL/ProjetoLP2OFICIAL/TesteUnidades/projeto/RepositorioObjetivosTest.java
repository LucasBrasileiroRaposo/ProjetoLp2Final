package projeto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projeto.objetivos_e_problemas.RepositorioObjetivos;

class RepositorioObjetivosTest {
private RepositorioObjetivos repositorioObjetivos;
	
	@BeforeEach
	void setup() {
		
		this.repositorioObjetivos = new RepositorioObjetivos();
		
		this.repositorioObjetivos.cadastraObjetivo("GERAL", "Preservar a Amazonia", 5, 4);
		this.repositorioObjetivos.cadastraObjetivo("Especifico", "Salvar as Andorinhas", 2 , 3);
		
	}

	@Test
	void testCadastraObjetivo() {
		assertEquals( "O3", this.repositorioObjetivos.cadastraObjetivo("ESPECIFICO", "Salvar o mundo", 5 , 1));
		assertEquals( "O4", this.repositorioObjetivos.cadastraObjetivo("GERAL", "Melhorar as Universidades", 4 , 3));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.repositorioObjetivos.cadastraObjetivo("Xablau", "Salvar o Xablau", 3 , 5));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.repositorioObjetivos.cadastraObjetivo("", "Salvar o Xablau", 3 , 5));
		
		assertThrows( NullPointerException.class, ()-> 
		this.repositorioObjetivos.cadastraObjetivo(null, "Salvar o Xablau", 3 , 5));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.repositorioObjetivos.cadastraObjetivo("GERAL", "", 3 , 5));
		
		assertThrows( NullPointerException.class, ()-> 
		this.repositorioObjetivos.cadastraObjetivo("GERAL", null, 3 , 5));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.repositorioObjetivos.cadastraObjetivo("GERAL", "Salvar o Xablau", 6 , 2));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.repositorioObjetivos.cadastraObjetivo("GERAL", "Salvar o Xablau", 2 , -4));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.repositorioObjetivos.cadastraObjetivo("GERAL", "Salvar o Xablau", 2 , 0));
	}

	@Test
	
	void testApagarObjetivo() {
		this.repositorioObjetivos.apagarObjetivo("O1");
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.repositorioObjetivos.exibeObjetivo("O1"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.repositorioObjetivos.apagarObjetivo("O9"));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.repositorioObjetivos.apagarObjetivo(""));
		
		assertThrows( NullPointerException.class, ()-> 
		this.repositorioObjetivos.apagarObjetivo(null));
		
		
		
	}

	@Test
	void testExibeObjetivo() {
		assertEquals( "O1 - GERAL - Preservar a Amazonia - 9", this.repositorioObjetivos.exibeObjetivo("O1"));
		
		assertThrows( NullPointerException.class, ()-> 
		this.repositorioObjetivos.exibeObjetivo(null));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.repositorioObjetivos.exibeObjetivo(""));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.repositorioObjetivos.exibeObjetivo("O5"));
		
		
	}

}
