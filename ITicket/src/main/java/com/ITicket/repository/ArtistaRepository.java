package com.ITicket.repository;

import com.ITicket.entity.Artista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author madri
 */

@Repository
public interface ArtistaRepository extends CrudRepository<Artista,Integer>{
    
}
