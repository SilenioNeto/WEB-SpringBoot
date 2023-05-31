package web.repository;

import org.springframework.data.repository.CrudRepository;
import web.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, String> {
	Livro findById(long id);
}
