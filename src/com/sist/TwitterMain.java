package com.sist;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class TwitterMain {
	
	public static void main(String[] args){
		
		try{
			TwitterStream ts = new TwitterStreamFactory().getInstance();
			String[] data = {"������", "ȫ��ǥ", "��ö��", "���¹�", "�ɻ���", "�ڱ���", "�ּ���", "�����"};
			FilterQuery fq = new FilterQuery();
			fq.track(data);
			TwitterListener list = new TwitterListener();
			ts.addListener(list);
			ts.filter(fq);
		}catch(Exception e){
			
		}
	}

}
