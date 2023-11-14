package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.beans.Bike;
import br.com.fiap.bo.BikeBO;

@Path("/bike")
public class BikeResource {

	private BikeBO bikeBO = new BikeBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Bike> buscar() throws SQLException, ClassNotFoundException {
		return (ArrayList<Bike>) bikeBO.selecionarBO();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs (Bike bike, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		bikeBO.inserirBO(bike);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(bike.getIdentifica()));
		return Response.created(builder.build()).build();		
	}
	
	@PUT
	@Path("/{identifica_bike}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarRs (Bike bike, @PathParam("identifica_bike") int identifica_bike) throws SQLException, ClassNotFoundException {
		bikeBO.alterarBO(bike);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{identifica_bike}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs (@PathParam("identifica_bike") int identifica_bike) throws ClassNotFoundException, SQLException {
		bikeBO.deletarBO(identifica_bike);
		return Response.ok().build();
	}
	
}
