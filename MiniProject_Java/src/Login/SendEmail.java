//package Login;
//
//public class SendEmail {
//
//	public static void main(String[] args) {
//		String from = "from@gmail.com"; // 메일 보내는 사람
//		String to = "killmewild@naver.com"; // 메일 보낼사람
//
//		String subject = "자바 email test ";// 제목
//		String content = "연습용 ";// 내용
//
//		if (from.trim().equals("")) {
//			System.out.println("보내는 사람을 입력하지 않았습니다.");
//		} else if (to.trim().equals("")) {
//			System.out.println("받는 사람을 입력하지 않았습니다.");
//		} else {
//			try {
//				MailTest mt = new MailTest();
//
//				// 메일보내기
//				mt.sendEmail(from, to, cc, subject, content);
//				System.out.println("메일 전송에 성공하였습니다.");
//			} catch (MessagingException me) {
//				System.out.println("메일 전송에 실패하였습니다.");
//				System.out.println("실패 이유 : " + me.getMessage());
//			} catch (Exception e) {
//				System.out.println("메일 전송에 실패하였습니다.");
//				System.out.println("실패 이유 : " + e.getMessage());
//			}
//		}
//	}
//
//}	
