package com.example.jumpstart.ecommerce.controllers;

import com.example.jumpstart.ecommerce.entities.Pedido;
import com.example.jumpstart.ecommerce.entities.Producto;
import com.example.jumpstart.ecommerce.services.PedidoServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
//    @GetMapping("usuario/{id}/carrito")
//    public String carrito(Model model, @PathVariable("id")long id, Pageable pageable) {
//        try {
//            //Pedido
//            Pedido pedido = this.svcPedido.activePedido(id);
//            model.addAttribute("pedido", pedido);
//            //Productos
//            Page<Producto> productos = this.svcPedidoProducto.searchByPedido(pedido.getId(), pageable);
//            model.addAttribute("productos", productos);
//            return "views/inicio";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "error";
//        }
//    }
}
