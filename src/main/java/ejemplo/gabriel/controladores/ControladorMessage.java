/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.controladores;

import ejemplo.gabriel.modelo.datos.Client;
import ejemplo.gabriel.modelo.datos.Message;
import ejemplo.gabriel.modelo.servicios.MessageServicios;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/api/Message")
public class ControladorMessage {
    
   @Autowired /**Inyectamos la dependencias*/
    MessageServicios messageServicios;
    @GetMapping("/all")
    public List<Message> buscarTodosLosMensajes() {
        return messageServicios.buscarTodosLosMensaje();/**Retornamos todos los usarios invocando el método buscarTodos*/
    }
    
    /**ok*/
        
    @GetMapping("/Client/{id}")
    public Message getPorIdMensae(@PathVariable("id") Integer id) {
        return messageServicios.buscarPorIdMensajes(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> guardarMensaje(@RequestBody Message input) {
        messageServicios.guardarMessage(input);/**Este input recibe el cuerpo de los datos que se van a cargar*/
            return ResponseEntity.status(201).build();
    }
    
    
    
    
   
    /**metodos para el reto4*/
    
   /** @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
       
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    */
}
