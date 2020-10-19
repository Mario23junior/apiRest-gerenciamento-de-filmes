package filmes.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping(path = {"/list/id/{id}"})
    public ResponseEntity<FilmeModel> findByIdEntity(@PathVariable long id){
    	 return filmerepository.findById(id)
    			 .map(listID -> ResponseEntity.ok().body(listID))
    			 .orElse(ResponseEntity.notFound().build());
    }
}
