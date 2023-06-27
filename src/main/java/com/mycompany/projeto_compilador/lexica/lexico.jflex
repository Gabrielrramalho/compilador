import java_cup.runtime.Symbol;

%%
%class MeuAnalizadorLexico

%{
  // Importações, declarações de variáveis ou código Java adicional podem ser colocados aqui
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

{Identifier}    { return token(sym.IDENTIFIER); }
{IntegerLiteral} { return token(sym.INT_LITERAL); }
{RealLiteral}   { return token(sym.REAL_LITERAL); }

":="            { return token(sym.ASSIGN); }

"+"             { return token(sym.PLUS); }
"-"             { return token(sym.MINUS); }
"*"             { return token(sym.MULT); }
"/"             { return token(sym.DIV); }
"="             { return token(sym.EQUALS); }
"<"             { return token(sym.LESS_THAN); }
">"             { return token(sym.GREATER_THAN); }
"<="            { return token(sym.LESS_THAN_EQUALS); }
">="            { return token(sym.GREATER_THAN_EQUALS); }
"<>"            { return token(sym.NOT_EQUALS); }
":"             { return token(sym.COLON); }
";"             { return token(sym.SEMICOLON); }
"("             { return token(sym.LEFT_PAREN); }
")"             { return token(sym.RIGHT_PAREN); }
"["             { return token(sym.LEFT_BRACKET); }
"]"             { return token(sym.RIGHT_BRACKET); }
","             { return token(sym.COMMA); }
"."             { return token(sym.DOT); }

.               { /* Ignorar outros caracteres inválidos */ }

%%

// Implementação adicional de métodos e lógica do analisador léxico em Java, se necessário
