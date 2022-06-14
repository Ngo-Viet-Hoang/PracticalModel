package com.example.practicalmodel.model;

import com.example.practicalmodel.entity.Phone;

import java.util.List;

public interface PhoneModel {
    boolean save(Phone phone);
    boolean update(int id, Phone phone);
    boolean delete (int id);
    Phone findById(int id);
    List<Phone> findAll();

}
