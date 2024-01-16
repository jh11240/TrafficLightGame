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
		System.out.println("��ȣ�� �����Դϴ�.");
		r.read();
		System.out.println("�������� �г����� �����ּ���: ");
		r.setId(s.nextLine());		
		
		 while (true) {
			 System.out.println("-------------------------------------------");
			 System.out.print("�޴�(���ӽ���:1, �� ��:2, �·�����:3, �ְ� ��������:4 ,��������:5) >>");
			 int menu = s.nextInt();
			 switch (menu) {
			 case 1: g. main_game(); break;
			 case 2: g. money(); break;
			 case 3: g. winrate(); break;
			 case 4:
				 r.read();
				 System.out.println("�ְ� ������ ������ "+ r.getId()+" �̰� ������ "+r.getScore()+"�Դϴ�."); break;
			 case 5: g. finish(); return;
			 default: System.out.println("�߸��Է��Ͽ����ϴ�. ����(1~5)�� �Է����ּ���");
			 }
		 }
	}
}

//�������� ������ 0~8�� ���ڸ� 3������ �����ִ� Ŭ����
class detectcolor  {
	
	public int detect(int a) {
		if (a<3) return 1;
		else if(a<6) return 2;
		else return 3;
	}
}

//���ӿ� �ʿ��� ��ɵ��� �ִ� Ŭ����
class game_options {
	private int a;
	private int mymoney=10;
	
	List<Integer> list = new LinkedList<>(); //���׸� ���
    detectcolor d = new detectcolor();
    Random rand = new Random();
    Scanner s = new Scanner(System.in);
    Color_Define m = ()-> rand.nextInt(8);
    read_thebest re = new read_thebest();
	
    //���� ���� �Լ�
	public void main_game(){

		
		while (true) {
			a=d.detect(m.random()); //�������� 0~8�� �޾� 3������ �з� 1�϶� ���� 2�϶� ��Ȳ 3�϶� �ʷ�
			/*System.out.println("������"+a+"�Դϴ�");*/ //Ȥ�� �׽�Ʈ �Ͻ� �� �� �̸� �˰�����ø� ����ϼ���!
			 System.out.println("-------------------------------------------------");
			 System.out.println("������ �ϳ��� ���⸦ ������. 1�� : ������ , 2�� : ��Ȳ�� , 3�� : �ʷϻ�  (���ڷ� �Է��ϼ���)");
			 int menu = s.nextInt();
			 switch (menu) {
			
			 case 1:  //���� ���� ���� �����
				 if(a==1) {
				 System.out.println("���ϵ帳�ϴ�! ���߼̽��ϴ�! \n");
				 mymoney +=10;
				 list.add(1);
				  }
			 else if(a==2){
				 System.out.println("�ƽ����ϴ� ��Ȳ���̿����ϴ�.. \n" );
				 mymoney -=10;
				 if(mymoney<0) {
					 System.out.println("�̷�~ ���� �� ���������ϴ�!  \n GAME OVER!");
					 System.exit(1);}
				 list.add(0);
			 }
			 else {
				 System.out.println("�ƽ����ϴ� �ʷϻ��̿����ϴ�..\n");
				 mymoney -=10;
				 if(mymoney<0) {
					 System.out.println("�̷�~  ���� �� ���������ϴ�! \n GAME OVER!");
					 System.exit(1);}
				 list.add(0);
			 }
			 
			if(read_thebest.getScore()<list.size()) {
				
				System.out.println("���ϵ帳�ϴ�!! �ְ� ����� ����̽��ϴ�.");
				write_thebest(re.getCurrent(),list.size());
				System.out.println(re.getCurrent()+"���� �ְ� �������� ��ϵǾ����ϴ�.");
				System.out.println("(���� �޴��� �ְ� ���� �޴����� Ȯ���Ͻ� �� �ֽ��ϴ�.)\n");
			}
			if(continue_or_not()==1) break;
			 else return;
			 
			 case 2:  //���� ��Ȳ���� �� ���
				 if(a==1) {
				 System.out.println("�ƽ����ϴ� �������̿����ϴ�.. \n");
				 mymoney -=10;
				 if(mymoney<0) {
					 System.out.println("�̷�~ ���� �� ���������ϴ�! \n GAME OVER!");
					 System.exit(1);}
				 list.add(0);
			 }
			 else if(a==2){
				 System.out.println("���ϵ帳�ϴ�! ���߼̽��ϴ�! \n" );
				 mymoney +=10;
				 list.add(1);
			 }
			 else {
				 System.out.println("�ƽ����ϴ� �ʷϻ��̿����ϴ�..\n");
				 mymoney -=10;
				 if(mymoney<0) {
					 System.out.println("�̷�~ ���� �� ���������ϴ�! \n GAME OVER!");
					 System.exit(1);}
				 list.add(0);
			 }
			 if(read_thebest.getScore()<list.size()) {
					
					System.out.println("���ϵ帳�ϴ�!! �ְ� ����� ����̽��ϴ�.");
					write_thebest(re.getCurrent(),list.size());
					System.out.println(re.getCurrent()+"���� �ְ� �������� ��ϵǾ����ϴ�.");
					System.out.println("(���� �޴��� �ְ� ���� �޴����� Ȯ���Ͻ� �� �ֽ��ϴ�.)\n");
				}
				if(continue_or_not()==1) break;
				 else return;
			 
			 case 3: //���� �ʷϻ��� �� ���
				 if(a==1) {
				 System.out.println("�ƽ����ϴ� �������̿����ϴ�.. \n");
				 mymoney -=10;
				 if(mymoney<0) {
					 System.out.println("�̷�~ ���� �� ���������ϴ�! \n GAME OVER!");
					 System.exit(1);}
				 list.add(0);
			 }
			 else if(a==2){
				 System.out.println("�ƽ����ϴ� ��Ȳ���̿����ϴ�.. \n" );
				 mymoney -=10;
				 if(mymoney<0) {
					 System.out.println("�̷�~ ���� �� ���������ϴ�! \n GAME OVER!");
					 System.exit(1);}
				 list.add(0);
			 }
			 else {
				 System.out.println("���ϵ帳�ϴ�! ���߼̽��ϴ�!\n");
				 mymoney +=10;
				 list.add(1);
			 }
			 
			 if(read_thebest.getScore()<list.size()) {
					
					System.out.println("���ϵ帳�ϴ�!! �ְ� ����� ����̽��ϴ�.");
					write_thebest(re.getCurrent(),list.size());
					System.out.println(re.getCurrent()+"���� �ְ� �������� ��ϵǾ����ϴ�.");
					System.out.println("(���� �޴��� �ְ� ���� �޴����� Ȯ���Ͻ� �� �ֽ��ϴ�.)\n");
				}
				if(continue_or_not()==1) break;
				 else return;
			 default: System.out.println("�߸��Է��Ͽ����ϴ�.");
			 }
		}
	}
	
