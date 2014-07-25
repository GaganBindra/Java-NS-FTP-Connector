package com.example;


import java.net.URI;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;


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
    public String postIt(@PathParam("fileName") String fileName, @Context UriInfo ui){
    	
    	MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();
        
        Set queryKeySet = queryParams.keySet();
        String qParams = "";
        
        for(int i=0; i<=queryKeySet.size();i++){
        	
        qParams = qParams + queryParams.get(queryKeySet).get(i);
        
        }
        
    	return "Hello, Heroku receieved file - "+fileName+" successfully witj queryParams as "+qParams;
    	
    	
    }
    
}
