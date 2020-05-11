package app.embadm.repository;

import app.embadm.entity.PessoaEntidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaEntidade, Integer> {

}
