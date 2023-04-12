package com.example.Ambula.controller;

import com.example.Ambula.entity.UserLocation;
import com.example.Ambula.service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserLocationController {

    @Autowired
    UserLocationService userLocationService;


    /**
     * @param userRole  to verify between Admin or Reader.
     * @param id        User ID to Update Record.
     * @param latitude  New Latitude will be given in RequestBody by Admin.
     * @param longitude New Longitude will be given in RequestBody by Admin.
     * @return It will return Success in ResponseBody.
     */
    @RequestMapping("/update_data")
    public String update(@RequestHeader("user_role") String userRole, @RequestParam("id") Integer id, @RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude) {
        return userLocationService.updateLocation(userRole, id, latitude, longitude);
    }


    /**
     * @param number it's N(number) taken in RequestBody.
     * @return It will return Success in ResponseBody.
     */
    @RequestMapping("/get_data")
    public List<UserLocation> getData(@RequestParam("number") Integer number) {
        return userLocationService.getData(number);
    }

    /**
     * @param userRole to verify between Admin or Reader.
     * @return It will return Success in ResponseBody.
     */
    @RequestMapping("/create_data")
    public String createData(@RequestHeader("user_role") String userRole) {
        return userLocationService.createLocation(userRole);
    }
}
