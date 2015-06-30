package kr.co.cooks.service;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import kr.co.cooks.dao.FoodDao;
import kr.co.cooks.vo.FoodFileListMapVO;
import kr.co.cooks.vo.FoodFileListVO;
import kr.co.cooks.vo.FoodVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class FoodService {
	@Autowired FoodDao foodDao ;
	@Autowired ServletContext servletContext;
	
	List<FoodFileListMapVO> foodFileList;

	public FoodVO getFoodDetail(int f_num) {
		return foodDao.getFoodDetail(f_num);
	}

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

	//	public void addFood(HashMap<String, Object> hashMap) {
	//		foodDao.addFood(hashMap);
	//	}

	@Transactional()
	public void addFood(FoodVO foodVO, MultipartHttpServletRequest multipartReq) {
		
		foodDao.addFood(foodVO);


		String fileUploadRealPath = servletContext.getRealPath("/fileUpload");

		File dir = new File(fileUploadRealPath);

		if(!dir.isDirectory()){
			dir.mkdir();
		}

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

					FoodFileListVO foodFileVO = new FoodFileListVO();
					foodFileVO.setOriginFileName(originFileName);
					foodFileVO.setSaveFileName(saveFileName);
					foodFileVO.setFileSize(fileSize);
					
					foodDao.addFoodFileUpload(foodFileVO);
					
					try{
						uploadFile.transferTo(new File(fileUploadRealPath + "/" + saveFileName));
					} catch(Exception e) {
						e.printStackTrace();
					} // catch
				}


			}

		}
	}

}
