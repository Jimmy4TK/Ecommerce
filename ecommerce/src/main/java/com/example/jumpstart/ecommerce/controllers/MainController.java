package com.example.jumpstart.ecommerce.controllers;

import com.example.jumpstart.ecommerce.entities.Producto;
import com.example.jumpstart.ecommerce.services.CategoriaService;
import com.example.jumpstart.ecommerce.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private ProductoService svcProducto;
    @Autowired
    private CategoriaService svcCategoria;

    @GetMapping(value = "/")
    public String index(Model model) {
        String saludo = "Hola Thymeleaf";
        model.addAttribute("saludo", saludo);
        return "index";
    }

    @GetMapping("/inicio")
    public String inicio(Model model, Pageable pageable) {
        try {
            Page<Producto> productos = this.svcProducto.findAll(pageable);
            model.addAttribute("productos", productos);

            return "views/inicio";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/crud")
    public String crudProducto(Model model, Pageable pageable){
        try {
            Page<Producto> productos = this.svcProducto.findAll(pageable);
            model.addAttribute("productos",productos);
            return "views/crud";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
