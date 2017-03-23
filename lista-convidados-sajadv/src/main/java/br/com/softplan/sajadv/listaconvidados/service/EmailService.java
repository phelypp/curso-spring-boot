package br.com.softplan.sajadv.listaconvidados.service;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailService {

	private static final String URL_ENVIAR_EMAIL = "http://localhost:8082/enviar-email";
	private static final String USUARIO_SENHA = "sajadv:sajadv123";


	public void enviarEmail(String nome, String email) {
		HttpHeaders headers = this.createHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		EmailDto emailDto = criarEmailDto(nome, email);
		new RestTemplate().exchange(URL_ENVIAR_EMAIL, HttpMethod.POST, new HttpEntity<EmailDto>(emailDto, headers),
				String.class);
	}

	protected HttpHeaders createHeaders() {
		return new HttpHeaders() {

			private static final long serialVersionUID = -277246240519084725L;

			{
				byte[] encodedAuth = Base64Utils.encode(USUARIO_SENHA.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				this.set("Authorization", authHeader);
			}
		};
	}

	private EmailDto criarEmailDto(String nome, String emailDestinatario) {
		EmailDto emailDto = new EmailDto();
		emailDto.setRemetente("festasajadv@gmail.com");
		emailDto.setAssunto("Você foi convidado para festa do SajAdv");
		emailDto.setConteudo("Olá " + nome + ". Você acaba de ser convidado para festa do SajAdv.");
		emailDto.setDestinatario(emailDestinatario);
		return emailDto;
	}
}
