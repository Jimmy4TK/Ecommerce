package com.example.jumpstart.ecommerce.controllers;

import com.example.jumpstart.ecommerce.entities.Pedido;
import com.example.jumpstart.ecommerce.services.PedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "jumpstart/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{

    @GetMapping("/searchClientFac")
    public ResponseEntity<?> searchClientFac(@RequestParam int fkCliente, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchClientFac(fkCliente,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }
}
