package be.helb.PierrePlay.services;

import be.helb.PierrePlay.daos.TagDao;
import be.helb.PierrePlay.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagDao tagDao;
    public TagService(TagDao tagDao) { this.tagDao = tagDao; }

    public List<Tag> getAll() { return tagDao.findAll(); }

    public Tag getById(Long id) { return tagDao.findById(id).orElse(null); }

    public TagDao getTagDao() {
        return tagDao;
    }

    public void setTagDao(TagDao tagDao) {
        this.tagDao = tagDao;
    }
}