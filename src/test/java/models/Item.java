package models;

public class Item {
	private Boolean status;
	private String image;
	private String name;
	private String price;
	private String button;
	
	public Item() {
		this.image = "";
		this.name = "";
		this.price = "";
		this.button = "";	
		this.status = false;
	}
	
	public Item(String image, String name, String price, String button) {
		this.image = image;
		this.name = name;
		this.price = price;
		this.button = button;
		this.status = true;
	}

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getButton() {
		return button;
	}
	
	public Boolean getStatus() {
		if(!status) return status;
		else if(this.button.isEmpty()) return false;
		else if(this.image.isEmpty()) return false;
		else if(this.name.isEmpty()) return false;
		else if(this.price.isEmpty()) return false;
		else return true;
	}
	
	
	
	

}
