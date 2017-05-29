package com.sist;

import java.util.Date;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import java.io.*;

public class TwitterListener implements StatusListener{

	public void onException(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}

	public void onDeletionNotice(StatusDeletionNotice arg0) {
		
	}

	public void onScrubGeo(long arg0, long arg1) {
		
	}

	public void onStallWarning(StallWarning arg0) {
		
	}
	
	//한줄 읽어올때마다 자동으로 이 메서드가 실행된다.
	public void onStatus(Status status) {
		String id= status.getUser().getScreenName();
		String data =status.getText();
		Date regdate = status.getCreatedAt();
		System.out.println("@"+id+":"+data+" at "+regdate);
		try{
			FileWriter fw = new FileWriter("c://webDev//twitter.txt", true);
			fw.write(data);
			fw.close();
		}catch(Exception e){
			
		}
	}

	public void onTrackLimitationNotice(int arg0) {
		
	}

}
