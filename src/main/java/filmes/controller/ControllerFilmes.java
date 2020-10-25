package filmes.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @PostMapping(value = "/save")
    public FilmeModel create(@RequestBody FilmeModel movie) {
    	return filmerepository.save(movie);
    }
    
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<FilmeModel>update(@PathVariable("id") long id,@RequestBody FilmeModel movieUpdate){
    	
       return filmerepository.findById(id)	
    		   .map(movie -> {
    			   movie.setDataLancamento(movieUpdate.getDataLancamento());
    			   movie.setNome(movieUpdate.getNome());
    			   movie.setSinopse(movieUpdate.getSinopse());
    			   FilmeModel update = filmerepository.save(movie);
    			   return ResponseEntity.ok().body(update);
    		   }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(path = "/remove/id/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
         
    	return filmerepository.findById(id)
    			.map(deleteMovie -> {
    				filmerepository.deleteById(id);
    				return ResponseEntity.ok().build();
    			}).orElse(ResponseEntity.notFound().build());
    }
}












