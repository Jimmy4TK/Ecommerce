package com.example.jumpstart.ecommerce.entities.controllers;

import com.example.jumpstart.ecommerce.entities.Pedido;
import com.example.jumpstart.ecommerce.services.PedidoServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "jumpstart/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{
}
