package repository.impl;

import domain.User;
import repository.UserRepository;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usha on 4/7/2017.
 */
public class UserRepositoryImpl implements UserRepository {

    public User findUser(String name, String password) {
        User user = null;

        String query = "select * from user where name=? and password=?";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(query);
        try {
            pstm.setString(1, name);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> findAll() {
        List<User> userList = new ArrayList<User>();
        String query = "select * from user";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(query);

        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public Integer save(User user) {
        String saveQuery = "Insert into user(name,password,role) values (?,?,?)";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(saveQuery);

        try {
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getRole());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void delete(int id) {
        String query = "delete from user where id = ?";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(query);
        try {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int update(User user) {
        String query = "update user set name = ?, password = ? , role= ? where id = ?";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(query);
        int updatedRowId = 0;
        try {
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getPassword());
            pstm.setString(3, user.getRole());
            pstm.setInt(4,user.getId());
            updatedRowId = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRowId;
    }

    public User findUserById(int id) {
        User user = null;

        String query = "select * from user where id=?";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(query);
        try {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
