package projeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerAtividadeTest {

    private ControllerAtividade controleAtividade;

    @BeforeEach
    public void inicializador(){
        this.controleAtividade = new ControllerAtividade();
    }

    @Test
    void cadastraAtividade() {
        assertEquals("A1",this.controleAtividade.cadastraAtividade("Fazer os Testes JUnit","MEDIO","pois caso eu teste errado vamos ter problems"));
        assertEquals("A2",this.controleAtividade.cadastraAtividade("Jogar FIFINHA","ALTO","pois to jogando a primeira divisao com um time m**d@"));
        try{
            this.controleAtividade.cadastraAtividade("","BAIXO","pois eh facil dimai papai");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("            ","BAIXO","pois eh facil dimai papai");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade(null,"BAIXO","pois eh facil dimai papai");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Analisar os jogares de peda na lua","","pois eh facil dimai papai");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Analisar os jogares de peda na lua","   ","pois eh facil dimai papai");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Analisar os jogares de peda na lua",null,"pois eh facil dimai papai");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Analisar os jogares de peda na lua","ALTO","");
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Analisar os jogares de peda na lua","ALTO","            ");
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Analisar os jogares de peda na lua","ALTO",null);
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.cadastraAtividade("Analisar os jogares de peda na lua","ALTO DIMAI HOMI","pois eh facil dimai papai");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void apagaAtividade() {
        assertEquals("A1",this.controleAtividade.cadastraAtividade("Fazer os Testes JUnit","MEDIO","pois caso eu teste errado vamos ter problems"));
        assertEquals("A2",this.controleAtividade.cadastraAtividade("Jogar FIFINHA","ALTO","pois to jogando a primeira divisao com um time m**d@"));
        assertEquals("Jogar FIFINHA (ALTO - pois to jogando a primeira divisao com um time m**d@)",this.controleAtividade.exibeAtividade("A2"));
        this.controleAtividade.apagaAtividade("A2");
        try{
            this.controleAtividade.apagaAtividade("A2");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controleAtividade.apagaAtividade("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.apagaAtividade(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.apagaAtividade("      ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }

    }

    @Test
    void cadastraItem() {
        this.controleAtividade.cadastraAtividade("Jogar FIFINHA","ALTO","pois to jogando a primeira divisao com um time m**d@");
        this.controleAtividade.cadastraItem("A1","acabar projeto");
        this.controleAtividade.cadastraItem("A1","commitar no git");
        this.controleAtividade.cadastraItem("A1","ligar videogame");
        assertEquals("Jogar FIFINHA (ALTO - pois to jogando a primeira divisao com um time m**d@) | PENDENTE - acabar projeto | PENDENTE - commitar no git | PENDENTE - ligar videogame", this.controleAtividade.exibeAtividade("A1"));
        try {
            this.controleAtividade.cadastraItem("","abrir jogo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem("        ","abrir o jogo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem(null,"abrir o jogo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem("A3.0","abrir o jogo");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try {
            this.controleAtividade.cadastraItem("A1","");
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem("A1","       ");
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem("A1",null);
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem("A67",null);
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem("","       ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem("","");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem(null,"");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.cadastraItem(null,null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
    }

    @Test
    void exibeAtividade() {
        this.controleAtividade.cadastraAtividade("Jogar FIFINHA","ALTO","pois to jogando a primeira divisao com um time m**d@");
        this.controleAtividade.cadastraItem("A1","acabar projeto");
        this.controleAtividade.cadastraItem("A1","commitar no git");
        this.controleAtividade.cadastraItem("A1","ligar videogame");
        assertEquals("Jogar FIFINHA (ALTO - pois to jogando a primeira divisao com um time m**d@) | PENDENTE - acabar projeto | PENDENTE - commitar no git | PENDENTE - ligar videogame", this.controleAtividade.exibeAtividade("A1"));

        try {
            this.controleAtividade.exibeAtividade("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.exibeAtividade("      ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.exibeAtividade(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.controleAtividade.exibeAtividade("A");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void contaItensPendentes() {
        this.controleAtividade.cadastraAtividade("Jogar FIFINHA","ALTO","pois to jogando a primeira divisao com um time m**d@");
        this.controleAtividade.cadastraAtividade("exercitar-me fisicamente","ALTO","falta-me coragem");
        this.controleAtividade.cadastraItem("A1","acabar projeto");
        this.controleAtividade.cadastraItem("A1","commitar no git");
        this.controleAtividade.cadastraItem("A1","ligar videogame");
        assertEquals(0,this.controleAtividade.contaItensPendentes("A2"));
        assertEquals(3,this.controleAtividade.contaItensPendentes("A1"));
        this.controleAtividade.apagaAtividade("A2");
        try{
            this.controleAtividade.contaItensPendentes("A2");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controleAtividade.contaItensPendentes("A26");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controleAtividade.contaItensPendentes("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.contaItensPendentes("    ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.contaItensPendentes(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
    }

    @Test
    void contaItensRealizados() {
        this.controleAtividade.cadastraAtividade("Jogar FIFINHA","ALTO","pois to jogando a primeira divisao com um time m**d@");
        this.controleAtividade.cadastraItem("A1","acabar projeto");
        this.controleAtividade.cadastraItem("A1","commitar no git");
        this.controleAtividade.cadastraItem("A1","ligar videogame");
        assertEquals(0, this.controleAtividade.contaItensRealizados("A1"));
        try{
            this.controleAtividade.contaItensRealizados("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.contaItensRealizados("          ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.contaItensRealizados(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.controleAtividade.contaItensRealizados("H2O");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.controleAtividade.contaItensRealizados("Raiff");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        } try{
            this.controleAtividade.contaItensRealizados("A00");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
    }


}