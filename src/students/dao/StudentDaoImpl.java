package students.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import students.model.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Student> getAllStudents() {
		String sql = "SELECT     students.cipher, PIB, mark, departments.department, institutes.institute FROM     students      INNER JOIN departments ON departments.department_id = students.department        INNER JOIN    institutes ON departments.institute_id = institutes.institute_id";
		List<Student> students  = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<Student>(Student.class));
	
		return students;
	}

	@Override
	public int getStudentsCount() {
		String sql = "SELECT count(*) FROM student.students;";
		@SuppressWarnings("deprecation")
		int count = getJdbcTemplate().queryForInt(sql);
		 
		return count;
	}
	
	

}
