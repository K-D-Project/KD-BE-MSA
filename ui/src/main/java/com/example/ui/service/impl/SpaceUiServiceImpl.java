package com.example.ui.service.impl;
import com.example.ui.model.component.SpaceUi;
import com.example.ui.model.response.SpaceDto;
import com.example.ui.model.response.UiDomainDto;
import com.example.ui.repository.SpaceUiRepository;
import com.example.ui.service.SpaceUiService;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SpaceUiServiceImpl implements SpaceUiService {

    private final SpaceUiRepository spaceUiRepository;
    private final WebClient client;
    private final ObjectMapper mapper;
    @Override
    public Mono<UiDomainDto> getAsync(int id) {
        Mono<SpaceUi> spaceUi = spaceUiRepository.findByUuid(id);
        Mono<EntityModel<SpaceDto>> spaceDto = client.get()
                .uri("http://localhost:9035/spaces/3")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<EntityModel<SpaceDto>>(){});

        return Mono.zip(spaceUi, spaceDto)
                .map(tuple -> {
                    return UiDomainDto.builder()
                            .spaceUi(tuple.getT1())
                            .domain(tuple.getT2().getContent())
                            .build();
                });
    }

    @Override
    public UiDomainDto getSync(int id) {
        SpaceUi spaceUi = spaceUiRepository.findByUuid(id).block();
        EntityModel<SpaceDto> spaceDto = client.get()
                .uri("http://localhost:9035/spaces/3")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<EntityModel<SpaceDto>>(){})
                .block();


        return UiDomainDto.builder()
                .spaceUi(spaceUi)
                .domain(spaceDto)
                .build();
    }




}
