package com.example.space.web;

import com.example.space.model.entity.Space;
import com.example.space.model.response.ResultData;
import com.example.space.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/spaces")
@RequiredArgsConstructor
public class SpaceController {

    private final SpaceService spaceService;
    

}
