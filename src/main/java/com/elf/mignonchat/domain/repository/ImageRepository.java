package com.elf.mignonchat.domain.repository;

import com.elf.mignonchat.domain.model.Image;

import java.util.List;

public interface ImageRepository {
    List<Image> getAllCats();
    Image getCatById(String id);
}
