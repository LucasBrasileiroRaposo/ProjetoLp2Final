package projeto.atividades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.atividades.Atividade;

import static org.junit.jupiter.api.Assertions.*;

class AtividadeTest {
    Atividade a1,a2;

    @BeforeEach
    void criaAtividade(){
        a1 = new Atividade("Visita","MEDIO","cachorros");
        a2 = new Atividade("Correr","BAIXO","queda");
    }

    @Test
    void testToString() {
        assertEquals(a1.toString(),"Visita (MEDIO - cachorros)");
        assertEquals(a2.toString(),"Correr (BAIXO - queda)");
    }

    @Test
    void cadastraItem() {

    }

    @Test
    void contaItensPendentes() {
    }

    @Test
    void contaItensRealizados() {
    }

    @Test
    void controlaDestinoAtividade() {
    }

    @Test
    void executaAtividade() {
    }

    @Test
    void veriricaResultado() {
    }

    @Test
    void removeResultado() {
    }

    @Test
    void cadastraResultado() {
    }

    @Test
    void exibeResultados() {
    }

    @Test
    void criaPrecedente() {
    }

    @Test
    void pegaProximo() {
    }

    @Test
    void pegaMaiorRiscoAtividades() {
    }
}