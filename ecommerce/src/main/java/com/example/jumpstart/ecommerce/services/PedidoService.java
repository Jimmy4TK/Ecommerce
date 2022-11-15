package com.example.jumpstart.ecommerce.services;

import com.example.jumpstart.ecommerce.entities.Pedido;
import com.example.jumpstart.ecommerce.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface PedidoService extends BaseService<Pedido, Long>{

    Page<Pedido> searchClientFac(int fkCliente, Pageable pageable) throws Exception;
}