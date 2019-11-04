package projeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PesquisadoresTest {
    Pesquisadores p1,p2;
    @BeforeEach
    void criaPesquisador() {
        p1 = new Pesquisadores("4Lan", "Estudante", "Estudante pesquisador", "4lan@hotmail.com", "http://www.foto.com");
        p2 = new Pesquisadores("Tey", "Professor", "Estudante pesquisador", "Teyn@hotmail.com", "http:www.foto.com");
    }
    @Test
    void testToString(){
        assertEquals(p1.toString(),"4Lan (Estudante) - Estudante pesquisador - 4lan@hotmail.com - http://www.foto.com");
        assertNotEquals(p2.toString(),"Tey (Professor) - Estudante pesquisador - Tey@hotmail.com - http://www.foto.com");
    }


}