package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.daos.AchievementDao;
import be.helb.PierrePlay.models.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AchievementController
{
    @Autowired
    private AchievementDao achievementDao;

    @GetMapping("achievements")
    public List<Achievement> AchievementList()
    {
        return achievementDao.findAll();
    }
}
