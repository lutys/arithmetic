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
				out.write(ss.getBytes()); //д��������
				out.write("  ".getBytes()); //��ź�д��ո�����Ŀ�ָ���
				out.write(s.getBytes("utf-8"));//д����Ŀ
				out.write("\r\n".getBytes());//д�뻻��
				i++;
			} catch (IOException e) {
				System.out.println("xieru����I/O����");
			}	     
	}

	   public static OutputStream getOutputStream(){
	      try {
			File file = new File(path); //�ȴ���File����󣬴����ļ�·��
			  if (!file.exists()) {
			  file.createNewFile(); //���ļ��������򴴽��ļ�
			   }
			  return new FileOutputStream(file,true);//��ʵ����FileOutputStream,��������Ϊtrue�Ų��Ḳ��֮ǰд��Ķ���
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ���ָ���ļ�");
		} catch (IOException e) {
			System.out.println("getOutputStream����I/O����");
		}
		return null;
	  }
}
