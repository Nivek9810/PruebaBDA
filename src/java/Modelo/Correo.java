/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Seba
 */
public class Correo {

    //public boolean enviarCorreo(String de, String clave, String[] para, String mensaje, String asunto){
    public boolean enviarCorreo(String para, String mensaje, String asunto, String archivo) {
        boolean enviado = false;
        try {

            String host = "smtp.gmail.com";
            String mail = "inmobiliariaud@gmail.com";
            String pass = "PAt305Lo";

            Properties prop = System.getProperties();

            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", host);
            prop.put("mail.smtp.user", mail);
            prop.put("mail.smtp.password", pass);
            prop.put("mail.smtp.port", 587);
            prop.put("mail.smtp.auth", "true");

            Session sesion = Session.getDefaultInstance(prop, null);

            MimeMessage message = new MimeMessage(sesion);

            message.setFrom(new InternetAddress(mail));

            /*
                    
                    NOTA: para enviar correo electronico masivo
                
                    InternetAddress[] direcciones = new InternetAddress[para.length];
                    for(int i=0;i<para.length;i++){
                        direcciones[i] = new InternetAddress(para[i]);
                    }
                
                    for(int i=0;i<direcciones.length;i++){
                        message.addRecipient(Message.RecipientType.TO, direcciones[i]);
                    }
                
             */
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));

            if (archivo == null) {
                message.setSubject(asunto);
                message.setText(mensaje);
            } else {
                BodyPart texto = new MimeBodyPart();
                texto.setText(mensaje);
                BodyPart adjunto = new MimeBodyPart();
                adjunto.setDataHandler(new DataHandler(new FileDataSource("C:/Users/user/Desktop/"+archivo+".pdf")));
                adjunto.setFileName("Declaración de gastos.pdf");
                MimeMultipart multiParte = new MimeMultipart();
                multiParte.addBodyPart(texto);
                multiParte.addBodyPart(adjunto);
                message.setSubject(asunto);
                message.setText(mensaje);
                message.setContent(multiParte);
            }

            Transport transport = sesion.getTransport("smtp");

            transport.connect(host, mail, pass);

            transport.sendMessage(message, message.getAllRecipients());

            transport.close();

            enviado = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return enviado;
    }

}
