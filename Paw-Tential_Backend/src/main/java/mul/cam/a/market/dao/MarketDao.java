package mul.cam.a.market.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.market.dto.MarketDto;
import mul.cam.a.market.dto.MarketReportDto;

@Mapper
@Repository
public interface MarketDao {
	//MarketDto marketSearch(String id);
	MarketDto[] printAllMarketList(int page);
	MarketDto[] searchMarket(HashMap<String, Object> searchInfo);
	
	int writeMarket(MarketDto writeMarketInfo);
	int updateMarket(MarketDto updateMarketInfo);
	int deleteMarket(HashMap<String, Object> idAndPosting);
	
	int viewCheck(HashMap<String, Object> idAndPosting);
	int viewInsert(HashMap<String, Object> idAndPosting);
	int viewPrint(int posting);
	
	int marketNumberOfLike(int posting);
	int marketClickHistoryOfLike(HashMap<String, Object> sendInfo);
	int marketAddLike(HashMap<String, Object> sendInfo);
	int marketRemoveLike(HashMap<String, Object> sendInfo);

	int reportMarket(MarketReportDto reportInfo);
}
