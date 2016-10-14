package com.eli.calc.shape.service.ws.resp;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.eli.calc.shape.model.ShapeName;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public final class ShapeNamesResponse extends StatusResponse {

	private final List<ShapeName> shapeNames = Arrays.asList(ShapeName.values());
	
	public List<ShapeName> getShapeNames() {
		return shapeNames;
	}
}
