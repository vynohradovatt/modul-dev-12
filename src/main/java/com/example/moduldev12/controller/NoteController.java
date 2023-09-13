package com.example.moduldev12.controller;

import com.example.moduldev12.service.NoteService;
import com.example.moduldev12.entity.Note;
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
        result.addObject("listOfNotes", noteService.listAll());
        return  result;
    }

    @PostMapping(value = ("/delete"))
    public String deleteNote(@RequestParam Long id){
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView editNote(@RequestParam Long id){
        ModelAndView result = new ModelAndView("edit-note");
        Note note = noteService.getById(id);
        result.addObject("note", note);
        return  result;
    }

    @PostMapping(value = ("/edit"))
    public ModelAndView updateNote(
            @RequestParam Long id,
            @RequestParam String title,
            @RequestParam String content){

        noteService.update(noteService.getById(id), title, content);
        ModelAndView result = new ModelAndView("redirect:/note/list");
        return result;

    }

}
