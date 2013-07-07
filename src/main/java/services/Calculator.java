package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.InternalServerErrorException;

@Path("/calc")
@Produces(MediaType.TEXT_PLAIN)
public class Calculator {

    @GET
    @Path("add")
    public String add(@QueryParam("a")int a, @QueryParam("b")int b){
    	if (a > 0 && b > 0 && (Integer.MAX_VALUE - a) < b) {
    		throw new InternalServerErrorException("ひどい話だ");
    	}
    	if (a < 0 && b < 0 && (Integer.MAX_VALUE + a) < -1 * b) {
    		throw new InternalServerErrorException("ひどい話だ");
    	}
        return String.valueOf(a + b);
    }
    
    @GET
    @Path("subtract")
    public String subtract(@QueryParam("a")int a, @QueryParam("b")int b){
        return String.valueOf(a - b);
    }

    @GET
    @Path("multiply")
    public String multiply(@QueryParam("a")int a, @QueryParam("b")int b){
        return String.valueOf(a * b);
    }

    @GET
    @Path("divide")
    public String divide(@QueryParam("a")int a, @QueryParam("b")int b){
    	if (b == 0) {
    		return "error::divide by zero";
    	}
        return String.valueOf(a / b);
    }
}
