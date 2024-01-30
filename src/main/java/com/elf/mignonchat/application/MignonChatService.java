package com.elf.mignonchat.application;

import com.elf.mignonchat.domain.model.Image;
import com.elf.mignonchat.domain.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MignonChatService {

    private final ImageRepository catRepository;

    @Autowired
    public MignonChatService(ImageRepository catRepository) {
        this.catRepository = catRepository;
    }
    public List<Image> getAllCats() {
        return catRepository.getAllCats();
    }

    public Image getCatById(String id) {
        return catRepository.getCatById(id);
    }
}
