package beans.dao;

import java.util.List;

import beans.data.StudentRequest;

public interface IStudentDao {
	public void save(Object data);
	public void update(Object student);
	public void delete(String name) ;
	public Object find(String obj);
	public List<StudentRequest> findAll();
}
