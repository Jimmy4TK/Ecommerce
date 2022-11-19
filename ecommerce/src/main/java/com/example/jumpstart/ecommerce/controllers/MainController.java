package com.example.jumpstart.ecommerce.controllers;

import com.example.jumpstart.ecommerce.entities.Categoria;
import com.example.jumpstart.ecommerce.entities.Producto;
import com.example.jumpstart.ecommerce.services.CategoriaService;
import com.example.jumpstart.ecommerce.services.ProductoService;
import com.example.jumpstart.ecommerce.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @Autowired
    private ProductoService svcProducto;
    @Autowired
    private CategoriaService svcCategoria;
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping(value = "/")
    public String index(Model model) {
        String saludo = "Hola Thymeleaf";
        model.addAttribute("saludo", saludo);
        return "index";
    }
    @PostMapping(value = "/registro")
    public String registro(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String mail, @RequestParam String contrasena, ModelMap modelo){
        try {
            usuarioService.registrar(mail, nombre, apellido, contrasena);
            modelo.put("exito", "Registrado correctamente");
            return  "views/inicio";
        }catch(Exception e){
            modelo.put("error", e.getMessage());
            return "views/inicio";
        }
    }
    @GetMapping("/inicio")
    public String inicio(Model model, Pageable pageable) {
        try {
            Page<Categoria> categorias = this.svcCategoria.findAll(pageable);
            model.addAttribute("categorias", categorias);
            Page<Producto> productos = this.svcProducto.findAll(pageable);
            model.addAttribute("productos", productos);
            return "views/inicio";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
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
