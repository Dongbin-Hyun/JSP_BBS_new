package kr.ac.kopo.kopo44.DAO;

import kr.ac.kopo.kopo44.DTO.UserDTO;

public interface UserDAO {

	public int login(String userID, String userPassword);

	public int join(UserDTO user);
	

}
