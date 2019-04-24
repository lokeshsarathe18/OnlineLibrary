package com.kulchuri.library.category;

import java.io.Serializable;

public class CategoryDto implements Serializable {
	private int cid;
	private String cname;

	public CategoryDto() {
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
}
