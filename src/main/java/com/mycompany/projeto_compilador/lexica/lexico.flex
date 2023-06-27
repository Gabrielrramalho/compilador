import java_cup.runtime.Symbol;

%%
%class MeuAnalizadorLexico

%{
  // Importações, declarações de variáveis ou código Java adicional podem ser colocados aqui
%}

// Declaração dos símbolos
%{
public static final int IDENTIFIER = 1;
public static final int INT_LITERAL = 2;
public static final int REAL_LITERAL = 3;
public static final int ASSIGN = 4;
public static final int PLUS = 5;
public static final int MINUS = 6;
public static final int MULT = 7;
public static final int DIV = 8;
public static final int EQUALS = 9;
public static final int LESS_THAN = 10;
public static final int GREATER_THAN = 11;
public static final int LESS_THAN_EQUALS = 12;
public static final int GREATER_THAN_EQUALS = 13;
public static final int NOT_EQUALS = 14;
public static final int COLON = 15;
public static final int SEMICOLON = 16;
public static final int LEFT_PAREN = 17;
public static final int RIGHT_PAREN = 18;
public static final int LEFT_BRACKET = 19;
public static final int RIGHT_BRACKET = 20;
public static final int COMMA = 21;
public static final int DOT = 22;
%}

// Palavras-chave
%public
%final
%unicode
%type Token

// Definição de expressões regulares e regras léxicas
%{

// Regras léxicas
private Symbol token(int type) {
  return new Symbol(type);
}

%}

// Caracteres ignorados (espaços em branco, tabulações, quebras de linha)
Whitespace = [\ \t\r\n]+

// Regras léxicas
Identifier = [a-zA-Z][_a-zA-Z0-9]*
IntegerLiteral = [0-9]+
RealLiteral = [0-9]+\.[0-9]+([eE][-+]?[0-9]+)?

%%

// Regras léxicas adicionais
{Whitespace}    { /* Ignorar caracteres de espaço em branco */ }

{Identifier}    { return token(IDENTIFIER); }
{IntegerLiteral} { return token(INT_LITERAL); }
{RealLiteral}   { return token(REAL_LITERAL); }

":="            { return token(ASSIGN); }

"+"             { return token(PLUS); }
"-"             { return token(MINUS); }
"*"             { return token(MULT); }
"/"             { return token(DIV); }
"="             { return token(EQUALS); }
"<"             { return token(LESS_THAN); }
">"             { return token(GREATER_THAN); }
"<="            { return token(LESS_THAN_EQUALS); }
">="            { return token(GREATER_THAN_EQUALS); }
"<>"            { return token(NOT_EQUALS); }
":"             { return token(COLON); }
";"             { return token(SEMICOLON); }
"("             { return token(LEFT_PAREN); }
")"             { return token(RIGHT_PAREN); }
"["             { return token(LEFT_BRACKET); }
"]"             { return token(RIGHT_BRACKET); }
","             { return token(COMMA); }
"."             { return token(DOT); }

.               { /* Ignorar outros caracteres inválidos */ }
