package com.example.JDBC_Assignment.controller;

import com.example.JDBC_Assignment.entity.Staff;
import com.example.JDBC_Assignment.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    //1. Get all staff
    @GetMapping("/getallstaff")
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    //2. Get staff with id 3
    @GetMapping("/staffid")
    public List<Staff> getStaffWithID3(){
        return staffService.getStaffWithID3();
    }

    //3. Insert into staff
    @PostMapping("/add")
    public String addStaff(@RequestBody Staff staff) {
        staffService.insertStaff(staff);
        return "Staff inserted successfully";
    }

    //4. List of Staffs with salary grater than 20k
    @GetMapping("/staff_salary_gt_20k")
    public List<Staff> getStaffWithSalaryGreaterThan20k(){
        return staffService.getStaffWithSalaryGreaterThan20k();
    }

    //5. List of staff with experience b/w 10 to 20 yrs
    @GetMapping("/staff_with_exp_between_10_n_20")
    public List<Staff> getStaffWithExp10To20(){
        return staffService.getStaffWithExp10To20();
    }

    //6. Staff with Maximum salary
    @GetMapping("/max_salary")
    public Staff maxSalaryStaff() {
        return staffService.maxSalaryStaff();
    }

    //error
    //7. Update salary of a staff
    @PutMapping("/update/{id}/{salary}")
    public String updateSalary(@PathVariable int id, @PathVariable int salary){
        staffService.updateSalary(id, salary);
        return "Salary updated";
    }

    //8. Get staff with minimum experience
    @GetMapping("/min_exp")
    public String getStaffNameWithMinExperience(){
        return staffService.getStaffNameWithMinExperience();
    }

    //9. List of staff with profile trainer
    @GetMapping("/staff_profile_trainer")
    public List<Staff> staffProfileTrainer(){
        return staffService.staffProfileTrainer();
    }

    //10. List of staff with profile not as a trainer
    @GetMapping("/staff_profile_not_trainer")
    public List<Staff> staffProfileNotTrainer(){
        return staffService.staffProfileNotTrainer();
    }
}
