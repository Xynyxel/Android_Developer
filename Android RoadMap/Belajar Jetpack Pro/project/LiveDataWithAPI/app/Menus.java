public class Menus{

	@SerializedName("foods")
	private List<FoodsItem> foods;

	@SerializedName("drinks")
	private List<DrinksItem> drinks;

	public List<FoodsItem> getFoods(){
		return foods;
	}

	public List<DrinksItem> getDrinks(){
		return drinks;
	}
}
