package app.embadm.controller;

import app.embadm.entity.MateriaEntidade;
import app.embadm.enuns.MateriaAcoesEnum;
import app.embadm.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping("inserir-materia")
    public String inserirMateria (Model model) {
        MateriaEntidade materia = new MateriaEntidade();
        return materiaService.adicionarAtributoDaResposta("materia", model.addAttribute(materia))
                .redirecionar(MateriaAcoesEnum.REDIRECIONAR_MATERIA);
    }

    @RequestMapping(path = "salvar-materia", method = RequestMethod.POST)
    public String salvarMateria (MateriaEntidade materiaEntidade) {
        materiaEntidade.setAtivo(true);
        return materiaService.salvarMateria(materiaEntidade)
                .redirecionar(MateriaAcoesEnum.REDIRECIONAR_MATERIA);
    }
}
