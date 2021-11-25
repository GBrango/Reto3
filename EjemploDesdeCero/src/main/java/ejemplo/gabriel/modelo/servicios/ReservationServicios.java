/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.modelo.servicios;

import ejemplo.gabriel.modelo.crud.ReservationCrudRepositorio;
import ejemplo.gabriel.modelo.datos.Reservation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
public class ReservationServicios {
    
    @Autowired
    ReservationCrudRepositorio repoReservation;
            
    /**Guardado*/
    public void guardarReservasion (Reservation reserva){
    
        repoReservation.save(reserva);
    }
    /**Consulta*/
    public List<Reservation> buscarTodosLasReservas(){
    
        return (List<Reservation>) repoReservation.findAll();
    }
    
    /**Consultanos por ID*/
    
    public Reservation buscarPorIdReserva(Integer clave){
    
     return repoReservation.findById(clave).orElse(null);/**retornamos nulo, sino se encuentra el id*/
     
    }
    
}
