package com.goit.module14_hw_springdata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name = "notes")
public class Note {

    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "content")
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
