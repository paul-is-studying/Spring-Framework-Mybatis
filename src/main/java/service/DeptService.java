package service;

import dao.DeptDAO;

public class DeptService {

	private DeptDAO deptDao;
	
	public DeptService(DeptDAO deptDao) {
		this.deptDao = deptDao;
	}
	
}
