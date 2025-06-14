//package machio.ken.server2.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import simplex.bn25.kaiden.june.arai101892.libraryapp.service.ReturnService;
//
//@Controller
//public class ReturnController {
//
//    private final ReturnService returnService;
//
//    @Autowired
//    public ReturnController(ReturnService returnService) {
//        this.returnService = returnService;
//    }
//
//    @PostMapping("/return")
//    public String returnBook(@RequestParam("circulationId") Long circulationId) {
//        returnService.returnBook(circulationId);
//        return "redirect:/circulation/list"; // 登録一覧画面にリダイレクト
//    }
//}
