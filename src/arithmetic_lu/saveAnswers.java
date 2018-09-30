package arithmetic_lu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class saveAnswers {
	private static String path = "F:\\Answers.txt";
	   int i = 1;
	   public void xieru(String s){
	        OutputStream out;
			try {
				out = getOutputStream();
				String ss = String.valueOf(i)+".";
				out.write(ss.getBytes()); //写入题的序号
				out.write("  ".getBytes()); //序号后写入空格于题目分隔开
				out.write(s.getBytes("utf-8"));//写入题目
				out.write("\r\n".getBytes());//写入换行
				i++;
			} catch (IOException e) {
				System.out.println("xieru方法I/O错误");
			}	     
	}

	   public static OutputStream getOutputStream(){
	      try {
			File file = new File(path); //先创建File类对象，存入文件路径
			  if (!file.exists()) {
			  file.createNewFile(); //如文件不存在则创建文件
			   }
			  return new FileOutputStream(file,true);//再实例化FileOutputStream,参数设置为true才不会覆盖之前写入的东西
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件");
		} catch (IOException e) {
			System.out.println("getOutputStream方法I/O错误");
		}
		return null;
	  }
}
