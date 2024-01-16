package finalexam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.OutputStream;


interface Color_Define {	
	int random();
}
interface rate{
	double cal(int a, int b);
}

public class majimak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
        Scanner s = new Scanner(System.in);
        game_options g = new game_options();
        read_thebest r = new read_thebest();
		System.out.println("신호등 게임입니다.");
		r.read();
		System.out.println("참여자의 닉네임을 정해주세요: ");
		r.setId(s.nextLine());		
		
		 while (true) {
			 System.out.println("-------------------------------------------");
			 System.out.print("메뉴(게임시작:1, 내 돈:2, 승률보기:3, 최고 성적보기:4 ,게임종료:5) >>");
			 int menu = s.nextInt();
			 switch (menu) {
			 case 1: g. main_game(); break;
			 case 2: g. money(); break;
			 case 3: g. winrate(); break;
			 case 4:
				 r.read();
				 System.out.println("최고 성적의 유저는 "+ r.getId()+" 이고 점수는 "+r.getScore()+"입니다."); break;
			 case 5: g. finish(); return;
			 default: System.out.println("잘못입력하였습니다. 숫자(1~5)로 입력해주세요");
			 }
		 }
	}
}

//랜덤으로 배정된 0~8의 숫자를 3가지로 나눠주는 클래스
class detectcolor  {
	
	public int detect(int a) {
		if (a<3) return 1;
		else if(a<6) return 2;
		else return 3;
	}
}

//게임에 필요한 기능들이 있는 클래스
class game_options {
	private int a;
	private int mymoney=10;
	
	List<Integer> list = new LinkedList<>(); //제네릭 사용
    detectcolor d = new detectcolor();
    Random rand = new Random();
    Scanner s = new Scanner(System.in);
    Color_Define m = ()-> rand.nextInt(8);
    read_thebest re = new read_thebest();
	
    //게임 진행 함수
	public void main_game(){

		
		while (true) {
			a=d.detect(m.random()); //랜덤으로 0~8을 받아 3가지로 분류 1일땐 빨강 2일땐 주황 3일땐 초록
			/*System.out.println("정답은"+a+"입니다");*/ //혹시 테스트 하실 때 답 미리 알고싶으시면 사용하세요!
			 System.out.println("-------------------------------------------------");
			 System.out.println("다음중 하나의 보기를 고르세요. 1번 : 빨간색 , 2번 : 주황색 , 3번 : 초록색  (숫자로 입력하세요)");
			 int menu = s.nextInt();
			 switch (menu) {
			
			 case 1:  //내가 빨간 색을 고른경우
				 if(a==1) {
				 System.out.println("축하드립니다! 맞추셨습니다! \n");
				 mymoney +=10;
				 list.add(1);
				  }
			 else if(a==2){
				 System.out.println("아쉽습니다 주황색이였습니다.. \n" );
				 mymoney -=10;
				 if(mymoney<0) {
					 System.out.println("이런~ 돈이 다 떨어졌습니다!  \n GAME OVER!");
					 System.exit(1);}
				 list.add(0);
			 }
			 else {
				 System.out.println("아쉽습니다 초록색이였습니다..\n");
				 mymoney -=10;
				 if(mymoney<0) {
					 System.out.println("이런~  돈이 다 떨어졌습니다! \n GAME OVER!");
					 System.exit(1);}
				 list.add(0);
			 }
			 
			if(read_thebest.getScore()<list.size()) {
				
				System.out.println("축하드립니다!! 최고 기록을 세우셨습니다.");
				write_thebest(re.getCurrent(),list.size());
				System.out.println(re.getCurrent()+"님이 최고 성적으로 등록되었습니다.");
				System.out.println("(메인 메뉴의 최고 성적 메뉴에서 확인하실 수 있습니다.)\n");
			}
			if(continue_or_not()==1) break;
			 else return;
			 
			 case 2:  //내가 주황색을 고른 경우
				 if(a==1) {
				 System.out.println("아쉽습니다 빨간색이였습니다.. \n");
				 mymoney -=10;
				 if(mymoney<0) {
					 System.out.println("이런~ 돈이 다 떨어졌습니다! \n GAME OVER!");
					 System.exit(1);}
				 list.add(0);
			 }
			 else if(a==2){
				 System.out.println("축하드립니다! 맞추셨습니다! \n" );
				 mymoney +=10;
				 list.add(1);
			 }
			 else {
				 System.out.println("아쉽습니다 초록색이였습니다..\n");
				 mymoney -=10;
				 if(mymoney<0) {
					 System.out.println("이런~ 돈이 다 떨어졌습니다! \n GAME OVER!");
					 System.exit(1);}
				 list.add(0);
			 }
			 if(read_thebest.getScore()<list.size()) {
					
					System.out.println("축하드립니다!! 최고 기록을 세우셨습니다.");
					write_thebest(re.getCurrent(),list.size());
					System.out.println(re.getCurrent()+"님이 최고 성적으로 등록되었습니다.");
					System.out.println("(메인 메뉴의 최고 성적 메뉴에서 확인하실 수 있습니다.)\n");
				}
				if(continue_or_not()==1) break;
				 else return;
			 
			 case 3: //내가 초록색을 고른 경우
				 if(a==1) {
				 System.out.println("아쉽습니다 빨간색이였습니다.. \n");
				 mymoney -=10;
				 if(mymoney<0) {
					 System.out.println("이런~ 돈이 다 떨어졌습니다! \n GAME OVER!");
					 System.exit(1);}
				 list.add(0);
			 }
			 else if(a==2){
				 System.out.println("아쉽습니다 주황색이였습니다.. \n" );
				 mymoney -=10;
				 if(mymoney<0) {
					 System.out.println("이런~ 돈이 다 떨어졌습니다! \n GAME OVER!");
					 System.exit(1);}
				 list.add(0);
			 }
			 else {
				 System.out.println("축하드립니다! 맞추셨습니다!\n");
				 mymoney +=10;
				 list.add(1);
			 }
			 
			 if(read_thebest.getScore()<list.size()) {
					
					System.out.println("축하드립니다!! 최고 기록을 세우셨습니다.");
					write_thebest(re.getCurrent(),list.size());
					System.out.println(re.getCurrent()+"님이 최고 성적으로 등록되었습니다.");
					System.out.println("(메인 메뉴의 최고 성적 메뉴에서 확인하실 수 있습니다.)\n");
				}
				if(continue_or_not()==1) break;
				 else return;
			 default: System.out.println("잘못입력하였습니다.");
			 }
		}
	}
	
