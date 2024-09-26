package com.oracle.samil.HsDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.samil.Amodel.Attendee;
import com.oracle.samil.Amodel.Event;
import com.oracle.samil.Amodel.Reservation;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class HsCalDaoImpl implements HsCalDao {
	
	@Autowired
	private final SqlSession session;

	@Override
	public List<Event> listEvent(int eventCategory, int empno) {
		List<Event> eventList = null;
		System.out.println("HsCalDaoImpl listEvent Start...");
		
		Map<String, Object> eventm = new HashMap<>();
		eventm.put("eventCategory", eventCategory);
		eventm.put("empno", empno);
		try {
			eventList = session.selectList("tkEventListAll",eventm);
			System.out.println("HsCalDaoImpl listEvent eventList.size()-> "+eventList.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsCalDaoImpl listEvent e.getMessage()-> "+e.getMessage());
		}
		
		System.out.println("HsCalDaoImpl listEvent End...");
		return eventList;
	}
	
	@Override
	public List<Event> listComEve(Event event) {
		List<Event> listComEvent = null;
		System.out.println("HsCalDaoImpl listComEve Start...");
		try {
			listComEvent = session.selectList("tkEventComp", event);
			System.out.println("HsCalDaoImpl listComEve listCatego.size()-> "+listComEvent.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsCalDaoImpl listComEve e.getMessage()-> "+e.getMessage());
		}
		return listComEvent;
	}
	
	@Override
	public List<Event> listCategory(Event event) {
		List<Event> listCatego = null;
		System.out.println("HsCalDaoImpl listCategory Start...");
		try {
			listCatego = session.selectList("tkEventCategory", event);
			System.out.println("HsCalDaoImpl listCategory listCatego.size()-> "+listCatego.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsCalDaoImpl listCategory e.getMessage()-> "+e.getMessage());
		}
		return listCatego;
	}

	@Override
	public Attendee detailEvent(int eventId, int empno) {
		Attendee attendee = new Attendee();
		System.out.println("HsCalDaoImpl detailEvent Start...");
		Map<String, Object> eventm = new HashMap<>();
		eventm.put("eventId", eventId);
		eventm.put("empno", empno);
		try {
			attendee = session.selectOne("tkEventSelOne", eventm);
			System.out.println("HsCalDaoImpl detailEvent attendee-> "+attendee);
			
		} catch (Exception e) {
			System.out.println("HsCalDaoImpl detailEvent e.getMessage()-> "+e.getMessage());
		}
		System.out.println("HsCalDaoImpl detailEvent End...");
		return attendee;
	}

	@Override
	public int updateEvent(Event event, int empno) {
		int updateCount = 0;
		System.out.println("HsCalDaoImpl updateEvent Start...");
		
		
		try {
			updateCount = session.update("tkEventUpdate", event);
			System.out.println("HsCalDaoImpl updateEvent updateCount-> "+updateCount);
		} catch (Exception e) {
			System.out.println("HsCalDaoImpl updateEvent e.getMessage()-> "+e.getMessage());
		}
		return updateCount;
	}

	@Override
	public int insertEvent(Event event, int empno) {
		int result = 0;
		System.out.println("HsCalDaoImpl insertEvent Start...");
		try {
			result = session.insert("tkEventInsert", event);
			System.out.println("HsCalDaoImpl insertEvent event-> "+event);
		} catch (Exception e) {
			System.out.println("HsCalDaoImpl insertEvent e.getMessage()-> "+e.getMessage());
		}
		return result;
	}

	@Override
	public int deleteEvent(Event event, int empno) {
		int result = 0;
		System.out.println("HsCalDaoImpl deleteEvent Start...");
		try {
			result = session.update("tkEventDelupt", event);
			System.out.println("HsCalDaoImpl updateEvent updateCount-> "+result);
		} catch (Exception e) {
			System.out.println("HsCalDaoImpl deleteEvent e.getMessage()-> "+e.getMessage());
		}
		return result;
	}

	@Override
	public List<Attendee> listReqAtten(Attendee attendee, int empno) {
		List<Attendee> listReqAttendee = null;
		System.out.println("HsCalDaoImpl listReqAtten Start...");
		System.out.println("다오에서 empno 나오니? " + empno);
		
		Map<String, Object> attendee1 = new HashMap<>();
		attendee1.put("attendee", attendee);
		attendee1.put("empno", empno);
		
		try {
			listReqAttendee = session.selectList("tkReqAttList",attendee1);
			System.out.println("HsCalDaoImpl listReqAtten listReqAttendee.size()-> "+listReqAttendee.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsCalDaoImpl listReqAtten e.getMessage()-> "+e.getMessage());
		}
		
		System.out.println("HsCalDaoImpl listReqAtten End...");
		return listReqAttendee;
	}


	@Override
	public int updateAttAcc(Attendee attendee, int empno) {
		int updateCount = 0;
		System.out.println("HsCalDaoImpl updateAttAcc Start...");
		
		
		try {
			updateCount = session.update("tkAttAccupdate", attendee);
			System.out.println("HsCalDaoImpl updateAttAcc updateCount-> "+updateCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsCalDaoImpl updateAttAcc e.getMessage()-> "+e.getMessage());
		}
		return updateCount;
	}

	@Override
	public int updateAttRej(Attendee attendee, int empno) {
		int updateCount = 0;
		System.out.println("HsCalDaoImpl updateAttRej Start...");
		
		
		try {
			updateCount = session.update("tkAttRejupdate", attendee);
			System.out.println("HsCalDaoImpl updateAttRej updateCount-> "+updateCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsCalDaoImpl updateAttRej e.getMessage()-> "+e.getMessage());
		}
		return updateCount;
	}

	@Override
	public List<Attendee> listResAtten(Attendee attendee, int empno) {
		List<Attendee> listResAttendee = null;
		System.out.println("HsCalDaoImpl listResAtten Start...");
		
		Map<String, Object> attendee1 = new HashMap<>();
		attendee1.put("attendee", attendee);
		attendee1.put("empno", empno);
		try {
			listResAttendee = session.selectList("tkResAttList",attendee1);
			System.out.println("HsCalDaoImpl listResAtten listResAttendee.size()-> "+listResAttendee.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsCalDaoImpl listResAtten e.getMessage()-> "+e.getMessage());
		}
		
		System.out.println("HsCalDaoImpl listResAtten End...");
		return listResAttendee;
	}
	
	@Override
	public int eventRestore(Event event, int empno) {
		int updateCount = 0;
		System.out.println("HsCalDaoImpl eventRestore Start...");
		
		
		try {
			updateCount = session.update("tkeventRestore", event);
			System.out.println("HsCalDaoImpl eventRestore updateCount-> "+updateCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsCalDaoImpl eventForever e.getMessage()-> "+e.getMessage());
		}
		return updateCount;
	}

	@Override
	public int eventForever(int eventId, int empno) {
		int result = 0;
		System.out.println("HsCalDaoImpl eventForever Start...");
		System.out.println("HsCalDaoImpl eventForever eventId->" +eventId);
		try {
			result = session.delete("tkEventDelete", eventId);
			System.out.println("HsCalDaoImpl deleteEvent result-> "+result);
		} catch (Exception e) {
			System.out.println("HsCalDaoImpl deleteEvent e.getMessage()-> "+e.getMessage());
		}
		return result;
	}

	@Override
	public List<Event> listDelete(Event event, int empno) {
		List<Event> listDelete = null;
		System.out.println("HsCalDaoImpl listDelete Start...");
		
		Map<String, Object> eventm = new HashMap<>();
		eventm.put("event", event);
		eventm.put("empno", empno);
		
		try {
			listDelete = session.selectList("tkEventListDel",eventm);
			System.out.println("HsCalDaoImpl listDelete listDelete.size()-> "+listDelete.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsCalDaoImpl listDelete e.getMessage()-> "+e.getMessage());
		}
		
		System.out.println("HsCalDaoImpl listDelete End...");
		return listDelete;
	}

	@Override
	public List<Event> listAdEve(Event event, int empno) {
		List<Event> eventAdminList = null;
		System.out.println("HsCalDaoImpl listAdEve Start...");
		
		try {
			eventAdminList = session.selectList("tkEventAdList",event);
			System.out.println("HsCalDaoImpl listAdEve eventAdminList.size()-> "+eventAdminList.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("HsCalDaoImpl listAdEve e.getMessage()-> "+e.getMessage());
		}
		
		System.out.println("HsCalDaoImpl listAdEve End...");
		return eventAdminList;
	}

	@Override
	public Event detailAdEvent(int eventId, int empno) {
		Event event = new Event();
		System.out.println("HsCalDaoImpl detailAdEvent Start...");
		try {
			event = session.selectOne("tkEventAdSelOne", eventId);
			System.out.println("HsCalDaoImpl detailAdEvent event-> "+event);
			
		} catch (Exception e) {
			System.out.println("HsCalDaoImpl detailAdEvent e.getMessage()-> "+e.getMessage());
		}
		System.out.println("HsCalDaoImpl detailAdEvent End...");
		return event;
	}

	@Override
	public int deleteAdEvent(int eventId, int empno) {
		
		int result = 0;
		System.out.println("HsCalDaoImpl deleteAdEvent Start...");
		System.out.println("HsCalDaoImpl deleteAdEvent eventId->" +eventId);
		try {
			result = session.delete("tkEventAdDel", eventId);
			System.out.println("HsCalDaoImpl deleteAdEvent result-> "+result);
		} catch (Exception e) {
			System.out.println("HsCalDaoImpl deleteAdEvent e.getMessage()-> "+e.getMessage());
		}
		return result;
	}
	
}
