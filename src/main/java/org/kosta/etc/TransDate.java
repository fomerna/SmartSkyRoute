package org.kosta.etc;

import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TransDate {
	
	//스트링으로 받은 날짜의 차이를 구하기 위한 자바 소스
	private static TransDate transdate = new TransDate();

	public static String PlusDate(String date ,int day) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date Date = format.parse(date);

		// 날짜 더하기

		Calendar cal = Calendar.getInstance();

		cal.setTime(Date);

		cal.add(Calendar.DATE, day);		//날짜 더하기
		String strDate = format.format(cal.getTime());
		return strDate;
	}


	public static TransDate getInstance() {
		return transdate;
	}
	//String으로 받은 날짜의 차이를 구하는 메소드
	  public static String diffOfDate(String begin, String end) throws Exception
	  {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date beginDate = formatter.parse(begin);
	    Date endDate = formatter.parse(end);

	    long diff = endDate.getTime() - beginDate.getTime();
	    long diffDays = diff / (24 * 60 * 60 * 1000);
	 

	    return Long.toString(diffDays+1);
	  }
	  
	  //String으로 받은날짜들 사이에 날짜를 List로 저장하는 메소드
	  public static List<String> gapDate(String start_date,String end_date) throws Exception{
		  List<String> list = new ArrayList<String>();
	  DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	  Calendar cal = Calendar.getInstance();

	  //Date타입으로 변경

	  Date d1 = df.parse( start_date );
	  Date d2 = df.parse( end_date );

	  Calendar c1 = Calendar.getInstance();
	  Calendar c2 = Calendar.getInstance();

	  //Calendar 타입으로 변경 add()메소드로 1일씩 추가해 주기위해 변경
	  c1.setTime( d1 );
	  c2.setTime( d2 );

	  //시작날짜와 끝 날짜를 비교해, 시작날짜가 작거나 같은 경우 출력

	  while( c1.compareTo( c2 ) !=1 ){

	  String strDate = df.format(c1.getTime());
	  list.add(strDate);
	  //시작날짜 + 1 일
	  c1.add(Calendar.DATE, 1);

	  }
	  return list;
	  }
	  
	  
}
