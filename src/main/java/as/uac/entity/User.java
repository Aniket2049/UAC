package as.uac.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "privilege")
	private String privilege;
	
	public User()
	{
	}
	
	public User(String name, String username, String password, String privilege)
	{
		this.name      = name;
		this.username  = username;
		this.password  = password;
		this.privilege = privilege;
	}
	
	public User(int id, String name, String username, String password, String privilege)
	{
		this.id        = id;
		this.name      = name;
		this.username  = username;
		this.password  = password;
		this.privilege = privilege;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPrivilege()
	{
		return privilege;
	}
	
	public void setPrivilege(String privilege)
	{
		this.privilege = privilege;
	}
	
}
