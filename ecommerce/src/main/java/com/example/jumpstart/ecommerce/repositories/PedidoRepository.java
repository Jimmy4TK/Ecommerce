package com.example.jumpstart.ecommerce.repositories;

import com.example.jumpstart.ecommerce.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long>{
    @Query(value="SELECT * FROM pedido WHERE pedido.fk_cliente LIKE %:fkCliente% and pedido.pagado = '0'",
            countQuery = "SELECT count(*) FROM producto",
            nativeQuery = true)
    Page<Pedido> searchClientFac(@Param("fkCliente") int fkCliente, Pageable pageable);
}
