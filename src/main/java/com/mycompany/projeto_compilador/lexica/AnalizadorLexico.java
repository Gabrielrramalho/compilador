/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.projeto_compilador.lexica;

/**
 *
 * @author User
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java_cup.runtime.Symbol;
import java_cup.sym;

public class AnalizadorLexico {

    public static void main(String[] args) {
        String codigoFonte = lerCodigoFonteDeArquivo("C:/Users/User/Desktop/projeto/Projeto_compilador/src/main/java/com/mycompany/projeto_compilador/lexica/lexico.jflex"); 

        MeuAnalizadorLexico lexer = new MeuAnalizadorLexico(codigoFonte); // Crie uma instância do analisador léxico

        Symbol token;
        do {
            token = lexer.next_token(); // Obtenha o próximo token
            System.out.println(token.toString()); // Exiba o token na tela (ou realize a ação desejada)
        } while (token.sym != sym.EOF); // Continue até encontrar o fim do arquivo (EOF)
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

