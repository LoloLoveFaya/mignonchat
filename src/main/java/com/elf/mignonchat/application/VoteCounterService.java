package com.elf.mignonchat.application;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VoteCounterService {
    private final Map<String, Integer> imageVotes = new HashMap<>();

    public void voteForImage(String imageId) {
        imageVotes.put(imageId, imageVotes.getOrDefault(imageId, 0) + 1);
    }

    public int getVotesForImage(String imageId) {
        return imageVotes.getOrDefault(imageId, 0);
    }
}
