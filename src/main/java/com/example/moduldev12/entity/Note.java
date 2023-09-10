package com.example.moduldev12.entity;

import com.example.moduldev12.generator.GeneratorId;
import lombok.Data;

import java.util.Random;


@Data
public class Note {

    private long id;

    private String title;

    private String content;

    public Note(String title, String content){
        this.id = new GeneratorId().generateRandomId();
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
