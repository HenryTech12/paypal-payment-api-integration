package com.payment.api.dto;

import java.time.*;

public class ReceiptDTO
{
	private String email;
	private LocalDate date;
	private LocalTime time;
	private String method;
	private String desc;
	private String currency;
	private String total;

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEmail()
	{
		return email;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void setTime(LocalTime time)
	{
		this.time = time;
	}

	public LocalTime getTime()
	{
		return time;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String getMethod()
	{
		return method;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setTotal(String total)
	{
		this.total = total;
	}

	public String getTotal()
	{
		return total;
	}}
