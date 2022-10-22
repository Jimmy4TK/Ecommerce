package com.example.jumpstart.ecommerce.services;

import com.example.jumpstart.ecommerce.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService extends BaseService<Cliente, Long>{
    Page<Cliente> search(String filtro, Pageable pageable) throws Exception;
}
