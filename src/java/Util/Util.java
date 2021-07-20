/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Models.Client;
import Models.Rol;
import Models.UserEntity;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matthew
 */
public class Util extends Connection {

    private static String UserKey = "userSession";
    private static String ssession = "Session";
    private static String UserEmail = "dondur520@gmail.com";
    private static String UserEmailPass = "97112901683";
    private static String Domain = "http://localhost:8080/DonDur_1.0/";
    private UserEntity User;
    private HttpSession session;

    public List<Messages> listMessages = new ArrayList<Messages>();

    public Util() {

    }

    public void AddMessage(String message, MessageType MessageType) {
        if (this.listMessages != null && this.listMessages.size() > 0) {
            this.listMessages.add(new Messages(message, MessageType));

        } else {
            this.listMessages = new ArrayList<Messages>();
            this.listMessages.add(new Messages(message, MessageType));
        }

    }

    public void SaveInSession(String Name, Object obj) {
        getSession().setAttribute(Name, obj);
    }

    public Object GetFromSession(String Name) {
        return getSession().getAttribute(Name);
    }

    public void SaveUserSession(UserEntity CurrentUser) {
        getSession().setAttribute(UserKey, CurrentUser);
    }

    public void SaveSession(HttpSession session) {
        this.setSession(session);
    }

    public String GetMD5(String characters) {
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
            mdAlgorithm.update(characters.getBytes());

            byte[] digest = mdAlgorithm.digest();

            for (int i = 0; i < digest.length; i++) {
                characters = Integer.toHexString(0xFF & digest[i]);

                if (characters.length() < 2) {
                    characters = "0" + characters;
                }

                hexString.append(characters);
            }
        } catch (NoSuchAlgorithmException ex) {
            AddMessage(ex.getMessage(), MessageType.Error);
        }

