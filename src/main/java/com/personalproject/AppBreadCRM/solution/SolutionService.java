package com.personalproject.AppBreadCRM.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionService {

    @Autowired
    private SolutionRepository solutionRepository;

    public List<Solution> readAllSolutions(){
        return (List<Solution>) solutionRepository.findAll();
    }
    public Solution readOneSolution(long id){
        return getSolutionById(id);
    }

    public void updateSolution(Solution solution){
        solutionRepository.save(solution);
    }

    public void createSolution(Solution solution){
        solutionRepository.save(solution);
    }

    public void deleteSolution(long id){
        solutionRepository.delete(getSolutionById(id));
    }


    public Solution getSolutionById(long id) {
        Solution solution = solutionRepository.findById(id).get();
        return solution;
    }

}
