package be.helb.PierrePlay.services;

import be.helb.PierrePlay.daos.AchievementDao;
import be.helb.PierrePlay.models.Achievement;
import be.helb.PierrePlay.models.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AchievementService {
    @Autowired
    private AchievementDao achievementDao;
    public AchievementService(AchievementDao achievementDao) { this.achievementDao = achievementDao; }

    public List<Achievement> getAll() { return achievementDao.findAll(); }

    public Achievement getById(Long id) { return achievementDao.findById(id).orElse(null); }

    public AchievementDao getAchievementDao() {
        return achievementDao;
    }

    public void setAchievementDao(AchievementDao achievementDao) {
        this.achievementDao = achievementDao;
    }

    public Achievement save(Achievement achievement) { return achievementDao.save(achievement); }

    public void delete(Achievement achievement) { achievementDao.delete(achievement); }

    public void update(Achievement achievement) { achievementDao.save(achievement); }
}
