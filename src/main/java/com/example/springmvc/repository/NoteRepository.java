package com.example.springmvc.repository;

import com.example.springmvc.entity.Note;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface NoteRepository {
    List<Note> getAll();

    boolean delete(Long id);

    Optional<Note> getById(Long id);

    boolean update(Long id, String message, Date date);

    boolean add(String message,Date date);
}
