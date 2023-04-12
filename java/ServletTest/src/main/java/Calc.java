
public class Calc {
	
	
	private String Fnum;
	private String Snum;
	private String chk;
	private float num = 0;
	
	Calc(String Fnum, String Snum, String chk){
		this.Fnum = Fnum;
		this.Snum = Snum;
		this.chk = chk;
		
	}

	 
	 public float oper() {
		 if(chk.equals("+"))this.num = Integer.parseInt(Fnum) + Integer.parseInt(Snum);
		 if(chk.equals("-"))this.num = Integer.parseInt(Fnum) + Integer.parseInt(Snum);
		 if(chk.equals("*"))this.num = Integer.parseInt(Fnum) + Integer.parseInt(Snum);
		 if(chk.equals("/"))this.num = Integer.parseInt(Fnum) + Integer.parseInt(Snum);
		 return num;
	 }

}
