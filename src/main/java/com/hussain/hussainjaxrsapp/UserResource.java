package com.hussain.hussainjaxrsapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.hussain.hussainjaxrsapp.dao.UserDao;
import com.hussain.hussainjaxrsapp.model.User;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("User")
public class UserResource {

	private Gson gson = new Gson();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItems() {
		UserDao userDao = new UserDao();
		List<User> userList = userDao.getAll();
		
		String jsonString = gson.toJson(userList);
		
		return Response
				.status(200)
				.entity(jsonString)
				.build();
	}
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnItem(@PathParam("id") int id) {
		UserDao userDao = new UserDao();
		User user = userDao.getAUser(id);
		if(user != null){
		String jsonString = gson.toJson(user);
		
		return Response
				.status(200)
				.entity(jsonString)
				.build();
		} else {
			Map<String, String> errorMsg = new HashMap<>();
			errorMsg.put("ERROR", "Invalid user id");
			String errorString = gson.toJson(errorMsg);
			return Response
					.status(400)
					.entity(errorString)
					.build();
		}
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addItem() {
		return "add user to the system";
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem() {
		return "Update a User";
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem() {
		return "Delete a User";
	}

}
