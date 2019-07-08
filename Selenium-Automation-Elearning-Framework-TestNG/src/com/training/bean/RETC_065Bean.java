package com.training.bean;

/**
 * 
 * @author Naveen
 * @see this class shall get the bean data 
 */
public class RETC_065Bean {
	
	private String UserName;
	private String Password;
	private String Name;
	private String Slug;
	private String Description;
	private String Title;
	private String Body;
	private String Phrase;

	public RETC_065Bean() {
	}

	public RETC_065Bean(String UserName, String Password, String Name, String Slug, String Description, String Title,String Body,String Phrase) {
		super();
		this.UserName = UserName;
		this.Password = Password;
		this.Name = Name;
		this.Slug = Slug;
		this.Description = Description;
		this.Title = Title;
		this.Body = Body;
		this.Phrase = Phrase;
		
	}
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getSlug() {
		return Slug;
	}

	public void setSlug(String Slug) {
		this.Slug = Slug;
		
	}
	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}
	public String getBody() {
		return Body;
	}

	public void setBody(String Body) {
		this.Body = Body;
	}
	public String getPhrase() {
		return Phrase;
	}

	public void setPhrase(String Phrase) {
		this.Phrase = Phrase;
	}


	@Override
	public String toString() {
		return "RETC_065Bean [UserName=" + UserName + ",Password=" + Password + ",Name=" + Name + ",Slug=" + Slug + ",Description=" + Description + ",Title=" + Title +",Body=" + Body +",Phrase=" + Phrase +"]";
	}

}
