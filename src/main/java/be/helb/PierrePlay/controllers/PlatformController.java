package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Platform;
import be.helb.PierrePlay.services.PlatformService;
import be.helb.PierrePlay.models.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
