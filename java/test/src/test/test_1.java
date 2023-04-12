package test;

import java.util.Scanner


public class test_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int room = 3;
		int student = 50;
		
		String[][] name = new String[room][student];
		int [][][] score = new int [room][student][4];
		float [][] avg = new float[room][student];
		int []classCount = new int [3];
		String[] sb = {"국어", "영어","수학"," 총점"	};
		
		
		
		while(true) {
			
			int ch;
			int cr;
			System.out.println("1.입력, 2.출력 3.검색 4.종료");
			ch = sc.nextInt();
			if (ch == 1) {
				System.out.println("반을 입력");
				cr = sc.nextInt();
				ch= cr-1;
				if(cr<4 && cr>0) {
					System.out.println("이름 : ");
					name[ch][classCount[ch]] = sc.next();
					
					for (int i = 0; i < score[ch][classCount[ch]].length -1 ; i++) {
						if(i ==0) 
						{
						System.out.println("국어점수 : ");
						score[ch][classCount[ch]][i] = sc.nextInt();
						score[ch][classCount[ch]][3] += score[ch][classCount[ch]][i];
						}
						
						else if(i==1)
						{
							System.out.println("영어점수 : ");
							score[ch][classCount[ch]][i] = sc.nextInt();
							score[ch][classCount[ch]][3] += score[ch][classCount[ch]][i];
						}
						else if(i ==2)
						{
							System.out.println("수학점수 : ");
							score[ch][classCount[ch]][i] = sc.nextInt();
							score[ch][classCount[ch]][3] += score[ch][classCount[ch]][i];
						}
						avg[ch][classCount[ch]] = score[ch][classCount[ch]][3]/3.f;
					}
					classCount[ch]++;        //classcount를 을 올라면서 같은 배열 공간에 저장 하지 않는다.
			}
				else
				{
				System.out.println("입력 하신 반을 없습니다.");	
				}
			}
			else  if(ch ==2 )
			{
				while(true)
				{
					int sce;
					System.out.println("1. 전체 출력 \t 2.특정반 출력");
					sce =sc.nextInt();
					if(sce==1)
					{
						for (int z = 0; z < room; z++) 
						{
							for (int i = 0; i < classCount[z]; i++) 
							{
								System.out.print(name[z][i]+"\t");
								for (int j = 0; j < score[z][i].length; j++) 
								{
									System.out.println(score[z][i][j]+"\t");
								}
								System.out.println(avg[z][i]);
							}
								
							}
						break;
					}
					else if(sce==2)  //입력하고 싶은 반 정하기
					{
						System.out.println("1.전체출력 2. 반출력");
						int c1=sc.nextInt();
						if(c1==1) {// 전체출력
							for(int i=0;i<name.length;i++) {
								System.out.println(i+1+"반");
								for(int j=0;j<name[i].length;j++) {
									for(int k=j+1;k<name[i].length;k++) {
										if(avg[i][k]>avg[i][j]) {//성적 높은순 정렬 bubble sort
											String str=name[i][j];
											name[i][j]=name[i][k];
											name[i][k]=str;
											//국어성적 
											int temp=score[i][j][0];
											score[i][j][0]=score[i][k][0];
											score[i][k][0]=temp;
											//영어성적
											temp=score[i][j][1];
											score[i][j][1]=score[i][k][1];
											score[i][k][1]=temp;
											//수학성적
											temp=score[i][j][2];
											score[i][j][2]=score[i][k][2];
											score[i][k][2]=temp;
											//총점
											temp=score[i][j][3];
											score[i][j][3]=score[i][k][3];
											score[i][k][3]=temp;
											//평균
											float trash=avg[i][j];
											avg[i][j]=avg[i][k];
											avg[i][k]=trash;								
										}
									}
									if(name[i][j]!=null) {													
										System.out.print(name[i][j]+": ");
										for(int k=0;k<score[i][j].length;k++) {
											System.out.print(sb[k]+": "+score[i][j][k]+":점\t");
										}
										System.out.println("평균: "+avg[i][j]+":점");
					}
					}
				}
			}
		
	}
}
