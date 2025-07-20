package com.example.tracker.TrackerController;

import com.example.tracker.API.ApiResponse;
import com.example.tracker.TrackerModel.TrackerModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tracker")
public class TrackerController {

    ArrayList<TrackerModel> trackerList = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<TrackerModel> getTrackerList() {
        return trackerList;
    }

    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody TrackerModel tracker){
        trackerList.add(tracker);
        return new ApiResponse("Tracker Added Successfully", "200");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@RequestBody TrackerModel tracker, @PathVariable int index){
        trackerList.set(index, tracker);
        return new ApiResponse("Tracker Updated Successfully", "200");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index){
        trackerList.remove(index);
        return new ApiResponse("Tracker Deleted Successfully", "200");
    }

    @PutMapping("/changeStatus/{index}")
    public ApiResponse ChangeStatus(@PathVariable int index, @RequestParam String status){
        trackerList.get(index).setStatus(status);
        return new ApiResponse("Status Changed Successfully", "200");
    }

    @GetMapping("/search")
    public ApiResponse searchProject(@RequestParam String title){
        for(TrackerModel tracker : trackerList){
            if(tracker.getTitle().equals(title)){
                return new ApiResponse("Tracker Found Successfully", "200");
            }
        }
        return new ApiResponse("Tracker Not Found", "404");
    }

    @GetMapping("/get/company")
    public ArrayList<TrackerModel> getAllProjectByOneCompany(@RequestParam String companyName) {
        ArrayList<TrackerModel> trackerList = new ArrayList<>();
        for(TrackerModel tracker : this.trackerList){
            if(tracker.getCompanyName().equals(companyName)){
                trackerList.add(tracker);
            }
        }
        return trackerList;
    }



}
