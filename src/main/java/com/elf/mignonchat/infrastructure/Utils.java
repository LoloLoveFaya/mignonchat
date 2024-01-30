package com.elf.mignonchat.infrastructure;

import com.elf.mignonchat.domain.model.Image;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Image> deserialize(String apiUrl) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(new URL(apiUrl));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Image> images = new ArrayList<>();

        for (JsonNode imageNode : jsonNode.get("images")) {
            Image image = objectMapper.convertValue(imageNode, Image.class);
            images.add(image);
        }

        return images;
    }
}
