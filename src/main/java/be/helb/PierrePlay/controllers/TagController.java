package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Tag;
import be.helb.PierrePlay.services.TagService;
import be.helb.PierrePlay.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController 
{
    @Autowired
    private TagService tagService;

    @GetMapping("tags")
    public List<Tag> TagList()
    {
        return tagService.getAll();
    }

    @GetMapping("tags/{id}")
    public Tag tagById(@PathVariable long id) {
        return tagService.getById(id);
    }
}
