package com.eli.calc.shape.service.ws.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"code","description", "clazz", "errMsg","causeMsg"})
public class StatusResponse {

    //@XmlElement(required = true)
	private StatusCode code;
	
    //@XmlElement(required = true)
	private String description;
	
	private Class clazz;
	
	private String errMsg;
	
	private String causeMsg;
	
	public StatusResponse() {
		
		this.code = StatusCode.ERROR;
		this.description = "DESCRIPTION NEEDS TO BE SET";
		Exception e = new Exception(
				"NEED AN EXCEPTION CLASS",
				new IllegalArgumentException("FAKE CAUSE"));
		this.clazz = e.getClass();
		this.errMsg = e.getMessage();
		this.causeMsg = e.getCause().getMessage();
	}

	public StatusResponse(StatusCode code, String description) {

		this();

		this.code = code;
		this.description = description;

		if (StatusCode.SUCCESS.equals(code)) {
			this.clazz = null;
			this.errMsg = null;
			this.causeMsg = null;
		}
	}

	public StatusResponse(String description, Exception e) {

		this(StatusCode.ERROR,description);
		
		if (null!=e) {
			this.clazz = e.getClass();
			this.errMsg = e.getMessage();
			if (e.getCause()!=null) { this.causeMsg = e.getCause().getMessage(); }
			else { this.causeMsg = null; }
		}
	}

	public StatusCode getCode() {
		return code;
	}

	public void setCode(StatusCode code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getCauseMsg() {
		return causeMsg;
	}

	public void setCauseMsg(String causeMsg) {
		this.causeMsg = causeMsg;
	}

	@Override
	public String toString() {
		return "StatusResponse [code=" + code + ", description=" + description + ", clazz=" + clazz
				+ ", errMsg=" + errMsg + ", causeMsg=" + causeMsg + "]";
	}
	

	
}
