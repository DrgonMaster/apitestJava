package com.niuguwang.test.apitestJava.model;

import lombok.Data;

@Data
public class LoginCase {
        private int id;
        private String username;
        private String password;
        private String loginTyte;
        private String deviceid;
        private String company;
        private String expected;
		public final int getId() {
			return id;
		}
		public final void setId(int id) {
			this.id = id;
		}
		public final String getUsername() {
			return username;
		}
		public final void setUsername(String username) {
			this.username = username;
		}
		public final String getPassword() {
			return password;
		}
		public final void setPassword(String password) {
			this.password = password;
		}
		public final String getLoginTyte() {
			return loginTyte;
		}
		public final void setLoginTyte(String loginTyte) {
			this.loginTyte = loginTyte;
		}
		public final String getDeviceid() {
			return deviceid;
		}
		public final void setDeviceid(String deviceid) {
			this.deviceid = deviceid;
		}
		public final String getCompany() {
			return company;
		}
		public final void setCompany(String company) {
			this.company = company;
		}
		public final String getExpected() {
			System.out.println("获取预期结果");
			return expected;
		}
		public final void setExpected(String expected) {
			this.expected = expected;
		}
		@Override
		public String toString() {
			return "LoginCase [id=" + id + ", username=" + username + ", password=" + password + ", loginTyte="
					+ loginTyte + ", deviceid=" + deviceid + ", company=" + company + ", expected=" + expected + "]";
		}
        
}