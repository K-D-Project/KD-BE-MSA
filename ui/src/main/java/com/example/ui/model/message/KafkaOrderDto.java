package com.example.ui.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.io.Serializable;

@Data
@AllArgsConstructor
public class KafkaOrderDto implements Serializable {
    private Schema schema;
    private Payload payload;
}
