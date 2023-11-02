package com.example.ui.service.impl;
import com.example.ui.messagequeue.KafkaProducer;
import com.example.ui.model.component.SpaceUi;
import com.example.ui.model.response.MessageDto;
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
    private final KafkaProducer kafkaProducer;
    @Override
    public Mono<UiDomainDto> getAsync(int id) {
        Mono<SpaceUi> spaceUi = spaceUiRepository.findByUuid(id);
        Mono<EntityModel<SpaceDto>> spaceDto = client.get()
                .uri("http://localhost:8082/spaces/3")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });


        return Mono.zip(spaceUi, spaceDto)
                .map(tuple -> UiDomainDto.builder()
                        .spaceUi(tuple.getT1())
                        .domain(tuple.getT2().getContent())
                        .build());
    }

    @Override
    public UiDomainDto getSync(int id) {
        SpaceUi spaceUi = spaceUiRepository.findByUuid(id).block();
        EntityModel<SpaceDto> spaceDto = client.get()
                .uri("http://localhost:8082/spaces/3")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<EntityModel<SpaceDto>>(){})
                .block();


        return UiDomainDto.builder()
                .spaceUi(spaceUi)
                .build();
    }




}
