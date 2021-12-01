/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.modelo.servicios;

import ejemplo.gabriel.modelo.crud.ClientCrudRepositorio;
import ejemplo.gabriel.modelo.datos.Category;
import ejemplo.gabriel.modelo.datos.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class ClientServicios {/**Creamos la logica de negocio del  hp reto3*/
    
    @Autowired
    ClientCrudRepositorio repoClient;
    
    /**Creamos las peticiosnes propias del Reto3*/
    
    /**Guardado*/
    public void guardarCliente (Client clientes){
    
        repoClient.save(clientes);
    }
    /**Consulta*/
    public List<Client> buscarTodos(){
    
        return (List<Client>) repoClient.findAll();
    }
    
    /**Consultanos por ID*/
    
    public Client buscarPorId (Integer clave){
    
     return repoClient.findById(clave).orElse(null);/**retornamos nulo, sino se encuentra el id*/
     
    }
    
     /**Nuevos métodos para el reto4*/
    /**Borrado*/
     public Client borrarTodosLosClientes (Client clie){
       repoClient.deleteAll();
       return clie;
    }
    
     /**Actualizado*/
     public Client updateClient(Client cl){
     repoClient.findById(cl.getIdClient());     
     return cl;
     }
    
    
    
    
    
    
    
    /**Usamos las consultas personalizadas para probar*/
    
    public List<Client> findAllByNombre (String name){
       return repoClient.findAllByName(name);
    }
    
    
    public List<Client> findByAllNombreContaining (String palabra){
       return repoClient.findByNameContaining(palabra);
    }
    
    public List<Client> findByEmailEndingWith (String Palabra){
        return repoClient.findByEmailEndingWith(Palabra);
    }
    
    public List<Client> buscarClientSinEmail(){
        return repoClient.listaUsuariosEmailVacios();
    
    }
    
}
