package kr.ac.kopo.kopo44.Service;

import kr.ac.kopo.kopo44.DTO.UserDTO;

public interface UserService {
	
	public int login(String userID, String userPassword);

	public int join(UserDTO user);

}
