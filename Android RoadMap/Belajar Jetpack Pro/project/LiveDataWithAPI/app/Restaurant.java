public class Restaurant{

	@SerializedName("customerReviews")
	private List<CustomerReviewsItem> customerReviews;

	@SerializedName("address")
	private String address;

	@SerializedName("pictureId")
	private String pictureId;

	@SerializedName("city")
	private String city;

	@SerializedName("name")
	private String name;

	@SerializedName("rating")
	private double rating;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private String id;

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	@SerializedName("menus")
	private Menus menus;

	public List<CustomerReviewsItem> getCustomerReviews(){
		return customerReviews;
	}

	public String getAddress(){
		return address;
	}

	public String getPictureId(){
		return pictureId;
	}

	public String getCity(){
		return city;
	}

	public String getName(){
		return name;
	}

	public double getRating(){
		return rating;
	}

	public String getDescription(){
		return description;
	}

	public String getId(){
		return id;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	public Menus getMenus(){
		return menus;
	}
}
