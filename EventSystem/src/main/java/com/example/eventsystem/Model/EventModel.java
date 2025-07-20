package com.example.eventsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventModel {
    private String ID , description ;
    private int capacity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String startDate , endDate;
}
