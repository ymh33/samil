package com.oracle.samil.HbService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.samil.Amodel.Utility;
import com.oracle.samil.HbDao.UtilityDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtilityServiceImpl implements UtilityService {
	
	 private final UtilityDao hbUtilityDao;
	 
	@Override
	public List<Utility> getUtilityData() {
		return hbUtilityDao.getUtilityList();
	}

}
