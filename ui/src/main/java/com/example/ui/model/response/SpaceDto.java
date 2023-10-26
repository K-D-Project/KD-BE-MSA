package com.example.ui.model.response;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class SpaceDto {
    private String name;
    private String createdAt;
    private String updatedAt;
    private Object _links;

    @JsonCreator
    public SpaceDto(@JsonProperty("name") String name, @JsonProperty("createdAt") String createdAt, @JsonProperty("updatedAt") String updatedAt, @JsonProperty("_links") String _links) {
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this._links = _links;
    }
}
