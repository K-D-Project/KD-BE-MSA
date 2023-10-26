package com.example.ui.repository;

import com.example.ui.model.component.SpaceUi;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Test extends MongoRepository<SpaceUi,String> {

    SpaceUi findByUuid(int id);
}
