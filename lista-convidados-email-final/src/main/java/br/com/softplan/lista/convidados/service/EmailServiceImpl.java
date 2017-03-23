
package br.com.softplan.lista.convidados.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.softplan.lista.convidados.dto.EmailDto;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void enviarEmail(EmailDto emailDto) {
		MimeMessage mail = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail, true);
			helper.setFrom(emailDto.getRemetente());
			helper.setSubject(emailDto.getAssunto());
			helper.setText(emailDto.getConteudo());
			helper.addTo(emailDto.getDestinatario());
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
		}
		javaMailSender.send(mail);
	}
}
