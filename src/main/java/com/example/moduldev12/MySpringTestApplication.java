package com.example.moduldev12;

import com.example.moduldev12.service.NoteService;
import com.example.moduldev12.entity.Note;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringTestApplication {

	public static void main(String[] args) {

		SpringApplication.run(MySpringTestApplication.class, args);

		NoteService noteService = new NoteService();

		noteService.add(new Note("Test1", "Some Content-1")); // додає нову нотатку у список та генерує ID
		noteService.add(new Note("Test2", "Some Content-2"));
		noteService.add(new Note("Test3", "Some Content-3"));
//		Note noteTest = noteService.add(new Note("Note", "Content"));
//
//		List<Note> noteList = noteService.listAll(); //повертає список усіх нотаків
//
//		noteList.forEach(note -> System.out.println("note = " + note));
//
//		noteService.deleteById(noteService.listAll().get(1).getId());//видаляє нотатку за ID
//
//		noteService.update(noteTest, "A", "C");//оновлює нотатку
//
//		Note byId = noteService.getById(noteService.listAll().get(0).getId()); // повертає нотатку за ID
//		System.out.println(byId.toString());
//
//		noteList.forEach(note -> System.out.println("note = " + note));


	}

}
