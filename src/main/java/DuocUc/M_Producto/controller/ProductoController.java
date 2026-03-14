package DuocUc.M_Producto.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DuocUc.M_Producto.model.ProductoModel;
import DuocUc.M_Producto.service.ProductoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping
    public ArrayList<ProductoModel> entregarProductos(){
        return productoService.obtenerProducto();
    }

    @PostMapping
    public ProductoModel guardaProducto(@RequestBody ProductoModel producto){
        return productoService.guardarProducto(producto);   
    }
    
    @GetMapping(path = "/{id}")
    public Optional<ProductoModel> entregarProductoId (@PathVariable long id){
        return this.productoService.buscarPorId(id);
        
    }
    

    @PutMapping("/{id}")
    public ProductoModel actualizarProducto(@RequestBody ProductoModel request, @PathVariable Long id){
        return this.productoService.actualizarProducto(request, id);

    }

    @DeleteMapping(path = "/{id}")
    public String aliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.productoService.eliminarProducto(id);

        if (ok) {
            return "Producto con id " + id + " ELIMINADO";
        } else {
            return "ERROR, EL USUARIO CON EL ID "+ id + "NO SE ELIMINO";
        }
    }
    

}
