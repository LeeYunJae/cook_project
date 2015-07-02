package kr.co.cooks.service;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import kr.co.cooks.dao.RestaurantDao;
import kr.co.cooks.vo.RestaurantFileListVO;
import kr.co.cooks.vo.RestaurantFileVO;
import kr.co.cooks.vo.RestaurantVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class RestaurantService {
	@Autowired RestaurantDao restaurantDao;
	@Autowired ServletContext servletContext;
	
	public List<RestaurantFileListVO> restaurantList(){

		return restaurantDao.getRestaurant();

	}

	
	@Transactional()
	public void addRestaurant(RestaurantVO restaurantVO, MultipartHttpServletRequest multipartReq){
		
		restaurantDao.addRestaurant(restaurantVO);
		
		String fileUploadRealPath = servletContext.getRealPath("/fileUpload");
		
		File dir = new File(fileUploadRealPath);
		
		if(!dir.isDirectory()) {
			dir.mkdir();
		}
		
		if(multipartReq.getFile("restaurantFile").getOriginalFilename() != null) {
			
			List<MultipartFile> multiFile = multipartReq.getFiles("restaurantFile");
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
					
					RestaurantFileVO restaurantFileVO = new RestaurantFileVO();
					restaurantFileVO.setOriginFileName(originFileName);
					restaurantFileVO.setSaveFileName(saveFileName);
					restaurantFileVO.setFileSize(fileSize);
					restaurantFileVO.setR_Num(restaurantVO.getR_Num());
					
					restaurantDao.addFileUpload(restaurantFileVO);
					
					try{
						uploadFile.transferTo(new File(fileUploadRealPath + "/" + saveFileName));
					} catch(Exception e) {
						e.printStackTrace();
					} // catch
				} // if
				
			} // while
		} // if
	}
	
	
}
