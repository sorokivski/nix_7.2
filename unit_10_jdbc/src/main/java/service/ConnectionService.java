package service;

import algorithm.CommisVoyageur;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.*;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Queue;

    public class ConnectionService {

        CommisVoyageur commisVoyageur;

        public Connection createConnection() throws SQLException {

            Properties properties = new Properties();
            try (InputStream input = service.ConnectionService.class.getResourceAsStream("/jdbc.properties")) {
                properties.load(input);
                return DriverManager.getConnection(properties.getProperty("url"));
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        public void executeStatement(Connection con) throws SQLException {

            Statement st = con.createStatement();
            Queue<String> locations = new ArrayDeque<>();
            commisVoyageur = new CommisVoyageur();

            ResultSet rs = st.executeQuery("SELECT * FROM locations");

            while (rs.next()) {
                locations.add(rs.getString(2));
            }

            Statement st1 = con.createStatement();
            ResultSet problems = st1.executeQuery("SELECT *FROM problems LEFT JOIN solutions ON problems.id=solutions.problem_id");
            commisVoyageur.lessCost(locations, st.executeQuery("SELECT * FROM routes"));

            while (problems.next()) {
                int result = commisVoyageur.cheapestCost(problems);
                PreparedStatement pst = con.prepareStatement("INSERT into solutions (problem_id, cost) VALUES (?, ?) ON CONFLICT DO NOTHING");
                pst.setInt(1, problems.getInt(1));
                pst.setInt(2, result);
                pst.addBatch();
                pst.executeBatch();
            }

            System.out.println("DATA WAS SUCCESSFULLY WRITTEN TO TABLE SOLUTIONS");
        }

    }

