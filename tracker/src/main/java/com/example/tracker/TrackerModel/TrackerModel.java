package com.example.tracker.TrackerModel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrackerModel {
    private String ID;
    private String title;
    private String description;
    private String status;
    private String companyName;

}
