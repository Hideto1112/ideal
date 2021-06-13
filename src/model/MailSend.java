package model;

import java.util.Date;
import java.util.Properties;
import java.lang.NoClassDefFoundError;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

import controller.ReserveOperationSvl;
import controller.UserOperationSvl;

public class MailSend {

	public static void send(int mailMode, int id) throws IdealException {
System.out.println("mailsend star");

	String title = "";
	String message = "";
	User u = User.getUser(id);
	Reserve r = Reserve.getReserve(id);
System.out.println("mailsend mode " + mailMode);
	if(mailMode == ReserveOperationSvl.INSERT) {
		title = "ご予約を承りました。";
		message ="<h2>いつも「Restrante IDEALLE」をご利用頂きまして</h2><br />"
				+ "<h2>誠にありがとうございます。</h2><br />"
				+ "<h2>" + r.getUsrName() + "様、ご予約が完了いたしました。</h2><br />"
				+ "<h2>" + r.getRsvYyMmDd() + " " + r.getRsvHhMi() + "より</h2><br />"
				+ "<h2" + r.getCourseName() + r.getPerson() + "名様</h2><br />"
				+ "<h2>ご予約番号は" + r.getRsvId() + "番です。</h2><br />"
				+ "<h2>ご来店の際、受付にお申し付けください。</h2><br />"
				+ "<h2>" + r.getUsrName() + "様のご来店を心よりお待ちしております。</h2><br />"
				+ "<h2>＊本メールは配信専用のため、ご返信いただきましてもレストランへは届きません。</h2><br />";
	}else if(mailMode == UserOperationSvl.MAILMODE) {
		title = "お客様情報のご登録が完了いたしました。";
		message ="<h2>" + u.getUsrName() + "様</h2><br />"
				+ "<h2>「Restrante IDEALLE」へのご登録、誠にありがとうございます。</h2><br />"
				+ "<h2>お客様ＩＤは、" + u.getUsrId() + " となります。</h2><br />"
				+ "<h2>ログインの際に必要となりますので大切に保管してください。</h2><br />"
				+ "<h2>" + u.getUsrName() + "様のご来店を心よりお待ちしております。</h2><br />"
				+ "<h2>＊本メールは配信専用のため、ご返信いただきましてもレストランへは届きません。</h2><br />";
	}

				    try {
	      // プロパティの設定
	      Properties props = System.getProperties();
	      // ホスト
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      // 認証（する）
	      props.put("mail.smpt.auth", "true");
	      // ポート指定（サブミッションポート）
	      props.put("mail.smtp.port", "587");
	      // STARTTLSによる暗号化（する）
	      props.put("mail.smtp.starttls.enable", "true");

	      // セッションの取得
	      Session session = Session.getInstance(props);

	      // MimeMessageの取得と設定
	      Message msg = new MimeMessage(session);
	      // 送信者設定
	      msg.setFrom(new InternetAddress("ueda.hideto1112@gmail.com"));
	      // 宛先設定
	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("hueda439@yahoo.co.jp", false));
	      // タイトル設定
	      msg.setSubject(title);
	      // 本文設定
	      msg.setContent(message, "text/html; charset=iso-2022-jp");
	      // 送信日時設定
	      msg.setSentDate(new Date());

	      // 送信
	      SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
	      try {
	        t.connect("smtp.gmail.com", "ueda.hideto1112@gmail.com", "fylqcxhonbnreapi");
	        t.sendMessage(msg, msg.getAllRecipients());
	      } finally {
	        t.close();
	      }

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
System.out.println("mailsend finish");
	  }
}
