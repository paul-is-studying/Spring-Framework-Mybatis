package service;

import java.util.List;

import dao.DeptDAO;
import vo.DeptVO;

public class DeptService {

	private DeptDAO deptDao;
	
	public DeptService(DeptDAO deptDao) {
		this.deptDao = deptDao;
	}
	
	public List<DeptVO> selectList(){
		return deptDao.selectList();
	}
	
	public boolean insert(DeptVO vo) {
		
		vo.setDeptno(deptDao.maxNo());
		
		boolean check = false;
		
		if(deptDao.insert(vo) != 0) {
			check = true;
		}
		
		return check;
	}
	
	public DeptVO selectOne(int deptno) {
		return deptDao.selectOne(deptno);
	}
	
	public int update(DeptVO vo) {
		return deptDao.update(vo);
	}
	
	public int delete(int deptno) {
		return deptDao.delete(deptno);
	}
	

	
}











