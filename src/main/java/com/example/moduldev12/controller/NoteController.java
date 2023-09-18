package com.example.moduldev12.controller;

import com.example.moduldev12.entity.Note;
import com.example.moduldev12.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = ("note"))
public class NoteController {

    private final NoteService noteService;

    @GetMapping(value = "/list")
    public ModelAndView listOfNotes(){
        ModelAndView result = new ModelAndView("list");
        result.addObject("listOfNotes", noteService.findAll());
        return result;
    }
    @PostMapping(value = ("/delete"))
    public String deleteNote(@RequestParam Long id){
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
    @GetMapping(value = "/create")
    public ModelAndView createNotePage(){
        ModelAndView result = new ModelAndView("create-note");
        result.addObject("note", new Note());
        return result;
    }
    @PostMapping(value = ("/create"))
    public ModelAndView createNewNote(
            @RequestParam String title,
            @RequestParam String content){
        ModelAndView result = new ModelAndView("redirect:/note/list");
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.addNote(note);
        return result;

    }
    @GetMapping(value = "/edit")
    public ModelAndView editNote(@RequestParam Long id){
        ModelAndView result = new ModelAndView("edit-note");
        result.addObject("note", noteService.getById(id));
        return  result;
    }
    @PostMapping(value = ("/edit"))
    public ModelAndView updateNote(@ModelAttribute Note note){

        noteService.updateNote(noteService.getById(note.getId()), note.getTitle(), note.getContent());
        ModelAndView result = new ModelAndView("redirect:/note/list");
        return result;

    }

}