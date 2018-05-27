package beans.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.data.StudentEntity;
import beans.data.StudentRequest;
import beans.db.StudentDB;

@Repository
public class StudentDao implements IStudentDao{
	
	
/*	@Autowired
    private SessionFactory sessionFactory;
	*/

	public void save(Object data) {
		System.out.println("In Dao method save");
		StudentRequest value=(StudentRequest)data;
		StudentDB.db.put(value.getFirstName(),value);
		System.out.println(StudentDB.db);
		 //getSession().persist(data);
	}

	public void update(Object student) {
		StudentRequest value=(StudentRequest)student;
		StudentRequest value1=StudentDB.db.get(value.getFirstName());
		StudentDB.db.put(value.getFirstName(), value1);
		//  getSession().update(student);
	}

	public void delete(String studentName) {
		StudentDB.db.remove(studentName);
		 //getSession().delete(studentName);
	}

	public Object find(String student) {
		
		return (StudentRequest)StudentDB.db.get(student);
		//return getSession().load(StudentEntity.class, student);
	}

	public List<StudentRequest> findAll() {
		List<StudentRequest> requests=new ArrayList<>();
		Set<String> set=StudentDB.db.keySet();
		for(String key:set) {
			requests.add(StudentDB.db.get(key));
		}
		return requests;
		//return getSession().createQuery("from StudentEntity").list();
	}
	
	/*public Session getSession() {
		return sessionFactory.getCurrentSession();
	}*/

}
