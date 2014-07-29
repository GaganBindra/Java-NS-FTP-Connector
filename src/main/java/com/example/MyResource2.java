package com.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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


@Path("myresource2/")
public class MyResource2 {

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response doPost(
			@FormDataParam("file") InputStreamReader uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail
			){
		return Response.status(200).encoding(fileDetail.getFileName()).build();
		
	}
}
