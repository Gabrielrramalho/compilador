package com.mycompany.projeto_compilador.lexica;

import com.mycompany.projeto_compilador.lexica.Sym;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnalizadorLexico {

    public static void main(String[] args) {
        String codigoFonte = lerCodigoFonteDeArquivo("C:/Users/User/Desktop/projeto/Projeto_compilador/src/main/java/com/mycompany/projeto_compilador/lexica/a.txt");

        MeuAnalizadorLexico lexer = new MeuAnalizadorLexico(codigoFonte); // Crie uma instância do analisador léxico

        int token;
        do {
            token = lexer.next_token(); // Obtenha o próximo token
            System.out.println(token); // Exiba o token na tela (ou realize a ação desejada)
        } while (token != Sym.EOF); // Continue até encontrar o fim do arquivo (EOF)
    }

    private static String lerCodigoFonteDeArquivo(String caminhoArquivo) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
