package com.rs.util.bean;

/**返回accid、token
 * 
 * @author wcs
 *
 */
public class InfoBean {
	private String token ;
	private String accid ;
	public void setToken(String token) {
		this.token = token;
	}
	public String getToken() {
		return this.token;
	}
	public void setAccid(String accid) {
		this.accid = accid;
	}
	public String getAccid() {
		return this.accid;
	}
}
