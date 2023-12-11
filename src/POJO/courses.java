package POJO;

import java.util.List;

public class courses 
{
	private List< WebAutomation >webAutomation;
	private List<Api> api;
	private List<mobile> mobile;
	
	public List<WebAutomation> getWebAutomation() 
	{
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) 
	{
		this.webAutomation = webAutomation;
	}
	public List<Api> getApi()
	{
		return api;
	}
	public void setApi(List<Api> api) 
	{
		this.api = api;
	}
	public List<POJO.mobile> getMobile() 
	{
		return mobile;
	}
	public void setMobile(List<POJO.mobile> mobile) 
	{
		this.mobile = mobile;
	}
	

}
