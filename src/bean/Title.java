package bean;
//��װ���ݵ�javabean
public class Title {

	private String isbn;// ISNB��
	private String title;// ����
	private String copyright;// ��Ȩ
	private String imageFile;// ����ͼ���ļ�
	private int editonNumber;// �汾��
	private int publisherId;// ������ID
	private float price;// ����۸�

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
