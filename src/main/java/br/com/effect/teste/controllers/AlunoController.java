package br.com.effect.teste.controllers;

import br.com.effect.teste.domain.Aluno;
import br.com.effect.teste.domain.Turma;
import br.com.effect.teste.service.AlunoService;
import br.com.effect.teste.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;
    @Autowired
    private TurmaService turmaService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView model = new ModelAndView("aluno/form");
        List<Turma> turmas = turmaService.findAll();
        model.addObject("turmas", turmas);
        return model;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("aluno/list");
        List<Aluno> alunoList = alunoService.findAll();
        model.addObject("list", alunoList);
        if (alunoList.size() == 0) {
            model.addObject("teste", true);
        }
        return model;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView deleteAluno(@PathVariable long id) {
        alunoService.delete(id);
        return new ModelAndView("redirect:/aluno");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("aluno") Aluno aluno) {
        ModelAndView model = new ModelAndView("aluno/index");
        if (aluno != null) {
            alunoService.save(aluno);
            model.addObject("mensage", "Aluno cadastrado com sucesso!");

        } else {
            model.addObject("mensage", "Algum Erro Aconteceu!");

        }
        return new ModelAndView("redirect:/aluno");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") long id) {
        ModelAndView model = new ModelAndView("aluno/edit");
        Aluno aluno = alunoService.findOne(id);
        List<Turma> turmas = turmaService.findAll();
        model.addObject("turmas", turmas);
        model.addObject("aluno", aluno);
        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("id") long id,
                               @RequestParam("nome") String nome, @RequestParam("matricula") Integer matricula,
                               @RequestParam("dataNascimento") String dataNascimento,
                               @RequestParam("turmas") Set<Turma> turmas) {
        Aluno aluno = alunoService.findOne(id);
        aluno.setNome(nome);
        aluno.setMatricula(matricula);
        aluno.setDataNascimento(dataNascimento);
        aluno.setTurmas(turmas);
        alunoService.save(aluno);
        return new ModelAndView("redirect:/aluno");
    }
}
