package com.sist;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainClass {

	public static void main(String[] args) {
		String[] data = {"������", "ȫ��ǥ", "��ö��", "���¹�", "�ɻ���", "�ڱ���", "�ּ���", "�����"};
		
		Pattern[] p = new Pattern[data.length]; //���� �迭�� �����
		for(int i=0; i<p.length;i++){
			p[i]=Pattern.compile(data[i]); //���� �迭�� �ְ�
		}
		try{
			String temp="";
			FileReader fr = new FileReader("c://webDev//twitter.txt"); //���� �о
			int i=0;
			while((i=fr.read())!=-1){
				temp+=String.valueOf((char)i); //�о���ΰ� String �ϳ��� �ְ�
			}
			fr.close();
			String[] strData = temp.split("\n"); //�װ� ���پ� ������ String �迭�� �ְ�
			
			//���� ������ ���پ� ���������� ���� pattern�� � �ִ��� Ȯ��
			Matcher[] m = new Matcher[data.length]; //��ġ �迭 �����
			
			int[] count = new int[data.length];
			for(int j=0; j<strData.length;j++){
				for(int k=0; k<m.length;k++){
					m[k] = p[k].matcher(strData[j]); //String�� �ϳ���, �����̶� ��ġ�غ��� �� ����� ��ġ�� �ְ�
					if(m[k].find()){ //���ϰ� ��ġ�ϴ°� �ִٸ�, 
						count[k]++; //data�� �����Ǵ� �迭�� Ƚ���� ���ڸ� �÷���!
					}
				}
			}
			
			
			String csv = "";
			
			for(int k=0;k<data.length;k++){
				System.out.println(data[k]+":"+count[k]); //�˻��� : Ƚ��
				csv+=data[k]+" "+count[k]+"\n"; //�˻��� Ƚ�� �ؼ� ���� �ϳ� ����� �̰� R���� �о�鿩�� ������ ����
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
