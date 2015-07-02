package kr.co.cooks.vo;

import java.sql.Timestamp;

public class OrdersVO {
	private int f_num;				//음식 번호
	private int o_num ;				//주문 번호
	private String r_num;			//식당 번호
	private Timestamp o_date;		//날짜
	private int o_count;			//수량
	private int o_price;			//총 결제 금액
	
	
	public int getF_num() {
		return f_num;
	}
	public void setF_num(int f_num) {
		this.f_num = f_num;
	}
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public String getR_num() {
		return r_num;
	}
	public void setR_num(String r_num) {
		this.r_num = r_num;
	}
	public Timestamp getO_date() {
		return o_date;
	}
	public void setO_date(Timestamp o_date) {
		this.o_date = o_date;
	}
	public int getO_count() {
		return o_count;
	}
	public void setO_count(int o_count) {
		this.o_count = o_count;
	}
	public int getO_price() {
		return o_price;
	}
	public void setO_price(int o_price) {
		this.o_price = o_price;
	}
	
	
	@Override
	public String toString() {
		return "OrdersVO [f_num=" + f_num + ", o_num=" + o_num + ", r_num="
				+ r_num + ", o_date=" + o_date + ", o_count=" + o_count
				+ ", o_price=" + o_price + "]";
	}	

}
