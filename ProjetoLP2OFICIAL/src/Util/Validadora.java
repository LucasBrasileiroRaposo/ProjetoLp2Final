package Util;


public class Validadora {
    public static void verificaValorNullVazio(String valor, String msg) {
        if (valor == null) {
            throw new NullPointerException(msg);
        } else if (valor.trim().equals("")) {
            throw new IllegalArgumentException(msg);
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

    public static void validaEmail(String email, String msg) {
        String partesEmail[] = new String[2];
        partesEmail[1] = "";
        if (email.contains("@")) {
            partesEmail = email.split("@");
            if(partesEmail.length == 1){
                throw new IllegalArgumentException(msg);
            }
            for(String s: partesEmail){
                if(s.equals("")) {
                    throw new IllegalArgumentException(msg);
                }
            }
        }else{
            throw new IllegalArgumentException(msg);
        }
    }
        public static void validaFoto (String fotoURL, String msg){
        if(fotoURL.length() < 7){
            throw new IllegalArgumentException(msg);
        }
         else if (!(fotoURL.substring(0, 8).equals("https://") || fotoURL.substring(0, 7).equals("http://"))) {
                throw new IllegalArgumentException(msg);}
        }


        public static void validaAtributo (String atributo, String msg){
            if (!(atributo.equals("NOME") || atributo.equals("EMAIL") || atributo.equals("FUNCAO") || atributo.equals("FOTO") || atributo.equals("BIOGRAFIA"))){
                throw new IllegalArgumentException(msg);
            }
    }
        public static void verificaPesquisador(boolean valor,String msg){
        if(valor == false){
            throw new NullPointerException(msg);
        }
    }
    public static void verificaPesquisadorAtivo(boolean valor, String msg){
        if(valor == true){
            throw new IllegalArgumentException(msg);
        }
    }

	public static void verificaViabilidade_Aderencia(int valor, String mensagem) {
		if ( (valor < 1) || (valor > 5)) {
			throw new IllegalArgumentException(mensagem);
		}
		
	}
	
	public static void validaAtividadeChecaOpcoesNivelderisco(String valor, String msg){
	       if (!valor.equals("BAIXO") && !valor.equals("MEDIO") && !valor.equals("ALTO")){
	           throw new IllegalArgumentException(msg);
	       }
	   }
	
	

}



