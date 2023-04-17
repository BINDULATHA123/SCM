package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DeviceData;

@Repository
public interface DeviceDataRepository extends MongoRepository<DeviceData, String> {

}
