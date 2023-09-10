package com.example.moduldev12.CRUD;

import com.example.moduldev12.entity.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NoteService {

    private static List<Note> notes = new ArrayList<>();

    public List<Note> listAll() {
        return notes;
    }

    public Note add(Note note) {
        notes.add(note);
        return note;
    }

    public Object deleteById(long id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                notes.remove(note);
                System.out.println("Note Delete!");
                break;
            }
        }
        return null;
    }

    public void update(Note note, String title, String content) {
        if(notes.contains(note)){
            note.setTitle(title);
            note.setContent(content);
        }

    }

    public Note getById(long id) {

        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }
}
