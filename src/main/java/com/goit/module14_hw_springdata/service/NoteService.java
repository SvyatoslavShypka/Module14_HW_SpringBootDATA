package com.goit.module14_hw_springdata.service;

import com.goit.module14_hw_springdata.dto.NoteDto;
import com.goit.module14_hw_springdata.entity.Note;
import com.goit.module14_hw_springdata.mapper.NoteMapper;
import com.goit.module14_hw_springdata.repository.NoteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final NoteMapper noteMapper;

    public NoteService(NoteRepository noteRepository, NamedParameterJdbcTemplate jdbcTemplate, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.jdbcTemplate = jdbcTemplate;
        this.noteMapper = noteMapper;
    }

    public List<NoteDto> listAll() {
        List<Note> result = noteRepository.findAll();
        return noteMapper.mapEntityToDto(result);
    }

    public NoteDto add(Note note) {
        Random random = new Random();
        note.setId(random.nextLong(1000000));
        noteRepository.save(note);
        return noteMapper.mapEntityToDto(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }

    public NoteDto getById(long id) {
        String query = "SELECT n.id, n.title, n.content FROM notes n WHERE id=:id";
        return jdbcTemplate.queryForObject(
                query,
                Map.of("id", id),
                (resultSet, index) -> {
                    return NoteDto.of(
                            resultSet.getLong("id"),
                            resultSet.getString("title"),
                            resultSet.getString("content")
                    );
                }
        );
    }

    @PostConstruct
    public void construct() {
//        log.info("CustomerService construct");
    }

    @PreDestroy
    public void destroy() {
//        log.info("CustomerService destroy");
    }
}
