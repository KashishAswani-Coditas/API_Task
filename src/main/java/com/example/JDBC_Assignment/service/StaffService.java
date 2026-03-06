package com.example.JDBC_Assignment.service;

import com.example.JDBC_Assignment.dao.StaffDao;
import com.example.JDBC_Assignment.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffDao staffDao;

    //1
    public List<Staff> getAllStaff() {
        return staffDao.getAllStaff();

    }

    //2
    public List<Staff> getStaffWithID3(){
        return staffDao.getStaffWithID3();
    }

    //3
    public int insertStaff(Staff staff){
        return staffDao.insertStaff(staff);
    }

    //4
    public List<Staff> getStaffWithSalaryGreaterThan20k(){
        return staffDao.getStaffWithSalaryGreaterThan20k();
    }

    //5
    public List<Staff> getStaffWithExp10To20(){
        return staffDao.getStaffWithExp10To20();
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
    public String getStaffNameWithMinExperience(){
        return staffDao.getStaffNameWithMinExperience();
    }

    //9
    public List<Staff> staffProfileTrainer(){
        return staffDao.staffProfileTrainer();
    }

    //10
    public List<Staff> staffProfileNotTrainer(){
        return staffDao.staffProfileNotTrainer();
    }
}
