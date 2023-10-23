package com.example.ui.service.impl;
import com.example.ui.model.component.SpaceUi;
import com.example.ui.repository.SpaceUiRepository;
import com.example.ui.service.SpaceUiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpaceUiServiceImpl implements SpaceUiService {

    private final SpaceUiRepository spaceUiRepository;
    @Override
    public SpaceUi get(int id) {
        SpaceUi spaceUi = spaceUiRepository.findByUuid(id);
        return spaceUi;
    }
}
