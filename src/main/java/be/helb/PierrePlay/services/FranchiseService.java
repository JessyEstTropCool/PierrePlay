package be.helb.PierrePlay.services;

import be.helb.PierrePlay.daos.FranchiseDao;
import be.helb.PierrePlay.models.Franchise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranchiseService {
    @Autowired
    private FranchiseDao franchiseDao;
    public FranchiseService(FranchiseDao franchiseDao) { this.franchiseDao = franchiseDao; }

    public List<Franchise> getAll() { return franchiseDao.findAll(); }

    public Franchise getById(Long id) { return franchiseDao.findById(id).orElse(null); }

    public FranchiseDao getFranchiseDao() {
        return franchiseDao;
    }

    public void setFranchiseDao(FranchiseDao franchiseDao) {
        this.franchiseDao = franchiseDao;
    }
}
