/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.controladores;

import ejemplo.gabriel.modelo.datos.Client;
import ejemplo.gabriel.modelo.servicios.ClientServicios;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/api")
public class ControladorClient {
    
    @Autowired /**Inyectamos la dependencias*/
    ClientServicios clientServicios;
    @GetMapping("/Client/all")
    public List<Client> buscarTodos() {
        return clientServicios.buscarTodos();/**Retornamos todos los usarios invocando el método buscarTodos*/
    }
    
    /**ok*/
    
    
    @GetMapping("/Client/{id}")
    public Client getPorIDCliente(@PathVariable("id") Integer id) {
        return clientServicios.buscarPorId(id);
    }
    
    
    @PostMapping("/Client/save")
    public ResponseEntity<?> guardar(@RequestBody Client input) {
        clientServicios.guardarCliente(input);/**Este input recibe el cuerpo de los datos que se van a cargar*/
            return ResponseEntity.status(201).build();
    }
    
    
    /**El Put y el delete son para el reto4*/
    /**Actualizado*/
    @PutMapping("/Client/update")
    public ResponseEntity<?> put(@RequestBody Client input) {
      clientServicios.guardarCliente(input);
       return ResponseEntity.status(201).build();
    }
    
   /**Borrado de todos los Clientes*/
    @DeleteMapping("/Client/all")
    public ResponseEntity<?> deleteClientes (@RequestBody Client clie) {
        clientServicios.borrarTodosLosClientes(clie);
        return ResponseEntity.status(201).build();
    } 
     
    
    
    /**Aqui podemos llamar a los metodos personalizados de JPQL*/
    @GetMapping("/Client-nombre/{nombre}")
    public List<Client> mostrarPorNombre(@PathVariable String nombre){
    return clientServicios.findAllByNombre(nombre);
    
    }
    
    @GetMapping("/Client-nombreX/{palabra}")
    public List<Client> mostrarPorCoincidenciaDeNombre(@PathVariable String palabra){
    return clientServicios.findByAllNombreContaining(palabra);
    
    }
    
    @GetMapping("/Client-server-email/{server}")
    public List<Client> mostrarServerEmail(@PathVariable String server){
    return clientServicios.findByEmailEndingWith(server);
    
    }
    
    @GetMapping("/Client-sinEmail")
    public List<Client> mostrarSinEmail(){
    return clientServicios.buscarClientSinEmail();
    
    }
    
    
    
    
}
