package bean;
//封装数据的javabean
public class Title {

	private String isbn;// ISNB号
	private String title;// 书名
	private String copyright;// 版权
	private String imageFile;// 封面图像文件
	private int editonNumber;// 版本号
	private int publisherId;// 出版商ID
	private float price;// 出版价格

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public int getEditonNumber() {
		return editonNumber;
	}

	public void setEditonNumber(int editonNumber) {
		this.editonNumber = editonNumber;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
