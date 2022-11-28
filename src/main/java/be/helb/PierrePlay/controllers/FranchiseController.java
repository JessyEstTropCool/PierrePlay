package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.daos.FranchiseDao;
import be.helb.PierrePlay.models.Franchise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FranchiseController
{
    @Autowired
    private FranchiseDao franchiseDao;

    @GetMapping("franchises")
    public List<Franchise> FranchiseList()
    {
        return franchiseDao.findAll();
    }
}
