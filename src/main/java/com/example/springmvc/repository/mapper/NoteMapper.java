package com.example.springmvc.repository.mapper;

import com.example.springmvc.entity.Note;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class NoteMapper implements RowMapper<Note> {
    @Override
    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
                if(rowNum>0){
                   return Note.builder().
                            id(rs.getLong(1)).
                            message(rs.getString(2)).
                            date(rs.getDate(3)).
                            build();
                }
                return null;
    }
}
