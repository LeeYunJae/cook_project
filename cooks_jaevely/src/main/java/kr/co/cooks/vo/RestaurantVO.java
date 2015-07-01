package kr.co.cooks.vo;

public class RestaurantVO {
	
	private String r_num;
	private String r_name;
	private String id;
	private String r_address;
	private String r_phone;
	private String r_foodtype;
	private String r_info;
	
	
	public String getR_num() {
		return r_num;
	}
	public void setR_num(String r_num) {
		this.r_num = r_num;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getR_address() {
		return r_address;
	}
	public void setR_address(String r_address) {
		this.r_address = r_address;
	}
	public String getR_phone() {
		return r_phone;
	}
	public void setR_phone(String r_phone) {
		this.r_phone = r_phone;
	}
	public String getR_foodtype() {
		return r_foodtype;
	}
	public void setR_foodtype(String r_foodtype) {
		this.r_foodtype = r_foodtype;
	}
	public String getR_info() {
		return r_info;
	}
	public void setR_info(String r_info) {
		this.r_info = r_info;
	}
	
	
	@Override
	public String toString() {
		return "RestaurantVO [r_num=" + r_num + ", r_name=" + r_name + ", id="
				+ id + ", r_address=" + r_address + ", r_phone=" + r_phone
				+ ", r_foodtype=" + r_foodtype + ", r_info=" + r_info + "]";
	}
}
