package projeto;

public interface Busca{
    String busca(String palavra);
    int contaResultadosBusca(String termo);
    String busca(String termo, int numeroDoResultado);
}
