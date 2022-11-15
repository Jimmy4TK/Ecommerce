package com.example.jumpstart.ecommerce.services;

import com.example.jumpstart.ecommerce.entities.Pedido;

import com.example.jumpstart.ecommerce.entities.Producto;
import com.example.jumpstart.ecommerce.repositories.BaseRepository;
import com.example.jumpstart.ecommerce.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService{
        @Autowired
        private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {
            super(baseRepository);
        }

    @Override
    public Page<Pedido> searchClientFac(int fkCliente, Pageable pageable) throws Exception {
        try{
            Page<Pedido> pedidos = pedidoRepository.searchClientFac(fkCliente, pageable);
            return pedidos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