	//�� �� �˷��ִ� �Լ�
	public void money() {
	
		System.out.println("���� ���� ���� : " + mymoney);
		if(mymoney==0) System.out.println("����! �� �� ���� ��������~");
		
	}
	
	//�·� �˷��ִ� �Լ�
	public void winrate() {
		int win = 0;
		int lose =0;
		rate r;
		r = (int a, int b)-> a*100/(a+b); //���� �Լ��� �̿��� �������̽� ����
				
		
		for (Iterator<Integer> i= list.iterator();i.hasNext(); ) {
			if(i.next()==1) win++;
			else lose++;
		}
		
		
		System.out.println("�� " + list.size()+"�� ��"+ win+"�� �̱�� "+lose+"�� ���̽��ϴ�.");
		if(win+lose==0) {
			System.out.println("���� ������ �Ͻ��� �����̽��ϴ�. �·������ ������ �ϰ� �ٽ� �̿����ּ���.");
			return;}
		else System.out.println("�·���: "+r.cal(win,lose) +"�ۼ�Ʈ");
		}
	
	//���� ���� ���� ����ִ� �Լ�
	public void finish() {
		System.out.println("������ �����մϴ�.");
	}
	
	//������ ��� �̾�� ������ üũ�ϴ� �Լ�
	 public int continue_or_not() {
	    	int a=0;
	    	while(true) {
	    		System.out.println("����Ͻðڽ��ϱ�? (��:1, �ƴϿ�:2): ");
				 
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
					 System.out.println("���� 1 �Ǵ� 2�� �Է����ּ���");
				 }
	    		
	    	}
	    	return a;
	    }

	 //�ְ� ������ ���� �ȴٸ� ���Ͽ� �Է����ִ� �Լ�
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
	
	//���Ͽ� �ִ� ���� �ҷ��� a�� s�� ��������
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
	
	//�ְ� ������ �� ������ �г����� �ҷ����� �Լ�
	public String getId() {
		return s;
	}
	
	//�ְ� ���� �� ������ ���� �ҷ����� �Լ�
	public static int getScore() {
		return a;
	}
	
	//�������� �г��� ���� ���ִ� �Լ�
	public void setId(String c) {
		currentid =c;
	}
	
	//���� �������� �г��� �ҷ����� �Լ�
	public String getCurrent() {
		s = currentid; //currentid�� �ҷ��� �� ������ �ְ� ��� ������ ���̹Ƿ� s�� �־���
		return s;
		
	}
	 
}


	


 