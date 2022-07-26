package com.personalproject.AppBreadCRM.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SolutionController {

    @Autowired
    private SolutionService solutionService;

    @GetMapping(value = "/solutions")
    public List<Solution> readAllKnowledge(){
        return solutionService.readAllSolutions();
    }
    @GetMapping(value = "/solutions/{id}")
    public Solution readOneSolution(@PathVariable long id){
        return solutionService.readOneSolution(id);
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
    public void deleteCustomer(@PathVariable("id") long id){
        solutionService.deleteSolution(id);
    }
}
