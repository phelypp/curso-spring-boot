
package br.com.softplan.lista.convidados.service;

import br.com.softplan.lista.convidados.dto.EmailDto;

/**
 * Interface que define a API de serviço de envio de e-mail.
 */
public interface EmailService {

	/**
	 * Metódo responsável por enviar email.
	 *
	 * @param emailDto {@link EmailDto}
	 */
	void enviarEmail(EmailDto emailDto);
}
