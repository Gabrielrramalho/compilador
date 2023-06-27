package com.mycompany.projeto_compilador.lexica;

public class Sym {
    public static final int EOF = 0;
    public static final int IDENTIFIER = 1;
    public static final int INT_LITERAL = 2;
    public static final int PLUS = 3;
    public static final int MINUS = 4;
    public static final int MULT = 5;
    public static final int DIV = 6;
    public static final int EQUALS = 7;
    public static final int LESS_THAN = 8;
    public static final int GREATER_THAN = 9;
    public static final int LESS_THAN_EQUALS = 10;
    public static final int GREATER_THAN_EQUALS = 11;
    public static final int NOT_EQUALS = 12;
    public static final int COLON = 13;
    public static final int SEMICOLON = 14;
    public static final int LEFT_PAREN = 15;
    public static final int RIGHT_PAREN = 16;
    public static final int LEFT_BRACKET = 17;
    public static final int RIGHT_BRACKET = 18;
    public static final int COMMA = 19;
    public static final int DOT = 20;
    public static final int ASSIGN = 21;
    // Adicione os demais tipos de símbolos utilizados pelo seu analisador

    private Sym() {
    }
}