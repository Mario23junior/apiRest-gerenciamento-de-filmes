package filmes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import filmes.model.FilmeModel;

public interface filmesRepository extends JpaRepository<FilmeModel, Long>{

}
