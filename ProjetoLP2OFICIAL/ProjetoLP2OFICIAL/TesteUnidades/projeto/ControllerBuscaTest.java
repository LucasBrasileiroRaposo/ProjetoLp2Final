package projeto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projeto.atividades.RepositorioAtividade;
import projeto.busca.ControllerBusca;
import projeto.objetivos_e_problemas.RepositorioObjetivos;
import projeto.objetivos_e_problemas.RepositorioProblemas;
import projeto.pesquisa_e_associacoes.RepositorioPesquisa;
import projeto.pesquisadores.RepositorioPesquisador;


class ControllerBuscaTest {
	private ControllerBusca controllerBusca;

	private RepositorioProblemas repositorioProblemas;
	private RepositorioObjetivos repositorioObjetivos;
	private RepositorioAtividade repositorioAtividade;
	private RepositorioPesquisador repositorioPesquisador;
	private RepositorioPesquisa repositorioPesquisa;
	
	
	@BeforeEach
	void setup() {
		
		this.repositorioProblemas = new RepositorioProblemas();
		this.repositorioProblemas.cadastraProblema("A busca por aceitacao na sociedade atual", 3);
		this.repositorioObjetivos = new RepositorioObjetivos();
		this.repositorioObjetivos.cadastraObjetivo( "GERAL", "Coletar livros brasileiros em Portugal", 3, 1);
		this.repositorioPesquisador = new RepositorioPesquisador();
		this.repositorioPesquisador.cadastraPesquisador("Rocky Balboa", "professor", "Um grande lutador que agora é "
				+ "pesquisador depois de dar muita porrada", "Rocky@gmail.com", "https://MinhaSelfie");
		this.repositorioAtividade = new RepositorioAtividade();
		this.repositorioAtividade.cadastraAtividade("Fazer um carregador portátil", "ALTO", "Tem que ter cuidado "
				+ "para nao dar choque.");
		this.repositorioPesquisa = new RepositorioPesquisa();
		this.repositorioPesquisa.cadastraPesquisa("Os cordeis do sertao", "Lingua Portuguesa, Literatura");
		this.controllerBusca = new ControllerBusca(this.repositorioPesquisa,this.repositorioPesquisador,
				this.repositorioProblemas,this.repositorioObjetivos, this.repositorioAtividade);
		
		
	}

	@Test
	void testBuscaString() {
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerBusca.busca(""));
		assertThrows( NullPointerException.class, ()-> 
		this.controllerBusca.busca(null));
		
		assertEquals("Rocky@gmail.com: Um grande lutador que agora é pesquisador depois de dar muita porrada "
				+ "| P1: A busca por aceitacao "
				+ "na sociedade atual | A1: Fazer um carregador portátil",this.controllerBusca.busca("por"));
		
		assertEquals("LIN1: Lingua Portuguesa, Literatura | O1: Coletar livros brasileiros em Portugal",
				this.controllerBusca.busca("Por"));
		
		assertEquals("", this.controllerBusca.busca("Balburdia"));
		
	} 

	@Test
	void testBuscaStringInt() {
		assertEquals("Rocky@gmail.com: Um grande lutador que agora é pesquisador depois de dar muita porrada"
				,this.controllerBusca.busca("por", 1 ));
		
		assertEquals("A1: Fazer um carregador portátil"
				,this.controllerBusca.busca("por", 3 ));
		
		assertThrows( NullPointerException.class, ()-> 
		this.controllerBusca.busca(null , 2));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerBusca.busca("", 2));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerBusca.busca("por", -1));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerBusca.busca("por", 69));
		
		
		
		
	}

	@Test
	void testContaResultadosBusca() {
		assertThrows( NullPointerException.class, ()-> 
		this.controllerBusca.contaResultadosBusca(null));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerBusca.contaResultadosBusca(""));
		
		assertThrows( IllegalArgumentException.class, ()-> 
		this.controllerBusca.contaResultadosBusca("balburdia"));
		
		assertEquals(3,this.controllerBusca.contaResultadosBusca("por"));
		
		assertEquals(2,this.controllerBusca.contaResultadosBusca("Por"));
	}

}
