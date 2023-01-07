package be.helb.PierrePlay.services;

import be.helb.PierrePlay.daos.PlatformDao;
import be.helb.PierrePlay.models.Platform;
import be.helb.PierrePlay.models.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformService {
    @Autowired
    private PlatformDao platformDao;
    public PlatformService(PlatformDao platformDao) { this.platformDao = platformDao; }

    public List<Platform> getAll() { return platformDao.findAll(); }

    public Platform getById(Long id) { return platformDao.findById(id).orElse(null); }

    public Platform save(Platform platform) { return platformDao.save(platform); }

    public void delete(Platform platform) { platformDao.delete(platform); }

    public void update(Platform platform) { platformDao.save(platform); }

    public PlatformDao getPlatformDao() {
        return platformDao;
    }

    public void setPlatformDao(PlatformDao platformDao) {
        this.platformDao = platformDao;
    }
}