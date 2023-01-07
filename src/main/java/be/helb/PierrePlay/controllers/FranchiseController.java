package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Franchise;
import be.helb.PierrePlay.models.Franchise;
import be.helb.PierrePlay.services.FranchiseService;
import be.helb.PierrePlay.models.Franchise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping(path="franchises/add")
    public Franchise addFranchise(@RequestBody Franchise franchise) {
        franchise.setFranchiseId(null);
        
        franchiseService.save(franchise);
        return franchise;
    }

    @DeleteMapping(path="franchises/{id}")
    public @ResponseBody String deleteFranchise(@PathVariable long id) {
        Franchise franchise = franchiseService.getById(id);

        if ( franchise != null )
        {
            franchiseService.delete(franchise);
            return "Delete Successfully";
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Franchise not found");
    }

    @PutMapping(path="franchises/{id}")
    public Franchise updateFranchise(@PathVariable long id, @RequestBody Franchise franchise) {
        franchise.setFranchiseId(id);
        if (franchiseService.getById(id) != null)
        {
            franchiseService.save(franchise);
            return franchise;
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Franchise not found");
    }
}
