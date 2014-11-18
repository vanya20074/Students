package students.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import students.model.Institute;

public class InstituteDaoImpl implements InstituteDao {


	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Institute> getAllInstitutes() {
		String sql = "SELECT * FROM student.institutes;";
		List<Institute> institutes  = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<Institute>(Institute.class));
	
		return institutes;
	}

	@Override
	public int getInstitutesCount() {
		String sql = "SELECT count(*) FROM student.institutes;";
		@SuppressWarnings("deprecation")
		int count = getJdbcTemplate().queryForInt(sql);
		 
		return count;
	}

}
