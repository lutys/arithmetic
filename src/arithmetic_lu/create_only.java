package arithmetic_lu;

import java.util.ArrayList;

public class create_only {
	static GeneratingExpression ge = new GeneratingExpression();
	main m = new main();
	static duplicate_checking dc = new duplicate_checking();
	static Nope nope = new Nope();
			
	public String cha() {
	String s2 = ge.GeneratingExpression(Integer.parseInt(m.sz1[2]));
	  if(m.chachong.size()==0) {
	  m.chachong.add(s2);
	  }
	  else {
		  for(int p=0;p<m.chachong.size();p++) {
			  if(!nope.compare(dc.cnki(s2),dc.cnki(m.chachong.get(p)))) {}
			  else {return cha();}
		  }
	  }
	  m.chachong.add(s2);
	  return s2;
}
}