package Util;

public class Validadora {
	
	public static void verificaValorNullVazio(String valor, String mensagem) {
		if (valor == null ||  valor.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
  
    public static void validaEntradaCampo(String campoDeInteresse) {
        if (campoDeInteresse == null || campoDeInteresse.trim().equals("")) {
            throw new NullPointerException("Formato do campo de interesse invalido.");
        } else if (campoDeInteresse.length() > 255) {
            throw new IllegalArgumentException("Formato do campo de interesse invalido.");
        } else if (verificaTopico(campoDeInteresse)) {
            throw new IllegalArgumentException("Formato do campo de interesse invalido.");
        }

    }

  

    private static boolean verificaTopico(String camposDeInteresse) {
        String[] topicos = camposDeInteresse.split(",");
        boolean retorno = false;
        int contador = 0;
        for (String e : topicos) {
            if (e.length() < 3) {
                retorno = true;
                break;
            } else {
                contador += 1;
                if (contador > 4) {
                    retorno = true;
                }
            }
        }

        return retorno;
    }
    
    public static void verificaViabilidade_Aderencia(int valor, String mensagem) {
		if ( (valor < 1) || (valor > 5)) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}