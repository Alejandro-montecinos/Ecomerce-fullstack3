package DuocUc.M_Producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DuocUc.M_Producto.model.ProductoModel;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel,Long>  {


    
}  

    
