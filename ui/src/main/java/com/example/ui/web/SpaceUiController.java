package com.example.ui.web;

import com.example.ui.model.component.SpaceUi;
import com.example.ui.model.response.ResultData;
import com.example.ui.model.response.UiDomainDto;
import com.example.ui.service.SpaceUiService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("spaceUi")
public class SpaceUiController {


    private final SpaceUiService spaceUiService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ResultData>> getAsync(@PathVariable int id){
        Mono<UiDomainDto> spaceUiMono = spaceUiService.getAsync(id);
        return spaceUiMono
                .map(resource -> ResultData.ok(resource))
                .defaultIfEmpty(ResultData.ok("empty"));
    }

    @GetMapping("/Sync/{id}")
    public ResponseEntity<ResultData> getSync(@PathVariable int id){
        UiDomainDto uiDomainDto = spaceUiService.getSync(id);
        return ResultData.ok(uiDomainDto);
    }




}
