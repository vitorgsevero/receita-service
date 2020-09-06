package com.vitorgsevero.io.receitaapi.csv;

import java.io.*;

/**
 * @author vitorgsevero<vitorgsevero@gmail.com>
 * Essa classe serve para fazer a leitura do arquivo .csv com os dados bancários
 */
public class LeitorCSV {

    public File file = new File("\\receita.csv");
    private BufferedReader reader = null;
    private String line = "";
    private String csvSeparator = ";";

    public void readCSV() throws IOException {

        try {

            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null){

                String[] receita = line.split(csvSeparator);

                System.out.println("entrou aqui");

                System.out.println(receita);

            }
        } catch (FileNotFoundException e){
            e.getLocalizedMessage();
        }
    }
}
