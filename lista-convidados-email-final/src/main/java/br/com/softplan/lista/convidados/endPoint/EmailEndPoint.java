
package br.com.softplan.lista.convidados.endPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.softplan.lista.convidados.dto.EmailDto;
import br.com.softplan.lista.convidados.service.EmailService;

@RestController
public class EmailEndPoint {

	private static final String URI_ENVIAR_EMAIL = "/enviar-email";

	@Autowired
	private EmailService service;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = EmailEndPoint.URI_ENVIAR_EMAIL, method = RequestMethod.POST, 
	consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
	produces = { MediaType.APPLICATION_JSON_VALUE,
    MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> enviarEmailSemAnexo(@RequestBody EmailDto emailDto) {
		this.service.enviarEmail(emailDto);
		return new ResponseEntity(new HttpHeaders(), HttpStatus.CREATED);
	}

}