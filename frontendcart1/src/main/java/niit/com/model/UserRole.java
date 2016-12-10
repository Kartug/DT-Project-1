package niit.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
public class UserRole{

	@Id
    @GeneratedValue
    private int roleId;
    private String username;
    private String role;
    

    public int getRoleId() {
  		return roleId;
  	}

  	public void setRoleId(int roleId) {
  		this.roleId = roleId;
  	}

  	public String getRole() {
  		return role;
  	}

  	public void setRole(String role) {
  		this.role = role;
  	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
