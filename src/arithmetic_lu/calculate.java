package arithmetic_lu;

import java.util.ArrayList;
import java.util.Stack;

public class calculate {
	static GeneratingExpression ges = new GeneratingExpression();
	main m = new main();
	public String jisuan(String ss) {
		
	String st1;
	int int1=0;
	ArrayList<String> a1=new ArrayList<String>();
	ArrayList<String> a2=new ArrayList<String>();
	String st=ss;
	String o,oo;
	String[] a=st.split("\\+|\\-|\\×|\\÷|\\(|\\)");
	String[] b=st.split("");
	String[] c;
	String tt = "";
	StringBuffer sb = new StringBuffer("");
	Stack<String> zhan_num = new Stack<String>();
	Stack<String> zhan_string = new Stack<String>();
	
		for(int i=0;i<a.length;i++) {//将所有数化为分数
		if(a[i].equals("")) {}
		else if(a[i].contains("/")) {}
		else {
			String fz = a[i];
			a[i]=fz+"/1";
		}
		if(!a[i].equals("")) {
			a1.add(a[i]);	
		}
		}
		
		for(int i1=0;i1<b.length;i1++) {
			if(b[i1].equals("+")) {b[i1]="m+m";}
			else if(b[i1].equals("-")) {b[i1]="m-m";}
			else if(b[i1].equals("×")) {b[i1]="m×m";}
			else if(b[i1].equals("÷")) {b[i1]="m÷m";}
			else if(b[i1].equals("(")) {b[i1]="m(m";}
			else if(b[i1].equals(")")) {b[i1]="m)m";}
		}
		for(int i2=0;i2<b.length;i2++) {
			 sb.append(b[i2]);
		}
		String st2 = sb.toString();
		c = st2.split("m");
		for(int i3=0;i3<c.length;i3++) {
			if(!c[i3].equals("")) {
				a2.add(c[i3]);
			}
		}
		for(int i4=0;i4<a2.size();i4++) {
		String st3=a2.get(i4);
		if(st3.substring(0, 1).matches("\\d")) { //contains不能使用正则表达式
			a2.set(i4, a1.get(int1));
			int1++;
		}
		}
		for(int idai=0;idai<a2.size();idai++) {  //处理带分数
			if(a2.get(idai).contains("'")) {
				String dai = a2.get(idai);
				int aa = Integer.parseInt(dai.substring(0, dai.indexOf("'")));
				int bb = Integer.parseInt(dai.substring(dai.indexOf("'")+1, dai.indexOf("/")));
				String cc = dai.substring(dai.indexOf("/")+1, dai.length()); //包含起始字符
				String dd = String.valueOf(aa*bb);
				String ee = dd+"/"+cc;
				a2.set(idai, ee);
			}
		}	

		for(int i4=0;i4<a2.size();i4++) {
			String st4 = a2.get(i4);
			if(st4.substring(0, 1).matches("\\d")) {
				zhan_num.push(st4);
			}
			else if(st4.equals("(")) {
				zhan_string.push(st4);
			}
			else if(st4.equals(")")) {
				String st5 = yunsuan(zhan_num.pop(), zhan_num.pop(), zhan_string.pop());
				zhan_num.push(st5);
				zhan_string.pop();
			}
			else if(youxianji(st4)>0) {
				if (zhan_string.isEmpty()) { // 栈为空直接入栈
                    zhan_string.push(st4);
                }
				else {
                    // 如果栈顶元素优先级大于或等于要入栈的元素,将栈顶元素弹出并计算,然后入栈
                    if (youxianji(zhan_string.peek())>=youxianji(st4)) {
                    	String st5 = yunsuan(zhan_num.pop(), zhan_num.pop(), zhan_string.pop());
                    	//
                    	String[] pp = st5.split("/");
                    	if((Integer.parseInt(pp[0])<0)||(Integer.parseInt(pp[1])<0)){
                    		jisuan(ges.GeneratingExpression(Integer.parseInt(m.sz1[2])));
                    	}
                    	zhan_num.push(st5);
                    }
                    zhan_string.push(st4);
                }
			}
			
		}
		while (!zhan_string.isEmpty()) {
			String st5 = yunsuan(zhan_num.pop(), zhan_num.pop(), zhan_string.pop());
			String[] pp = st5.split("/");
        	if((Integer.parseInt(pp[0])<0)||(Integer.parseInt(pp[1])<0)){
        		jisuan(ges.GeneratingExpression(Integer.parseInt(m.sz1[2])));
        	}
			tt = st5;
			zhan_num.push(st5);
        }
		String[] ttt = tt.split("/");  //如为xx/1的形式，输出xx
		if(ttt[1].equals("1")) {
			return ttt[0];
		}
		else if(Integer.parseInt(ttt[0])==0) {
			return "0";
		}
		else if(Integer.parseInt(ttt[0])>Integer.parseInt(ttt[1])) {  //若分子大于分母，输出带分数
			String xx = String.valueOf(Integer.parseInt(ttt[0])/Integer.parseInt(ttt[1]));
			String yy = String.valueOf(Integer.parseInt(ttt[0])%Integer.parseInt(ttt[1]));
			String zz = xx+"'"+yy+"/"+ttt[1];
			return zz;
		}
		else {return zhan_num.pop();}
	}
			
