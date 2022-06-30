package com.ITicket.controller;

import com.ITicket.entity.Artista;
import com.ITicket.entity.Concierto;
import com.ITicket.service.IArtistaService;
import com.ITicket.service.IConciertoService;
import java.util.List;
import static org.hibernate.criterion.Projections.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author madri
 */
@Controller
public class ConciertoController {
    
    @Autowired
    private IConciertoService conciertoService;    
    @Autowired
    private IArtistaService artistaService;
        
    @GetMapping("/concierto")    
    public String index(Model model){        
        List<Concierto> listaConcierto = conciertoService.getAllConcierto();        
        model.addAttribute("titulo", "Tabla Concierto");        
        model.addAttribute("concierto", listaConcierto);        
        return "conciertos";
    }
    
    @GetMapping("/conciertoN")
    public String crearPersona(Model model){
        List<Artista> listaArtista = artistaService.listArtista();        
        model.addAttribute("concierto", new Concierto());       
        model.addAttribute("artista", listaArtista);
        return "crear";
    }
    
    @PostMapping("/save")
    public String guardarConcierto(@ModelAttribute Concierto concierto){
        conciertoService.saveConcierto(concierto);
        return "redirect:/concierto";
    }
    
    @GetMapping("/editConcierto/{id}")
    public String editarConcierto(@PathVariable("id") int idConcierto, Model model){
        Concierto concierto = conciertoService.getConciertoById(idConcierto);
        List<Artista> listaArtista = artistaService.listArtista();
        model.addAttribute("concierto", concierto);
        model.addAttribute("artista", listaArtista);
        return "crear";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarConcierto(@PathVariable("id")Integer idConcierto){
        conciertoService.delete(idConcierto);
        return "redirect:/concierto";
    } 
}
