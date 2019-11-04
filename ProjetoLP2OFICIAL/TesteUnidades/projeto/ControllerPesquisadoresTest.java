package projeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerPesquisadoresTest {
    Pesquisadores p1,p2,p3;
    ControllerPesquisadores cp;
    
    @BeforeEach
    void CriaPesquisador() {
    	
        p1 = new Pesquisadores("4Lan", "Estudante", "Estudante pesquisador", "4lan@hotmail.com", "http://www.foto1.com");
        p2 = new Pesquisadores("Kaio", "Externo", "Externo pesquisador", "kaio@hotmail.com", "http://www.foto2.com");
        p3 = new Pesquisadores("Gaudencio", "Professor", "Professor pesquisador", "gaudencio@hotmail.com", "http://www.foto3.com");
        cp = new ControllerPesquisadores();
        cp.cadastraPesquisador("Tey","Estudante","Estudante pesquisador","tey@hotmail.com","http://www.foto1.com");
        cp.cadastraPesquisador("Frodo", "Externo", "Externo pesquisador", "frodo@hotmail.com", "http://www.foto2.com");
        cp.cadastraPesquisador("ain", "Professor", "Professor pesquisador", "ain@hotmail.com", "http://www.foto3.com");

    }
    @Test
    void cadastraPesquisador() {

        cp.cadastraPesquisador("4Lan","Estudante","Estudante pesquisador","4lan@hotmail.com","http://www.foto1.com");
        cp.cadastraPesquisador("Kaio", "Externo", "Externo pesquisador", "kaio@hotmail.com", "http://www.foto2.com");
        cp.cadastraPesquisador("Gaudencio", "Professor", "Professor pesquisador", "gaudencio@hotmail.com", "http://www.foto3.com");
        assertEquals(cp.exibePesquisador("4lan@hotmail.com"),"4Lan (Estudante) - Estudante pesquisador - 4lan@hotmail.com - http://www.foto1.com");
        assertEquals(cp.exibePesquisador("kaio@hotmail.com"),"Kaio (Externo) - Externo pesquisador - kaio@hotmail.com - http://www.foto2.com");
        assertNotEquals(cp.exibePesquisador("gaudencio@hotmail.com"),"Kaio (Externo) - Externo pesquisador - kaio@hotmail.com - http://www.foto2.com");

    }

    @Test
    void alteraPesquisador() {
    	
        cp.alteraPesquisador("tey@hotmail.com","NOME","TEY");
        assertEquals(cp.exibePesquisador("tey@hotmail.com"),"TEY (Estudante) - Estudante pesquisador - tey@hotmail.com - http://www.foto1.com");
        cp.alteraPesquisador("frodo@hotmail.com","BIOGRAFIA","Externo pesquisador novato");
        assertEquals(cp.exibePesquisador("frodo@hotmail.com"),"Frodo (Externo) - Externo pesquisador novato - frodo@hotmail.com - http://www.foto2.com");
        cp.alteraPesquisador("ain@hotmail.com","EMAIL","ain@gmail.com");
        assertEquals(cp.exibePesquisador("ain@gmail.com"),"ain (Professor) - Professor pesquisador - ain@gmail.com - http://www.foto3.com");
        cp.alteraPesquisador("ain@gmail.com","FOTO","https://www.foto4.com");
        assertEquals(cp.exibePesquisador("ain@gmail.com"),"ain (Professor) - Professor pesquisador - ain@gmail.com - https://www.foto4.com");
    }

    @Test
    void desativaPesquisador() {
        cp.desativaPesquisador("ain@hotmail.com");
        
        try{
            cp.desativaPesquisador("ain@hotmail.com");
            fail("Pesquisador inativo.");
        }catch (IllegalArgumentException ex){

        }
        cp.desativaPesquisador("tey@hotmail.com");
        cp.desativaPesquisador("frodo@hotmail.com");
        assertEquals(cp.exibePesquisador("ain@hotmail.com"),"PESQUISADOR DESATIVADO!");
        assertEquals(cp.exibePesquisador("tey@hotmail.com"),"PESQUISADOR DESATIVADO!");
        assertEquals(cp.exibePesquisador("frodo@hotmail.com"),"PESQUISADOR DESATIVADO!");
    }

    @Test
    void ativaPesquisador() {
    	
        try {
            cp.ativaPesquisador("ain@hotmail.com");
            fail("Pesquisador ja ativado.");
        }catch (IllegalArgumentException ex){

        }
        cp.desativaPesquisador("ain@hotmail.com");
        assertEquals(cp.exibePesquisador("ain@hotmail.com"),"PESQUISADOR DESATIVADO!");
        cp.ativaPesquisador("ain@hotmail.com");
        assertEquals(cp.exibePesquisador("ain@hotmail.com"),"ain (Professor) - Professor pesquisador - ain@hotmail.com - http://www.foto3.com");
    }

    @Test
    void exibePesquisador() {
    	
        assertEquals(cp.exibePesquisador("tey@hotmail.com"),"Tey (Estudante) - Estudante pesquisador - tey@hotmail.com - http://www.foto1.com");
        assertEquals(cp.exibePesquisador("frodo@hotmail.com"),"Frodo (Externo) - Externo pesquisador - frodo@hotmail.com - http://www.foto2.com");
        assertNotEquals(cp.exibePesquisador("ain@hotmail.com"),"ain (Externo) - Externo pesquisador - ain@hotmail.com - http://www.foto3.com");
    }

    @Test
    void pesquisadorEhAtivo() {
    	
        assertTrue(cp.pesquisadorEhAtivo("tey@hotmail.com"));
        cp.desativaPesquisador("tey@hotmail.com");
        assertFalse(cp.pesquisadorEhAtivo("tey@hotmail.com"));
    }
}