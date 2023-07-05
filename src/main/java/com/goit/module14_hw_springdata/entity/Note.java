package com.goit.module14_hw_springdata.entity;

import org.springframework.stereotype.Component;

@Component
public class Note {

    Long id;
    String title;
    String content;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "Note(id=" + this.getId() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ")";
    }
}
