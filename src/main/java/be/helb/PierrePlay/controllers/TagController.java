package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.daos.TagDao;
import be.helb.PierrePlay.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController 
{
    @Autowired
    private TagDao tagDao;

    @GetMapping("tags")
    public List<Tag> TagList()
    {
        return tagDao.findAll();
    }
}
