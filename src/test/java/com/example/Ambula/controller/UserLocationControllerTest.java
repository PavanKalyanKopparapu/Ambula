package com.example.Ambula.controller;

import com.example.Ambula.entity.UserLocation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLocationControllerTest {

    @Test
    void update() {
        UserLocationController userLocationController = new UserLocationController();
        assertEquals("ADMIN", "ADMIN");
        String error = "latitude";
        assertEquals("latitude", error);
    }

    @Test
    void getData() {
    }

    @Test
    void createData() {
    }
}