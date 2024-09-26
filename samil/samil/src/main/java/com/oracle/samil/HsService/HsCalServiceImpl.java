package com.oracle.samil.HsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.samil.Amodel.Attendee;
import com.oracle.samil.Amodel.Event;
import com.oracle.samil.Amodel.Reservation;
import com.oracle.samil.HsDao.HsCalDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HsCalServiceImpl implements HsCalService {
	
	@Autowired
	private final HsCalDao hcd;

	@Override
	public List<Event> listEvent(int eventCategory, int empno) {
		List<Event> eventList = null;
		System.out.println("HsCalServiceImpl listEvent Start...");
		eventList = hcd.listEvent(eventCategory, empno);
		System.out.println("HsCalServiceImpl listEvent End...");
		return eventList;
	}
	
	@Override
	public List<Event> listComEve(Event event) {
		System.out.println("HsCalServiceImpl listComEve Start...");
		List<Event> listComEvent = hcd.listComEve(event);
		System.out.println("HsCalServiceImpl listComEve After...");
		return listComEvent;
	}
	
	@Override
	public List<Event> listCategory(Event event) {
		System.out.println("HsCalServiceImpl listCategory Start...");
		List<Event> listCatego = hcd.listCategory(event);
		System.out.println("HsCalServiceImpl listCategory After...");
		return listCatego;
	}

	@Override
	public Attendee detailEvent(int eventId, int empno) {
		System.out.println("HsCalServiceImpl detailEvent Start...");
		Attendee attendee = hcd.detailEvent(eventId, empno);
		System.out.println("service attendee-> "+attendee);
		System.out.println("HsCalServiceImpl detailEvent End...");
		return attendee;
	}

	@Override
	public int updateEvent(Event event, int empno) {
		System.out.println("HsCalServiceImpl updateEvent Start...");
		int updateCount=0;
		updateCount = hcd.updateEvent(event, empno);
		System.out.println("HsCalServiceImpl updateEvent updateCount -> "+updateCount);
		System.out.println("HsCalServiceImpl updateEvent After...");
		return updateCount;
	}

	@Override
	public int insertEvent(Event event, int empno) {
		System.out.println("HsCalServiceImpl insertEvent Start...");
		int result = hcd.insertEvent(event, empno);
		
		System.out.println("HsCalServiceImpl insertEvent result-> "+result);
		System.out.println("HsCalServiceImpl insertEvent hcd.insertEvent After...");
		return result;
	}

	@Override
	public int deleteEvent(Event event, int empno) {
		System.out.println("HsCalServiceImpl deleteEvent Start...");
		int result = hcd.deleteEvent(event, empno);
		
		System.out.println("HsCalServiceImpl deleteEvent result-> "+result);
		System.out.println("HsCalServiceImpl deleteEvent hcd.deleteEvent After...");
		return result;
	}

	@Override
	public List<Attendee> listReqAtten(Attendee attendee, int empno) {
		List<Attendee> listReqAttendee = null;
		System.out.println("HsCalServiceImpl listReqAtten Start...");
		listReqAttendee = hcd.listReqAtten(attendee, empno);
		System.out.println("HsCalServiceImpl listReqAtten End...");
		return listReqAttendee;
	}

	@Override
	public int updateAttAcc(Attendee attendee, int empno) {
		System.out.println("HsCalServiceImpl updateAttAcc Start...");
		int updateCount=0;
		updateCount = hcd.updateAttAcc(attendee, empno);
		System.out.println("HsCalServiceImpl updateAttAcc updateCount -> "+updateCount);
		System.out.println("HsCalServiceImpl updateAttAcc After...");
		return updateCount;
	}

	@Override
	public int updateAttRej(Attendee attendee, int empno) {
		System.out.println("HsCalServiceImpl updateAttRej Start...");
		int updateCount=0;
		updateCount = hcd.updateAttRej(attendee, empno);
		System.out.println("HsCalServiceImpl updateAttRej updateCount -> "+updateCount);
		System.out.println("HsCalServiceImpl updateAttRej After...");
		return updateCount;
	}

	@Override
	public List<Attendee> listResAtten(Attendee attendee, int empno) {
		List<Attendee> listResAttendee = null;
		System.out.println("HsCalServiceImpl listResAtten Start...");
		listResAttendee = hcd.listResAtten(attendee, empno);
		System.out.println("HsCalServiceImpl listResAtten End...");
		return listResAttendee;
	}

	@Override
	public int eventRestore(Event event, int empno) {
		System.out.println("HsCalServiceImpl eventRestore Start...");
		int updateCount=0;
		updateCount = hcd.eventRestore(event, empno);
		System.out.println("HsCalServiceImpl eventRestore updateCount -> "+updateCount);
		System.out.println("HsCalServiceImpl eventRestore After...");
		return updateCount;
	}

	@Override
	public int eventForever(int eventId, int empno) {
		System.out.println("HsCalServiceImpl eventForever Start...");
		int result=0;
		result = hcd.eventForever(eventId, empno);
		System.out.println("HsCalServiceImpl eventForever result -> "+result);
		System.out.println("HsCalServiceImpl eventForever After...");
		return result;
	}

	@Override
	public List<Event> listDelete(Event event, int empno) {
		List<Event> listDelete = null;
		System.out.println("HsCalServiceImpl listDelete Start...");
		listDelete = hcd.listDelete(event, empno);
		System.out.println("HsCalServiceImpl listDelete End...");
		return listDelete;
	}

	@Override
	public List<Event> listAdEve(Event event, int empno) {
		List<Event> eventAdminList = null;
		System.out.println("HsCalServiceImpl listAdEve Start...");
		eventAdminList = hcd.listAdEve(event, empno);
		System.out.println("HsCalServiceImpl listAdEve End...");
		return eventAdminList;
	}

	@Override
	public Event detailAdEvent(int eventId, int empno) {
		System.out.println("HsCalServiceImpl detailAdEvent Start...");
		Event event = hcd.detailAdEvent(eventId, empno);
		
		System.out.println("HsCalServiceImpl detailAdEvent End...");
		return event;
	}

	@Override
	public int deleteAdEvent(int eventId, int empno) {
		System.out.println("HsCalServiceImpl deleteAdEvent Start...");
		int result = hcd.deleteAdEvent(eventId, empno);
		
		System.out.println("HsCalServiceImpl deleteAdEvent result-> "+result);
		System.out.println("HsCalServiceImpl deleteAdEvent hcd.deleteAdEvent After...");
		return result;
	}




}
