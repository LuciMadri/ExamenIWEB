package com.ITicket.service;

import com.ITicket.entity.Concierto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author madri
 */
public interface IConciertoService{
    
    public List<Concierto> getAllConcierto();
    public Concierto getConciertoById (Integer id);
    public void saveConcierto(Concierto concierto);
    public void delete(Integer id);
    
}
