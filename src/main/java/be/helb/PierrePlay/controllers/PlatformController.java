package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.daos.PlatformDao;
import be.helb.PierrePlay.models.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatformController
{
    @Autowired
    private PlatformDao platformDao;

    @GetMapping("platforms")
    public List<Platform> PlatformList()
    {
        return platformDao.findAll();
    }
}
