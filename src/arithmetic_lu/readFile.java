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
		if(file.isFile() && file.exists()) { //当文件正常且存在
		InputStreamReader in = new InputStreamReader(new FileInputStream(file), "utf-8");
		BufferedReader br = new BufferedReader(in); //从字符输入流中读取文本，缓冲各个字符，从而提供字符、数组和行的高效读取
		String aa = null;
		while ((aa = br.readLine()) != null) {
			list1.add(aa);
		}
		 br.close();
		} else {
			System.out.println("文件不存在!");
		}
	} catch (UnsupportedEncodingException e) {
		System.out.println("字符编码不支持");
	} catch (FileNotFoundException e) {
		System.out.println("找不到指定文件");
	} catch (IOException e) {
		System.out.println("I/O错误");
	}
	return list1;
	} 	
}
