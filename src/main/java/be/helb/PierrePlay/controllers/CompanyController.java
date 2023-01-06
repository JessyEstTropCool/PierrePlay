package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Company;
import be.helb.PierrePlay.services.CompanyService;
import be.helb.PierrePlay.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController
{
    @Autowired
    private CompanyService companyService;

    @GetMapping("companys")
    public List<Company> CompanyList()
    {
        return companyService.getAll();
    }

    @GetMapping("companys/{id}")
    public Company companyById(@PathVariable long id) {
        return companyService.getById(id);
    }
}

