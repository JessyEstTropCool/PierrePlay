package be.helb.PierrePlay.services;

import be.helb.PierrePlay.daos.CompanyDao;
import be.helb.PierrePlay.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;
    public CompanyService(CompanyDao companyDao) { this.companyDao = companyDao; }

    public List<Company> getAll() { return companyDao.findAll(); }

    public Company getById(Long id) { return companyDao.findById(id).orElse(null); }

    public CompanyDao getCompanyDao() {
        return companyDao;
    }

    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }
}