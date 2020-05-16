package app.embadm.service;

import app.embadm.entity.PessoaEntidade;
import app.embadm.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void salvarPessoa (PessoaEntidade pessoa) {pessoaRepository.save(pessoa); }

    public List<PessoaEntidade> listarTodasPessoas () {
        return StreamSupport.stream(pessoaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deletarPessoaPorCpf (String cpf) {pessoaRepository.deleteByCpf(cpf); }

    public PessoaEntidade obterPessoaPorCpf (String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }
    
}
