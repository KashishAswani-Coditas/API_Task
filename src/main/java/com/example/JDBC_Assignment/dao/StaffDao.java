package com.example.JDBC_Assignment.dao;

import com.example.JDBC_Assignment.entity.Staff;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDao {

    private final JdbcTemplate jdbcTemplate;
    //constructor based injection
    public StaffDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    String selectQuery = "SELECT * FROM staff ";

    //1
    public List<Staff> getAllStaff(int page, int size) {
        int offset = (page - 1)*size;

        String sql = selectQuery + "LIMIT ?, ?";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Staff.class), offset, size);
    }

    //2
    public Staff getStaffWithId(int id) {
        String sql = selectQuery + " WHERE staffid = %d".formatted(id);
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Staff.class));
    }

    //3
    public void insertStaff(Staff staff) {
         jdbcTemplate.update(
                "INSERT INTO staff (staffid,name,profile,salary,experience)\n" +
                        "VALUES (?,?,?,?,?)",
                staff.getStaffId(),
                staff.getName(),
                staff.getProfile(),
                staff.getSalary(),
                staff.getExperience()
        );
    }

    //4
    public List<Staff> getStaffWithSalaryGreaterThanX(int salary) {
        String sql = selectQuery + " WHERE salary > " + salary;
        List<Staff> staffList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Staff.class));
        return staffList;
    }

    //5
    public List<Staff> getStaffWithExpStartToEnd(int start, int end) {
        String sql = selectQuery + " WHERE experience BETWEEN %d AND %d".formatted(start, end);
        List<Staff> staffList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Staff.class));
        return staffList;
    }

    //6
    public Staff maxSalaryStaff() {
        String sql = selectQuery+ " WHERE salary = (SELECT MAX(salary) FROM staff)";
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
    public List<Staff> getStaffNameWithMinExperience() {
        String sql = selectQuery + " WHERE experience = (SELECT MIN(experience) FROM staff)";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Staff.class));
    }

    //9
    public List<Staff> staffByProfile(String profile) {
        String sql = selectQuery + " WHERE profile = '%s'".formatted(profile) ;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Staff.class));

    }

    //10
    public List<Staff> staffProfileNotX(String profile) {
        String sql = selectQuery+ " WHERE profile != '%s' ".formatted(profile);

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Staff.class));

    }

}


