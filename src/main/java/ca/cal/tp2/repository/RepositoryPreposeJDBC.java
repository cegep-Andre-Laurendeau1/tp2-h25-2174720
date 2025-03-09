package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Prepose;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryPreposeJDBC extends RepositoryParent implements RepositoryPrepose {

    public void save(Prepose client) {
        executePreparedStatement(client);
    }

    @Override
    public String getSql() {
        return "INSERT INTO PREPOSE VALUES(?,?,?,?)";
    }

    @Override
    public <T> void getPreparedStatementParameters(PreparedStatement preparedStatement, T t) throws SQLException {
        Prepose prepose = (Prepose) t;
        preparedStatement.setLong(1, prepose.getUserID());
        preparedStatement.setString(2, prepose.getName());
        preparedStatement.setString(3, prepose.getPhoneNumber());
        preparedStatement.setString(4, prepose.getEmail());
    }



    public Prepose getPrepose(int id) {
        Prepose prepose = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Prepose WHERE userID = ? ")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
//                prepose = new Prepose(resultSet.getInt("userID"),
//                        resultSet.getString("name"),
//                        resultSet.getString("phoneNumber"),
//                        resultSet.getString("email"));
            }
            return prepose;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
