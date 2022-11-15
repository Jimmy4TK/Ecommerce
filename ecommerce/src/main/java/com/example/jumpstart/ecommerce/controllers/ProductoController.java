package com.example.jumpstart.ecommerce.controllers;

import com.example.jumpstart.ecommerce.entities.Producto;
import com.example.jumpstart.ecommerce.services.ProductoServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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

    @GetMapping("/searchByCategory")
    public ResponseEntity<?> searchByCategory(@RequestParam String category, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByCategory(category, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }


    @GetMapping("/searchByPrice")
    public ResponseEntity<?> searchByPrice(@RequestParam float priceMin,@RequestParam float priceMax,Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByPrice( priceMin,  priceMax, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/orderAscPrice")
    public ResponseEntity<?> orderAscPrice(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.orderAscPrice( pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/orderDescPrice")
    public ResponseEntity<?> orderDescPrice(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.orderDescPrice(pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchMostSelled")
    public ResponseEntity<?> searchMostSelled(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchMostSelled(pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchInDiscount")
    public ResponseEntity<?> searchInDiscount(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchInDiscount(pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

}
