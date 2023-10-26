package com.example.ui.service;
import com.example.ui.model.component.SpaceUi;
import com.example.ui.model.response.UiDomainDto;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Transactional
public interface SpaceUiService {

    Mono<UiDomainDto> getAsync(int id);

    UiDomainDto getSync(int id);
}
