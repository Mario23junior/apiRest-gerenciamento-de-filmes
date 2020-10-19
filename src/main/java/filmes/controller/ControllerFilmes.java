package filmes.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import filmes.Repository.filmesRepository;
import filmes.model.FilmeModel;

@RequestMapping("/movie")
@RestController
public class ControllerFilmes {
    
	@Autowired
	private filmesRepository filmerepository;
	
    public ControllerFilmes(filmesRepository filmerepository) {
		this.filmerepository = filmerepository;
	}	
    
    @GetMapping(value = "/list/All") 
    public List<FilmeModel> listAll() {
    	return filmerepository.findAll();
    }
}
