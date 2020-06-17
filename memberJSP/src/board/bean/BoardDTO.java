package board.bean;

import java.util.Date;

import lombok.Data;
@Data
public class BoardDTO {
	private int seq, ref, lev, step, pseq, reply, hit, rn;
	private String id, name, email, homepage ;
	private String subject, content;
	private Date logdate;
}
