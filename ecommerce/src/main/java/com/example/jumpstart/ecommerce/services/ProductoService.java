package com.example.jumpstart.ecommerce.services;

import com.example.jumpstart.ecommerce.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService extends BaseService<Producto, Long>{
    Page<Producto> search(String filtro, Pageable pageable) throws Exception;
}
