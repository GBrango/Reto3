/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.modelo.servicios;

import ejemplo.gabriel.modelo.crud.CategoryCrudRepositorio;
import ejemplo.gabriel.modelo.datos.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class CategoryServicios {
    
    @Autowired
    CategoryCrudRepositorio repoCategory;
            
    /**Guardado*/
    public void guardarCategory (Category categoria){
    
        repoCategory.save(categoria);
    }
    /**Consulta*/
    public List<Category> buscarTodasLasCategorias(){
    
        return (List<Category>) repoCategory.findAll();
    }
    
    /**Consultanos por ID*/
    
    public Category buscarPorIdCategoria (Integer clave){
    
     return repoCategory.findById(clave).orElse(null);/**retornamos nulo, sino se encuentra el id*/
     
    }
    
}
