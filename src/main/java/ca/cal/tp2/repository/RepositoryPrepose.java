package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Prepose;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface RepositoryPrepose {

    String getSql();
    <T> void getPreparedStatementParameters(PreparedStatement preparedStatement, T t) throws SQLException;
    Prepose getPrepose(int id);
}
