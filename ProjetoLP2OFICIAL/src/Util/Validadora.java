package Util;

public class Validadora {

    public static void validaEntradaDescricao(String descricao) {
        if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Descricao nao pode ser nula ou vazia.");
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

    public static void validaMotivo(String motivo) {
        if (motivo == null || motivo.trim().equals("")) {
            throw new NullPointerException("Motivo nao pode ser nulo ou vazio.");
        }

    }

    public static void verificaCodigo(String codigo) {
        if (codigo == null || codigo.trim().equals("")){
            throw new NullPointerException("Codigo nao pode ser nulo ou vazio.");
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
}