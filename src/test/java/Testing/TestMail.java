package Testing;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class TestMail {

	public static void main(String[] args) throws AddressException, MessagingException {

		

		MonitoringMail mail = new MonitoringMail();
		mail.sendMail(TestMailConfig.server, TestMailConfig.from, TestMailConfig.to, TestMailConfig.subject, TestMailConfig.messageBody, TestMailConfig.attachmentPath, TestMailConfig.attachmentName);

	}

}
