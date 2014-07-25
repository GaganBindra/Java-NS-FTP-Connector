package com.example;


import java.io.InputStream;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;




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
    
}
