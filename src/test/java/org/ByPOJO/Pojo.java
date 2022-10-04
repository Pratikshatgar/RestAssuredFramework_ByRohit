package org.ByPOJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonProperty("data")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Pojo {

	@JsonProperty("id")
		private String id;
	@JsonProperty("email")
		private String email;
	@JsonProperty("first_name")
		private String first_name;
	@JsonProperty("last_name")
		private String last_name;
	@JsonProperty("avatar")
		private String avatar;
	
	private String name;
	private String job;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@JsonProperty("data")
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
		@JsonProperty("data")
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		@JsonProperty("data")
		public String getFirst_name() {
			return first_name;
		}
		
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		
		@JsonProperty("data")
		public String getLast_name() {
			return last_name;
		}
		
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		
		@JsonProperty("data")
		public String getAvatar() {
			return avatar;
		}
		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
		

}