        return hexString.toString();

    }

    /**
     * @return the User
     */
    public UserEntity getUser() {
        return User;
    }

    /**
     * @param User the User to set
     */
    public void setUser(UserEntity User) {
        this.User = User;
    }

    /**
     * @return the session
     */
    public HttpSession getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(HttpSession session) {
        this.session = session;
    }

    /**
     * @return the listMessages
     */
    public List<Messages> getListMessages() {

        return listMessages;
    }

    /**
     * @param listMessages the listMessages to set
     */
    public void setListMessages(List<Messages> listMessages) {
        this.listMessages = listMessages;
    }

    public void SendEmailByUser(UserEntity user, String Subject) throws AddressException, MessagingException {
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true"); // added this line
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", UserEmail);
        props.put("mail.smtp.password", UserEmailPass);
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        String[] to = {user.getEmail()}; // To Email address
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(UserEmail));
        InternetAddress[] toAddress = new InternetAddress[to.length];
        // To get the array of addresses
        for (int i = 0; i < to.length; i++) { // changed from a while loop
            toAddress[i] = new InternetAddress(to[i]);
        }
        System.out.println(Message.RecipientType.TO);
        for (int j = 0; j < toAddress.length; j++) { // changed from a while loop
            message.addRecipient(Message.RecipientType.TO, toAddress[j]);
        }
        message.setSubject(Subject);
        String body = generateBodyMessage(1, user);
        body = body.replace("{NAME}", user.getNombre());
        body = body.replace("{CC}", user.getNoDocumento());
        body = body.replace("{PHONE}", "" + user.getTelefono());
        body = body.replace("{MAIL}", user.getEmail());

        message.setContent(body, "text/html");
        Transport transport = session.getTransport("smtp");
        transport.connect(host, UserEmail, UserEmailPass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public void SendEmailByUser(Client client, String Subject) throws AddressException, MessagingException {
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true"); // added this line
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", UserEmail);
        props.put("mail.smtp.password", UserEmailPass);
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        String[] to = {client.getCorreoElectronico()}; // To Email address
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(UserEmail));
        InternetAddress[] toAddress = new InternetAddress[to.length];
        // To get the array of addresses
        for (int i = 0; i < to.length; i++) { // changed from a while loop
            toAddress[i] = new InternetAddress(to[i]);
        }
        System.out.println(Message.RecipientType.TO);
        for (int j = 0; j < toAddress.length; j++) { // changed from a while loop
            message.addRecipient(Message.RecipientType.TO, toAddress[j]);
        }
        message.setSubject(Subject);
        String body = generateBodyMessage(1, client);
        body = body.replace("{NAME}", client.getNombres());
        body = body.replace("{CC}", client.getNumeroDocumento());
        body = body.replace("{PHONE}", "" + client.getTelefono());
        body = body.replace("{MAIL}", client.getCorreoElectronico());

        message.setContent(body, "text/html");
        Transport transport = session.getTransport("smtp");
        transport.connect(host, UserEmail, UserEmailPass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public void SendEmailChangePass(UserEntity user, String Subject) throws AddressException, MessagingException {
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true"); // added this line
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", UserEmail);
        props.put("mail.smtp.password", UserEmailPass);
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        String[] to = {user.getEmail()}; // To Email address
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(UserEmail));
        InternetAddress[] toAddress = new InternetAddress[to.length];
        // To get the array of addresses
        for (int i = 0; i < to.length; i++) { // changed from a while loop
            toAddress[i] = new InternetAddress(to[i]);
        }
        System.out.println(Message.RecipientType.TO);
        for (int j = 0; j < toAddress.length; j++) { // changed from a while loop
            message.addRecipient(Message.RecipientType.TO, toAddress[j]);
        }
        message.setSubject(Subject);
        String body = generateBodyMessage(2, user);
        body = body.replace("{NAME}", user.getNombre());

        message.setContent(body, "text/html");
        Transport transport = session.getTransport("smtp");
        transport.connect(host, UserEmail, UserEmailPass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public String generateBodyMessage(int option, UserEntity user) {
        String bodyMessage = "";
        if (option == 2) {
            bodyMessage = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head> <title>Dondur</title></head><body> <table width=\"70\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#FFFFFF\" style=\"border:solid 0px #8f9097; z-index:100px; background-image: url( https://scontent.fbog2-1.fna.fbcdn.net/v/t1.0-9/21314482_113693032678128_4500976029076286134_n.jpg?oh=acc6a73b43ad91f5700f7ad179086184&oe=5A27C30F ); background-repeat: no-repeat;\"> <tr> <td> <center> <img style=\"z-index:-100px;\" src=\"https://image.ibb.co/ep7K9F/descarga.png\"/> </center> </td></tr><tr align=\"cen\" style=\"font: 12px Arial, Helvetica, sans-serif;float: left;color: #666;margin-left: 10px;font-weight: bold;\"> <center> <td> <h3 style=\"margin-left:150px;\" >Usted ha solicitado cambio de contraseña:</h3> </td></center> </tr><tr> <td align=\"center\" valign=\"middle\"> <center> <table width=\"600\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#535353\"> <tr> <td height=\"150\" colspan=\"2\" valign=\"top\" bgcolor=\"white\" align=\"center\"> <font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"2\"> <div> <p align=\"left\"> Respetado señor/señora: <br/> <b>{NAME}</b> <br><br>Por favor ingrese al siguiente link para efectuar su cambio de contraseña:{LINK}</p><p align=\"left\"> Atentamente, <br><br><b>DONDUR S:A</b> </p><br/> </div></font> </td></tr></table> </center> </td></tr><tr align=\"center\"> <td align=\"center\" width=\"10\" height=\"30\" style=\"background: #ed6824; font-family: helvetica; font-size: 11px; color: #fff; margin-top: 64px; max-width: 10px; \"> Dondur 2018 - Todos Los Derechos Reservados. </td></tr></table></body></html>";

            String linkToChange = Domain + "UserServlet?idtoChangePass=" + user.getIdUsuario() + "&code=" + user.getPass();
            bodyMessage = bodyMessage.replace("{LINK}", linkToChange);
        } else if (option == 1) {
            bodyMessage = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/> <title>Dondur</title> <style type=\"text/css\"></style></head><body> <table width=\"30\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#FFFFFF\" style=\"border:solid 0px #8f9097; background-image: url(https://preview.ibb.co/dcz7UF/21192490_100283790713469_3735791942453866109_n.jpg); background-repeat: no-repeat;\"> <tr> <td> <img src=\"https://image.ibb.co/ep7K9F/descarga.png\"/> </td></tr><tr align=\"cen\" style=\"font: 12px Arial, Helvetica, sans-serif;float: left;color: #666;margin-left: 10px;font-weight: bold;\"> <center> <td> <h3 style=\"margin-left:150px;\" >Bienvenido a DONDUR sus datos de registro son:</h3> </td></center> </tr><tr> <td> <table cellpadding=\"0\" border=\"0\" cellspacing=\"0\" width=\"630\" style=\"float: left;margin-left: 15px;margin-top: 20px;\"> <tr style=\"border-bottom:1px solid #f2f2f2;float:left;width:100%;margin-bottom:5px;\"> <td style=\"font: 12px Arial, Helvetica, sans-serif;color: #333;float: left;width: 30%;height: 20px;font-weight: bold;\"> Nombre: </td><td style=\"float: left;width: 70%;min-height: 20px;font: 11px Arial, Helvetica, sans-serif;font-weight: normal;color: #999;\">{NAME}</td></tr><tr style=\"border-bottom:1px solid #f2f2f2;float:left;width:100%;margin-bottom:5px;\"> <td style=\"font: 12px Arial, Helvetica, sans-serif;color: #333;float: left;width: 30%;height: 20px;font-weight: bold;\"> CC: </td><td style=\"float: left;width: 70%;min-height: 20px;font: 11px Arial, Helvetica, sans-serif;font-weight: normal;color: #999;\">{CC}</td></tr><tr style=\"border-bottom:1px solid #f2f2f2;float:left;width:100%;margin-bottom:5px;\"> <td style=\"font: 12px Arial, Helvetica, sans-serif;color: #333;float: left;width: 30%;height: 20px;font-weight: bold;\"> Teléfono: </td><td style=\"float: left;width: 70%;min-height: 20px;font: 11px Arial, Helvetica, sans-serif;font-weight: normal;color: #999;\">{PHONE}</td></tr><tr style=\"border-bottom:1px solid #f2f2f2;float:left;width:100%;margin-bottom:5px;\"> <td style=\"font: 12px Arial, Helvetica, sans-serif;color: #333;float: left;width: 30%;height: 20px;font-weight: bold;\"> Email: </td><td style=\"float: left;width: 70%;min-height: 20px;font: 11px Arial, Helvetica, sans-serif;font-weight: normal;color: #999;\"> <a href=\"{MAIL}\" style=\"color: #ed6824;text-decoration: none;\">{MAIL}</a> </a> </td></tr></table> </td></tr><tr align=\"center\"> <td align=\"center\" width=\"200\" height=\"30\" style=\"background: #ed6824; font-family: helvetica; font-size: 11px; color: #fff; margin-top: 64px; max-width: 10px; \"> Dondur 2018 - Todos Los Derechos Reservados. </td></tr></table></body></html>";

        }
        return bodyMessage;

    }

    public String generateBodyMessage(int option, Client user) {
        String bodyMessage = "";
        if (option == 1) {
            bodyMessage = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/> <title>Dondur</title> <style type=\"text/css\"></style></head><body> <table width=\"30\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#FFFFFF\" style=\"border:solid 0px #8f9097; background-image: url(https://preview.ibb.co/dcz7UF/21192490_100283790713469_3735791942453866109_n.jpg); background-repeat: no-repeat;\"> <tr> <td> <img src=\"https://image.ibb.co/ep7K9F/descarga.png\"/> </td></tr><tr align=\"cen\" style=\"font: 12px Arial, Helvetica, sans-serif;float: left;color: #666;margin-left: 10px;font-weight: bold;\"> <center> <td> <h3 style=\"margin-left:150px;\" >Bienvenido a DONDUR sus datos de registro son:</h3> </td></center> </tr><tr> <td> <table cellpadding=\"0\" border=\"0\" cellspacing=\"0\" width=\"630\" style=\"float: left;margin-left: 15px;margin-top: 20px;\"> <tr style=\"border-bottom:1px solid #f2f2f2;float:left;width:100%;margin-bottom:5px;\"> <td style=\"font: 12px Arial, Helvetica, sans-serif;color: #333;float: left;width: 30%;height: 20px;font-weight: bold;\"> Nombre: </td><td style=\"float: left;width: 70%;min-height: 20px;font: 11px Arial, Helvetica, sans-serif;font-weight: normal;color: #999;\">{NAME}</td></tr><tr style=\"border-bottom:1px solid #f2f2f2;float:left;width:100%;margin-bottom:5px;\"> <td style=\"font: 12px Arial, Helvetica, sans-serif;color: #333;float: left;width: 30%;height: 20px;font-weight: bold;\"> CC: </td><td style=\"float: left;width: 70%;min-height: 20px;font: 11px Arial, Helvetica, sans-serif;font-weight: normal;color: #999;\">{CC}</td></tr><tr style=\"border-bottom:1px solid #f2f2f2;float:left;width:100%;margin-bottom:5px;\"> <td style=\"font: 12px Arial, Helvetica, sans-serif;color: #333;float: left;width: 30%;height: 20px;font-weight: bold;\"> Teléfono: </td><td style=\"float: left;width: 70%;min-height: 20px;font: 11px Arial, Helvetica, sans-serif;font-weight: normal;color: #999;\">{PHONE}</td></tr><tr style=\"border-bottom:1px solid #f2f2f2;float:left;width:100%;margin-bottom:5px;\"> <td style=\"font: 12px Arial, Helvetica, sans-serif;color: #333;float: left;width: 30%;height: 20px;font-weight: bold;\"> Email: </td><td style=\"float: left;width: 70%;min-height: 20px;font: 11px Arial, Helvetica, sans-serif;font-weight: normal;color: #999;\"> <a href=\"{MAIL}\" style=\"color: #ed6824;text-decoration: none;\">{MAIL}</a> </a> </td></tr></table> </td></tr><tr align=\"center\"> <td align=\"center\" width=\"200\" height=\"30\" style=\"background: #ed6824; font-family: helvetica; font-size: 11px; color: #fff; margin-top: 64px; max-width: 10px; \"> Dondur 2018 - Todos Los Derechos Reservados. </td></tr></table></body></html>";

        }
        return bodyMessage;

    }

    public boolean getBolleanByPermissions(String url, UserEntity user) {

        if (user != null) {
            if ((user.getRol() == Rol.Tecnico && url.equals("/DonDur_1.0/Users/TableUser.jsp")) || (user.getRol() == Rol.Tecnico && url.equals("/DonDur_1.0/Users/FormUser.jsp"))) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;

        }
    }

}
