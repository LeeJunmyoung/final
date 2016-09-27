package login.controller;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

	public int emailSender(String mail) throws MessagingException{
        // 硫붿씪 愿��젴 �젙蹂�
		
        String host = "smtp.gmail.com";
        String username = "honeycomb0727@gmail.com";
        String password = "honeycombo123";
        //�옖�뜡 �븿�닔 i(�씤利앸쾲�샇)
        int i = (int)(Math.random()*999999)+1;
        // 硫붿씪 �궡�슜
        String recipient = mail;//�씠硫붿씪二쇱냼
        String subject = "honeycomb에서 인증메일을 발송하였습니다."; //�궡�슜
        String j = String.valueOf(i);
        String body = "인증번호는 "+j+"입니다.";	
         System.out.println(i);
        //properties �꽕�젙
        Properties props = new Properties();
        props.put("mail.smtps.auth", "true");
        // 硫붿씪 �꽭�뀡
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
 
        // 硫붿씪 愿��젴
        msg.setSubject(subject);
        msg.setText(body);
        msg.setFrom(new InternetAddress(username));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
        // 諛쒖넚 泥섎━
        Transport transport = session.getTransport("smtps");
        transport.connect(host, username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();    
        return i;
    }
}