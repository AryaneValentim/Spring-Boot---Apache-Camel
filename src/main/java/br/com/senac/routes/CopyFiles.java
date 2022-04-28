package br.com.senac.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


//spring vai injetar e instanciar 
@Component
public class CopyFiles extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {
		from("file:input")
		.to("file:output");
	}
}
