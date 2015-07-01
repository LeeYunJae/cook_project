package kr.co.cooks.service;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import kr.co.cooks.dao.FoodDao;
import kr.co.cooks.vo.FoodMainFileListMapVO;
import kr.co.cooks.vo.FoodFileListVO;
import kr.co.cooks.vo.FoodMainFileListVO;
import kr.co.cooks.vo.FoodVO;
import kr.co.cooks.vo.RestaurantVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FoodService {
	@Autowired FoodDao foodDao ;
	@Autowired ServletContext servletContext;

	List<FoodMainFileListMapVO> foodFileList;
	List<FoodFileListVO> foodFilesList;

	
	//한 레스토랑에 있는 총 음식 리스트
	public HashMap<String, Object> list(String r_num) {
		HashMap<String, Object> hashMap = new HashMap<>();

		int count = foodDao.getFoodCount(r_num);	//총 음식 갯수

		//글이 있으면	
		if(count>0) {		
			foodFileList = foodDao.getArticles(r_num) ;
		}
		//글이 없으면
		else {			
			foodFileList = null ;
		}	

		hashMap.put("count",  count);		//총 글의 갯수
		hashMap.put("foodFileList", foodFileList);	//음식이 들어있는 list

		return hashMap;
	}

	//음식 상세정보 가져오기
	public FoodMainFileListMapVO getFoodDetail(int f_num) {
		return foodDao.getFoodDetail(f_num);
	}


	//추가 사진들 가져오기
	public HashMap<String, Object> getFoodFiles(int f_num){
		HashMap<String, Object> hashMap = new HashMap<>();

		foodFilesList = foodDao.getFoodFiles(f_num);

		hashMap.put("foodFilesList", foodFilesList);	//음식이 들어있는 list

		return hashMap;
	}
	
	//레스토랑 정보 가져오기
	public RestaurantVO getResInfo(String r_num){
		return foodDao.getResInfo(r_num);
	}

	//음식 등록하기 
	@Transactional()
	public void addFood(FoodVO foodVO, MultipartHttpServletRequest multipartReq) {

		//음식 정보 등록
		foodDao.addFood(foodVO);

		String fileUploadRealPath = servletContext.getRealPath("/fileUpload");

		File dir = new File(fileUploadRealPath);

		if(!dir.isDirectory()){
			dir.mkdir();
		}

		//음식 메인사진 
		if(multipartReq.getFiles("food_mainFile")!=null) {

			List<MultipartFile> multiFile = multipartReq.getFiles("food_mainFile");
			Iterator<MultipartFile> iterator = multiFile.iterator();

			while(iterator.hasNext()) {
				MultipartFile uploadFile = iterator.next();
				String originFileName = uploadFile.getOriginalFilename();
				String saveFileName = originFileName;
				long fileSize = uploadFile.getSize();

				if(!originFileName.isEmpty()) {
					if(new File(fileUploadRealPath + "/" + originFileName).exists()) {
						saveFileName = originFileName + "_" +System.currentTimeMillis();
					}

					FoodMainFileListVO foodMainFileVO = new FoodMainFileListVO();
					foodMainFileVO.setOriginFileName(originFileName);
					foodMainFileVO.setSaveFileName(saveFileName);
					foodMainFileVO.setFileSize(fileSize);

					//메인사진 등록
					foodDao.addFoodMainFile(foodMainFileVO);

					try{
						uploadFile.transferTo(new File(fileUploadRealPath + "/" + saveFileName));
					} catch(Exception e) {
						e.printStackTrace();
					} // catch
				}

			}

		}

		//음식 추가사진들
		if(multipartReq.getFiles("food_files")!=null) {


			List<MultipartFile> multiFile = multipartReq.getFiles("food_files");
			Iterator<MultipartFile> iterator = multiFile.iterator();

			while(iterator.hasNext()) {
				MultipartFile uploadFile = iterator.next();
				String originFileName = uploadFile.getOriginalFilename();
				String saveFileName = originFileName;
				long fileSize = uploadFile.getSize();

				if(!originFileName.isEmpty()) {
					if(new File(fileUploadRealPath + "/" + originFileName).exists()) {
						saveFileName = originFileName + "_" +System.currentTimeMillis();
					}

					FoodFileListVO foodFileVO = new FoodFileListVO();
					foodFileVO.setOriginFileName(originFileName);
					foodFileVO.setSaveFileName(saveFileName);
					foodFileVO.setFileSize(fileSize);

					//메뉴 사진들 등록
					foodDao.addFoodFile(foodFileVO);

					try{
						uploadFile.transferTo(new File(fileUploadRealPath + "/" + saveFileName));
					} catch(Exception e) {
						e.printStackTrace();
					} // catch
				}
			}		
		}

	}

	//음식 삭제하기 
	public void deleteFood(int f_num) {
		foodDao.deleteFoodMainFile(f_num);	//메인 사진 삭제
		foodDao.deleteFoodFiles(f_num);	//추가 사진들 삭제		
		foodDao.deleteFood(f_num);	//음식 정보 삭제
	}

}
