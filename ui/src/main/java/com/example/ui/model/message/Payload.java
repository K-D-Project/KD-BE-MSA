package com.example.ui.model.message;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payload {
    private String message;
}
