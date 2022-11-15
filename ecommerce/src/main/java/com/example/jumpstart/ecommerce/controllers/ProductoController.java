package com.example.jumpstart.ecommerce.controllers;

import com.example.jumpstart.ecommerce.entities.Producto;
import com.example.jumpstart.ecommerce.services.CategoriaService;
import com.example.jumpstart.ecommerce.services.ProductoService;
import com.example.jumpstart.ecommerce.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

@Controller
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl> {
    @Autowired
    private ProductoService svcProducto;
    @Autowired
    private CategoriaService svcCategoria;
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/formulario/producto/{id}")
    public String formularioProducto(Model model, @PathVariable("id")long id){
        try {
            model.addAttribute("categorias",this.svcCategoria.findAll(Pageable.unpaged()));
            if(id==0){
                model.addAttribute("producto",new Producto());
            }else{
                model.addAttribute("producto",this.svcProducto.findById(id));
            }
            return "views/formulario/producto";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/formulario/producto/{id}")
    public String guardarProducto(
            @RequestParam("archivo") MultipartFile archivo,
            @Valid @ModelAttribute("producto") Producto producto,
            BindingResult result,
            Model model,@PathVariable("id")long id
    ) {

        try {
            model.addAttribute("categorias",this.svcCategoria.findAll(Pageable.unpaged()));
            if(result.hasErrors()){
                return "views/formulario/producto";
            }
            String ruta = "C://Productos/imagenes";
            int index = archivo.getOriginalFilename().indexOf(".");
            String extension = "";
            extension = "."+archivo.getOriginalFilename().substring(index+1);
            String nombreFoto = Calendar.getInstance().getTimeInMillis()+extension;
            Path rutaAbsoluta = id != 0 ? Paths.get(ruta + "//"+producto.getImagen()) :
                    Paths.get(ruta+"//"+nombreFoto);
            if(id==0){
                if(archivo.isEmpty()){
                    model.addAttribute("errorImagenMsg","La imagen es requerida");
                    return "views/formulario/producto";
                }
                if(!this.validarExtension(archivo)){
                    model.addAttribute("errorImagenMsg","La extension no es valida");
                    return "views/formulario/producto";
                }
                if(archivo.getSize() >= 15000000){
                    model.addAttribute("errorImagenMsg","El peso excede 15MB");
                    return "views/formulario/producto";
                }
                Files.write(rutaAbsoluta,archivo.getBytes());
                producto.setImagen(nombreFoto);
                this.svcProducto.save(producto);
            }else{
                if(!archivo.isEmpty()){
                    if(!this.validarExtension(archivo)){
                        model.addAttribute("errorImagenMsg","La extension no es valida");
                        return "views/formulario/producto";
                    }
                    if(archivo.getSize() >= 15000000){
                        model.addAttribute("errorImagenMsg","El peso excede 15MB");
                        return "views/formulario/producto";
                    }
                    Files.write(rutaAbsoluta,archivo.getBytes());
                }
                this.svcProducto.update(id,producto);
            }
            return "redirect:/crud";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/eliminar/producto/{id}")
    public String eliminarProducto(Model model,@PathVariable("id")long id){
        try {
            model.addAttribute("producto",this.svcProducto.findById(id));
            return "views/formulario/eliminar";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/eliminar/producto/{id}")
    public String desactivarProducto(Model model, @PathVariable("id")long id){
        try {
            this.svcProducto.delete(id);
            return "redirect:/crud";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            System.out.println(e);
            return "error";
        }
    }

    public boolean validarExtension(MultipartFile archivo){
        try {
            ImageIO.read(archivo.getInputStream()).toString();
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    @GetMapping("/searchRecomended")
    public ResponseEntity<?> searchRecomended(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchRecomended(pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchByCategory")
    public ResponseEntity<?> searchByCategory(@RequestParam String category, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByCategory(category, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }


    @GetMapping("/searchByPrice")
    public ResponseEntity<?> searchByPrice(@RequestParam float priceMin,@RequestParam float priceMax,Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByPrice( priceMin,  priceMax, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/orderAscPrice")
    public ResponseEntity<?> orderAscPrice(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.orderAscPrice( pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/orderDescPrice")
    public ResponseEntity<?> orderDescPrice(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.orderDescPrice(pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchMostSelled")
    public ResponseEntity<?> searchMostSelled(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchMostSelled(pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchInDiscount")
    public ResponseEntity<?> searchInDiscount(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchInDiscount(pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \""+ e.getMessage() + "\"}"));
        }
    }

}
