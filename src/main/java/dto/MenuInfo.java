package dto;

public class MenuInfo {

	private int menuid = 0;
	private String menuname = "";

	public MenuInfo() {
		this.menuid = 0;
		this.menuname = "";
	}

	public MenuInfo(int menuid, String menuname) {
		this.menuid = menuid;
		this.menuname = menuname;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
}
