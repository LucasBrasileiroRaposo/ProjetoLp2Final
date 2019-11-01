package projeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerGeralTest {
    private ControllerGeral controllerGeral;

    @BeforeEach
    public void setup(){
        this.controllerGeral = new ControllerGeral();
    }

    @Test
    void cadastraAtividade() {
        assertEquals("A1", this.controllerGeral.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo"));
        assertEquals("A2",this.controllerGeral.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo"));
        try {
            this.controllerGeral.cadastraAtividade("","MEDIO","se nao lançar exececao complica");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.cadastraAtividade(null,"MEDIO","se nao lançar execao complica2");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.cadastraAtividade("                ","MEDIO","se nao lançar exececao complica");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","","Lança excecao pf");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","            ","Lança excecao pf");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada",null,"Lança excecao pf");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","BAIXO","");
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","MEDIO","           ");
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","ALTO",null);
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","alto","Lança excecao pf");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","ALTISSIMO","Lança excecao pf");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.cadastraAtividade("Nada","BAIXo","Lança excecao pf");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }

    }

    @Test
    void apagaAtividade() {
        assertEquals("A1",this.controllerGeral.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo"));
        assertEquals("A2",this.controllerGeral.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo"));
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo)",this.controllerGeral.exibeAtividade("A1"));
        assertEquals("Commitar pro git (MEDIO - Se commitar a pasta errada bagunça tudo)",this.controllerGeral.exibeAtividade("A2"));
        this.controllerGeral.apagaAtividade("A1");
        try{
            this.controllerGeral.apagaAtividade("A1");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.apagaAtividade("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.apagaAtividade("          ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.apagaAtividade(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
    }

    @Test
    void cadastraItem() {
        this.controllerGeral.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        this.controllerGeral.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 1");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 2");
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo) | PENDENTE - testar uso de caso 1 | PENDENTE - testar uso de caso 2", this.controllerGeral.exibeAtividade("A1"));
        try {
            this.controllerGeral.cadastraItem("","paralelepipedo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.cadastraItem("        ","paralelepipedo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.cadastraItem(null,"paralelepipedo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.cadastraItem("A50","paralelepipedo");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try {
            this.controllerGeral.cadastraItem("A1","");
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.cadastraItem("A1","       ");
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.cadastraItem("A1",null);
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }


    }

    @Test
    void exibeAtividade() {
        this.controllerGeral.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo)",this.controllerGeral.exibeAtividade("A1"));
        this.controllerGeral.cadastraItem("A1","testar uso de caso 1");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 2");
        assertEquals("Fazer testes JUnit (ALTO - Precisa testar tudo) | PENDENTE - testar uso de caso 1 | PENDENTE - testar uso de caso 2", this.controllerGeral.exibeAtividade("A1"));
        try {
            this.controllerGeral.exibeAtividade("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.exibeAtividade("      ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.exibeAtividade(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controllerGeral.exibeAtividade("A55");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void contaItensPendentes() {
        this.controllerGeral.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        this.controllerGeral.cadastraAtividade("Commitar pro git","MEDIO","Se commitar a pasta errada bagunça tudo");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 1.");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 2.");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 3.");
        assertEquals(3, this.controllerGeral.contaItensPendentes("A1"));
        assertEquals(0, this.controllerGeral.contaItensPendentes("A2"));
        try{
            this.controllerGeral.contaItensPendentes("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.contaItensPendentes("           ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.contaItensPendentes(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.contaItensPendentes("B20");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.contaItensPendentes("aabb");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        } try{
            this.controllerGeral.contaItensPendentes("A0");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }

    }

    @Test
    void contaItensRealizados() {
        this.controllerGeral.cadastraAtividade("Fazer testes JUnit","ALTO","Precisa testar tudo");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 1.");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 2.");
        this.controllerGeral.cadastraItem("A1","testar uso de caso 3.");
        assertEquals(0,this.controllerGeral.contaItensRealizados("A1"));
        try{
            this.controllerGeral.contaItensRealizados("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.contaItensRealizados("          ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.contaItensRealizados(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controllerGeral.contaItensRealizados("B20");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controllerGeral.contaItensRealizados("Lucas");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        } try{
            this.controllerGeral.contaItensRealizados("A0");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
    }

}
