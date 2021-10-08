package algorithm;

import entity.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Queue;

public class CommisVoyageur {

    City[] cities;
    int[][] matrixOfCosts;
    int numOfCities;

    public int algoDejkstra(ResultSet problems) throws SQLException {
        int temp, minindex, min;

        int begin_index = problems.getInt(2) - 1;
        int second = problems.getInt(3) - 1;

        int[] d = new int[numOfCities];
        int[] v = new int[numOfCities];

        for (int i = 0; i < numOfCities; i++) {
            d[i] = 999999999;
            v[i] = 1;
        }
        d[begin_index] = 0;
        do {
            minindex = 999999999;
            min = 999999999;
            for (int i = 0; i < numOfCities; i++) {
                if ((v[i] == 1) && (d[i] < min)) {
                    min = d[i];
                    minindex = i;
                }
            }

            if (minindex != 999999999) {
                for (int i = 0; i < numOfCities; i++) {
                    if (matrixOfCosts[minindex][i] > 0) {
                        temp = min + matrixOfCosts[minindex][i];
                        if (temp < d[i]) d[i] = temp;
                    }
                }
                v[minindex] = 0;
            }
        } while (minindex < 999999999);
        return d[second];
    }

    public void fulfillMatrixWithDefaultValues() {
        cities = new City[numOfCities];

        matrixOfCosts = new int[numOfCities][numOfCities];
        for (int i = 0; i < numOfCities; i++) {
            for (int j = 0; j < numOfCities; j++) {
                if (i == j) matrixOfCosts[i][j] = 0;
                else
                    matrixOfCosts[i][j] = 999999999;
            }
        }
    }

    public void lessCost(Queue<String> locations, ResultSet routes) throws SQLException {

        numOfCities = locations.size();
        fulfillMatrixWithDefaultValues();

        int id = 1;
        int num = numOfCities;

        while (num != 0) {
            String name = locations.poll();
            cities[id - 1] = new City(id, name);

            while (routes.next()) {
                // for all relations
                int i = routes.getInt(2);
                int id1 = routes.getInt(3);
                int cost = routes.getInt(4);

                matrixOfCosts[i - 1][id1 - 1] = cost;
            }
            num--;
            id++;
        }
    }

    public int cheapestCost(ResultSet problems) throws SQLException {
        return algoDejkstra(problems);
    }
}

