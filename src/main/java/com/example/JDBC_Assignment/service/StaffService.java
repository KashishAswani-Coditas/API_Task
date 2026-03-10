package com.example.JDBC_Assignment.service;

import com.example.JDBC_Assignment.dao.StaffDao;
import com.example.JDBC_Assignment.entity.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffDao staffDao;
    //constructor based injection
    public StaffService(StaffDao staffDao){
        this.staffDao = staffDao;
    }


    //1
    public List<Staff> getAllStaff(int page, int size) {
        return staffDao.getAllStaff(page, size);

    }

    //2
    public Staff getStaffWithId(int id){
        return staffDao.getStaffWithId(id);
    }

    //3
    public void insertStaff(Staff staff){
         staffDao.insertStaff(staff);
    }

    //4
    public List<Staff> getStaffWithSalaryGreaterThanX(int salary){
        return staffDao.getStaffWithSalaryGreaterThanX(salary);
    }

    //5
    public List<Staff> getStaffWithExpStartToEnd(int start, int end){
        return staffDao.getStaffWithExpStartToEnd(start, end);
    }

    //6
    public Staff maxSalaryStaff() {
        return staffDao.maxSalaryStaff();
    }

    //7
    public int updateSalary(int staffId, int salary) {
        return  staffDao.updateSalary(staffId, salary);
    }

    //8
    public List<Staff> getStaffNameWithMinExperience(){
        return staffDao.getStaffNameWithMinExperience();
    }

    //9
    public List<Staff> staffByProfile(String profile){
        return staffDao.staffByProfile(profile);
    }

    //10
    public List<Staff> staffProfileNotX(String profile){
        return staffDao.staffProfileNotX(profile);
    }
}
