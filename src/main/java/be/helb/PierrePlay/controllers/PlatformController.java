package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Platform;
import be.helb.PierrePlay.models.Platform;
import be.helb.PierrePlay.services.PlatformService;
import be.helb.PierrePlay.models.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PlatformController
{
    @Autowired
    private PlatformService platformService;

    @GetMapping("platforms")
    public List<Platform> PlatformList()
    {
        return platformService.getAll();
    }

    @GetMapping("platforms/{id}")
    public Platform platformById(@PathVariable long id) {
        return platformService.getById(id);
    }

    @PostMapping(path="platforms/add")
    public Platform addPlatform(@RequestBody Platform platform) {
        platform.setPlatformId(null);
        platformService.save(platform);
        return platform;
    }

    @DeleteMapping(path="platforms/{id}")
    public @ResponseBody String deletePlatform(@PathVariable long id) {
        Platform platform = platformService.getById(id);

        if ( platform != null )
        {
            platformService.delete(platform);
            return "Delete Successfully";
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Platform not found");
    }

    @PutMapping(path="platforms/{id}")
    public Platform updatePlatform(@PathVariable long id, @RequestBody Platform platform) {
        platform.setPlatformId(id);
        if (platformService.getById(id) != null)
        {
            platformService.save(platform);
            return platform;
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Platform not found");
    }
}
