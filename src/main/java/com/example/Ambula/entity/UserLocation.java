package com.example.Ambula.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_location")
public class UserLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userLocationId;

    @Column(name = "name")
    String name;

    @Column(name = "latitude")
    Double latitude;

    @Column(name = "longitude")
    Double longitude;
}
