package beans.service;

import java.util.List;

import beans.data.StudentRequest;

public interface IStudentService {
	
	public void save(StudentRequest student) ;
	public void update(StudentRequest student) ;
	public void delete(String student) ;
	public StudentRequest find(String student);
	public List<StudentRequest> findAll();

}
