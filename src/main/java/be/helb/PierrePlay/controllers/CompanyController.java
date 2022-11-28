package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.daos.CompanyDao;
import be.helb.PierrePlay.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController
{
    @Autowired
    private CompanyDao companyDao;

    @GetMapping("companys")
    public List<Company> CompanyList()
    {
        return companyDao.findAll();
    }
}

