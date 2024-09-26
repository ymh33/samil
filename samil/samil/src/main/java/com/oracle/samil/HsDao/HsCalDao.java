package com.oracle.samil.HsDao;

import java.util.List;

import com.oracle.samil.Amodel.Attendee;
import com.oracle.samil.Amodel.Event;
import com.oracle.samil.Amodel.Reservation;

public interface HsCalDao {

	List<Event> 	listEvent(int eventCategory, int empno);
	List<Event> 	listComEve(Event event);
	List<Event> 	listCategory(Event event);
	Attendee 		detailEvent(int eventId, int empno);
	int 			updateEvent(Event event, int empno);
	int 			insertEvent(Event event, int empno);
	int 			deleteEvent(Event event, int empno);
	List<Attendee> 	listReqAtten(Attendee attendee, int empno);
	int 			updateAttAcc(Attendee attendee, int empno);
	int 			updateAttRej(Attendee attendee, int empno);
	List<Attendee> 	listResAtten(Attendee attendee, int empno);
	int 			eventRestore(Event event, int empno);
	int 			eventForever(int eventId, int empno);
	List<Event> 	listDelete(Event event, int empno);
	
	//admin
	List<Event> 	listAdEve(Event event, int empno);
	Event 			detailAdEvent(int eventId, int empno);
	int 			deleteAdEvent(int eventId, int empno);
	

}
