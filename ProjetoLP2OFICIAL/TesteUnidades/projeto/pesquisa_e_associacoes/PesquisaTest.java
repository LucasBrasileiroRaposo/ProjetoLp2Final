package projeto.pesquisa_e_associacoes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.atividades.Atividade;
import projeto.objetivos_e_problemas.Objetivo;
import projeto.objetivos_e_problemas.Problema;
import projeto.pesquisadores.Pesquisador;

import static org.junit.jupiter.api.Assertions.*;

class PesquisaTest {
    Pesquisa p1,p2;
    Problema problema;
    Objetivo o1;
    Pesquisador pesquisador;
    Atividade a1,a2;

    @BeforeEach
    void criaPesquisas(){
        p1 = new Pesquisa("Pesquisa de Campo","Floresta","FLO1");
        p2 = new Pesquisa("Pesquisa de Quintal","Casa","CAS1");
        problema = new Problema("Problema Social",2,"PRO1");
        o1 = new Objetivo("GERAL","oi",1,2,"O1");
        pesquisador = new Pesquisador("4lan","Estudante","Pesquisador Estudante","4lan@gmail.com","https://foto.com");
        a1 = new Atividade("De campo","MEDIO","gorilas");
        a2 = new Atividade("De campo","MEDIO","gorilas");

    }
    @Test
    void testToString() {
        assertEquals(p1.toString()," - Pesquisa de Campo - Floresta");
        assertEquals(p2.toString()," - Pesquisa de Quintal - Casa");
    }

    @Test
    void associaProblema() {
        assertTrue(p1.associaProblema(problema));
        assertTrue(p2.associaProblema(problema));
    }

    @Test
    void desassociaProblema() {
        p1.associaProblema(problema);
        assertTrue(p1.desassociaProblema());
        assertFalse(p2.desassociaProblema());
    }

    @Test
    void associaObjetivo() {
        assertTrue(p1.associaObjetivo(o1));
        assertThrows(IllegalArgumentException.class,()->
                assertFalse(p2.associaObjetivo(o1)));

    }

    @Test
    void desassociaObjetivo() {
        p1.associaObjetivo(o1);
        assertTrue(p1.desassociaObjetivo(o1));
        assertFalse(p2.desassociaObjetivo(o1));

    }

    @Test
    void associaPesquisador() {
        assertTrue(p1.associaPesquisador(pesquisador));
    }
    @Test
    void desassociaPesquisador() {
        p1.associaPesquisador(pesquisador);
        assertTrue(p1.desassociaPesquisador("4lan@gmail.com"));
    }

    @Test
    void cadastraAtividade() {
        assertTrue(p1.cadastraAtividade(a1));
        assertFalse(p1.cadastraAtividade(a2));
    }

    @Test
    void removeAtividade() {
        p1.cadastraAtividade(a1);
        assertTrue(p1.removeAtividade(null));
        assertFalse(p1.removeAtividade("A1"));
    }
}