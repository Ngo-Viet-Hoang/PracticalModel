package com.example.practicalmodel.model;

import com.example.practicalmodel.entity.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlPhoneModelTest {
    private PhoneModel phoneModel;

    @BeforeEach
    void setUp() {
        phoneModel = new MySqlPhoneModel();
    }

    @Test
    void save() {
        Phone phone = new Phone("apple1","Apple",20000,"dien thoai apple");
        assertEquals(true, phoneModel.save(phone));
    }

    @Test
    void findAll() {
        MySqlPhoneModel mySqlPhoneModel = new MySqlPhoneModel();
        List<Phone> list = mySqlPhoneModel.findAll() ;
        assertNotEquals(0, list.size());
    }
}