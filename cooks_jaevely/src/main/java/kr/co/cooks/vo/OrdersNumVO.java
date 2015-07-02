package kr.co.cooks.vo;

public class OrdersNumVO {
	private int o_num ;				//주문 번호
	private String id ;				//아이디
	
	
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "OrdersNumVO [o_num=" + o_num + ", id=" + id + "]";
	}

}
