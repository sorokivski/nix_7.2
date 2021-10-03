package CheapestPath;

import entity.City;

import java.sql.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class CommisVoyageur {

    static City[] cities;
    String url = "jdbc:postgresql://localhost:5432/unit10?user=postgres&password=pwrd&ssl=false";
    Connection con = null;

    public void lessCost() {
        Queue<String> locations = new ArrayDeque<>();
        try {
            con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM solutions");
            ResultSet rs = st.executeQuery("SELECT * FROM locations");
            while (rs.next()) {
                locations.add(rs.getString(2));
            }
            int numOfCities = locations.size();
            cities = new City[numOfCities];

            int[][] matrixOfCosts = new int[numOfCities][numOfCities];
            for (int i = 0; i < numOfCities; i++) {
                for (int j = 0; j < numOfCities; j++) {
                    if (i == j) matrixOfCosts[i][j] = 0;
                    else
                        matrixOfCosts[i][j] = 999999999;
                }
            }

            int id = 1, temp, minindex, min;
            int num = numOfCities;

            while (num != 0) {
                String name = locations.poll();
                cities[id - 1] = new City(id, name);

                ResultSet routes = st.executeQuery("SELECT * FROM routes");
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

            ResultSet problems = st.executeQuery("SELECT *FROM problems");
            while (problems.next()) {

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
                //System.out.println(" Cheaper cost is: " + d[second]);
                PreparedStatement pst = con.prepareStatement("INSERT into solutions (problem_id, cost) VALUES (?, ?)");
                pst.setInt(1, problems.getInt(1));
                pst.setInt(2, d[second]);
                pst.executeUpdate();
            }

            System.out.println("DATA WAS SUCCESSFULLY WRITTEN TO TABLE SOLUTIONS");

            con.close();
        } catch (SQLException sqlException) {
            System.out.println("Error of connection to database Postgres: " + sqlException.getMessage());
            System.out.println("Rollback the transaction and quit program");
            try {
                con.rollback();
            } catch (Exception e) {
            }
            System.exit(-1);
        }
    }
}

