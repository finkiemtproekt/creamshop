package com.ukim.mk.projectspring.web.controller;

import com.ukim.mk.projectspring.Service.CreamService;
import com.ukim.mk.projectspring.model.Cream;
import com.ukim.mk.projectspring.model.Firm;
import com.ukim.mk.projectspring.repo.FirmRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cream")
@Controller
public class CreamController {


    private final CreamService CreamService;
    private final FirmRepository firmRepository;
    public CreamController(com.ukim.mk.projectspring.Service.CreamService creamService, FirmRepository firmRepository) {
        CreamService = creamService;
        this.firmRepository = firmRepository;
    }

    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Cream> products = this.CreamService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("bodyContent", "creams");
        return "master-template";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        this.CreamService.deleteById(id);
        return "redirect:/cream";
    }

    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addProductPage(Model model) {
        List<Firm> firm = this.firmRepository.findAll();
        model.addAttribute("firm", firm);
        model.addAttribute("bodyContent", "addCream");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam(required = false) Integer cream_id,
            @RequestParam String cream_name,
            @RequestParam String cream_year,
            @RequestParam Integer firm_id
    ) {

        this.CreamService.save(cream_id,cream_name, cream_year, firm_id);

        return "redirect:/cream";
    }

}
