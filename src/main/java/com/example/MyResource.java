package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.multipart.file.FileDataBodyPart;




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
    @POST
    public String getIt(@FormDataParam("file") InputStream in) {
        int i;
        char c;
        StringBuffer str= new StringBuffer();
        String message = new String();
       
        
    	try {
    		
    		if(in.markSupported()){
    			in.mark(0);
    		}
    		
			while((i=in.read())!=-1){
				c=(char)i;
				str.append(c); 
			}
			
			if(in.markSupported()){
				in.reset();
			}
			in.close();
			
			 
			 message = "Hello, Heroku! data is "+str.toString();
			 str=null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	
    	return message;
    }
    
    
}
