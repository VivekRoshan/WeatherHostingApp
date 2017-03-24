package com.cloudcomputing.assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




@Path("/ReportService")
public class ReportService {
	ReportDao dao = new ReportDao();
	
	
	@GET
	@Path("/historical")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReportDate> getAllWeatherJSON() {
		List<ReportDate> list = new ArrayList<>();
		List<Report> list2 = dao.readData() ;
		for (Report report : list2) {
			list.add(new ReportDate(report.DATE));
		}
		return list;
	}
	
		
	@GET
	@Path("/historical/{DATE}")
	@Produces(MediaType.APPLICATION_JSON)
	@Context
	public Response getUser(@PathParam("DATE") String date){
		Report report = dao.getReport(date);
		if(report == null)
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		else
			return Response.status(Response.Status.OK).entity(report).build();
		
		/*if(report == null)
			 return Response.status(Response.Status.NOT_FOUND).build();
		else
			return Response.status(Response.Status.OK).entity(report).build();*/
	 }
	 
	@GET
	@Path("/forecast/{DATE}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Report> nextSevenDays(@PathParam("DATE") String DATE){
		//return dao.nextSevenDays(DATE);
		return dao.getReportforfivedays(DATE);
	 }
	
	@GET
	@Path("/report/{DATE}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Report> reportFiveDays(@PathParam("DATE") String DATE){
		return dao.getReportforfivedays(DATE);
	 }
	
	
	
	@POST
	@Path("/historical")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(Report report){
	//Report report = new Report(DATE, TMAX, TMIN);
	int result = dao.addReport(report);
	if(result == 1)
		return Response.status(Response.Status.CREATED).entity(new ReportDate(report.DATE)).build();
	else
	{
		String str = "Invalid date "+report.DATE;
		return Response.status(Response.Status.BAD_REQUEST).entity(str).build();
		
	}
	}
	@DELETE
	@Path("/historical/{DATE}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("DATE") String DATE){
	Report result = dao.deleteReport(DATE);
	String str = "";
	if(result == null)
	{
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	else{
		str = result.DATE+" is deleted";
		return Response.status(Response.Status.OK).encoding(str).entity(str).build();
		
	}
}
}