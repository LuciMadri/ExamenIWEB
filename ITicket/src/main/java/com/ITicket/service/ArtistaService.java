package com.ITicket.service;

import com.ITicket.entity.Artista;
import com.ITicket.repository.ArtistaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author madri
 */

@Service

public class ArtistaService implements IArtistaService{
    
    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public List<Artista> listArtista() {
        return (List<Artista>) artistaRepository.findAll();
    }

}
