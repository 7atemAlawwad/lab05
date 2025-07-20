package com.example.eventsystem.Controller;

import com.example.eventsystem.API.ApiResponse;
import com.example.eventsystem.Model.EventModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    ArrayList<EventModel> events = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<EventModel> getEvents() {
        return events;
    }

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody EventModel eventModel) {
        events.add(eventModel);
        return new ApiResponse("Event added successfully", "200");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@RequestBody EventModel eventModel, @PathVariable int index) {
        events.set(index, eventModel);
        return new ApiResponse("Event updated successfully", "200");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("Event deleted successfully", "200");
    }

    @PutMapping("/changeCapacity/{index}")
    public ApiResponse changeCapacity(@RequestBody int capacity, @PathVariable int index){
        events.get(index).setCapacity(capacity);
        return new ApiResponse("Event capacity updated successfully", "200");
    }

    @GetMapping("/search/{ID}")
    public ApiResponse searchEvent(@PathVariable String ID){
        for(EventModel event : events){
            if(event.getID().equals(ID)){
                return new ApiResponse("Event found successfully", "200");
            }
        }
        return new ApiResponse("Event not found", "404");

    }


}
