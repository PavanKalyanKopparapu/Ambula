package com.example.Ambula.service;

import com.example.Ambula.entity.UserLocation;
import com.example.Ambula.repository.UserLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLocationService {

    @Autowired
    UserLocationRepository userLocationRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;


    /**
     * @param userRole to verify between Admin or Reader.
     * @return It will return Success in ResponseBody.
     */
    public String createLocation(String userRole) {
        if (userRole.equals("ADMIN")) {
            jdbcTemplate.execute("CREATE TABLE user_location " + "(user_location_id INT AUTO_INCREMENT PRIMARY KEY," + "name VARCHAR(64)," + "latitude double," + "longitude double);");
            return "Created successfully";
        } else {
            return "Permission denied";
        }
    }

    /**
     * @param number it's N(number) taken in RequestBody.
     * @return It will return Success in ResponseBody.
     */
    public List<UserLocation> getData(Integer number) {
        String query = "SELECT TOP ? * FROM USER_LOCATION ORDER BY LATITUDE,LONGITUDE";
        List<UserLocation> userLocations = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(UserLocation.class), number);
        return userLocations;
    }


    /**
     * @param userRole  to verify between Admin or Reader.
     * @param id        User ID to Update Record.
     * @param latitude  New Latitude will be given in RequestBody by Admin.
     * @param longitude New Longitude will be given in RequestBody by Admin.
     * @return It will return Success in ResponseBody.
     */
    public String updateLocation(String userRole, Integer id, Double latitude, Double longitude) {
        if (userRole.equals("ADMIN")) {
            UserLocation userLocation = userLocationRepository.findById(id).get();
            userLocation.setLatitude(latitude);
            userLocation.setLongitude(longitude);
            userLocationRepository.save(userLocation);
            return "Updated successfully";
        } else {
            return "Permission denied";
        }
    }

}
