package com.example.moduldev12.service;

import com.example.moduldev12.entity.Note;
import com.example.moduldev12.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> findAll() {
        return noteRepository.findAll();
    }
    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElse(null);
    }

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public void updateNote(Note note, String title, String content) {
        note.setTitle(title);
        note.setContent(content);
        noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

}
