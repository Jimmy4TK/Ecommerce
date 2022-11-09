package com.example.jumpstart.ecommerce.entities.controllers;

import com.example.jumpstart.ecommerce.entities.Cliente;
import com.example.jumpstart.ecommerce.services.ClienteServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "jumpstart/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }
}
