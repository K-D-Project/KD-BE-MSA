package com.example.space.service.impl;


import com.example.space.model.entity.Space;
import com.example.space.repository.SpaceRepository;
import com.example.space.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpaceServiceImpl implements SpaceService {

    private final SpaceRepository spaceRepository;

}
