package com.jorden.li.core;
/**
 * 
 * @author jorden.li
 *
 */
public class ReponseEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String totalPage;
	private String message;
	private Object results;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResults() {
		return results;
	}
	public void setResults(Object results) {
		this.results = results;
	}
	
	public ReponseEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
  public ReponseEntity(String code, String totalPage, String message, Object results) {
		super();
		this.code = code;
		this.totalPage = totalPage;
		this.message = message;
		this.results = results;
	}
  
   public static ReponseEntity  ok (Object results ){
	  return new ReponseEntity("10000","11","sucess",results);
	  
  }
	
	

}
