package students.dao;

import java.util.List;

import students.model.Department;


public interface DepartmentDao {
	public List<Department> getAllDepartments();
	public int getDepartmentsCount();
}
