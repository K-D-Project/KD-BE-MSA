package com.example.ui.web;

import com.example.ui.model.response.ResultData;
import com.example.ui.service.SpaceUiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("spaceUi")
public class SpaceUiController {


    private final SpaceUiService spaceUiService;

    @GetMapping("/{id}")
    public ResponseEntity<ResultData> get(@PathVariable int id){
        return ResultData.ok(spaceUiService.get(id));
    }

}
