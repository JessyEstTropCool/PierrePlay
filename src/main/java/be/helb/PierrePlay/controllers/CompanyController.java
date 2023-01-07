package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Company;
import be.helb.PierrePlay.models.Company;
import be.helb.PierrePlay.models.MyUser;
import be.helb.PierrePlay.services.CompanyService;
import be.helb.PierrePlay.models.Company;
import be.helb.PierrePlay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CompanyController
{
    private CompanyService companyService;
    private UserService userService;

    @Autowired
    public CompanyController(CompanyService companyService, UserService userService)
    {
        this.companyService = companyService;
        this.userService = userService;

    }

    @GetMapping("companies")
    public List<Company> CompanyList()
    {
        return companyService.getAll();
    }

    @GetMapping("companies/{id}")
    public Company companyById(@PathVariable long id) {
        return companyService.getById(id);
    }

    @PostMapping(path="companies/add")
    public Company addCompany(@RequestBody Company company) {
        company.setCompanyId(null);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        company.setOwner( userService.getByUsername(username) );
        companyService.save(company);
        return company;
    }

    @DeleteMapping(path="companies/{id}")
    public @ResponseBody String deleteCompany(@PathVariable long id) {
        Company company = companyService.getById(id);

        if ( company != null )
        {
            companyService.delete(company);
            return "Delete Successfully";
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
    }

    @PutMapping(path="companies/{id}")
    public Company updateCompany(@PathVariable long id, @RequestBody Company company) {
        company.setCompanyId(id);
        if (companyService.getById(id) != null)
        {
            companyService.save(company);
            return company;
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
    }
}

