package arithmetic_lu;

import java.util.Stack;

public class duplicate_checking {
	
	Stack<String> stack=new Stack<>();//存放除运算数的字符串
	int i,j,k;
	String a[]=new String[100];//存放数字
	String b[]=new String[100];
	String temp;

	Nope cnki(String s){
		i=0;j=0;k=0;
		while(j<s.length()) {//中缀表达式转化为后缀表达式
			temp=s.substring(j,j+1);
			if(temp.matches("\\d+")||temp.equals("'")||temp.equals("/")) {//对操作数存储，用数组实现
				a[i++]=temp;
				while(temp.matches("\\d+")||temp.equals("'")||temp.equals("/")) {
					if(j+1==s.length())break;
					temp=s.substring(j+1,j+2);
					if(temp.matches("\\d+")||temp.equals("'")||temp.equals("/")) {
						a[i-1]+=temp;
						j++;
					}	
				}
				b[k++]=a[i-1];
			}
			else {
				if(stack.empty())stack.push(temp);
				else if(temp.equals("("))stack.push(temp);
				else if(stack.peek().equals("("))stack.push(temp);
				else if(temp.equals(")")) {
					while(!stack.peek().equals("("))b[k++]=stack.pop();
					stack.pop();
				}
				else {
					if(prior(temp)>prior(stack.peek()))stack.push(temp);
					else {
						do {
							b[k++]=stack.pop();
							if(stack.empty()||stack.peek().equals("("))break;
						}while(prior(temp)<=prior(stack.peek()));
						stack.push(temp);
					}
				}
			}
			j++;
		}
		while(!stack.empty())b[k++]=stack.pop();
		b[k]=null;
		int m=0;
		while(b[m]!=null) m++;
		return new Nope().BiTree(b,m-1);
	}
	
	int prior(String s) {//运算优先级的判断
		if(s.equals("+")||s.equals("-"))return 0;
		else return 1;
	}
	
}
class Nope{
	
	String value;//结点的值
	Nope lc,rc;//左右孩子 

	Nope BiTree(String s[],int i){//构建二叉树
		Nope p=new Nope();
		Nope temp=new Nope();

		p.value=s[i];	
		if(p.value.matches("\\+|\\-|\\×|\\÷"))p.rc=BiTree(s,i-1);
		temp=p;
		int count=0;
		if(p.value.matches("\\+|\\-|\\×|\\÷")) {while(temp.rc.value.matches("\\+|\\-|\\×|\\÷")) {
			temp=temp.rc;
			count++;
		}
		count=count+1;
		}
		if(p.value.matches("\\+|\\-|\\×|\\÷"))p.lc=BiTree(s,i-2*count);
		return p;
	}
	
	public boolean compare(Nope p,Nope q) {
		if(p.value.equals(q.value)) {
			if(!p.value.matches("\\+|\\-|\\×|\\÷"))return true;
			return compare(p.lc,q.lc)&&compare(p.rc,q.rc)||compare(p.lc,q.rc)&&compare(p.rc,q.lc);
			
		}
		else return false;
	}
}