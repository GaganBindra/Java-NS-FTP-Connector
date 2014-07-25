package com.example;


//import java.net.URI;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


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
    public String postIt(@PathParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response){
    	

         
        
//       Set queryKeySet = queryParams.keySet();
//       String queryString = "";
//       Iterator i = queryKeySet.iterator();
//       
//       while(i.hasNext()){
//    	   
//    	   List<String> tempList = queryParams.get(i.next());
//    	   
//    	   for(int j=0;j<tempList.size();j++){
//    		   queryString = queryString.concat(tempList.get(j));   
//    	   }
//    	   
//       }
    	
    	
    	HttpSession session = request.getSession(true);
    	String name = "";
    	//process only if its multipart content
    	if(ServletFileUpload.isMultipartContent(request))
    	{
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        name = new File(item.getName()).getName();
                        //item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
           
               //File uploaded successfully
               //request.setAttribute("message", "Ahaan! File Uploaded Successfully.");
             
//               DataBean bean = ReadCSVFile.main(null);
//               
//               String rowCount = String.valueOf((bean.getEmail()).size());
//               
//               session.setAttribute("bean", bean);
//               session.setAttribute("rowCount", rowCount);
               
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
               return "File Upload Failed due to " + ex;
            }          
         
        }else{
            return "Sorry this Servlet only handles file upload request";
        }
       
    	return "Hello, Heroku receieved file - "+name+" successfully,and fileName param is "+fileName;
    	
    	
    }
    
}
