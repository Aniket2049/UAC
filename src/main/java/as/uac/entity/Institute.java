package as.uac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
public class Institute
{
	@Id
	@Column(name = "id")
	public int id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "cse")
	public int cse;
	
	@Column(name = "it")
	public int it;
	
	@Column(name = "ece")
	public int ece;
	
	@Column(name = "me")
	public int me;
	
	@Column(name = "ce")
	public int ce;
	
	public Institute()
	{
	}
	
	public Institute(String name, int cse, int it, int ece, int me, int ce)
	{
		this.name = name;
		this.cse  = cse;
		this.it   = it;
		this.ece  = ece;
		this.me   = me;
		this.ce   = ce;
	}
	
	public Institute(int id, String name, int cse, int it, int ece, int me, int ce)
	{
		this.id   = id;
		this.name = name;
		this.cse  = cse;
		this.it   = it;
		this.ece  = ece;
		this.me   = me;
		this.ce   = ce;
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
	
	public int getCse()
	{
		return cse;
	}
	
	public void setCse(int cse)
	{
		this.cse = cse;
	}
	
	public int getIt()
	{
		return it;
	}
	
	public void setIt(int it)
	{
		this.it = it;
	}
	
	public int getEce()
	{
		return ece;
	}
	
	public void setEce(int ece)
	{
		this.ece = ece;
	}
	
	public int getMe()
	{
		return me;
	}
	
	public void setMe(int me)
	{
		this.me = me;
	}
	
	public int getCe()
	{
		return ce;
	}
	
	public void setCe(int ce)
	{
		this.ce = ce;
	}
	
}
