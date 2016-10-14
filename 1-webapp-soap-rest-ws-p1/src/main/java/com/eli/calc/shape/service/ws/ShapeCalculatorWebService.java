package com.eli.calc.shape.service.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlElement;

import com.eli.calc.shape.service.ws.parms.QueueCalculationParms;
import com.eli.calc.shape.service.ws.resp.CalcTypesResponse;
import com.eli.calc.shape.service.ws.resp.CalculatedResultsResponse;
import com.eli.calc.shape.service.ws.resp.PendingRequestsResponse;
import com.eli.calc.shape.service.ws.resp.RunPendingRequestsResponse;
import com.eli.calc.shape.service.ws.resp.ShapeNamesResponse;
import com.eli.calc.shape.service.ws.resp.StatusResponse;

@WebService
public interface ShapeCalculatorWebService {

	ShapeNamesResponse getShapeNames();
	
	CalcTypesResponse getCalcTypes();
	
	@DELETE
	@Path("/pending")
	StatusResponse deletePendingRequests();
	
	@DELETE
	@Path("/results")
	StatusResponse deleteResults();
	
	/**
	 * Since executing this operation results in a pending request,
	 * let's use the same /pending endpoint.
	 * 
	 * @param parameters
	 * @return StatusReponse
	 */
	@PUT
	@Path("/pending")
	@WebMethod(operationName="queueCalculation")
    StatusResponse queueCalculation(
    		@WebParam(
    				name="QueueCalculationParms",
    				targetNamespace = "http://parms.ws.service.shape.calc.eli.com/"
    				)
    		@XmlElement(required=true)
    		QueueCalculationParms parameters
    		);


    @GET
    @Path("/pending")
	PendingRequestsResponse getPendingRequests();
	
    @GET
    @Path("/results")
	CalculatedResultsResponse getCalculatedResults();
	
    @PUT
    @Path("/run/stop")
	RunPendingRequestsResponse runPendingRequestsStopOnError();

    @PUT
    @Path("/run/nostop")
	RunPendingRequestsResponse runPendingRequestsNoStopOnError();
	
}