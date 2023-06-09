package application;

import java.lang.System.Logger;
import java.security.NoSuchProviderException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Correo {
	
	private String emailFrom = "camuproyecto@gmail.com";
    private String passwordFrom = "tdxmcfbsihwdncqs";
    private String emailTo;
    private String subject;
    private String content;

    private Properties mProperties = new Properties();
    private Session mSession;
    private MimeMessage mCorreo;
    
    
    public Correo() {
		this.mProperties = new Properties();
	}

	public void crearEnviarCorreo(String correoDestino, String asunto, String contenido) {
        emailTo = correoDestino.trim();
        subject = asunto.trim();
        content = contenido.trim();
        
         // Simple mail transfer protocol
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user",emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");
        mSession = Session.getDefaultInstance(mProperties);
        
        
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setText(content, "ISO-8859-1", "html");        
            enviarCorreo();
        } catch (AddressException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
        	ex.printStackTrace();
        }
    }

    private void enviarCorreo() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
}
