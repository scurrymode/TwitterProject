package com.sist;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class TwitterMain {
	
	public static void main(String[] args){
		
		try{
			TwitterStream ts = new TwitterStreamFactory().getInstance();
			String[] data = {"문재인", "홍준표", "안철수", "유승민", "심상정", "박근혜", "최순실", "백원우"};
			FilterQuery fq = new FilterQuery();
			fq.track(data);
			TwitterListener list = new TwitterListener();
			ts.addListener(list);
			ts.filter(fq);
		}catch(Exception e){
			
		}
	}

}
