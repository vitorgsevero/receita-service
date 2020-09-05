package com.vitorgsevero.io.receitaapi.csv;

import java.io.*;

/**
 * @author vitorgsevero<vitorgsevero@gmail.com>
 * Essa classe serve para fazer a leitura do arquivo .csv com os dados bancários
 */
public class LeitorCSV {

    public static File arquivo = new File("receita.csv");
    private static BufferedReader reader;

    public void readCSV() throws IOException {

        InputStream importa = new FileInputStream(arquivo);
        InputStreamReader input = new InputStreamReader(importa);
        reader = new BufferedReader(input);
        String linhacsv = reader.readLine();

        try {
            while (linhacsv != null) {

                System.out.println(linhacsv);
                linhacsv = reader.readLine();
            }
        } catch (FileNotFoundException arquivoNaoEncontrado) {
            throw new FileNotFoundException("arquivoNaoEncontrado");
        }

    }
}
