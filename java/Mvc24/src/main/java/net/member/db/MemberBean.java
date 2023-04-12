package net.member.db;

// ���� Ŭ���� ������ �� �ѱ�� �޾ƿ��� ����..?
// ���� ȸ������ ����.

public class MemberBean {
	private int MEMBER_NUM;
	private String id; // 1 ���̵� 
	private String pw; // 2 ���
	private String email; // 3 �̸���
	private String name; // 4 �̸�
	private String addr[]; // 5 �ּ�
	private String pin; // 6 �ֹι�ȣ
	private String year; // 7 ����
	private String month; // 8 ����
	private String day; // 9 ����
	private String hobby[]; // 10 ���ɺо�
	private String intro; // 11 �ڱ�Ұ� 
	
	private String addarr2; //�߰�
	private String hobbyarr2; // �߰�
	
	public MemberBean() {
		this.MEMBER_NUM = 0;
		this.id = "";
		this.pw = "";
		this.email = "";
		this.name = "";
		this.addr = null;
		this.pin = "";
		this.year = "";
		this.month = "";
		this.day = "";
		this.hobby = null;
		this.intro = "";
		
		this.addarr2 = null;
		this.hobbyarr2 = null;
	}
	
	public String getHobbyarr2() {
		return hobbyarr2;
	}
	
	public String getAddarr2() {
		return addarr2;
	}
	
	public void setHobbyarr2(String hobbyarr) {
		this.hobbyarr2 = hobbyarr;
	}
	
	public void setAddarr2(String addarr) {
		this.addarr2 = addarr;
	}
	
	
	public String getHobbyarr() {
		// ���ɺо߰� null �� �ƴϾ for���� ���ư�
		String hobbyarr = "";
		for(int i=0;i<hobby.length;i++) {
			hobbyarr += hobby[i];
			if(i<hobby.length -1) {
				hobbyarr += ',';
			}
		}
		return hobbyarr;
	}

	
	public String getAddarr() {
		String addarr = "";
		for(int i=0;i<addr.length;i++) {
			addarr += addr[i];
			if(i<addr.length -1) {
				addarr += "<br>";
			}
		}
		return addarr;
	}

	public int getMEMBER_NUM() {
		return MEMBER_NUM;
	}


	public void setMEMBER_NUM(int mEMBER_NUM) {
		MEMBER_NUM = mEMBER_NUM;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getAddr() {
		return addr;
	}

	public void setAddr(String[] addr) {
		this.addr = addr;
	}
	
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	public String[] getHobby() {
		return hobby;
	}
	public String getIntro() {
		return intro;
	}


	public void setIntro(String intro) {
		this.intro = intro;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}



}

