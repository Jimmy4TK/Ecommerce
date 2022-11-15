package com.example.jumpstart.ecommerce.services;

import com.example.jumpstart.ecommerce.entities.Producto;
import com.example.jumpstart.ecommerce.repositories.BaseRepository;
import com.example.jumpstart.ecommerce.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    public ProductoServiceImpl(BaseRepository<Producto, Long> baseRepository) {
        super(baseRepository);
    }
    @Override
    public Page<Producto> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Producto> productos = productoRepository.search(filtro, pageable);
            return productos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Producto> searchRecomended(Pageable pageable) throws Exception {
        try{
            Page<Producto> productos = productoRepository.searchRecomended(pageable);
            return productos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Producto> searchByCategory(String category, Pageable pageable) throws Exception {
        try{
            Page<Producto> productos = productoRepository.searchByCategory(category, pageable);
            return productos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Producto> searchByPrice(float priceMin, float priceMax, Pageable pageable) throws Exception {
        try{
            Page<Producto> productos = productoRepository.searchByPrice(priceMin, priceMax, pageable);
            return productos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Producto> orderAscPrice(Pageable pageable) throws Exception {
        try{
            Page<Producto> productos = productoRepository.orderAscPrice(pageable);
            return productos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }    }

    @Override
    public Page<Producto> orderDescPrice(Pageable pageable) throws Exception {
        try{
            Page<Producto> productos = productoRepository.orderDescPrice(pageable);
            return productos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }    }

    @Override
    public Page<Producto> searchMostSelled(Pageable pageable) throws Exception {
        try{
            Page<Producto> productos = productoRepository.searchMostSelled(pageable);
            return productos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }    }

    @Override
    public Page<Producto> searchInDiscount(Pageable pageable) throws Exception {
        try{
            Page<Producto> productos = productoRepository.searchInDiscount(pageable);
            return productos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
