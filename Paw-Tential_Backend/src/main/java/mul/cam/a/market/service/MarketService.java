package mul.cam.a.market.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.market.dao.MarketDao;
import mul.cam.a.market.dto.MarketDto;

@Service
@Transactional
public class MarketService {
	@Autowired
	MarketDao dao;
	
	public MarketDto[] searchMarket(String selectedOption, String searchWord,  int page) {
		System.out.println("searchMarket service : " + new Date());
		System.out.println("selected options : " + selectedOption);
		HashMap<String, Object> searchInfo = new HashMap<>();
		searchInfo.put("selectedOption", selectedOption);
		searchInfo.put("searchWord", searchWord);
		searchInfo.put("page", page);
		
		return dao.searchMarket(searchInfo);
	}
	
	public MarketDto[] printAllMarketSearch() {
		return dao.printAllMarketList();
	}
	
	// 게시물작성
	public boolean writeMarket(MarketDto writeMarketInfo) {
		return dao.writeMarket(writeMarketInfo) > 0 ? true : false;
	}
	
	// 게시물업데이트
	public boolean updateMarket(MarketDto updateMarketInfo) {
		return dao.updateMarket(updateMarketInfo) > 0 ? true : false;
	}
	
	// 게시물삭제
	public boolean deleteMarket(String id, int posting) {
		HashMap<String, Object> idAndPosting = new HashMap<>();
		idAndPosting.put("id", id);
		idAndPosting.put("posting", posting);
		return dao.deleteMarket(idAndPosting) > 0 ? true : false;
	}
	
	// 조회수추가
	public void viewAddMarket(String id, int posting) {
		HashMap<String, Object> idAndPosting = new HashMap<>();
		idAndPosting.put("id", id);
		idAndPosting.put("posting", posting);
		
		// 이미 보았던 게시물일 경우 추가하지 않음
		boolean viewCheck = dao.viewCheck(idAndPosting) > 0 ? true : false;
		System.out.println(viewCheck);
		if (viewCheck) return;
		
		// 보지않은 게시물일 경우 추가함
		boolean viewAddSuccess = dao.viewInsert(idAndPosting) > 0 ? true : false;
		System.out.println("view add >> " + viewAddSuccess);
		return;
	}
	
	//조회수 출력
	public int viewPrint(int posting) {
		return dao.viewPrint(posting);
	}
	
	// 해당게시물의 좋아요개수
	// 유저가 좋아요 누른적 있는지
	public HashMap<String, Object> marketHistoryOfLike(HashMap<String, Object> sendInfo) {
		HashMap<String, Object> histroyOfLike = new HashMap<>();
		
		boolean clicked = dao.marketClickHistoryOfLike(sendInfo) > 0 ? true : false;
		int like = dao.marketNumberOfLike((int)sendInfo.get("posting"));
		histroyOfLike.put("clicked", clicked);
		histroyOfLike.put("like", like);
		
		return histroyOfLike;
	}
	
	// 좋아요 클릭 시 등록 및 해제
	public String marketChangeLike(HashMap<String, Object> sendInfo) {
		// sendInfo.likeHistory 에서 true 면 delete 문
		// sendInfo.likeHistory 에서 false 면 insert 문
		if ((boolean)sendInfo.get("likeHistory")) {
			return dao.marketRemoveLike(sendInfo) > 0 ? "LIKE_REMOVE_OK" : "LIKE_REMOVE_NO";			
		}else{
			return dao.marketAddLike(sendInfo) > 0 ? "LIKE_ADD_OK" : "LIKE_ADD_NO";
		}
	}
	// 좋아요클릭시 좋아요 개수 불러오기
	public int marketNumberofLike(int posting) {
		return dao.marketNumberOfLike(posting);
	}
}

