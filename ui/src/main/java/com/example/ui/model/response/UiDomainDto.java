package com.example.ui.model.response;


import com.example.ui.model.component.SpaceUi;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class UiDomainDto {

    private SpaceUi spaceUi;
    private Object domain;
}
