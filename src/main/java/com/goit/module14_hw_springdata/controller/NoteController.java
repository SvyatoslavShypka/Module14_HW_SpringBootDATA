package com.goit.module14_hw_springdata.controller;

import com.goit.module14_hw_springdata.entity.Note;
import com.goit.module14_hw_springdata.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/note")
@Controller
public class NoteController {

    NoteService noteService = new NoteService();

    @GetMapping("/edit")
    public String showAddNoteForm(Note note) {
        return "add-note";
    }

    @PostMapping("/edit")
    public String addNote(Note note, BindingResult result) {
        if (result.hasErrors()) {
            return "add-note";
        }
        noteService.add(note);
        return "redirect:/note/list";
    }

    @GetMapping("/list")
    public String showAllNotes(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Note note = noteService.getById(id);

        model.addAttribute("note", note);
        return "update-note";
    }

    @PostMapping("/update/{id}")
    public String updateNote(@PathVariable("id") long id, Note note,
                             BindingResult result) {
        if (result.hasErrors()) {
            note.setId(id);
            return "update-note";
        }
        noteService.update(note);
        return "redirect:/note/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}
