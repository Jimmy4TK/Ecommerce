package com.example.jumpstart.ecommerce.services;

import com.example.jumpstart.ecommerce.entities.PedidoProducto;
import com.example.jumpstart.ecommerce.repositories.BaseRepository;
import com.example.jumpstart.ecommerce.repositories.PedidoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoProductoServiceImpl extends BaseServiceImpl<PedidoProducto, Long> implements PedidoProductoService{
    @Autowired
    private PedidoProductoRepository pedidoProductoRepository;

    public PedidoProductoServiceImpl(BaseRepository<PedidoProducto, Long> baseRepository) {
        super(baseRepository);
    }

}
