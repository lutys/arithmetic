package arithmetic_lu;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	static int exerciseNum;
	static String[] sz1;
	static String s1;
	static calculate cc= new calculate();
	static create_only aa1 = new create_only();
	static GeneratingExpression ge = new GeneratingExpression();
	static saveExercises sa = new saveExercises();
	static saveAnswers sa1 = new saveAnswers();
	static readFile rf = new readFile();
	static readAnswer ra = new readAnswer();
	static ArrayList<Integer> T=new ArrayList<Integer>();
	static ArrayList<Integer> F=new ArrayList<Integer>();
	static ArrayList<String> chachong=new ArrayList<String>();
	private static Scanner sn1;
	static duplicate_checking dc = new duplicate_checking();
	static Nope nope = new Nope();
	
	public static void main(String[] args) {
		sn1 = new Scanner(System.in);
		
		if(sn1.hasNext()) { //���������
			s1 = sn1.nextLine();
			
			if(s1.contains("-n")&&(s1.substring(s1.indexOf("r")+2, s1.length())).matches("\\d+")) { //������Ŀ���
			  sz1 = s1.split("\\D+");//sz1[1]��������sz1[2]������Χ
			  exerciseNum= Integer.parseInt(sz1[1]);
			    for(int i=0;i<Integer.parseInt(sz1[1]);i++) {
			    	String s2 = aa1.cha();
				  sa.xieru(s2+"=");
				  String s3 = cc.jisuan(s2);
				  sa1.xieru(s3);
			    }		
			    System.out.println("�ɹ�������Ŀ��𰸣�");
		    }
			
		    else if(s1.contains("-e")) { //�Ĵ���
			String t = s1.substring(s1.indexOf("e")+2,s1.indexOf("a")-2);//����Ŀ��ַ
			String d = s1.substring(s1.indexOf("a")+2,s1.length());//�������ַ
			int u=rf.read(t).size();
			for(int ii=0;ii<u;ii++){
				if((rf.read(t).get(ii)).equals(ra.read(d).get(ii))) {
					T.add(ii+1);
				}
				else {
					F.add(ii+1);
				}
			}
			System.out.print("Correct: "+T.size()+"("); //��ӡ��ȷ����������Ŀ��
			for(int i=0;i<T.size();i++) {
				if(!(i==T.size()-1)) {
			       System.out.print(T.get(i)+",");
				}
				else {
					System.out.print(T.get(i));
				}
			}
			System.out.println(")");
			
			System.out.print("Wrong: "+F.size()+"("); //��ӡ�������������Ŀ��
			for(int i=0;i<F.size();i++) {
				if(!(i==F.size()-1)) {
				   System.out.print(F.get(i)+",");
				}
				else {
				System.out.print(F.get(i));
				}
			}
			System.out.print(")");
		}
		else System.out.println("��������Ч����");
		}
		else System.out.println("����������");
	}
}
