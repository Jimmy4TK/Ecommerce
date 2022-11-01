package com.example.jumpstart.ecommerce.controllers;

import com.example.jumpstart.ecommerce.entities.Producto;
import com.example.jumpstart.ecommerce.services.ProductoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "jumpstart/v1/productos")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl> {
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/searchRecomended")
    public ResponseEntity<?> searchRecomended(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchRecomended(pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }
}
