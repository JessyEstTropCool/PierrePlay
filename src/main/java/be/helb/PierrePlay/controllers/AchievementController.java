package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Game;
import be.helb.PierrePlay.services.AchievementService;
import be.helb.PierrePlay.models.Achievement;
import be.helb.PierrePlay.services.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AchievementController
{
    @Autowired
    private AchievementService achievementService;

    @GetMapping("achievements")
    public List<Achievement> AchievementList()
    {
        return achievementService.getAll();
    }

    @GetMapping("achievements/{id}")
    public Achievement achievementById(@PathVariable long id) {
        return achievementService.getById(id);
    }
}
