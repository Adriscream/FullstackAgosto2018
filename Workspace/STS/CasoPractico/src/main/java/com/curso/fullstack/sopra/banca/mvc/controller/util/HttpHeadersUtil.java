package com.curso.fullstack.sopra.banca.mvc.controller.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class HttpHeadersUtil {
	public void addHeaderLocation(HttpHeaders headers, String id) throws URISyntaxException {
		headers.setLocation(new URI("http:localhost:8080/personas/"+id));
	}
}
