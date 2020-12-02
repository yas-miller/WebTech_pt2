package controller;

import java.util.GregorianCalendar;

import model.entities.ExpressService;
import model.entities.ScaleWork;

public class ParseUserPetitionPage {
	public static ExpressService parseWorking(String s){
		if("fix plumbing".equals(s)){
			return ExpressService.SANITARY_ENGINEERING;
		}else if("electric wiring".equals(s)){
			return ExpressService.ELECTRICAL;
		} else{
			return ExpressService.WOOD_WORK;
		}
	}
	
	public static ScaleWork parseScaleWork(String s){
		if("part of the room".equals(s)){
			return ScaleWork.PART_OF_THE_ROOM;
		}else if("room".equals(s)){
			return ScaleWork.ROOM;
		} else{
			return ScaleWork.FLAT;
		}
	}
	
	public static long parseTime(String month, String day, String hour, String minute){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(2015, Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute));		
		return calendar.getTimeInMillis();
	}
}
