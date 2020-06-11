
package friend.bean;

public class FriendDTO {
	private String name, tel1, tel2, tel3;
	private int read, movie, music, game, shopping, gender;
	int seq;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public int getMovie() {
		return movie;
	}

	public void setMovie(int movie) {
		this.movie = movie;
	}

	public int getMusic() {
		return music;
	}

	public void setMusic(int music) {
		this.music = music;
	}

	public int getGame() {
		return game;
	}

	public void setGame(int game) {
		this.game = game;
	}

	public int getShopping() {
		return shopping;
	}

	public void setShopping(int shopping) {
		this.shopping = shopping;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return seq+","+name;
	}

}
