package com.mycompany.projeto_compilador.lexica;

import com.mycompany.projeto_compilador.lexica.Sym;

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

    public int next_token() {
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
            return Sym.EOF;
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
            // Substitua Sym.IDENTIFIER pelo valor correspondente ao identificador
            return Sym.IDENTIFIER;

        // Identificação de token para um número inteiro
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
            int valor = Integer.parseInt(lexema); // Converter o lexema para um valor inteiro
            // Substitua Sym.INT_LITERAL pelo valor correspondente ao número inteiro
            return Sym.INT_LITERAL;

        // Identificação de token para operadores e símbolos
        } else {
            char currentChar = codigoFonte.charAt(posicao);
            posicao++;
            coluna++;

            switch (currentChar) {
                case ':':
                    // Verificar se é o operador de atribuição :=
                    if (posicao < codigoFonte.length() && codigoFonte.charAt(posicao) == '=') {
                        posicao++;
                        coluna++;
                        // Substitua Sym.ASSIGN pelo valor correspondente ao operador de atribuição
                        return Sym.ASSIGN;
                    } else {
                        // Substitua Sym.COLON pelo valor correspondente ao caractere ':'
                        return Sym.COLON;
                    }
                case '+':
                    // Substitua Sym.PLUS pelo valor correspondente ao caractere '+'
                    return Sym.PLUS;
                case '-':
                    // Substitua Sym.MINUS pelo valor correspondente ao caractere '-'
                    return Sym.MINUS;
                case '*':
                    // Substitua Sym.MULT pelo valor correspondente ao caractere '*'
                    return Sym.MULT;
                case '/':
                    // Substitua Sym.DIV pelo valor correspondente ao caractere '/'
                    return Sym.DIV;
                // Implemente a identificação de outros operadores e símbolos

                default:
                    // Caractere desconhecido, avançar para o próximo
                    return next_token(); // Chamar recursivamente para obter o próximo token
            }
        }
    }
}
