package kr.ac.kopo.kopo44.DAO;

import java.util.ArrayList;

import kr.ac.kopo.kopo44.DTO.BbsDTO;

public interface BbsDAO {
	
	public String getDate();
	
	public int getNext();
	
	public int write (String bbsTitle, String userID, String bbsContent);

	public ArrayList<BbsDTO> getList(int pageNumber);

	public boolean nextPage(int pageNumber);

	public BbsDTO getBbs(int bbsID);

	public int update(int bbsID, String bbsTitle, String bbsContent);

	public int delete(int bbsID);

	public ArrayList<BbsDTO> getSearchByBbsID(String searchBbsID);

	public ArrayList<BbsDTO> getSearchByBbsTitle(String searchBbsTitle);

	public ArrayList<BbsDTO> getSearchByUserID(String searchUserID);
	
	
}
