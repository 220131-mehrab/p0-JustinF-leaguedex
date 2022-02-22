package com.revature.leaguedex.repository;

import com.revature.leaguedex.domain.Champion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLDexRepository implements DexRepository{
    private String selectAll = "Select pokemon.id, name, type1, type2 from pokemon, types where pokemon.type=types.id";
    private Connection connection;

    public SQLDexRepository(Connection connection) {
        this.connection  = connection;
    }

    @Override
    public Champion getChampion(String name) {
        Champion result = null;
        try {
            String query = selectAll + " and name = '"+ name + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                result = Champion.of()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .type1(resultSet.getString("type1"))
                        .HP(resultSet.getString("hp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Champion> getPocketChampions() {
        List<Champion> results = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            statement.execute(selectAll);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Champion result = Champion.of()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .type1(resultSet.getString("type1"))
                        .HP(resultSet.getString("hp"));
                results.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}