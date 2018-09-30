package arithmetic_lu;

import java.util.Random;

public class GeneratingExpression {
	
	calculate result=new calculate();
	
	String operationCharacter[]= {"+","-","×","÷"};
	int operand[]= {2,3,4};
	
	GeneratingExpression(){
		
	}
	
	public String GeneratingExpression(int k){
		int i,j,q,w,e,r;
		j=new Random().nextInt(3)+2;//设定操作数个数
		q=new Random().nextInt(k);
		w=new Random().nextInt(k-1)+1;
		e=new Random().nextInt(k);
		r=new Random().nextInt(k-1)+1;
		
		while(q/w>=k) {
			q=new Random().nextInt(k);
		}
		
		String a,b;
		String s1=huajian(w,q);
		String s2=huajian(r,e);
		String []s11=s1.split("\\/");
		String []s22=s2.split("\\/");
		q=Integer.valueOf(s11[0]);
		w=Integer.valueOf(s11[1]);
		e=Integer.valueOf(s22[0]);
		r=Integer.valueOf(s22[1]);
		
		if(q==0)a=String.valueOf(q);
		else if(q/w==0)a=q+"/"+w;
		else if(q/w<(float)q/w)a=q/w+"'"+(q-q/w*w)+"/"+w;
		else a=String.valueOf(q/w);
		if(e==0)b=String.valueOf(e);
		else if(e/r==0)b=e+"/"+r;
		else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
		else b=String.valueOf(e/r);
		
		if(j==2) {//两个操作数
			String op1=operationCharacter[new Random().nextInt(4)];
			String s;
			while(b.equals("0")&&op1.equals("÷")||e/r>=k) {//判0操作
				e=new Random().nextInt(k);
				r=new Random().nextInt(k-1)+1;
				s2=huajian(r,e);
				s22=s2.split("\\/");
				e=Integer.valueOf(s22[0]);
				r=Integer.valueOf(s22[1]);
				if(e==0)b=String.valueOf(e);
				else if(e/r==0)b=e+"/"+r;
				else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
				else b=String.valueOf(e/r);
			}
			s=a+op1+b;
			return s;
		}
		if(j==3) {//三个操作数
			int t,y;
			String c;
			String op1=operationCharacter[new Random().nextInt(4)];
			String op2=operationCharacter[new Random().nextInt(4)];
			t=new Random().nextInt(k);
			y=new Random().nextInt(k-1)+1;
			
			String s3=huajian(y,t);
			String []s33=s3.split("\\/");
			t=Integer.valueOf(s33[0]);
			y=Integer.valueOf(s33[1]);
			if(t==0)c=String.valueOf(t);
			else if(t/y==0)c=t+"/"+y;
			else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
			else c=String.valueOf(t/y);
			String s=null;
			i=new Random().nextInt(3);
			switch(i) {////判0操作
			case 0:{
				while(b.equals("0")&&op1.equals("÷")||e/r>=k) {
					e=new Random().nextInt(k);
					r=new Random().nextInt(k-1)+1;
					s2=huajian(r,e);
					s22=s2.split("\\/");
					e=Integer.valueOf(s22[0]);
					r=Integer.valueOf(s22[1]);
					if(e==0)b=String.valueOf(e);
					else if(e/r==0)b=e+"/"+r;
					else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
					else b=String.valueOf(e/r);
				}
				while(c.equals("0")&&op2.equals("÷")||t/y>=k) {
					t=new Random().nextInt(k);
					y=new Random().nextInt(k-1)+1;
					s3=huajian(y,t);
					s33=s3.split("\\/");
					t=Integer.valueOf(s33[0]);
					y=Integer.valueOf(s33[1]);
					if(t==0)c=String.valueOf(t);
					else if(t/y==0)c=t+"/"+y;
					else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
					else c=String.valueOf(t/y);
				}
				s=a+op1+b+op2+c;break;
			}
			case 1:{
				while(op2.equals("÷")&&c.equals("0")||t/y>=k) {
					t=new Random().nextInt(k);
					y=new Random().nextInt(k-1)+1;
					s3=huajian(y,t);
					s33=s3.split("\\/");
					t=Integer.valueOf(s33[0]);
					y=Integer.valueOf(s33[1]);
					if(t==0)c=String.valueOf(t);
					else if(t/y==0)c=t+"/"+y;
					else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
					else c=String.valueOf(t/y);
				}
				while(op1.equals("÷")&&result.jisuan(b+op2+c).equals("0")||e/r>=k||t/y>=k) {
					e=new Random().nextInt(k);
					r=new Random().nextInt(k-1)+1;
					s2=huajian(r,e);
					s22=s2.split("\\/");
					e=Integer.valueOf(s22[0]);
					r=Integer.valueOf(s22[1]);
					if(e==0)b=String.valueOf(e);
					else if(e/r==0)b=e+"/"+r;
					else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
					else b=String.valueOf(e/r);
					t=new Random().nextInt(k);
					y=new Random().nextInt(k-1)+1;
					s3=huajian(y,t);
					s33=s3.split("\\/");
					t=Integer.valueOf(s33[0]);
					y=Integer.valueOf(s33[1]);
					if(t==0)c=String.valueOf(t);
					else if(t/y==0)c=t+"/"+y;
					else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
					else c=String.valueOf(t/y);
					while(op2.equals("÷")&&c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
				}
				s=a+op1+"("+b+op2+c+")";break;
			}
			}
			case 2:{
				op1=operationCharacter[new Random().nextInt(4)];
				op2=operationCharacter[new Random().nextInt(4)];
				while(op1.equals("÷")&&b.equals("0")||e/r>=k) {
					e=new Random().nextInt(k);
					r=new Random().nextInt(k-1)+1;
					s2=huajian(r,e);
					s22=s2.split("\\/");
					e=Integer.valueOf(s22[0]);
					r=Integer.valueOf(s22[1]);
					if(e==0)b=String.valueOf(e);
					else if(e/r==0)b=e+"/"+r;
					else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
					else b=String.valueOf(e/r);
				}
				while(op2.equals("÷")&&c.equals("0")||t/y>=k) {
					t=new Random().nextInt(k);
					y=new Random().nextInt(k-1)+1;
					s3=huajian(y,t);
					s33=s3.split("\\/");
					t=Integer.valueOf(s33[0]);
					y=Integer.valueOf(s33[1]);
					if(t==0)c=String.valueOf(t);
					else if(t/y==0)c=t+"/"+y;
					else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
					else c=String.valueOf(t/y);
				}
				if(op1.equals("×")||op1.equals("÷")||op2.equals("-")
						||op2.equals("+"))s=a+op1+b+op2+c;
				else s="("+a+op1+b+")"+op2+c;break;
			}
			}
			return s;
		}
		if(j==4) {//四个操作数
			int t,y,m,n;
			String c,d;
			String op1=operationCharacter[new Random().nextInt(4)];
			String op2=operationCharacter[new Random().nextInt(4)];
			String op3=operationCharacter[new Random().nextInt(4)];
			t=new Random().nextInt(k);
			y=new Random().nextInt(k-1)+1;
			m=new Random().nextInt(k);
			n=new Random().nextInt(k-1)+1;
			String s3=huajian(y,t);
			String s4=huajian(n,m);
			String []s33=s3.split("\\/");
			String []s44=s4.split("\\/");
			t=Integer.valueOf(s33[0]);
			y=Integer.valueOf(s33[1]);
			m=Integer.valueOf(s44[0]);
			n=Integer.valueOf(s44[1]);
			if(t==0)c="0";
			else if(t/y==0)c=t+"/"+y;
			else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
			else c=String.valueOf(t/y);
			if(m==0)d="0";
			else if(m/n==0)d=m+"/"+n;
			else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
			else d=String.valueOf(m/n);
			String s=null;
			i=new Random().nextInt(6);
			switch(i) {//判0操作
			case 0:{
				while(op1.equals("÷")&&op3.equals("÷")&&op3.equals("÷")
						&&b.equals("0")||c.equals("0")||d.equals("0")||e/r>=k||t/y>=k||m/n>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
					if(c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(op1.equals("÷")&&!op2.equals("÷")&&op3.equals("÷")
						&&b.equals("0")||d.equals("0")||e/r>=k||m/n>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(op1.equals("÷")&&!op2.equals("÷")&&!op3.equals("÷")
						&&b.equals("0")||e/r>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
				}
					while(!op1.equals("÷")&&op2.equals("÷")&&!op3.equals("÷")
							&&c.equals("0")||t/y>=k) {
						if(c.equals("0")||t/y>=k) {
							t=new Random().nextInt(k);
							y=new Random().nextInt(k-1)+1;
							s3=huajian(y,t);
							s33=s3.split("\\/");
							t=Integer.valueOf(s33[0]);
							y=Integer.valueOf(s33[1]);
							if(t==0)c=String.valueOf(t);
							else if(t/y==0)c=t+"/"+y;
							else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
							else c=String.valueOf(t/y);
						}
					}
					while(!op1.equals("÷")&&op2.equals("÷")&&op3.equals("÷")
							&&c.equals("0")||d.equals("0")||t/y>=k||m/n>=k) {
						if(c.equals("0")||t/y>=k) {
							t=new Random().nextInt(k);
							y=new Random().nextInt(k-1)+1;
							s3=huajian(y,t);
							s33=s3.split("\\/");
							t=Integer.valueOf(s33[0]);
							y=Integer.valueOf(s33[1]);
							if(t==0)c=String.valueOf(t);
							else if(t/y==0)c=t+"/"+y;
							else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
							else c=String.valueOf(t/y);
						}
						if(d.equals("0")||m/n>=k) {
							m=new Random().nextInt(k);
							n=new Random().nextInt(k-1)+1;
							s3=huajian(n,m);
							s33=s3.split("\\/");
							m=Integer.valueOf(s33[0]);
							n=Integer.valueOf(s33[1]);
							if(m==0)d=String.valueOf(m);
							else if(m/n==0)d=m+"/"+n;
							else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
							else c=String.valueOf(m/n);
						}
					}
					while(!op1.equals("÷")&&op2.equals("÷")&&op3.equals("÷")
							&&d.equals("0")||m/n>=k) {
						if(d.equals("0")||m/n>=k) {
							m=new Random().nextInt(k);
							n=new Random().nextInt(k-1)+1;
							s3=huajian(n,m);
							s33=s3.split("\\/");
							m=Integer.valueOf(s33[0]);
							n=Integer.valueOf(s33[1]);
							if(m==0)d=String.valueOf(m);
							else if(m/n==0)d=m+"/"+n;
							else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
							else c=String.valueOf(m/n);
						}
					}
					while(op1.equals("÷")&&op2.equals("÷")&&!op3.equals("÷")
							&&b.equals("0")||c.equals("0")||e/r>=k||t/y>=k) {
						if(b.equals("0")||e/r>=k) {
							e=new Random().nextInt(k);
							r=new Random().nextInt(k-1)+1;
							s2=huajian(r,e);
							s22=s2.split("\\/");
							e=Integer.valueOf(s22[0]);
							r=Integer.valueOf(s22[1]);
							if(e==0)b=String.valueOf(e);
							else if(e/r==0)b=e+"/"+r;
							else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
							else b=String.valueOf(e/r);
						}
						if(c.equals("0")||t/y>=k) {
							t=new Random().nextInt(k);
							y=new Random().nextInt(k-1)+1;
							s3=huajian(y,t);
							s33=s3.split("\\/");
							t=Integer.valueOf(s33[0]);
							y=Integer.valueOf(s33[1]);
							if(t==0)c=String.valueOf(t);
							else if(t/y==0)c=t+"/"+y;
							else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
							else c=String.valueOf(t/y);
						}
					}
					s=a+op1+b+op2+c+op3+d;
					break;
				}
			case 1:{
				while(op1.equals("÷")&&op3.equals("÷")&&op3.equals("÷")
						&&b.equals("0")||c.equals("0")||d.equals("0")||e/r>=k||t/y>=k||m/n>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
					if(c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(op1.equals("÷")&&!op2.equals("÷")&&op3.equals("÷")
						&&b.equals("0")||d.equals("0")||e/r>=k||m/n>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(op1.equals("÷")&&!op2.equals("÷")&&!op3.equals("÷")
						&&b.equals("0")||e/r>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
				}
					while(!op1.equals("÷")&&op2.equals("÷")&&!op3.equals("÷")
							&&c.equals("0")||t/y>=k) {
						if(c.equals("0")||t/y>=k) {
							t=new Random().nextInt(k);
							y=new Random().nextInt(k-1)+1;
							s3=huajian(y,t);
							s33=s3.split("\\/");
							t=Integer.valueOf(s33[0]);
							y=Integer.valueOf(s33[1]);
							if(t==0)c=String.valueOf(t);
							else if(t/y==0)c=t+"/"+y;
							else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
							else c=String.valueOf(t/y);
						}
					}
					while(!op1.equals("÷")&&op2.equals("÷")&&op3.equals("÷")
							&&c.equals("0")||d.equals("0")||t/y>=k||m/n>=k) {
						if(c.equals("0")||t/y>=k) {
							t=new Random().nextInt(k);
							y=new Random().nextInt(k-1)+1;
							s3=huajian(y,t);
							s33=s3.split("\\/");
							t=Integer.valueOf(s33[0]);
							y=Integer.valueOf(s33[1]);
							if(t==0)c=String.valueOf(t);
							else if(t/y==0)c=t+"/"+y;
							else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
							else c=String.valueOf(t/y);
						}
						if(d.equals("0")||m/n>=k) {
							m=new Random().nextInt(k);
							n=new Random().nextInt(k-1)+1;
							s3=huajian(n,m);
							s33=s3.split("\\/");
							m=Integer.valueOf(s33[0]);
							n=Integer.valueOf(s33[1]);
							if(m==0)d=String.valueOf(m);
							else if(m/n==0)d=m+"/"+n;
							else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
							else c=String.valueOf(m/n);
						}
					}
					while(!op1.equals("÷")&&op2.equals("÷")&&op3.equals("÷")
							&&d.equals("0")||m/n>=k) {
						if(d.equals("0")||m/n>=k) {
							m=new Random().nextInt(k);
							n=new Random().nextInt(k-1)+1;
							s3=huajian(n,m);
							s33=s3.split("\\/");
							m=Integer.valueOf(s33[0]);
							n=Integer.valueOf(s33[1]);
							if(m==0)d=String.valueOf(m);
							else if(m/n==0)d=m+"/"+n;
							else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
							else c=String.valueOf(m/n);
						}
					}
					while(op1.equals("÷")&&op2.equals("÷")&&!op3.equals("÷")
							&&b.equals("0")||c.equals("0")||e/r>=k||t/y>=k) {
						if(b.equals("0")||e/r>=k) {
							e=new Random().nextInt(k);
							r=new Random().nextInt(k-1)+1;
							s2=huajian(r,e);
							s22=s2.split("\\/");
							e=Integer.valueOf(s22[0]);
							r=Integer.valueOf(s22[1]);
							if(e==0)b=String.valueOf(e);
							else if(e/r==0)b=e+"/"+r;
							else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
							else b=String.valueOf(e/r);
						}
						if(c.equals("0")||t/y>=k) {
							t=new Random().nextInt(k);
							y=new Random().nextInt(k-1)+1;
							s3=huajian(y,t);
							s33=s3.split("\\/");
							t=Integer.valueOf(s33[0]);
							y=Integer.valueOf(s33[1]);
							if(t==0)c=String.valueOf(t);
							else if(t/y==0)c=t+"/"+y;
							else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
							else c=String.valueOf(t/y);
						}
					}
				if(op1.equals("×")||op1.equals("÷")&&op2.equals("×")||op2.equals("÷"))
					s=a+op1+b+op2+c+op3+d;
				else if(op3.equals("÷")||op3.equals("×"))s="("+a+op1+b+op2+c+")"+op3+d;
				else s=a+op1+b+op2+c+op3+d;
				break;
			}
			case 2:{
				while(op1.equals("÷")&&op3.equals("÷")&&op3.equals("÷")
						&&b.equals("0")||c.equals("0")||d.equals("0")||e/r>=k||m/n>=k||t/y>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
					if(c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(op1.equals("÷")&&!op2.equals("÷")&&op3.equals("÷")
						&&b.equals("0")||d.equals("0")||e/r>=k||m/n>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(op1.equals("÷")&&!op2.equals("÷")&&!op3.equals("÷")
						&&b.equals("0")||e/r>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
				}
					while(!op1.equals("÷")&&op2.equals("÷")&&!op3.equals("÷")
							&&c.equals("0")||t/y>=k) {
						if(c.equals("0")||t/y>=k) {
							t=new Random().nextInt(k);
							y=new Random().nextInt(k-1)+1;
							s3=huajian(y,t);
							s33=s3.split("\\/");
							t=Integer.valueOf(s33[0]);
							y=Integer.valueOf(s33[1]);
							if(t==0)c=String.valueOf(t);
							else if(t/y==0)c=t+"/"+y;
							else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
							else c=String.valueOf(t/y);
						}
					}
					while(!op1.equals("÷")&&op2.equals("÷")&&op3.equals("÷")
							&&c.equals("0")||d.equals("0")||t/y>=k||m/n>=k) {
						if(c.equals("0")||t/y>=k) {
							t=new Random().nextInt(k);
							y=new Random().nextInt(k-1)+1;
							s3=huajian(y,t);
							s33=s3.split("\\/");
							t=Integer.valueOf(s33[0]);
							y=Integer.valueOf(s33[1]);
							if(t==0)c=String.valueOf(t);
							else if(t/y==0)c=t+"/"+y;
							else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
							else c=String.valueOf(t/y);
						}
						if(d.equals("0")||m/n>=k) {
							m=new Random().nextInt(k);
							n=new Random().nextInt(k-1)+1;
							s3=huajian(n,m);
							s33=s3.split("\\/");
							m=Integer.valueOf(s33[0]);
							n=Integer.valueOf(s33[1]);
							if(m==0)d=String.valueOf(m);
							else if(m/n==0)d=m+"/"+n;
							else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
							else c=String.valueOf(m/n);
						}
					}
					while(!op1.equals("÷")&&op2.equals("÷")&&op3.equals("÷")
							&&d.equals("0")||m/n>=k) {
						if(d.equals("0")||m/n>=k) {
							m=new Random().nextInt(k);
							n=new Random().nextInt(k-1)+1;
							s3=huajian(n,m);
							s33=s3.split("\\/");
							m=Integer.valueOf(s33[0]);
							n=Integer.valueOf(s33[1]);
							if(m==0)d=String.valueOf(m);
							else if(m/n==0)d=m+"/"+n;
							else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
							else c=String.valueOf(m/n);
						}
					}
					while(op1.equals("÷")&&op2.equals("÷")&&!op3.equals("÷")
							&&b.equals("0")||c.equals("0")||e/r>=k||t/y>=k) {
						if(b.equals("0")||e/r>=k) {
							e=new Random().nextInt(k);
							r=new Random().nextInt(k-1)+1;
							s2=huajian(r,e);
							s22=s2.split("\\/");
							e=Integer.valueOf(s22[0]);
							r=Integer.valueOf(s22[1]);
							if(e==0)b=String.valueOf(e);
							else if(e/r==0)b=e+"/"+r;
							else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
							else b=String.valueOf(e/r);
						}
						if(c.equals("0")||t/y>=k) {
							t=new Random().nextInt(k);
							y=new Random().nextInt(k-1)+1;
							s3=huajian(y,t);
							s33=s3.split("\\/");
							t=Integer.valueOf(s33[0]);
							y=Integer.valueOf(s33[1]);
							if(t==0)c=String.valueOf(t);
							else if(t/y==0)c=t+"/"+y;
							else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
							else c=String.valueOf(t/y);
						}
					}
				if(op1.equals("×")||op1.equals("÷"))s=a+op1+b+op2+c+op3+d;
				else if(op2.equals("+")||op2.equals("-"))s=a+op1+b+op2+c+op3+d;
				else s="("+a+op1+b+")"+op2+c+op3+d;
				break;
			}
			case 3:{
				while(op1.equals("÷")
						&&d.equals("0")||b.equals("0")||c.equals("0")||m/n>=k||t/y>=k||e/r>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
					if(c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(!op1.equals("÷")&&op2.equals("÷")&&!op3.equals("÷")
						&&c.equals("0")||t/y>=k) {
					if(c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
					}
				}
				while(!op1.equals("÷")&&op2.equals("÷")&&op3.equals("÷")
						&&c.equals("0")||d.equals("0")||t/y>=k||m/n>=k) {
					if(c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(!op1.equals("÷")&&!op2.equals("÷")&&op3.equals("÷")
						&&d.equals("0")||m/n>=k) {
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				s=a+op1+"("+b+op2+c+op3+d+")";
				break;
			}
			case 4:{
				while(op1.equals("÷")&&!(!op2.equals("÷")&&!op3.equals("÷"))
						&&b.equals("0")||c.equals("0")||d.equals("0")||e/r>=k||t/y>=k||m/n>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
					if(c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(op1.equals("÷")&&!op3.equals("÷")
						&&b.equals("0")||c.equals("0")||e/r>=k||t/y>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
					if(c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
					}
				}
				while(!op1.equals("÷")&&op2.equals("÷")&&op3.equals("÷")
						&&c.equals("0")||d.equals("0")||t/y>=k||m/n>=k) {
					if(c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(!op1.equals("÷")&&op2.equals("÷")&&!op3.equals("÷")
						&&c.equals("0")||t/y>=k) {
					if(c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
					}
				}
				while(!op1.equals("÷")&&!op2.equals("÷")&&op3.equals("÷")
						&&d.equals("0")||m/n>=k) {
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				if(op2.equals("+")||op2.equals("-"))s=a+op1+"("+b+op2+c+")"+op3+d;
				else if(op1.equals("×")||op1.equals("÷"))s=a+op1+"("+b+op2+c+")"+op3+d;
				else s=a+op1+b+op2+c+op3+d;
				break;
			}
			case 5:{
				while(op1.equals("÷")&&op2.equals("÷")
						&&b.equals("0")||c.equals("0")||d.equals("0")||m/n>=k||t/y>=k||e/r>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
					if(c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(op1.equals("÷")&&!op2.equals("÷")&&op3.equals("÷")
						&&b.equals("0")||d.equals("0")||m/n>=k||e/r>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(!op1.equals("÷")&&op2.equals("÷")
						&&c.equals("0")||d.equals("0")||t/y>=k||m/n>=k) {
					if(c.equals("0")||t/y>=k) {
						t=new Random().nextInt(k);
						y=new Random().nextInt(k-1)+1;
						s3=huajian(y,t);
						s33=s3.split("\\/");
						t=Integer.valueOf(s33[0]);
						y=Integer.valueOf(s33[1]);
						if(t==0)c=String.valueOf(t);
						else if(t/y==0)c=t+"/"+y;
						else if(t/y<(float)t/y)c=t/y+"'"+(t-t/y*y)+"/"+y;
						else c=String.valueOf(t/y);
					}
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				while(op1.equals("÷")&&!op2.equals("÷")&&!op3.equals("÷")
						&&b.equals("0")||e/r>=k) {
					if(b.equals("0")||e/r>=k) {
						e=new Random().nextInt(k);
						r=new Random().nextInt(k-1)+1;
						s2=huajian(r,e);
						s22=s2.split("\\/");
						e=Integer.valueOf(s22[0]);
						r=Integer.valueOf(s22[1]);
						if(e==0)b=String.valueOf(e);
						else if(e/r==0)b=e+"/"+r;
						else if(e/r<(float)e/r)b=e/r+"'"+(e-e/r*r)+"/"+r;
						else b=String.valueOf(e/r);
					}
				}
				while(!op1.equals("÷")&&!op2.equals("÷")&&op3.equals("÷")
						&&d.equals("0")||m/n>=k) {
					if(d.equals("0")||m/n>=k) {
						m=new Random().nextInt(k);
						n=new Random().nextInt(k-1)+1;
						s3=huajian(n,m);
						s33=s3.split("\\/");
						m=Integer.valueOf(s33[0]);
						n=Integer.valueOf(s33[1]);
						if(m==0)d=String.valueOf(m);
						else if(m/n==0)d=m+"/"+n;
						else if(m/n<(float)m/n)d=m/n+"'"+(m-m/n*n)+"/"+n;
						else c=String.valueOf(m/n);
					}
				}
				if(op2.equals("÷")||op2.equals("×"))s=a+op1+b+op2+"("+c+op3+d+")";
				else if(op3.equals("÷")||op3.equals("×"))s=a+op1+b+op2+c+op3+d;
				else s=a+op1+b+op2+"("+c+op3+d+")";
				break;
			}
			}
			return s;
		}
		return null;
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
}
