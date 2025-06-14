package machio.ken.server2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import simplex.bn25.kaiden.june.arai101892.libraryapp.service.CollectionService;
import simplex.bn25.kaiden.june.arai101892.libraryapp.service.MembersService;
import simplex.bn25.kaiden.june.arai101892.libraryapp.util.CurrentTimeProvider;

@Controller
@RequestMapping("/circulations")
public class CirculationsController {

    private final CurrentTimeProvider currentTimeProvider;
    private final MembersService membersService;
    private final CollectionService collectionService;

    @Autowired
    public CirculationsController(CurrentTimeProvider currentTimeProvider,
                                  MembersService membersService,
                                  CollectionService collectionService) {
        this.currentTimeProvider = currentTimeProvider;
        this.membersService = membersService;
        this.collectionService = collectionService;
    }

    @GetMapping("/new")
    public String newCirculation(Model model) {
        initModel(model, new NewCirculationInput());
        return "circulations/new";
    }

    @PostMapping("/new")
    public String registerNewCirculation(@Validated NewCirculationInput input,
                                         Model model, RedirectAttributes redirect) {
        var collection = collectionService.tryToCheckout(
                input.getCollectionId(), input.getMemberId(),
                input.getSinceDate(), input.getDueDate());

        redirect.addFlashAttribute("flashInfo", "messages.success.checkout");
        redirect.addFlashAttribute("flashInfoArgs", collection.getSerialAndTitle());

        return "redirect:/collections";
    }

    private void initModel(Model model, NewCirculationInput input) {
        model.addAttribute("date", currentTimeProvider.today());
        model.addAttribute("members", membersService.listAll());
        model.addAttribute("collections", collectionService.listAll());

        input.setSinceDate(currentTimeProvider.today());
        input.setDueDate(currentTimeProvider.today().plusWeeks(2));
        model.addAttribute("input", input);
    }
}

