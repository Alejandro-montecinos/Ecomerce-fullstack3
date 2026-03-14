package DuocUc.M_Producto.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DuocUc.M_Producto.model.ProductoModel;
import DuocUc.M_Producto.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;


    public ArrayList<ProductoModel> obtenerProducto() {
        return (ArrayList<ProductoModel>)productoRepository.findAll();
    }

    public ProductoModel guardarProducto(ProductoModel producto){
        return productoRepository.save(producto);
    }

    public Optional<ProductoModel> buscarPorId (Long id){
        return productoRepository.findById(id);
    }

    public ProductoModel actualizarProducto(ProductoModel request, Long id){
        ProductoModel produ = productoRepository.findById(id).get();

        produ.setNombre(request.getNombre());
        produ.setDescripcion(request.getDescripcion());
        produ.setPrecio(request.getPrecio());
        produ.setStock(request.getStock());
        productoRepository.save(produ);
        return produ;
    }

    public Boolean eliminarProducto (Long id){
        try {

            productoRepository.deleteById(id);;
            return true;

        } catch (Exception e) {
            return false;
        }
    }



    

}
