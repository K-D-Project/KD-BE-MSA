package com.example.ui.service;
import com.example.ui.model.component.SpaceUi;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Transactional
public interface SpaceUiService {

    Mono<SpaceUi> get(int id);
}
