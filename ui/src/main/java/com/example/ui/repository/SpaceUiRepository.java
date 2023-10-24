package com.example.ui.repository;

import com.example.ui.model.component.SpaceUi;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SpaceUiRepository extends ReactiveMongoRepository<SpaceUi,String> {
    Mono<SpaceUi> findByUuid(int uuid);


}
