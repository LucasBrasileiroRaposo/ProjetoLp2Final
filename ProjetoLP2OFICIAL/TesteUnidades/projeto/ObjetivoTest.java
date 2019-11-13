package projeto;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projeto.objetivos_e_problemas.Objetivo;
import projeto.objetivos_e_problemas.Problema;


class ObjetivoTest {
private Objetivo objetivo1, objetivo2;
	
	@BeforeEach
	void setup() {
	this.objetivo1 = new Objetivo("GERAL", "Melhorar o LCC2", 3, 2, "O1");	
	this.objetivo2 = new Objetivo("ESPECIFICO", "Comprar melhores cadeiras", 3, 5, "O2");
		
	}
	@Test
	void testHashCode() {
		Objetivo objetivo3 = new Objetivo("GERAL", "Exterminar o lixo do lago", 1, 1, "O1");
		assertTrue(this.objetivo1.hashCode() == objetivo3.hashCode());
		assertFalse(this.objetivo1.hashCode() == this.objetivo2.hashCode());
	}

	@Test
	void testToString() {
		assertEquals("O1 - GERAL - Melhorar o LCC2 - 5", this.objetivo1.toString());
		assertEquals("O2 - ESPECIFICO - Comprar melhores cadeiras - 8", this.objetivo2.toString());
	}

	@Test
	void testAssociaObjetivo() {
		this.objetivo1.associaObjetivo();
		assertTrue(this.objetivo1.getAssociado() == true);
		assertTrue(this.objetivo2.getAssociado() == false);
		
	}

	@Test
	void testDesassociaObjetivo() {
		this.objetivo1.associaObjetivo();
		this.objetivo1.desassociaObjetivo();
		assertTrue(this.objetivo1.getAssociado() == false);
		
	}

	@Test
	void testEqualsObject() {
		Objetivo objetivo3 = new Objetivo("ESPECIFICO", "Comprar limao para todo mundo", 2 , 3, "O1");
		assertTrue(this.objetivo1.equals(objetivo3));
		assertFalse(this.objetivo2.equals(this.objetivo1));
	}

}
