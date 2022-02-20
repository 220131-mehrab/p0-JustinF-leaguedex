package com.revature.leaguedex.repository;

import com.revature.leaguedex.domain.Champion;

import java.sql.*;
import java.util.List;

public class SQLDexRepository implements DexRepository{

    @Override
    public Champion getChampion(String name) {
        Champion result = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc.h2.-/test", "sa", "");
            String query = "select * from champion where name = " + name + "'";
            Statement statement = conn.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                result = Champion.of()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .type1(new Types(2, resultSet.getString("type1")))
                        .HP(resultSet.getString("HP"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Champion> getPocketChampions() {
        return null;
    }
}
