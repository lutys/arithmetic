package arithmetic_lu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class readFile {
List<String> list1 = new ArrayList<String>();
	
	public List<String> read(String s) {
	try {
		File file = new File(s);
		if(file.isFile() && file.exists()) { //���ļ������Ҵ���
		InputStreamReader in = new InputStreamReader(new FileInputStream(file), "utf-8");
		BufferedReader br = new BufferedReader(in); //���ַ��������ж�ȡ�ı�����������ַ����Ӷ��ṩ�ַ���������еĸ�Ч��ȡ
		String aa = null;
		while ((aa = br.readLine()) != null) {
			list1.add(aa);
		}
		 br.close();
		} else {
			System.out.println("�ļ�������!");
		}
	} catch (UnsupportedEncodingException e) {
		System.out.println("�ַ����벻֧��");
	} catch (FileNotFoundException e) {
		System.out.println("�Ҳ���ָ���ļ�");
	} catch (IOException e) {
		System.out.println("I/O����");
	}
	return list1;
	} 	
}
