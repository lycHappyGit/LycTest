package mail;

import freemark.FreeMarkerUtil;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailTest {

	public static void main(String[] args) throws Exception{

		send("this is lyc test mail6 liufeiyu to lyc and contail null");
	}

	public static void send(String content) {

		try{
			Properties props = new Properties();
			InputStream in = MailTest.class.getClassLoader().getResourceAsStream("mail.properties");
			props.load(in);
			Session session = Session.getInstance(props);
			session.setDebug(true);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("liufeiyu6@163.com"));
			message.setSentDate(new Date());
			message.setSubject("hello mail");
			message.setContent(content, "text/html;charset=UTF-8");
			Transport tran = session.getTransport();
			tran.connect("smtp.163.com",25,"liufeiyu6@163.com","llc19910416");

			InternetAddress address1 = new InternetAddress("603893812@qq.com");
//			InternetAddress address3 = new InternetAddress("liuyingchao@ele-cloud.com");
			tran.sendMessage(message, new InternetAddress[]{address1});
			tran.close();

		}catch (Exception e){
			e.printStackTrace();
		}

	}

}

