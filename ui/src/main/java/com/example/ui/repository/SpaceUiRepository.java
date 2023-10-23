package com.example.ui.repository;

import com.example.ui.model.component.SpaceUi;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpaceUiRepository extends MongoRepository<SpaceUi,String> {
    public SpaceUi findByUuid(int uuid);

    public SpaceUi findByType(String type);
}
