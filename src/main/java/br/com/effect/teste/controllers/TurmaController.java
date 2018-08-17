package br.com.effect.teste.controllers;

import br.com.effect.teste.domain.Turma;
import br.com.effect.teste.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/turma")
public class TurmaController
{

    @Autowired
    private TurmaService turmaService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form() {
        return new ModelAndView("turma/form");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("turma/list");
        List<Turma> turmaList = turmaService.findAll();
        model.addObject("list", turmaList);
        if (turmaList.size() == 0) {
            model.addObject("teste", true);
        }
        return model;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView deleteTurma(@PathVariable long id) {
        turmaService.delete(id);
        return new ModelAndView("redirect:/turma");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("turma") Turma turma) {
        ModelAndView model = new ModelAndView("turma/index");
        if (turma != null) {
            turmaService.save(turma);
            model.addObject("mensage", "Turma cadastrado com sucesso!");

        } else {
            model.addObject("mensage", "Algum Erro Aconteceu!");

        }
        return new ModelAndView("redirect:/turma");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") long id) {
        ModelAndView model = new ModelAndView("turma/edit");
        Turma turma = turmaService.findOne(id);
        model.addObject("turma", turma);
        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("id") long id,
                               @RequestParam("periodo") String periodo, @RequestParam("numero") String numero) {
        Turma turma = turmaService.findOne(id);
        turma.setPeriodo(periodo);
        turma.setNumero(numero);
        turmaService.save(turma);
        return new ModelAndView("redirect:/turma");
    }
}
