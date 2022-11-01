package com.example.jumpstart.ecommerce.repositories;

import com.example.jumpstart.ecommerce.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long>{
    @Query(value="SELECT * FROM producto WHERE producto.nombre LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM producto",
            nativeQuery = true)
    Page<Producto> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM producto WHERE producto.recomendado = '1'",
    countQuery = "SELECT count(*) FROM producto",
    nativeQuery = true)
    Page<Producto> searchRecomended(Pageable pageable);


    //TEST ALL THIS...
    @Query(value = "SELECT * FROM producto WHERE producto.categoria LIKE %:category%",
            countQuery = "SELECT count(*) FROM producto",
            nativeQuery = true)
    Page<Producto> searchByCategory(@Param("category")String category,Pageable pageable);

    @Query(
            value = "SELECT * FROM producto WHERE producto.precio BETWEEN %:priceMin% and %:priceMax%",
            countQuery = "select count(*) from producto",
            nativeQuery = true)
    Page<Producto> searchByPrice(@Param("priceMin") float priceMin, @Param("priceMax") float priceMax,Pageable pageable);

    @Query(
            value = "SELECT * FROM producto order by producto.precio asc" ,
            countQuery = "select count(*) from producto",
            nativeQuery = true)
    Page<Producto> orderAscPrice(Pageable pageable);

    @Query(
            value = "SELECT * FROM producto order by producto.precio desc" ,
            countQuery = "select count(*) from producto",
            nativeQuery = true)
    Page<Producto> orderDescPrice(Pageable pageable);

    @Query(value = "SELECT * FROM producto WHERE producto.masVendido = '1'",
            countQuery = "SELECT count(*) FROM producto",
            nativeQuery = true)
    Page<Producto> searchMostSelled(Pageable pageable);

    @Query(value = "SELECT * FROM producto WHERE producto.descuento <> 0 ",
            countQuery = "SELECT count(*) FROM producto",
            nativeQuery = true)
    Page<Producto> searchInDiscount(Pageable pageable);
}
