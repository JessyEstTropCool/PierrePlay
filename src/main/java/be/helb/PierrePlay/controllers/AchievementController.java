package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.services.AchievementService;
import be.helb.PierrePlay.models.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping(path="achievements/add")
    public Achievement addAchievement(@RequestBody Achievement achievement) {
        achievement.setAchievementId(null);
        achievementService.save(achievement);
        return achievement;
    }

    @DeleteMapping(path="achievements/{id}")
    public @ResponseBody String deleteAchievement(@PathVariable long id) {
        Achievement achievement = achievementService.getById(id);

        if ( achievement != null )
        {
            achievementService.delete(achievement);
            return "Delete Successfully";
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Achievement not found");
    }

    @PutMapping(path="achievements/{id}")
    public Achievement updateAchievement(@PathVariable long id, @RequestBody Achievement achievement) {
        achievement.setAchievementId(id);
        achievementService.save(achievement);
        return achievement;
    }
}
