package com.example.springmvc.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Note {
    private final Long id;
    private final String message;
    private final Date date;

}
