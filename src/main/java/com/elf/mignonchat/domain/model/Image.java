package com.elf.mignonchat.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Image {
    private String url;
    private String id;
    private int score;

    @JsonCreator
    public Image(@JsonProperty("url") String url, @JsonProperty("id") String id) {
        this.url = url;
        this.id = id;
    }
}
