package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.entity.Course;
import poly.entity.Student;

@Controller
@RequestMapping(value = "/student")
@Transactional
public class StudentController {

	@Autowired
	SessionFactory sessionFactory;

	@RequestMapping(value = "/all")
	public String getAllStudent(ModelMap model) {
		Session session = sessionFactory.getCurrentSession();

		List<Student> listStudent = session.createQuery("from Student").list();

		model.addAttribute("listStudent", listStudent);

		return "danhsach";
	}

	@RequestMapping(method = RequestMethod.GET, value = "create")
	public String showCreate(ModelMap model) {
		Session session = sessionFactory.getCurrentSession();
		List<Course> courses = session.createQuery("from Course").list();
		model.addAttribute("student", new Student());
		model.addAttribute("course", courses);
		return "formCreate";
	}

	@RequestMapping(method = RequestMethod.POST, value = "create")
	public String createStudent(ModelMap model, Student student) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		List<Student> listStudent = new ArrayList<>();

		try {
			session.save(student);
			t.commit();
		} catch (Exception exception) {
			t.rollback();
		}
		session = sessionFactory.getCurrentSession();
		listStudent = session.createQuery("from Student").list();
		model.addAttribute("listStudent", listStudent);

		return "danhsach";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "update")
	public String showUpdate(ModelMap model, @RequestParam("id") int id) {
		Session session = sessionFactory.getCurrentSession();
		Student book =  (Student) session.get(Student.class, id);
		ArrayList<Course> categories =  (ArrayList<Course>) session.createQuery("From Course").list();
		model.addAttribute("book", book); // Gán đối tượng book cho view
		model.addAttribute("categories", categories); // Gán danh sách Categories cho view
		return "formUpdate";
	}

	@RequestMapping(method = RequestMethod.POST, value = "update")
	public String updateBook(ModelMap model, Student student) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		ArrayList<Student> list = new ArrayList<>();
		try {
			session.update(student);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}

		session = sessionFactory.getCurrentSession();
		list = (ArrayList<Student>) session.createQuery("from Student").list();
		model.addAttribute("listStudent", list);
		return "danhsach";
	}

	@RequestMapping("delete")
	public String deleteBook(ModelMap model, Student student) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		ArrayList<Student> list = new ArrayList<>();
		try {
			session.delete(student);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}

		session = sessionFactory.getCurrentSession();
		list = (ArrayList<Student>) session.createCriteria(Student.class).list();
		model.addAttribute("listStudent", list);
		return "danhsach";
	}

}
