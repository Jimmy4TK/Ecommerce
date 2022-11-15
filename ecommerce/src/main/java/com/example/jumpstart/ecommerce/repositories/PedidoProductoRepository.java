package com.example.jumpstart.ecommerce.repositories;

import com.example.jumpstart.ecommerce.entities.PedidoProducto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProductoRepository extends BaseRepository<PedidoProducto, Long>{
    @Query(value="SELECT * FROM pedidoproducto WHERE pedidoproducto.fk_factura LIKE %:numberFac%",
            countQuery = "SELECT count(*) FROM usuario",
            nativeQuery = true)
    Page<PedidoProducto> search(@Param("numberFac") String numberFac, Pageable pageable);
}
