package com.example.JDBC_Assignment.controller;

import com.example.JDBC_Assignment.entity.Staff;
import com.example.JDBC_Assignment.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;
    //Constructor based injection
    public StaffController(StaffService staffService){
        this.staffService = staffService;
    }

    //1. Get all staff
    @GetMapping("/get_all_staff")
    public List<Staff> getAllStaff(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        return staffService.getAllStaff(page, size);
    }

    //2. Get staff with id
    @GetMapping("/get_staff_by_id/{id}")
    public Staff getStaffWithId(@PathVariable int id){
        return staffService.getStaffWithId(id);
    }

    //3. Insert into staff
    @PostMapping("/add")
    public String addStaff(@RequestBody Staff staff) {
        staffService.insertStaff(staff);
        return "Staff inserted successfully";
    }

    //4. List of Staffs with salary grater than a particular value
    @GetMapping("/staff_salary_greater_than/{salary}")
    public List<Staff> getStaffWithSalaryGreaterThanX(@PathVariable int salary){
        return staffService.getStaffWithSalaryGreaterThanX(salary);
    }

    //5. List of staff with experience b/w Start and End yrs
    @GetMapping("/staff_with_exp_between/{start}/{end}")
    public List<Staff> getStaffWithExpStartToEnd(@PathVariable int start, @PathVariable int end){
        return staffService.getStaffWithExpStartToEnd(start, end);
    }

    //6. Staff with Maximum salary
    @GetMapping("/max_salary")
    public Staff maxSalaryStaff() {
        return staffService.maxSalaryStaff();
    }

    //7. Update salary of a staff
    @PutMapping("/update_salary/{id}/{salary}")
    public String updateSalary(@PathVariable int id, @PathVariable int salary){
        staffService.updateSalary(id, salary);
        return "Salary updated";
    }

    //8. Get staff with minimum experience
    @GetMapping("/min_exp")
    public List<Staff> getStaffNameWithMinExperience(){
        return staffService.getStaffNameWithMinExperience();
    }

    //9. List of staff with profile trainer
    @GetMapping("/get_by_staff_profile/{profileName}")
    public List<Staff> staffByProfile(@PathVariable String profileName){
        return staffService.staffByProfile(profileName);
    }

    //10. List of staff with profile not as a trainer
    @GetMapping("/get_staff_profile_not/{profile}")
    public List<Staff> staffProfileNotX(@PathVariable String profile){
        return staffService.staffProfileNotX(profile);
    }
}
