/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.modelo.crud;

import ejemplo.gabriel.modelo.datos.Client;
import java.util.List;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabriel
 */
@Repository
public interface ClientCrudRepositorio extends CrudRepository<Client, Integer> {
    
    public List<Client> findAllByName(String name);/**Buscamos por un nombre en específico*/
    public List<Client> findByNameContaining(String palabra);/**Busca por parte del nombre*/
    public List<Client> findByEmailEndingWith(String Palabra); /**Busca por email termiando con...*/
    
    /**Utilizamos ahora JPQL PARA CONSULT
     * @return A*/
    
    @Query("SELECT u from Client u WHERE email is NULL ")
    public List<Client> listaUsuariosEmailVacios();
}
