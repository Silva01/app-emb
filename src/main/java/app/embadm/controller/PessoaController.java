package app.embadm.controller;

import app.embadm.entity.PessoaEntidade;
import app.embadm.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("inserir-pessoa")
    public String inserirPessoa (Model model) {
        PessoaEntidade pessoaEntidade = new PessoaEntidade();
        model.addAttribute("pessoa", pessoaEntidade);
        return "pessoa/inserir-pessoa";
    }

    @RequestMapping(path = "salvar-pessoa", method = RequestMethod.POST)
    public String salvar(PessoaEntidade pessoaEntidade) {
        pessoaEntidade.setAtivo(true);
        pessoaService.salvarPessoa(pessoaEntidade);
        return "redirect:/pessoas/listar-pessoas";
    }

    @GetMapping("listar-pessoas")
    public String listarPessoas (Model model) {
        model.addAttribute("listarPessoas", pessoaService.listarTodasPessoas());
        return "pessoas/listar-pessoas";
    }

    @RequestMapping(path = "/deletar-pessoa/{cpf}")
    public String deletarPessoaPorCpf (@PathVariable("cpf") Integer cpf, Model model) {
        pessoaService.deletarPessoaPorCpf(cpf);
        model.addAttribute("listarPessoas", pessoaService.listarTodasPessoas());
        return "redirect:/pessoas/listar-pessoas";
    }

    @GetMapping("atualizar-pessoa/{cpf}")
    public String atualizarPessoaPorCpf (@PathVariable("cpf") Integer cpf, Model model) {
        model.addAttribute("pessoa", pessoaService.obterPessoaPorCpf(cpf));
        return "pessoa/inserir-pessoa";
    }

}
