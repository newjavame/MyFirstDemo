package bean;
//设计购物车项目类，里面封装了购书对象和购书数量
public class CartItem {
	private Title title;
	private int quantity;//购书数量
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
