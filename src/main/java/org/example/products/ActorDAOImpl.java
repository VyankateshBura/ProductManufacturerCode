package org.example.products;

import org.example.products.Actor;
import org.example.products.ActorDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAOImpl implements ActorDAO{
    Connection connection;
    public ActorDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","rps@123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int add(Actor actor) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "insert into actor (first_name,last_name) values (?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,actor.getActorFirstName());
            preparedStatement.setString(2,actor.getActorLastName());
            int res = preparedStatement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Actor> view() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from actor");
            List<Actor> actors = new ArrayList<>();
            while(rs.next()){
                actors.add(new Actor(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
            return actors;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public int delete(int actorId) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "delete from actor where actor_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,actorId);
            preparedStatement.execute();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Actor actor) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "update actor set first_name = ?,last_name = ? where actor_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,actor.getActorFirstName());
            preparedStatement.setString(2,actor.getActorLastName());
            preparedStatement.setInt(3,actor.getActorId());
            int res = preparedStatement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}