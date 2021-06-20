package com.nbs.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class ReservationnVo {
	
	private String id;
	private String userId;
	private String userName;
	private String fromDate;
	private String toDate;
	private String vehicleId;
	private String vName;
	private String vNumber;
	private String status;
	private String created;
	private String updated;
	
	}

