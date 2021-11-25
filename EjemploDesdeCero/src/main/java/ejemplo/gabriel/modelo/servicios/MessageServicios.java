/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.modelo.servicios;

import ejemplo.gabriel.modelo.crud.MessageCrudRepositorio;
import ejemplo.gabriel.modelo.datos.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class MessageServicios {
    
    @Autowired
    MessageCrudRepositorio repoMessage;
            
    /**Guardado*/
    public void guardarMessage (Message mensaje){
    
        repoMessage.save(mensaje);
    }
    /**Consulta*/
    public List<Message> buscarTodosLosMensaje(){
    
        return (List<Message>) repoMessage.findAll();
    }
    
    /**Consultanos por ID*/
    
    public Message buscarPorIdMensajes(Integer clave){
    
     return repoMessage.findById(clave).orElse(null);/**retornamos nulo, sino se encuentra el id*/
     
    }
    
}
