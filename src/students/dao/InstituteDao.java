package students.dao;

import java.util.List;

import students.model.Institute;

public interface InstituteDao {
	public List<Institute> getAllInstitutes();
	public int getInstitutesCount();
}
