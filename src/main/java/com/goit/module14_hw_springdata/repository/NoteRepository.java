package com.goit.module14_hw_springdata.repository;

import com.goit.module14_hw_springdata.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
