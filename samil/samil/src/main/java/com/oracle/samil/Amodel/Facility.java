package com.oracle.samil.Amodel;

import lombok.Data;

//시설종류TBL

@Data
public class Facility {
	private int 	facilId;	//시설종류코드 (시설예약 TBL 조인)
	private String 	facilType;	//시설종류 (차량 등)
	private String 	facilName;	//시설명
}
