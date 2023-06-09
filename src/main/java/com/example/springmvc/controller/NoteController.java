package com.example.springmvc.controller;

import com.example.springmvc.entity.Note;
import com.example.springmvc.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/note")
@Slf4j
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(@Autowired NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping
    public String getAllNotes(Model model){
        model.addAttribute("notes",noteRepository.getAll());
        return "all";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id, Model model){
        Optional<Note> noteOptional = noteRepository.getById(id);
        if(noteOptional.isPresent()){
            model.addAttribute("note",noteOptional.get());
        }else {
            model.addAttribute("error","note not found");
        }
        return "note";
    }

}
