package com.personalproject.AppBreadCRM.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class SolutionController {

    @Autowired
    private SolutionService solutionService;

    @GetMapping(value = "/solutions")
    public ModelAndView readAllSolutions(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("solutions");
        maw.addObject("solutionList", solutionService.readAllSolutions());
        return maw;
    }
    @GetMapping(value = "/solutions/{id}")
    public ModelAndView readOneSolution(@PathVariable long id){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("solutionpage");
        maw.addObject("solutionInfo", solutionService.getSolutionById(id));
        return maw;
    }

    @PutMapping(value = "/solutions")
    public void updateSolution(Solution solution){
        solutionService.updateSolution(solution);
    }

    @PostMapping(value = "/solutions")
    public void createSolution(@RequestBody Solution solution){
        solutionService.createSolution(solution);
    }

    @DeleteMapping(value = "/solutions/{id}")
    @ResponseBody
    public ModelAndView deleteSolution(@PathVariable("id") long id){
        solutionService.deleteSolution(id);
        return new ModelAndView("redirect:/solutions");

    }
}
