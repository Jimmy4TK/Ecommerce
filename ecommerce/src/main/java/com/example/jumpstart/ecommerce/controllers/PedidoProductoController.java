package com.example.jumpstart.ecommerce.entities.controllers;

import com.example.jumpstart.ecommerce.entities.PedidoProducto;
import com.example.jumpstart.ecommerce.services.PedidoProductoServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "jumpstart/v1/pedidosproductos")
public class PedidoProductoController extends BaseControllerImpl<PedidoProducto, PedidoProductoServiceImpl> {
}
