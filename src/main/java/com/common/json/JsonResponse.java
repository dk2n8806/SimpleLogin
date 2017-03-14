package com.common.json;

import java.io.Serializable;

public class JsonResponse implements Serializable {

	private static final long serialVersionUID = 7393002329648950522L;

	public static final boolean RESPONSE_SUCCESS   = true;
	public static final boolean RESPONSE_FAIL 				= false;
	
	private boolean state = false;
	private Object result = null;
	private String retUrl = null;
	
	public String getRetUrl() {		return retUrl;	}
	public void setRetUrl(String retUrl) {		this.retUrl = retUrl;	}
	
	public Object getResult() {		return result;	}
	public void setResult(Object result) {		this.result = result;	}
	
	public void setState(boolean state) {		this.state = state;	}
	public boolean getState(){		return this.state;	}
	
	
	
	
}
