package com.sist;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainClass {

	public static void main(String[] args) {
		String[] data = {"문재인", "홍준표", "안철수", "유승민", "심상정", "박근혜", "최순실", "백원우"};
		
		Pattern[] p = new Pattern[data.length]; //패턴 배열을 만들고
		for(int i=0; i<p.length;i++){
			p[i]=Pattern.compile(data[i]); //패턴 배열을 넣고
		}
		try{
			String temp="";
			FileReader fr = new FileReader("c://webDev//twitter.txt"); //파일 읽어서
			int i=0;
			while((i=fr.read())!=-1){
				temp+=String.valueOf((char)i); //읽어들인건 String 하나에 넣고
			}
			fr.close();
			String[] strData = temp.split("\n"); //그걸 한줄씩 나눠서 String 배열에 넣고
			
			//이제 파일을 한줄씩 나눠놨으니 이제 pattern이 몇개 있는지 확인
			Matcher[] m = new Matcher[data.length]; //매치 배열 만들고
			
			int[] count = new int[data.length];
			for(int j=0; j<strData.length;j++){
				for(int k=0; k<m.length;k++){
					m[k] = p[k].matcher(strData[j]); //String줄 하나당, 패턴이랑 매치해봐서 그 결과를 매치에 넣고
					if(m[k].find()){ //패턴과 일치하는게 있다면, 
						count[k]++; //data와 대응되는 배열의 횟수에 숫자를 올려라!
					}
				}
			}
			
			
			String csv = "";
			
			for(int k=0;k<data.length;k++){
				System.out.println(data[k]+":"+count[k]); //검색어 : 횟수
				csv+=data[k]+" "+count[k]+"\n"; //검색어 횟수 해서 파일 하나 만들고 이걸 R에서 읽어들여서 가지고 놀자
			}
			FileWriter fw = new FileWriter("c://webDev//data.txt");
			fw.write(csv);
			fw.close();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
