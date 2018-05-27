package beans.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.dao.IStudentDao;
import beans.data.StudentRequest;

@Service
public class StudentService implements IStudentService{

	@Autowired
	IStudentDao studentDao;
	
	public void save(StudentRequest student) {
		System.out.println("In service method save");
		 studentDao.save(student);
	}
	
	public void update(StudentRequest student) {
		 studentDao.update(student);
	}
	
	public void delete(String student) {
		 studentDao.delete(student);
	}
	
	public StudentRequest find(String student) {
		return (StudentRequest) studentDao.find(student);
	}
	
	public List<StudentRequest> findAll() {
		List<StudentRequest> list=new ArrayList<StudentRequest>();
		for(Object t:studentDao.findAll()) {
			list.add((StudentRequest) t);
		}
		return list ;
	}

}
