package com.example.ui.service;
import com.example.ui.model.component.SpaceUi;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SpaceUiService {

    SpaceUi get(int id);
}
