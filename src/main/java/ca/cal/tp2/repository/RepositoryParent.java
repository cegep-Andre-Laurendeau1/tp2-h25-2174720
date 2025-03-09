package ca.cal.tp2.repository;

import java.sql.*;

public abstract class RepositoryParent {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:tp1;DB_CLOSE_DELAY=-1";
    static final String USER = "bibliotheque";
    static final String PASS = "";
    static Connection conn = null;

    static {
        // STEP 1: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE TABLE PREPOSE " +
                    "(userID INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " phoneNumber VARCHAR(255), " +
                    " email VARCHAR(255), " +
                    " PRIMARY KEY ( userID ))";
            statement.executeUpdate(sql);
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected <T> void executePreparedStatement(T t) {
        try(PreparedStatement preparedStatement = conn.prepareStatement(getSql());) {
            getPreparedStatementParameters(preparedStatement, t);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract String getSql();
    protected abstract <T> void getPreparedStatementParameters(PreparedStatement preparedStatement, T t) throws SQLException;

}
