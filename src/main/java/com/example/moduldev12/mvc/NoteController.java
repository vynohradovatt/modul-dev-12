package com.example.moduldev12.mvc;

import com.example.moduldev12.CRUD.NoteService;
import com.example.moduldev12.entity.Note;
import lombok.NonNull;
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

    @PostMapping(value = ("/delete/{id}"))
    public String postDelete(@PathVariable(name = "id", required = false) long id){
        noteService.deleteById(id);
        return "redirect:/note/list";

    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView toUpdateNote(@PathVariable(name = "id", required = false) long id){
        ModelAndView result = new ModelAndView("edit-note");
        result.addObject("update", "Починаемо редагувати нотатки з id= " + id);
        Note note = noteService.getById(id);
        result.addObject("note", note);
        return  result;

    }

    @PostMapping(value = ("/edit/{id}"))
    public ModelAndView postDelete(
            @PathVariable(name = "id", required = false) long id,
            @RequestParam String title,
            @RequestParam String content){

        noteService.update(noteService.getById(id), title, content);
        ModelAndView result = new ModelAndView("redirect:/note/list");
        return result;

    }

}
