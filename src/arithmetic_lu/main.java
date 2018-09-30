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
		
		if(sn1.hasNext()) { //如果有输入
			s1 = sn1.nextLine();
			
			if(s1.contains("-n")&&(s1.substring(s1.indexOf("r")+2, s1.length())).matches("\\d+")) { //生成题目与答案
			  sz1 = s1.split("\\D+");//sz1[1]存题数，sz1[2]存数范围
			  exerciseNum= Integer.parseInt(sz1[1]);
			    for(int i=0;i<Integer.parseInt(sz1[1]);i++) {
			    	String s2 = aa1.cha();
				  sa.xieru(s2+"=");
				  String s3 = cc.jisuan(s2);
				  sa1.xieru(s3);
			    }		
			    System.out.println("成功生成题目与答案！");
		    }
			
		    else if(s1.contains("-e")) { //改错功能
			String t = s1.substring(s1.indexOf("e")+2,s1.indexOf("a")-2);//存题目地址
			String d = s1.substring(s1.indexOf("a")+2,s1.length());//存作答地址
			int u=rf.read(t).size();
			for(int ii=0;ii<u;ii++){
				if((rf.read(t).get(ii)).equals(ra.read(d).get(ii))) {
					T.add(ii+1);
				}
				else {
					F.add(ii+1);
				}
			}
			System.out.print("Correct: "+T.size()+"("); //打印正确的题数与题目号
			for(int i=0;i<T.size();i++) {
				if(!(i==T.size()-1)) {
			       System.out.print(T.get(i)+",");
				}
				else {
					System.out.print(T.get(i));
				}
			}
			System.out.println(")");
			
			System.out.print("Wrong: "+F.size()+"("); //打印错误的题数与题目号
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
		else System.out.println("请输入有效命令");
		}
		else System.out.println("请输入命令");
	}
}
