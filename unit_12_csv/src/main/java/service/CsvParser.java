package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvParser {


    static int NUMBER_OF_COLUMNS = 5;
    static String linesFromFile;
    public int numOfRows;
    String proper = "/file.csv";

    public void loadFileAsString() {

        try (
                InputStream inputStream = this.getClass().getResourceAsStream(proper);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                Stream<String> lines = bufferedReader.lines()

        ) {
            linesFromFile = lines.collect(Collectors.joining("\n"));

        } catch (IOException | NullPointerException e) {
            System.out.println("error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<String[]> ParseSightsCsv() {

        loadFileAsString();

        String[] fileLines;
        fileLines = linesFromFile.split("\n");
        List<String[]> dataArrays = new ArrayList<>();
        numOfRows = fileLines.length - 1;

        for (int i = 1; i < numOfRows; i++) {

            String[] components = {"id=", "name=", "country=", "coordinates=", "century="};
            String[] splitedText = fileLines[i].split(",");
            String[] columnList = new String[NUMBER_OF_COLUMNS];

            for (int j = 0; j < columnList.length; j++) {
                columnList[j] = components[j] + splitedText[j];
            }

            dataArrays.add(columnList);
        }

        return dataArrays;
    }
}
