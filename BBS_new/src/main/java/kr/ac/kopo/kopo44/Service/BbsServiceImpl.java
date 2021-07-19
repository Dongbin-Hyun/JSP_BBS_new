package kr.ac.kopo.kopo44.Service;

import java.util.ArrayList;

import kr.ac.kopo.kopo44.DAO.BbsDAO;
import kr.ac.kopo.kopo44.DAO.BbsDAOImpl;
import kr.ac.kopo.kopo44.DTO.BbsDTO;

public class BbsServiceImpl implements BbsService{
	
	private BbsDAO bbsDAO = BbsDAOImpl.getInstance();

	@Override
	public String getDate() {
		return bbsDAO.getDate();
	}

	@Override
	public int getNext() {
		return bbsDAO.getNext();
	}

	@Override
	public int write(String bbsTitle, String userID, String bbsContent) {
		return bbsDAO.write(bbsTitle, userID, bbsContent);
	}

	@Override
	public ArrayList<BbsDTO> getList(int pageNumber) {
		return bbsDAO.getList(pageNumber);
	}

	@Override
	public boolean nextPage(int pageNumber) {
		// TODO Auto-generated method stub
		return bbsDAO.nextPage(pageNumber);
	}

	@Override
	public BbsDTO getBbs(int bbsID) {
		return bbsDAO.getBbs(bbsID);
	}

	@Override
	public int update(int bbsID, String bbsTitle, String bbsContent) {
		return bbsDAO.update(bbsID, bbsTitle, bbsContent);
	}

	@Override
	public int delete(int bbsID) {
		return bbsDAO.delete(bbsID);
	}

	@Override
	public ArrayList<BbsDTO> getSearchByBbsID(String searchBbsID) {
		return bbsDAO.getSearchByBbsID(searchBbsID);
	}

	@Override
	public ArrayList<BbsDTO> getSearchByBbsTitle(String searchBbsTitle) {
		return bbsDAO.getSearchByBbsTitle(searchBbsTitle);
	}

	@Override
	public ArrayList<BbsDTO> getSearchByUserID(String searchUserID) {
		return bbsDAO.getSearchByUserID(searchUserID);
	}
	
	
	
	
	
	
}
