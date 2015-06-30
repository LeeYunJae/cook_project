package kr.co.cooks.vo;

public class FoodFileListMapVO {
	private int f_num;				//음식 번호
	private String f_name ;			//음식 이름
	private int f_price;			//가격
	private String r_num;			//사업자 등록번호
	private String saveFileName;	//저장된 파일 이름
	
	public int getF_num() {
		return f_num;
	}
	public void setF_num(int f_num) {
		this.f_num = f_num;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public int getF_price() {
		return f_price;
	}
	public void setF_price(int f_price) {
		this.f_price = f_price;
	}
	public String getR_num() {
		return r_num;
	}
	public void setR_num(String r_num) {
		this.r_num = r_num;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	
	
	@Override
	public String toString() {
		return "FoodFileListMapVO [f_num=" + f_num + ", f_name=" + f_name
				+ ", f_price=" + f_price + ", r_num=" + r_num
				+ ", saveFileName=" + saveFileName + "]";
	}
}
