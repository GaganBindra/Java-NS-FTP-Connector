package com.example;


//import java.net.URI;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;


import javax.servlet.http.HttpSession;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource/{fileName}")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hello, Heroku!";
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String postIt(@FormDataParam("file") InputStream uploadedInputStream,
    		@FormDataParam("file") FormDataContentDisposition fileDetail) {
    	
    	String name = "";
  
    	String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();
 
		
		
		// save it
		//writeToFile(uploadedInputStream, uploadedFileLocation);
 
		String output = "File uploaded to : " + uploadedFileLocation;
		
		return output;
 
		//return Response.status(200).entity(output).build();
    	
    	//return "Hello, Heroku receieved file - "+name+" successfully,and fileName param is "+fileName;
    	
    	
    }
    
    @POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
		@FormDataParam("file") InputStream uploadedInputStream,
		@FormDataParam("file") FormDataContentDisposition fileDetail) {
 
		String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();
 
		
		
		// save it
		//writeToFile(uploadedInputStream, uploadedFileLocation);
 
		String output = "File uploaded to : " + uploadedFileLocation;
		
 
		return Response.status(200).entity(output).build();
 
	}
    
}
