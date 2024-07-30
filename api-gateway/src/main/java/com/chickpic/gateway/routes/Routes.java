package com.chickpic.gateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;

@Configuration
public class Routes {
    @Bean
    public RouterFunction<ServerResponse> imageServiceRoute() {
        return route("image_service")
                .route(RequestPredicates.path("/api/image/**"), HandlerFunctions.http("http://localhost:8080"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> locationServiceRoute() {
        return route("location_service")
                .route(RequestPredicates.path("/api/location/**"), HandlerFunctions.http("http://localhost:8081"))
                .build();
    }

}
