package com.goit.module14_hw_springdata;

import com.goit.module14_hw_springdata.entity.Note;
import com.goit.module14_hw_springdata.exception.RecordNotFoundException;
import com.goit.module14_hw_springdata.service.NoteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class NoteServiceTest {

    NoteService noteService = new NoteService();

    @Test
    void listAll() {
//        Given
        int expectedQuantity = 2;
        List<Note> list = createListNotes();
//        When
        list.forEach(note -> noteService.add(note));
//        Then
        Assertions.assertEquals(expectedQuantity, noteService.getMap().size());
    }

    @Test
    void add() {
//        Given
        int expectedQuantity = 1;
        List<Note> list = createListNotes();
//        When
        Long id = noteService.add(list.get(0)).getId();
//        Then
        Assertions.assertEquals(expectedQuantity, noteService.getMap().size());
        Assertions.assertEquals(list.get(0), noteService.getById(id));
    }

    @Test
    void deleteById() {
//        Given
        int expectedQuantity = 1;
        List<Note> list = createListNotes();
        noteService.add(list.get(0));
        Long id = noteService.add(list.get(1)).getId();

//        When
        noteService.deleteById(id);
//        Then
        Assertions.assertEquals(expectedQuantity, noteService.getMap().size());
        Assertions.assertThrows(RecordNotFoundException.class,
                () -> noteService.deleteById(-1L),
                "Expected to throw, but it didn't" );
    }

    @Test
    void update() {
        //        Given
        int expectedQuantity = 2;
        List<Note> list = createListNotes();
        noteService.add(list.get(0));
        Long id = noteService.add(list.get(1)).getId();
        Note noteToUpdate = new Note();
        noteToUpdate.setId(id);
        String titleString = "Updated title";
        noteToUpdate.setTitle(titleString);
        String contentString = "Updated content";
        noteToUpdate.setContent(contentString);

//        When
        noteService.update(noteToUpdate);
//        Then
        Assertions.assertEquals(expectedQuantity, noteService.getMap().size());
        Assertions.assertEquals(titleString, noteService.getById(id).getTitle());
        Assertions.assertEquals(contentString, noteService.getById(id).getContent());
    }

    @Test
    void updateNotExistedNote() {
//        Given
        Note noteToUpdate = new Note();
//        When
        noteToUpdate.setId(-1L);
//        Then
        Assertions.assertThrows(RecordNotFoundException.class,
                () -> noteService.update(noteToUpdate),
                "Expected to throw, but it didn't" );
    }

    @Test
    void getById() {
        //        Given
        List<Note> list = createListNotes();
        noteService.add(list.get(0));
        noteService.add(list.get(1));
        List<Note> listAll = noteService.listAll();

//        When
        Note note = listAll.get(0);
        Long id = note.getId();
//        Then
        Assertions.assertEquals(note,
                noteService.getById(id));
        Assertions.assertThrows(RecordNotFoundException.class,
                () -> noteService.getById(-1L),
                "Expected to throw, but it didn't" );
    }

    List<Note> createListNotes() {
        List<Note> list = new ArrayList<>();
        Note testNote1 = new Note();
        testNote1.setTitle("TestNote title1");
        testNote1.setContent("TestNote content1");

        Note testNote2 = new Note();
        testNote2.setTitle("TestNote title2");
        testNote2.setContent("TestNote content2");

        list.add(testNote1);
        list.add(testNote2);
        return list;
    }
}