package projeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.objetivos_e_problemas.Problema;

import static org.junit.jupiter.api.Assertions.*;

class ProblemaTest {
	
	private Problema problema1, problema2;
	
	@BeforeEach
	void setup() {
	this.problema1 = new Problema("O cancer no Brasil", 2, "P1");	
	this.problema2 = new Problema("Os altos impostos brasileiros", 1, "P2");
		
	}
	
	
	@Test
	void testHashCode() {
		Problema problema3 = new Problema("A infleuncia dos memes nos jovens", 1, "P1");
		assertTrue(this.problema1.hashCode() == problema3.hashCode());
		assertFalse(this.problema1.hashCode() == this.problema2.hashCode());
	}

	@Test
	void testToString() {
		
		assertEquals("P1 - O cancer no Brasil - 2", this.problema1.toString());
		assertEquals("P2 - Os altos impostos brasileiros - 1", this.problema2.toString());
	}

	@Test
	void testEqualsObject() {
		Problema problema3 = new Problema("A infleuncia dos memes nos jovens", 1, "P1");
		assertTrue(this.problema1.equals(problema3));
		assertFalse(this.problema1.equals(problema2));
	}

}
