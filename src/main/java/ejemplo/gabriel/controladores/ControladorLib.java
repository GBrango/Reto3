/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.controladores;

import ejemplo.gabriel.modelo.datos.Lib;
import ejemplo.gabriel.modelo.servicios.LibServicios;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorLib {
    
    @Autowired /**Inyectamos la dependencias*/
    LibServicios libServicios;
    @GetMapping("/Lib/all")
    public List<Lib> buscarTodosLosLibs() {
        return libServicios.buscarTodasLasLibraries();/**Retornamos todos las bibliotecas invocando el método buscarTodosLosLibs*/
    }
    
    /**ok*/
    
    
    @GetMapping("/Lib/{id}")
    public Lib getPorIdLib(@PathVariable("id") Integer id) {
        return libServicios.buscarPorIdLibrary(id);
    }
    
    
    @PostMapping("/Lib/save")
    public ResponseEntity<?> guardar(@RequestBody Lib input) {
        libServicios.guardarLibrary(input);/**Este input recibe el cuerpo de los datos que se van a cargar*/
            return ResponseEntity.status(201).build();
    }
    
    
    /**Estos metdos son para el reto4*/
    @PutMapping("/Lib/update")
    public ResponseEntity<?> put(@RequestBody Lib input) {
      libServicios.actualizarLib(input);
       return ResponseEntity.status(201).build();
    }
    
   
    @DeleteMapping("/Lib/all")
    public ResponseEntity<?> deleteLibrary(@RequestBody Lib lb) {
        libServicios.borrarTodasLasLibraries(lb);
         return ResponseEntity.status(201).build();
    }
  
}
