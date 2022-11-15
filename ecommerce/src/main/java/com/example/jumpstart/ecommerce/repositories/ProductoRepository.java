package com.example.jumpstart.ecommerce.repositories;

import com.example.jumpstart.ecommerce.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long>{
    //BUSQUEDA POR NOMBRE DE PRODUCTO
    @Query(value="SELECT * FROM producto WHERE producto.nombre LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM producto",
            nativeQuery = true)
    Page<Producto> search(@Param("filtro") String filtro, Pageable pageable);


    // BUSQUEDA DE RECOMENDADOS
    @Query(value = "SELECT * FROM producto WHERE producto.recomendado = '1'",
            countQuery = "SELECT count(*) FROM producto",
            nativeQuery = true)
    Page<Producto> searchRecomended(Pageable pageable);


    //BUSQUEDA POR CATEGORIA DE PRODUCTO
    @Query(value = "SELECT * FROM producto WHERE producto.fk_categoria LIKE %:categoryid%",
            countQuery = "SELECT count(*) FROM producto",
            nativeQuery = true)
    Page<Producto> searchByCategory(@Param("categoryid")long category,Pageable pageable);


    //BUSQUEDA FILTRANDO POR RANGO DE PRECIO
    @Query(
            value = "SELECT * FROM producto WHERE producto.precio BETWEEN %:priceMin% and %:priceMax%",
            countQuery = "select count(*) from producto",
            nativeQuery = true)
    Page<Producto> searchByPrice(@Param("priceMin") float priceMin, @Param("priceMax") float priceMax,Pageable pageable);


    //BUSQUEDA ORDENANDO POR PRECIO DE MANERA ASCENDENTE
    @Query(
            value = "SELECT * FROM producto order by producto.precio asc" ,
            countQuery = "select count(*) from producto",
            nativeQuery = true)
    Page<Producto> orderAscPrice(Pageable pageable);

    //BUSQUEDA ORDENANDO POR PRECIO DE MANERA DESCENDENTE
    @Query(
            value = "SELECT * FROM producto order by producto.precio desc" ,
            countQuery = "select count(*) from producto",
            nativeQuery = true)
    Page<Producto> orderDescPrice(Pageable pageable);

    //BUSQUEDA DE LOS PRODUCTOS MAS VENDIDOS
    @Query(value = "SELECT * FROM producto WHERE producto.masVendido = '1'",
            countQuery = "SELECT count(*) FROM producto",
            nativeQuery = true)
    Page<Producto> searchMostSelled(Pageable pageable);

    //BUSQUEDA DE PRODUCTOS EN DESCUENTO
    @Query(value = "SELECT * FROM producto WHERE producto.descuento <> 0 ",
            countQuery = "SELECT count(*) FROM producto",
            nativeQuery = true)
    Page<Producto> searchInDiscount(Pageable pageable);
}
