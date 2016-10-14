package com.eli.calc.shape.service.ws.resp;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.eli.calc.shape.model.CalcType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public final class CalcTypesResponse extends StatusResponse {

	private final List<CalcType> calcTypes = Arrays.asList(CalcType.values());
	
	
	public List<CalcType> getCalcTypes() {
		return calcTypes;
	}
}
