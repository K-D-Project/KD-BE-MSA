package com.example.ui.model.component;



import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "ui") // 컬렉션 이름을 지정합니다.
@Getter
@Setter
@RequiredArgsConstructor
public class SpaceUi implements Serializable {

    @Id
    private String _id;
    @Field("id")
    private int id;
    private int uuid;
    private String type;
    private Property property;

    // Getter, Setter, Constructors

    @Getter
    private class Property {
        private Store store;
        private Style style;

        // Getter, Setter

        @Getter
        private class Store {
            private String key;

            // Getter, Setter
        }

        @Getter
        private class Style {
            private String margin;

            // Getter, Setter
        }
    }



}
