package com.curso.fullstack.sopra.mvc.controllers.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class HttpHeadersUtil {
	public void addHeaderLocation(HttpHeaders headers, long id) throws URISyntaxException {
		headers.setLocation(new URI("http:localhost:8080/personas/"+id));// añadimos en la localizacion a la cabecera
	}
}