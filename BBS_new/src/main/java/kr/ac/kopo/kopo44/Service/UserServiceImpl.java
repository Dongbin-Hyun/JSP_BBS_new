package kr.ac.kopo.kopo44.Service;

import kr.ac.kopo.kopo44.DAO.UserDAO;
import kr.ac.kopo.kopo44.DAO.UserDAOImpl;
import kr.ac.kopo.kopo44.DTO.UserDTO;

public class UserServiceImpl implements UserService{
	
	private  UserDAO userDAO = UserDAOImpl.getInstance();

	@Override
	public int login(String userID, String userPassword) {
		return userDAO.login(userID, userPassword);
	}

	@Override
	public int join(UserDTO user) {
		return userDAO.join(user);
	}

}
