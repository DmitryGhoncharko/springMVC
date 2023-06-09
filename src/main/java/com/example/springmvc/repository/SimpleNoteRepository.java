package com.example.springmvc.repository;

import com.example.springmvc.entity.Note;
import com.example.springmvc.repository.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class SimpleNoteRepository implements NoteRepository{

    private final JdbcTemplate jdbcTemplate;

    private final NoteMapper noteMapper;

    public SimpleNoteRepository(@Autowired JdbcTemplate jdbcTemplate,@Autowired NoteMapper noteMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.noteMapper = noteMapper;
    }

    @Override
    public List<Note> getAll() {
        return jdbcTemplate.query("select id, message, date from note", noteMapper);
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update("delete  from note where  id = ?",id)>0;
    }

    @Override
    public Optional<Note> getById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select id, message, date from note where id = ?",new Object[]{id},noteMapper));
    }

    @Override
    public boolean update(Long id, String message, Date date) {
       return jdbcTemplate.update("update  note set message = ?, date = ? where id = ?", message,date,id)>0;
    }

    @Override
    public boolean add(String message, Date date) {
        return jdbcTemplate.update("insert into  note(message,date) values (?,?)",message,date)>0;
    }
}
