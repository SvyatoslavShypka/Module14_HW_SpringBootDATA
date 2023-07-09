package com.goit.module14_hw_springdata.mapper;

import com.goit.module14_hw_springdata.dto.NoteDto;
import com.goit.module14_hw_springdata.entity.Note;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class NoteMapper implements Mapper<Note, NoteDto> {

    @Override
    public NoteDto mapEntityToDto(Note source) throws RuntimeException {
        if (isNull(source)) {
            return null;
        }
        NoteDto target = new NoteDto();
        target.setId(source.getId());
        target.setTitle(source.getTitle());
        target.setContent(source.getContent());
        return target;
    }

    @Override
    public Note mapDtoToEntity(NoteDto source) {
        if (isNull(source)) {
            return null;
        }
        Note target = new Note();
        target.setId(source.getId());
        target.setTitle(source.getTitle());
        target.setContent(source.getContent());
        return target;
    }
}
