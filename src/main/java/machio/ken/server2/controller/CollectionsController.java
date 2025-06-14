package machio.ken.server2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import simplex.bn25.kaiden.june.arai101892.libraryapp.model.view.CollectionWithStatus;
import simplex.bn25.kaiden.june.arai101892.libraryapp.service.CollectionService;
import simplex.bn25.kaiden.june.arai101892.libraryapp.util.CurrentTimeProvider;

import java.util.List;

@Controller
public class CollectionsController {

    private final CollectionService service;
    private final CurrentTimeProvider currentTimeProvider;

    @Autowired
    public CollectionsController(CollectionService service, CurrentTimeProvider currentTimeProvider) {
        this.service = service;
        this.currentTimeProvider = currentTimeProvider;
    }

    @GetMapping("/collections")
    public String collections(Model model) {
        List<CollectionWithStatus> list = service.listAll();

        model.addAttribute("collections", list);
        model.addAttribute("today", currentTimeProvider.today());

        return "collections/index";
    }
}
