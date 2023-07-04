package com.siival.springlearn.res;
/**
 * @time 2023年6月14日15:18:16
 * @author mark acrossxwall@gmail.com
 * @className CategoryInfo
 */
public class CategoryInfo {

	private Integer id  ;
	private String name;
	private String icon;
	private String type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
