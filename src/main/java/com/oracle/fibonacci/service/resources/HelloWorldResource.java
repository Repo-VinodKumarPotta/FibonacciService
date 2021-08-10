package com.oracle.fibonacci.service.resources;

import com.codahale.metrics.annotation.Timed;
import com.oracle.fibonacci.service.api.Saying;
import com.oracle.fibonacci.service.response.FibonacciSeriesResponse;
import com.oracle.fibonacci.service.utils.FibonacciSeriesUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    @Path ("/sayHello")
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }

    @GET
    @Path ("/calculateFibonacciSeries")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public FibonacciSeriesResponse calculateFibonacciSeries(@QueryParam ("number") Integer number) {
        return FibonacciSeriesUtil.calculateFibonacciSeries(number);
    }


}
