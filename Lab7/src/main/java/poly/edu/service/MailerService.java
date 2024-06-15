package poly.edu.service;

import javax.mail.MessagingException;

import poly.edu.model.MailInfo;

public interface MailerService {
	/**
	 * * Gửi email * @param mail thông tin email * @throws MessagingException lỗi
	 * gửi email
	 */
	void send(MailInfo mail) throws MessagingException;

	/**
	 * * Gửi email đơn giản * @param to email người nhận * @param subject tiêu đề
	 * email * @param body nội dung email * @throws MessagingException lỗi gửi email
	 */
	void send(String to, String subject, String body) throws MessagingException;
}
