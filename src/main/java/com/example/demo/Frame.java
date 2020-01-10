package com.example.demo;

import lombok.Data;

import java.util.List;

@Data
public class Frame {
    private Integer number;
    private List<Event> events;
}
