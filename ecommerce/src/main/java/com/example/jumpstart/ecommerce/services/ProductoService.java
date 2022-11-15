package com.example.jumpstart.ecommerce.services;

import com.example.jumpstart.ecommerce.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService extends BaseService<Producto, Long>{
    Page<Producto> search(String filtro, Pageable pageable) throws Exception;
    Page<Producto> searchRecomended(Pageable pageable) throws Exception;

    Page<Producto> searchByCategory(String category, Pageable pageable) throws Exception;

    Page<Producto> searchByPrice(float priceMin, float priceMax,Pageable pageable) throws Exception;

    Page<Producto> orderAscPrice(Pageable pageable) throws Exception;

    Page<Producto> orderDescPrice(Pageable pageable) throws Exception;

    Page<Producto> searchMostSelled(Pageable pageable) throws Exception;

    Page<Producto> searchInDiscount(Pageable pageable) throws Exception;
}