	public static String yunsuan(String st6,String st7,String st8) { //注意两数顺序
		String[] fenshu1 = st7.split("/");
		int fenzi1 = Integer.parseInt(fenshu1[0]);
		int fenmu1 = Integer.parseInt(fenshu1[1]);
		
		String[] fenshu2 = st6.split("/");
		int fenzi2 = Integer.parseInt(fenshu2[0]);
		int fenmu2 = Integer.parseInt(fenshu2[1]);
		
		if(st8.equals("+")) {
			int fenmu3 = least_common(fenmu1,fenmu2);
			int fenzi3 = fenmu3/fenmu1*fenzi1+fenmu3/fenmu2*fenzi2;
			String s = huajian(fenmu3,fenzi3);
			return s;
		}
		else if(st8.equals("-")) {
			int fenmu3 = least_common(fenmu1,fenmu2);
			int fenzi3 = fenmu3/fenmu1*fenzi1-fenmu3/fenmu2*fenzi2;
			String s = huajian(fenmu3,fenzi3);
			return s;
		}
		else if(st8.equals("×")) {
			int fenmu3 = fenmu1*fenmu2;
			int fenzi3 = fenzi1*fenzi2;
			String s = huajian(fenmu3,fenzi3);
			return s;
		}
		else {  //除法
			int fenmu3 = fenmu1*fenzi2;
			int fenzi3 = fenzi1*fenmu2;
			String s = huajian(fenmu3,fenzi3);
			return s;
		}
	}
	public static int least_common(int int2,int int3) {  //求最小公倍数
		int y = 0;
		if(int2<int3){
		int t=int2;
		int2=int3;
		int3=t;
		}
		for(int i=int3;i<=int2*int3;i++){
		if(i%int2==0 && i%int3==0) y=i;
		}
		return y;
	    }
	
	public static String huajian(int int5,int int6) {  //化简分数，int5为分母，int6为分子
		int greatest_common = greatest_common(int5,int6);
		String st8 = String.valueOf(int6/greatest_common)+"/"+String.valueOf(int5/greatest_common);
		return st8;
		}
	
	public static int greatest_common(int x, int y){  //辗转相除法求最大公约数
		if(y == 0)
		return x;
		else
		return greatest_common(y,x%y);
		}
	
	public static int youxianji(String st9) {
		if(st9.equals("+")) return 1;
		else if(st9.equals("-")) return 1;
		else if(st9.equals("×")) return 2;
		else if(st9.equals("÷")) return 2;
		else return 0;
	}
}