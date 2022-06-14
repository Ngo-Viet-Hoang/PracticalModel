package com.example.practicalmodel.model;

import com.example.practicalmodel.constant.SqlConstant;
import com.example.practicalmodel.entity.Phone;
import com.example.practicalmodel.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlPhoneModel implements PhoneModel {
    @Override
    public boolean save(Phone phone) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PHONE_INSERT);
            preparedStatement.setString(1,phone.getName());
            preparedStatement.setString(2, phone.getBrand());
            preparedStatement.setDouble(3, phone.getPrice());
            preparedStatement.setString(4, phone.getDescription());
            preparedStatement.setString(5, phone.getCreatedAt().toString());
            preparedStatement.setString(6, phone.getUpdatedAt().toString());
            preparedStatement.setInt(7, phone.getCreatedBy());
            preparedStatement.setInt(8, phone.getUpdatedBy());

            return preparedStatement.executeUpdate() >0;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Phone phone) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PHONE_UPDATE);
            preparedStatement.setString(1,phone.getName());
            preparedStatement.setString(2, phone.getBrand());
            preparedStatement.setDouble(3, phone.getPrice());
            preparedStatement.setString(4, phone.getDescription());
            preparedStatement.setString(5, phone.getUpdatedAt().toString());
            preparedStatement.setInt(6, phone.getUpdatedBy());

            return preparedStatement.executeUpdate() >0;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PHONE_DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Phone findById(int id) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PHONE_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                Double price = rs.getDouble("price");
                String description = rs.getString("description");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if(rs.getTimestamp("deletedAt") != null) {
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                int createdBy = rs.getInt("createdBy");
                int updatedBy = rs.getInt("updatedBy");
                int deletedBy = rs.getInt("deletedBy");
                Phone phone = new Phone(id,name, brand, price, description,createdAt, updatedAt, deletedAt, createdBy, updatedBy,deletedBy);
                return phone;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Phone> findAll() {
        List<Phone> phones = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PHONE_FIND_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                Double price = rs.getDouble("price");
                String description = rs.getString("description");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if(rs.getTimestamp("deletedAt") != null) {
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                int createdBy = rs.getInt("createdBy");
                int updatedBy = rs.getInt("updatedBy");
                int deletedBy = rs.getInt("deletedBy");
                Phone phone = new Phone(id,name, brand, price, description,createdAt, updatedAt, deletedAt, createdBy, updatedBy,deletedBy);
                phones.add(phone);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return phones;
    }
}
