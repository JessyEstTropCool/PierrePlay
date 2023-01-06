package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Franchise;
import be.helb.PierrePlay.services.FranchiseService;
import be.helb.PierrePlay.models.Franchise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FranchiseController
{
    @Autowired
    private FranchiseService franchiseService;

    @GetMapping("franchises")
    public List<Franchise> FranchiseList()
    {
        return franchiseService.getAll();
    }
    
    @GetMapping("franchises/{id}")
    public Franchise franchiseById(@PathVariable long id) {
        return franchiseService.getById(id);
    }
}
