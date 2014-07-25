package com.example;


//import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;


//import javax.servlet.http.HttpSession;




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
       String queryString = "";
       Iterator i = queryKeySet.iterator();
       
       while(i.hasNext()){
    	   
    	   List<String> tempList = queryParams.get(i.next());
    	   
    	   for(int j=0;j<tempList.size();j++){
    		   queryString = queryString.concat(tempList.get(j));   
    	   }
    	   
       }
       
    	return "Hello, Heroku receieved file - "+fileName+" successfully with queryParam = "+queryString;
    	
    	
    }
    
}
