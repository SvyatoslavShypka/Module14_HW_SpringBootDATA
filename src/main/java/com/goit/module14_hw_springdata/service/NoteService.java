package com.goit.module14_hw_springdata.service;

import com.goit.module14_hw_springdata.entity.Note;
import com.goit.module14_hw_springdata.exception.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {

    private Map<Long, Note> map = new HashMap<>();

    public NoteService() {
    }

    public List<Note> listAll() {
        List<Note> result = new ArrayList<>();
        for (Map.Entry<Long, Note> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public Note add(Note note) {
        Random random = new Random();
        note.setId(random.nextLong(1000000));
        map.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        if (map.remove(id) == null) {
            throw new RecordNotFoundException("Note was not found");
        }
    }

    public void update(Note note) {
        Note getNote = getById(note.getId());
        getNote.setTitle(note.getTitle());
        getNote.setContent(note.getContent());
    }

    public Note getById(long id) {
        Note result;
        result = map.get(id);
        if (result == null) {
            throw new RecordNotFoundException("Note was not found");
        }
        return result;
    }

    public Map<Long, Note> getMap() {
        return this.map;
    }

    public void setMap(Map<Long, Note> map) {
        this.map = map;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof NoteService)) return false;
        final NoteService other = (NoteService) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$map = this.getMap();
        final Object other$map = other.getMap();
        if (this$map == null ? other$map != null : !this$map.equals(other$map)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof NoteService;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $map = this.getMap();
        result = result * PRIME + ($map == null ? 43 : $map.hashCode());
        return result;
    }

    public String toString() {
        return "NoteService(map=" + this.getMap() + ")";
    }
}
