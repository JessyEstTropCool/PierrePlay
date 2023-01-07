package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Tag;
import be.helb.PierrePlay.models.Tag;
import be.helb.PierrePlay.services.TagService;
import be.helb.PierrePlay.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping(path="tags/add")
    public Tag addTag(@RequestBody Tag tag) {
        tag.setTagId(null);
        tagService.save(tag);
        return tag;
    }

    @DeleteMapping(path="tags/{id}")
    public @ResponseBody String deleteTag(@PathVariable long id) {
        Tag tag = tagService.getById(id);

        if ( tag != null )
        {
            tagService.delete(tag);
            return "Delete Successfully";
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found");
    }

    @PutMapping(path="tags/{id}")
    public Tag updateTag(@PathVariable long id, @RequestBody Tag tag) {
        tag.setTagId(id);
        if (tagService.getById(id) != null)
        {
            tagService.save(tag);
            return tag;
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found");
    }
}
