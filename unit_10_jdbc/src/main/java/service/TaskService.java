package service;

import java.sql.Connection;
import java.sql.SQLException;

public class TaskService {

    public Connection connectToDB() throws SQLException {
        return new ConnectionService().createConnection();
    }

    public void calculateLessCost() {
        Connection con = null;
        try {
            con = connectToDB();
            new ConnectionService().executeStatement(con);
        } catch (SQLException e) {
            System.out.println("Error of connection to database or creation of the statement: " + e.getMessage());
            System.out.println("Rollback the transaction and quit program");
            try {
                con.rollback();
            } catch (Exception ex) {
            }
        }
    }
}
