package com.mycompany.projeto_compilador.lexica;

import java_cup.runtime.Symbol;

public class MeuAnalizadorLexico {

    private final String codigoFonte;
    private int posicao;
    private int linha;
    private int coluna;

    public MeuAnalizadorLexico(String codigoFonte) {
        this.codigoFonte = codigoFonte;
        this.posicao = 0;
        this.linha = 1;
        this.coluna = 1;
    }

    public Symbol next_token() {
        // Ignorar caracteres de espaço em branco
        while (posicao < codigoFonte.length() && Character.isWhitespace(codigoFonte.charAt(posicao))) {
            if (codigoFonte.charAt(posicao) == '\n') {
                linha++;
                coluna = 1;
            } else {
                coluna++;
            }
            posicao++;
        }

        // Verificar se chegou ao fim do código-fonte
        if (posicao >= codigoFonte.length()) {
            return new Symbol(Sym.EOF);
        }

        // Implementar a lógica para identificar e retornar os diferentes tipos de tokens

        // Exemplo de identificação de token para um identificador
        if (Character.isLetter(codigoFonte.charAt(posicao))) {
            int inicio = posicao;
            posicao++;
            coluna++;

            // Avançar até o final do identificador
            while (posicao < codigoFonte.length() && Character.isLetterOrDigit(codigoFonte.charAt(posicao))) {
                posicao++;
                coluna++;
            }

            String lexema = codigoFonte.substring(inicio, posicao);
            return new Symbol(Sym.IDENTIFIER, lexema);

        // Exemplo de identificação de token para um número inteiro
        } else if (Character.isDigit(codigoFonte.charAt(posicao))) {
            int inicio = posicao;
            posicao++;
            coluna++;

            // Avançar até o final do número inteiro
            while (posicao < codigoFonte.length() && Character.isDigit(codigoFonte.charAt(posicao))) {
                posicao++;
                coluna++;
            }

            String lexema = codigoFonte.substring(inicio, posicao);
            return new Symbol(Sym.INT_LITERAL, lexema);

        // Implementar a identificação de outros tipos de tokens (operadores, símbolos, literais, etc.)

        } else {
            // Caractere desconhecido, avançar para o próximo
            posicao++;
            coluna++;
            return next_token(); // Chamar recursivamente para obter o próximo token
        }
    }
}
