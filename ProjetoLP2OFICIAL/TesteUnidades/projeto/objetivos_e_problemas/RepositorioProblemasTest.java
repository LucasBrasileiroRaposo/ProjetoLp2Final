package projeto.objetivos_e_problemas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projeto.objetivos_e_problemas.RepositorioProblemas;

class RepositorioProblemasTest {

    private RepositorioProblemas repositorioProblemas;

    @BeforeEach
    void setup() {
        this.repositorioProblemas = new RepositorioProblemas();

        this.repositorioProblemas.cadastraProblema("O alcool no cotidiano", 4);
        this.repositorioProblemas.cadastraProblema("Os vicios dos jogos celulares", 5);


    }

    @Test
    void testCadastraProblema() {
        assertEquals( "P3", this.repositorioProblemas.cadastraProblema("Violencia no Brasil", 4));
        assertEquals( "P4", this.repositorioProblemas.cadastraProblema("Os altos impostos no Brasil", 5));

        assertThrows( IllegalArgumentException.class, ()->
                this.repositorioProblemas.cadastraProblema("", 5));

        assertThrows( NullPointerException.class, ()->
                this.repositorioProblemas.cadastraProblema(null, 5));

        assertThrows( IllegalArgumentException.class, ()->
                this.repositorioProblemas.cadastraProblema("O problema do VAR no Brasil", 6));

        assertThrows( IllegalArgumentException.class, ()->
                this.repositorioProblemas.cadastraProblema("O problema do VAR no Brasil", -1));

        assertThrows( IllegalArgumentException.class, ()->
                this.repositorioProblemas.cadastraProblema("O problema do VAR no Brasil", 0));
    }

    @Test
    void testApagarProblema() {
        this.repositorioProblemas.apagarProblema("P1");

        assertThrows( IllegalArgumentException.class, ()->
                this.repositorioProblemas.exibeProblema("P1"));

        assertThrows( IllegalArgumentException.class, ()->
                this.repositorioProblemas.apagarProblema(""));

        assertThrows( NullPointerException.class, ()->
                this.repositorioProblemas.apagarProblema(null));

        assertThrows( IllegalArgumentException.class, ()->
                this.repositorioProblemas.apagarProblema("P7"));


    }

    @Test
    void testExibeProblema() {

        assertEquals( "P1 - O alcool no cotidiano - 4", this.repositorioProblemas.exibeProblema("P1"));

        assertThrows( IllegalArgumentException.class, ()->
                this.repositorioProblemas.exibeProblema(""));

        assertThrows( NullPointerException.class, ()->
                this.repositorioProblemas.exibeProblema(null));

        assertThrows( IllegalArgumentException.class, ()->
                this.repositorioProblemas.exibeProblema("P7"));
    }

}
