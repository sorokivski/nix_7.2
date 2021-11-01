package controller;

import service.CsvMapper;

import java.util.List;
import java.util.Scanner;

public class UnitController {
    private static final Scanner in = new Scanner(System.in);
    private CsvMapper mapper = new CsvMapper();

    public void run() {

        switch (getChoicesFromOptions()) {
            case 1 -> {
                List<String> listOfPlaces = mapper.showAllRowsWithData();
                for (String s : listOfPlaces) {
                    System.out.println(s);
                }
            }
            default -> {
            }
        }
    }

    private int getChoicesFromOptions() {

        System.out.println(
                """
                        *** OPTIONS ***
                        1 - show all sights places
                        0 - EXIT
                        **** CHOSE OPTION TO PROCEED ****
                        """);
        return in.nextInt();
    }

}

