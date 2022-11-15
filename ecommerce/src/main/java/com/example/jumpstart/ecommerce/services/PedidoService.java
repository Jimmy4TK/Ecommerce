package com.example.jumpstart.ecommerce.services;

import com.example.jumpstart.ecommerce.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PedidoService extends BaseService<Pedido, Long>{
    Page<Pedido> searchClientFac(int fkCliente, Pageable pageable) throws Exception;
}
