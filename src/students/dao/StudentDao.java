package students.dao;

import java.util.List;

import students.model.Student;

public interface StudentDao {
	public List<Student> getAllStudents();
	public int getStudentsCount();
}
