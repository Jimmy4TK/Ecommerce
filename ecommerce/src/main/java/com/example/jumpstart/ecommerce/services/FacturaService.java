package com.example.jumpstart.ecommerce.services;

import com.example.jumpstart.ecommerce.entities.Factura;
import com.example.jumpstart.ecommerce.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface FacturaService extends BaseService<Factura, Long>{

    Page<Factura> searchClientFac(int fkCliente, Pageable pageable) throws Exception;
}
