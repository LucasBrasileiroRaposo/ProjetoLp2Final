package projeto.pesquisadores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PesquisadoresTest {

    Pesquisador p1,p2;

    @BeforeEach
    void criaPesquisador() {

        p1 = new Pesquisador("4Lan", "Estudante", "Estudante pesquisador", "4lan@hotmail.com", "http://www.foto.com");
        p2 = new Pesquisador("Tey", "Professor", "Estudante pesquisador", "Teyn@hotmail.com", "http:www.foto.com");
    }

    @Test
    void testToString(){

        assertEquals(p1.toString(),"4Lan (Estudante) - Estudante pesquisador - 4lan@hotmail.com - http://www.foto.com");
        assertNotEquals(p2.toString(),"Tey (Professor) - Estudante pesquisador - Tey@hotmail.com - http://www.foto.com");
    }


}