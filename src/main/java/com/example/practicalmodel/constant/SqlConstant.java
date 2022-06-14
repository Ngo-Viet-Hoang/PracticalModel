package com.example.practicalmodel.constant;

public class SqlConstant {
    public static final String PHONE_INSERT = "INSERT INTO phones (name, brand, price, description, createdAt, updatedAt,createdBy, updatedBy) values (?,?,?,?,?,?,?,?)";
    public static final String PHONE_UPDATE = "UPDATE phones SET name = ?, brand = ?, price = ?, description = ?, udpatedAt = ?, updatedBy = ? where id = ?";
    public static final String PHONE_DELETE = "DELETE FROM categories WHERE id = ?;";
    public static final String PHONE_FIND_BY_ID = "SELECT * FROM phones WHERE id = ?";
    public static final String PHONE_FIND_ALL = "SELECT * FROM phones ";

}
