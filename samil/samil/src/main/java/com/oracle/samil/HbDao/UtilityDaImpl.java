package com.oracle.samil.HbDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.samil.Amodel.Utility;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UtilityDaImpl implements UtilityDao {
	
				@Autowired
				private final SqlSession session;
				
				@Override
				public List<Utility> getUtilityList() {
					
					List<Utility> getUtiltyList = null;
					try {
						getUtiltyList = session.selectList("getUtilityList");
					} catch (Exception e) {
						System.out.println("UtilityDaImpl error .. : " + e.getMessage());
					}
					return getUtiltyList;
				}

}
