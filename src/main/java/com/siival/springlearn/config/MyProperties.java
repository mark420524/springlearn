package com.siival.springlearn.config;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("my.service")
public class MyProperties {

    @Override
	public String toString() {
		return "MyProperties [enabled=" + enabled + ", remoteAddress=" + remoteAddress + ", security=" + security + "]";
	}

	private boolean enabled;

    private InetAddress remoteAddress;

    public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public InetAddress getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(InetAddress remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public Security getSecurity() {
		return security;
	}

	private final Security security = new Security();

    // getters / setters...

    public static class Security {

        private String username;

        private String password;

        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public List<String> getRoles() {
			return roles;
		}

		public void setRoles(List<String> roles) {
			this.roles = roles;
		}

		@Override
		public String toString() {
			return "Security [username=" + username + ", password=" + password + ", roles=" + roles + "]";
		}

        // getters / setters...

    }

}