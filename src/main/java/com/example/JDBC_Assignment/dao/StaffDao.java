package com.example.JDBC_Assignment.dao;

import com.example.JDBC_Assignment.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //1
    public List<Staff> getAllStaff() {
        String sql = "SELECT * FROM staff";
        List<Staff> staffList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Staff.class));
        return staffList;
    }

    //2
    public List<Staff> getStaffWithID3() {
        String sql = "SELECT * FROM staff WHERE staffid = 3";
        List<Staff> staffList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Staff.class));
        return staffList;
    }

    //3
    public int insertStaff(Staff staff) {
        return jdbcTemplate.update(
                "INSERT INTO staff VALUES (?,?,?,?,?)",
                staff.getStaffId(),
                staff.getName(),
                staff.getProfile(),
                staff.getSalary(),
                staff.getExperience()
        );
    }

    //4
    public List<Staff> getStaffWithSalaryGreaterThan20k() {
        String sql = "SELECT * FROM staff WHERE salary > 20000";
        List<Staff> staffList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Staff.class));

        return staffList;
    }

    //5
    public List<Staff> getStaffWithExp10To20() {
        String sql = "SELECT * FROM staff WHERE experience BETWEEN 10 AND 20";
        List<Staff> staffList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Staff.class));
        return staffList;
    }

    //6
    public Staff maxSalaryStaff() {
        String sql = "SELECT * FROM staff WHERE salary = (SELECT MAX(salary) FROM staff)";
        Staff s = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Staff.class));
        return s;
    }

    //7
    public int updateSalary(int staffId, int salary) {
        String sql = "UPDATE staff SET salary = ? WHERE staffid = ?";
        int result = jdbcTemplate.update(sql, salary, staffId);
        return result;
    }

    //8
    public String getStaffNameWithMinExperience() {
        String sql = "SELECT name FROM staff WHERE experience = (SELECT MIN(experience) FROM staff)";
        String name = jdbcTemplate.queryForObject(sql, String.class);
        return name;
    }

    //9
    public List<Staff> staffProfileTrainer() {
        String sql = "SELECT * FROM staff WHERE profile = 'Trainer'";

        List<Staff> staffList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Staff.class));

        return staffList;
    }

    //10
    public List<Staff> staffProfileNotTrainer() {
        String sql = "SELECT * FROM staff WHERE profile != 'Trainer'";

        List<Staff> staffList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Staff.class));

        return staffList;
    }

}


