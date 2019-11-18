package Util;


import projeto.pesquisadores.Pesquisador;
import projeto.pesquisadores.PesquisadorSimples;

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
            if (partesEmail.length == 1) {
                throw new IllegalArgumentException(msg);
            }
            for (String s : partesEmail) {
                if (s.equals("")) {
                    throw new IllegalArgumentException(msg);
                }
            }
        } else {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void validaFoto(String fotoURL, String msg) {
        if (fotoURL.length() < 7) {
            throw new IllegalArgumentException(msg);
        } else if (!(fotoURL.substring(0, 8).equals("https://") || fotoURL.substring(0, 7).equals("http://"))) {
            throw new IllegalArgumentException(msg);
        }
    }


    public static void validaAtributo(String atributo, String msg) {
        if (!atributo.equals("NOME") && (!atributo.equals("EMAIL")) && (!atributo.equals("FUNCAO")) && !atributo.equals("FOTO") && !atributo.equals("BIOGRAFIA") && !atributo.equals("DATA")
                && !atributo.equals("FORMACAO") && !atributo.equals("UNIDADE") && !atributo.equals("SEMESTRE") && !atributo.equals("IEA")) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void verificaPesquisador(boolean valor, String msg) {
        if (valor == false) {
            throw new NullPointerException(msg);
        }
    }

    public static void verificaPesquisadorAtivo(boolean valor, String msg) {
        if (valor == true) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void verificaViabilidade_Aderencia(int valor, String mensagem) {
        if ((valor < 1) || (valor > 5)) {
            throw new IllegalArgumentException(mensagem);
        }

    }

    public static void validaAtividadeChecaOpcoesNivelderisco(String valor, String msg) {
        if (!valor.equals("BAIXO") && !valor.equals("MEDIO") && !valor.equals("ALTO")) {
            throw new IllegalArgumentException(msg);
        }
    }


        public static void verificaSeNumeroNegativo ( int valorNumerico, String msg){
            if (valorNumerico <= 0) {
                throw new IllegalArgumentException(msg);
            }
        }
        public static void verificaSeNumeroMaiorQueResultados ( int v1, int v2, String msg){
            if (v1 > v2) {
                throw new IllegalArgumentException(msg);
            }
        }
        public static void validaResultadoBusca (boolean valor1, String msg){
            if (valor1 == false) {
                throw new IllegalArgumentException(msg);
            }
        }

    public static void verificaFormatoData(String data, String msg) {
        int dias = 0;
        int mes = 0;
        int ano = 0;

        if (data.length() != 10) {
            throw new IllegalArgumentException(msg);
        } else if (!data.substring(2, 3).equals("/") || !data.substring(5, 6).equals("/")) {
            throw new IllegalArgumentException(msg);
        } else {
            dias = Integer.parseInt(data.substring(0, 2));
            mes = Integer.parseInt(data.substring(3, 5));
            ano = Integer.parseInt(data.substring(6, 10));
            if (dias <= 0 || dias > 31) {
                throw new IllegalArgumentException(msg);
            } else if (mes <= 0 || mes > 12) {
                throw new IllegalArgumentException(msg);
            } else if (ano < 0) {
                throw new IllegalArgumentException(msg);
            }
        }
    }
    
    public static void verificaEstrategia(String estrategia,String msg){
        if (!estrategia.equals("MENOS_PENDENCIAS") && !estrategia.equals("MAIOR_RISCO") && !estrategia.equals("MAIS_ANTIGA") && !estrategia.equals("MAIOR_DURACAO")){
            throw new IllegalArgumentException(msg);
        }
    }
}



