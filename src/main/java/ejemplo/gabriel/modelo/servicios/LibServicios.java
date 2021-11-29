/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.modelo.servicios;

import ejemplo.gabriel.modelo.crud.LibCrudRepositorio;
import ejemplo.gabriel.modelo.datos.Lib;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class LibServicios {
    
    @Autowired
    LibCrudRepositorio repoLibrary;
            
    /**Guardado*/
    public void guardarLibrary (Lib libreria){
    
        repoLibrary.save(libreria);
    }
    /**Consulta*/
    public List<Lib> buscarTodasLasLibraries(){
    
        return (List<Lib>) repoLibrary.findAll();
    }
    
    /**Consultanos por ID*/
    
    public Lib buscarPorIdLibrary (Integer clave){
    
     return repoLibrary.findById(clave).orElse(null);/**retornamos nulo, sino se encuentra el id*/
     
    }
    
     /**Nuevos métodos para el reto4*/
    /**Borrado*/
     public void borrarLibraries (Integer c){
       repoLibrary.deleteById(c);
    }
    
      /**Actualizado*/
     public Lib updateLib(Lib lb){
     repoLibrary.findById(lb.getId());     
     return lb;
     }
    
    
}
