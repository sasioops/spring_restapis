package com.example.spring_demo1.dao;
import com.example.spring_demo1.bean.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Repository
public class StudentDetailsDaoImpl implements StudentDetailsDao {
    @Value("${queryToFetchAllUsers}")
    private String queryToFetchAllUsers;

    @Value("${queryToFetchUserByName}")
    private String queryToFetchUserByName;

    @Value("${queryToFetchUserByUserName}")
    private String queryToFetchUserByUserName;

    @Value("${queryToFetchStudents}")
    private String queryToFetchStudents;

    @Value("${queryToAddStudents}")
    private String queryToAddStudents;

    @Value("${queryToUpdateStudents}")
    private String queryToUpdateStudents;

    @Value("${queryToDeleteStudent}")
    private String queryToDeleteStudent;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Students> getAllStudents() {
        return jdbcTemplate.query(queryToFetchAllUsers, new StudentRowMapper());


    }

    public List<Students> getStudentsByName(){
        return jdbcTemplate.query(queryToFetchUserByName,new Object[]{"vams%"},new StudentRowMapper());
    }



    @Override
    public Students getStudentsByUserName(String userName) {
        System.out.println(userName);
        try {
            return jdbcTemplate.queryForObject(queryToFetchUserByUserName, new Object[]{userName}, new StudentRowMapper() );
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Map<String, Object>> getStudents(){
        return jdbcTemplate.queryForList(queryToFetchStudents);
    }


    public int addStudents(Students students){
        return jdbcTemplate.update(queryToAddStudents,new Object[]{students.getFirstName(),students.getLastName()});

    }



    public int updateStudent(int rollNo,Students students){
        return jdbcTemplate.update(queryToUpdateStudents, new Object[]{students.getFirstName(),students.getLastName(),rollNo});
    }

    public int deleteStudent(int rollNo){
        System.out.println(rollNo);
        return jdbcTemplate.update(queryToDeleteStudent,new Object[]{rollNo});
    }

    public class StudentRowMapper implements RowMapper<Students> {
        @Override
        public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
            Students students = new Students();
            students.setFirstName(rs.getString("first_name"));
            students.setLastName(rs.getString("last_name"));
            students.setRollNo(rs.getInt("roll_no"));
            return students;
        }
    }
}