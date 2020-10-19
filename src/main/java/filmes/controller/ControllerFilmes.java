package filmes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import filmes.Repository.filmesRepository;

@RequestMapping("/movie")
@RestController
public class ControllerFilmes {
    
	private filmesRepository filmerepository;
	
    public ControllerFilmes(filmesRepository filmerepository) {
		this.filmerepository = filmerepository;
	}	
}
