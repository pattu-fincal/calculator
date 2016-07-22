package org.ram.examples;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by pattu on 22/07/16.
 */
@Path("calculator")
public class Resource {
    @GET
    @Path("sum")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateSum(@QueryParam("input1") String input1, @QueryParam("input2") String input2) {
        Integer i1 = Integer.parseInt(input1);
        Integer i2 = Integer.parseInt(input2);
        return new Integer(i1 + i2).toString();
    }

    @GET
    @Path("product")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateProduct(@QueryParam("input1") String input1, @QueryParam("input2") String input2) {
        Integer i1 = Integer.parseInt(input1);
        Integer i2 = Integer.parseInt(input2);
        return new Integer(i1 * i2).toString();
    }

    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(@QueryParam("input1") String input1, @QueryParam("input2") String input2) {
        Integer i1 = Integer.parseInt(input1);
        Integer i2 = Integer.parseInt(input2);
        return new Integer((i1 +1) * (i2 +1)).toString();
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String postMethod(@FormParam("input1") String input1, @FormParam("input2") String input2,
                             @FormParam("operation") String operation) {
        String result;
        if (operation.equalsIgnoreCase("sum")) {
            result = calculateSum(input1, input2);
        } else if (operation.equalsIgnoreCase("product")) {
            result = calculateProduct(input2, input2);
        } else {
            return "<h2> Unknown operation: " + operation + "</h2>";
        }
        return "<h2>Hello, " + input1 + " operation " + input2 + " is " + result + "</h2>";
    }
}
