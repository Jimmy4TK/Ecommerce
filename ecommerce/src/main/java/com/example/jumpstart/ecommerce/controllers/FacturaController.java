package com.example.jumpstart.ecommerce.controllers;

import com.example.jumpstart.ecommerce.entities.Factura;
import com.example.jumpstart.ecommerce.services.FacturaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "jumpstart/v1/facturas")
public class FacturaController  extends BaseControllerImpl<Factura, FacturaServiceImpl>{

}
