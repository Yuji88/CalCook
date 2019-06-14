package dto;

public class IngredientDispInfo {
	private int MenuId = 0;
	private String MenuName = "";
	private String IngredientDisps = "";

	public IngredientDispInfo() {
		this.MenuId = 0;
		this.MenuName = "";
		this.IngredientDisps = "";
	}

	public IngredientDispInfo(int MenuId, String MenuName, String IngredientDisps) {
		this.MenuId = MenuId;
		this.MenuName = MenuName;
		this.IngredientDisps = IngredientDisps;
	}

	public int getMenuId() {
		return MenuId;
	}

	public void setMenuId(int menuId) {
		MenuId = menuId;
	}

	public String getMenuName() {
		return MenuName;
	}

	public void setMenuName(String menuName) {
		MenuName = menuName;
	}

	public String getIngredientDisps() {
		return IngredientDisps;
	}

	public void setIngredientDisps(String ingredientDisps) {
		IngredientDisps = ingredientDisps;
	}
}
