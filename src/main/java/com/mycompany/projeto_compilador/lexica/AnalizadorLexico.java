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

public class AnalizadorLexico {

    public static void main(String[] args) {
        String codigoFonte = lerCodigoFonteDeArquivo("caminho/do/arquivo.txt"); // Substitua pelo caminho do seu arquivo

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