	//내 돈 알려주는 함수
	public void money() {
	
		System.out.println("지금 나의 돈은 : " + mymoney);
		if(mymoney==0) System.out.println("위험! 한 판 지면 게임종료~");
		
	}
	
	//승률 알려주는 함수
	public void winrate() {
		int win = 0;
		int lose =0;
		rate r;
		r = (int a, int b)-> a*100/(a+b); //람다 함수를 이용해 인터페이스 정의
				
		
		for (Iterator<Integer> i= list.iterator();i.hasNext(); ) {
			if(i.next()==1) win++;
			else lose++;
		}
		
		
		System.out.println("총 " + list.size()+"판 중"+ win+"판 이기고 "+lose+"판 지셨습니다.");
		if(win+lose==0) {
			System.out.println("아직 게임을 하시지 않으셨습니다. 승률보기는 게임을 하고 다시 이용해주세요.");
			return;}
		else System.out.println("승률은: "+r.cal(win,lose) +"퍼센트");
		}
	
	//게임 종료 문구 띄워주는 함수
	public void finish() {
		System.out.println("게임을 종료합니다.");
	}
	
	//게임을 계속 이어나갈 것인지 체크하는 함수
	 public int continue_or_not() {
	    	int a=0;
	    	while(true) {
	    		System.out.println("계속하시겠습니까? (예:1, 아니요:2): ");
				 
				 int choice= s.nextInt();
				 
				 if(choice ==1) {
					 a= 1;
					 break;
				 }
				 else if(choice ==2) {
					 a= 2;
					 break;
				 }
				 else {
					 System.out.println("숫자 1 또는 2로 입력해주세요");
				 }
	    		
	    	}
	    	return a;
	    }

	 //최고 성적을 내게 된다면 파일에 입력해주는 함수
	 public void write_thebest(String b, int c) {
		 FileWriter a;
			try {
				a= new FileWriter("best.txt",false);
				a.write(b);
				a.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			try(OutputStream out = new FileOutputStream("best.dat")){
				out.write(c);
			}catch(IOException e) {
				e.printStackTrace();
			}

	 }
	 
	
}

 class read_thebest {
	private static int a;
	private static String s;
	private static String currentid;
	
	//파일에 있는 것을 불러와 a와 s에 저장해줌
	public void read() {
	 try(BufferedReader br = new BufferedReader(new FileReader("best.txt"))){
		
				s = br.readLine();
	 }
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try(InputStream in= new FileInputStream("best.dat")){
			a= in.read();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//최고 성적을 낸 유저의 닉네임을 불러오는 함수
	public String getId() {
		return s;
	}
	
	//최고 성적 낸 유저의 점수 불러오는 함수
	public static int getScore() {
		return a;
	}
	
	//참여자의 닉네임 저장 해주는 함수
	public void setId(String c) {
		currentid =c;
	}
	
	//현재 참여자의 닉네임 불러오는 함수
	public String getCurrent() {
		s = currentid; //currentid가 불렸을 땐 어차피 최고 기록 세웠을 때이므로 s에 넣어줌
		return s;
		
	}
	 
}


	


 