package mail;

import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailTest {

	public static void main(String[] args) throws Exception{
		
		Properties props = new Properties();
		InputStream in = MailTest.class.getClassLoader().getResourceAsStream("mail.properties");
		props.load(in);
		Session session = Session.getInstance(props);
		session.setDebug(true);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("liufeiyu6@163.com"));
//		message.setFrom(new InternetAddress("fpbox.ele-cloud.com"));
		message.setSentDate(new Date());
		message.setSubject("hello mail");
		message.setText("this is lyc test mail3 fpbox to dingxueyin second 胡聪聪是个二货6");
		
		Transport tran = session.getTransport();
		tran.connect("smtp.163.com",25,"liufeiyu6@163.com","lzc19910416");
//		tran.connect("fpbox.ele-cloud.com",25,"dxhy@fpbox.ele-cloud.com","123456");
		tran.sendMessage(message, new InternetAddress[]{new InternetAddress("603893812@qq.com")});
		tran.close();
	}
}

