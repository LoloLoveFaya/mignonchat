package com.elf.mignonchat.presentation.controller;

import com.elf.mignonchat.application.MignonChatService;
import com.elf.mignonchat.application.VoteCounterService;
import com.elf.mignonchat.domain.model.Image;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ImageController {
    private final MignonChatService mignonChatService;
    private final VoteCounterService voteCounterService;

    public ImageController(MignonChatService mignonChatService, VoteCounterService voteCounterService) {
        this.mignonChatService = mignonChatService;
        this.voteCounterService = voteCounterService;
    }

    @GetMapping("/")
    public ModelAndView redirectToImagesPage() {
        return new ModelAndView("redirect:/images");
    }

    @GetMapping("/images")
    public String showCatListPage(Model model) {
        List<Image> images = mignonChatService.getAllCats();
        model.addAttribute("images", images);
        model.addAttribute("voteCounterService", voteCounterService);
        return "imagesView";
    }

   @PostMapping("/vote/{imageId}")
   public ModelAndView vote(@PathVariable String imageId) {
       Image image = mignonChatService.getCatById(imageId);
       if (image != null) {
           voteCounterService.voteForImage(imageId);
           // Mise à jour du score
           image.setScore(voteCounterService.getVotesForImage(imageId));
           return new ModelAndView("redirect:/images");
       } else {
           return new ModelAndView("redirect:/images");
       }
   }

}
