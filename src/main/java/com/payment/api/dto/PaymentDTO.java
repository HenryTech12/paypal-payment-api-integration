package com.payment.api.dto;

public class PaymentDTO
{

   private String email;
	private Double total;
	private String currency;
	private String desc;
	private String intent;
	private String method;
	private String cancelUrl;
	private String successUrl;
	
	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEmail()
	{
		return email;
	}

	public void setTotal(Double total)
	{
		this.total = total;
	}

	public Double getTotal()
	{
		return total;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setIntent(String intent)
	{
		this.intent = intent;
	}

	public String getIntent()
	{
		return intent;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String getMethod()
	{
		return method;
	}

	public void setCancelUrl(String cancelUrl)
	{
		this.cancelUrl = cancelUrl;
	}

	public String getCancelUrl()
	{
		return cancelUrl;
	}

	public void setSuccessUrl(String successUrl)
	{
		this.successUrl = successUrl;
	}

	public String getSuccessUrl()
	{
		return successUrl;
	}}
