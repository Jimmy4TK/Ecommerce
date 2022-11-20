package com.example.jumpstart.ecommerce.controllers;

import com.example.jumpstart.ecommerce.entities.Usuario;
import com.example.jumpstart.ecommerce.services.PedidoService;
import com.example.jumpstart.ecommerce.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/compras")
    public String perfil(HttpSession http, ModelMap modelo){
        Usuario logueado = (Usuario) http.getAttribute("usuariosession");
        try{
            modelo.put("usuario", logueado);
            modelo.addAttribute("pedidos", pedidoService.pedidosFacturados());
        }catch (Exception e){
            modelo.put("error", e.getMessage());
        }finally {
            return "views/facturas";
        }

    }
}
