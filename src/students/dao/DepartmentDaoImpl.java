package students.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import students.model.Department;
import students.model.Student;

public class DepartmentDaoImpl implements DepartmentDao {


	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	@Override
	public List<Department> getAllDepartments() {
		String sql = "SELECT departments.department_id, department, institutes.institute FROM departments INNER JOIN institutes ON departments.institute_id = institutes.institute_id";
		List<Department> departments  = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<Department>(Department.class));
	
		return departments;
	}

	@Override
	public int getDepartmentsCount() {
		String sql = "SELECT count(*) FROM student.departments;";
		@SuppressWarnings("deprecation")
		int count = getJdbcTemplate().queryForInt(sql);
		 
		return count;
	}

}
