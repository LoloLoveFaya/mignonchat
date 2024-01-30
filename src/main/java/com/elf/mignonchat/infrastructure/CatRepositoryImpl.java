package com.elf.mignonchat.infrastructure;

import com.elf.mignonchat.domain.model.Image;
import com.elf.mignonchat.domain.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.elf.mignonchat.infrastructure.Utils.*;

@Component
public class CatRepositoryImpl implements ImageRepository {
    @Value("${cats.api.url}")
    private String catsApiUrl;
    public static List<Image> images;

    @Override
    public List<Image> getAllCats() {
        images = deserialize(catsApiUrl);
        return images;
    }

    @Override
    public Image getCatById(String id) {
            return images.stream()
                    .filter(cat -> cat.getId().equals(id))
                    .findFirst()
                    .orElse(null);
    }
}
