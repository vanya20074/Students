package students.controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import students.dao.DepartmentDao;
import students.dao.InstituteDao;
import students.dao.StudentDao;
import students.model.Department;
import students.model.Institute;
import students.model.Student;

@Controller
public class MainController {
	ApplicationContext cntx = new ClassPathXmlApplicationContext("jdbc.xml");
	StudentDao studentDao = (StudentDao) cntx.getBean("studentDao");
	DepartmentDao departmentDao = (DepartmentDao) cntx.getBean("departmentDao");
	InstituteDao instituteDao = (InstituteDao) cntx.getBean("instituteDao");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToIndex() {
		return "index";
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getAllStudents() {

		List<Student> students = studentDao.getAllStudents();

		return students;
	}

	@RequestMapping(value = "/studentsCount", method = RequestMethod.GET)
	@ResponseBody
	public int getStudentsCount() {

		int count = studentDao.getStudentsCount();

		return count;
	}

	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public String goToDepartment() {
		return "department";
	}

	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	@ResponseBody
	public List<Department> getAllDepartments() {

		List<Department> departmetns = departmentDao.getAllDepartments();

		return departmetns;
	}

	@RequestMapping(value = "/departmentsCount", method = RequestMethod.GET)
	@ResponseBody
	public int getDepartmentsCount() {

		int count = departmentDao.getDepartmentsCount();

		return count;
	}
	
	@RequestMapping(value = "/institute", method = RequestMethod.GET)
	public String goToInstitute() {
		return "institute";
	}

	@RequestMapping(value = "/institutes", method = RequestMethod.GET)
	@ResponseBody
	public List<Institute> getAllInstitutes() {

		List<Institute> institutes = instituteDao.getAllInstitutes();

		return institutes;
	}

	@RequestMapping(value = "/institutesCount", method = RequestMethod.GET)
	@ResponseBody
	public int getInstituteCount() {

		int count = instituteDao.getInstitutesCount();

		return count;
	}
}
