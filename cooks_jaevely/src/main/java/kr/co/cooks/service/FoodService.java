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

	public FoodMainFileListMapVO getFoodDetail(int f_num) {
		return foodDao.getFoodDetail(f_num);
	}
	
	public HashMap<String, Object> getFoodFiles(int f_num){
		HashMap<String, Object> hashMap = new HashMap<>();
		
		foodFilesList = foodDao.getFoodFiles(f_num);
		
		hashMap.put("foodFilesList", foodFilesList);	//음식이 들어있는 list

		return hashMap;
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

	@Transactional()
	public void addFood(FoodVO foodVO, MultipartHttpServletRequest multipartReq) {
		
		//음식 등록
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

}
