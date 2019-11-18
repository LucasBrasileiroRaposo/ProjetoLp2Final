package projeto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projeto.atividades.RepositorioAtividade;

class RepositorioAtividadeTest {
    private RepositorioAtividade repositorioAtividade;

    @BeforeEach
    public void inicializador(){
        this.repositorioAtividade = new RepositorioAtividade();
    }

    @Test
    void cadastraAtividade() {
        assertEquals("A1",this.repositorioAtividade.cadastraAtividade("Fazer os Testes JUnit","MEDIO","pois caso eu teste errado vamos ter problems"));
        assertEquals("A2",this.repositorioAtividade.cadastraAtividade("Jogar FIFINHA","ALTO","pois to jogando a primeira divisao com um time m**d@"));
        try{
            this.repositorioAtividade.cadastraAtividade("","BAIXO","pois eh facil dimai papai");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("            ","BAIXO","pois eh facil dimai papai");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade(null,"BAIXO","pois eh facil dimai papai");
            fail("Campo Descricao nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Analisar os jogares de peda na lua","","pois eh facil dimai papai");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Analisar os jogares de peda na lua","   ","pois eh facil dimai papai");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Analisar os jogares de peda na lua",null,"pois eh facil dimai papai");
            fail("Campo nivelRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Analisar os jogares de peda na lua","ALTO","");
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Analisar os jogares de peda na lua","ALTO","            ");
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Analisar os jogares de peda na lua","ALTO",null);
            fail("Campo descricaoRisco nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.cadastraAtividade("Analisar os jogares de peda na lua","ALTO DIMAI HOMI","pois eh facil dimai papai");
            fail("Valor invalido do nivel do risco.");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void apagaAtividade() {
        assertEquals("A1",this.repositorioAtividade.cadastraAtividade("Fazer os Testes JUnit","MEDIO","pois caso eu teste errado vamos ter problems"));
        assertEquals("A2",this.repositorioAtividade.cadastraAtividade("Jogar FIFINHA","ALTO","pois to jogando a primeira divisao com um time m**d@"));
        assertEquals("Jogar FIFINHA (ALTO - pois to jogando a primeira divisao com um time m**d@)",this.repositorioAtividade.exibeAtividade("A2"));
        this.repositorioAtividade.apagaAtividade("A2");
        try{
            this.repositorioAtividade.apagaAtividade("A2");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.apagaAtividade("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.apagaAtividade(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.apagaAtividade("      ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }

    }

    @Test
    void cadastraItem() {
        this.repositorioAtividade.cadastraAtividade("Jogar FIFINHA","ALTO","pois to jogando a primeira divisao com um time m**d@");
        this.repositorioAtividade.cadastraItem("A1","acabar projeto");
        this.repositorioAtividade.cadastraItem("A1","commitar no git");
        this.repositorioAtividade.cadastraItem("A1","ligar videogame");
        assertEquals("Jogar FIFINHA (ALTO - pois to jogando a primeira divisao com um time m**d@) | PENDENTE - acabar projeto | PENDENTE - commitar no git | PENDENTE - ligar videogame", this.repositorioAtividade.exibeAtividade("A1"));
        try {
            this.repositorioAtividade.cadastraItem("","abrir jogo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("        ","abrir o jogo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.repositorioAtividade.cadastraItem(null,"abrir o jogo");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("A3.0","abrir o jogo");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("A1","");
            fail("Item nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("A1","       ");
            fail("Item nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("A1",null);
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("A67",null);
            fail("Item nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("","       ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.repositorioAtividade.cadastraItem("","");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.repositorioAtividade.cadastraItem(null,"");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.cadastraItem(null,null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
    }

    @Test
    void exibeAtividade() {
        this.repositorioAtividade.cadastraAtividade("Jogar FIFINHA","ALTO","pois to jogando a primeira divisao com um time m**d@");
        this.repositorioAtividade.cadastraItem("A1","acabar projeto");
        this.repositorioAtividade.cadastraItem("A1","commitar no git");
        this.repositorioAtividade.cadastraItem("A1","ligar videogame");
        assertEquals("Jogar FIFINHA (ALTO - pois to jogando a primeira divisao com um time m**d@) | PENDENTE - acabar projeto | PENDENTE - commitar no git | PENDENTE - ligar videogame", this.repositorioAtividade.exibeAtividade("A1"));

        try {
            this.repositorioAtividade.exibeAtividade("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.repositorioAtividade.exibeAtividade("      ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try {
            this.repositorioAtividade.exibeAtividade(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try {
            this.repositorioAtividade.exibeAtividade("A");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    void contaItensPendentes() {
        this.repositorioAtividade.cadastraAtividade("Jogar FIFINHA","ALTO","pois to jogando a primeira divisao com um time m**d@");
        this.repositorioAtividade.cadastraAtividade("exercitar-me fisicamente","ALTO","falta-me coragem");
        this.repositorioAtividade.cadastraItem("A1","acabar projeto");
        this.repositorioAtividade.cadastraItem("A1","commitar no git");
        this.repositorioAtividade.cadastraItem("A1","ligar videogame");
        assertEquals(0,this.repositorioAtividade.contaItensPendentes("A2"));
        assertEquals(3,this.repositorioAtividade.contaItensPendentes("A1"));
        this.repositorioAtividade.apagaAtividade("A2");
        try{
            this.repositorioAtividade.contaItensPendentes("A2");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.contaItensPendentes("A26");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.contaItensPendentes("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.contaItensPendentes("    ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.contaItensPendentes(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
    }

    @Test
    void contaItensRealizados() {
        this.repositorioAtividade.cadastraAtividade("Jogar FIFINHA","ALTO","pois to jogando a primeira divisao com um time m**d@");
        this.repositorioAtividade.cadastraItem("A1","acabar projeto");
        this.repositorioAtividade.cadastraItem("A1","commitar no git");
        this.repositorioAtividade.cadastraItem("A1","ligar videogame");
        assertEquals(0, this.repositorioAtividade.contaItensRealizados("A1"));
        try{
            this.repositorioAtividade.contaItensRealizados("");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.contaItensRealizados("          ");
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.contaItensRealizados(null);
            fail("Campo codigo nao pode ser nulo ou vazio.");
        }catch (NullPointerException e){
        }
        try{
            this.repositorioAtividade.contaItensRealizados("H2O");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
        try{
            this.repositorioAtividade.contaItensRealizados("Raiff");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        } try{
            this.repositorioAtividade.contaItensRealizados("A00");
            fail("Atividade nao encontrada");
        }catch (IllegalArgumentException e){
        }
    }

}