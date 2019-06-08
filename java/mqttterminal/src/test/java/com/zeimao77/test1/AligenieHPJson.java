package com.zeimao77.test1;

import java.util.UUID;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import top.zeimao77.aligenie.entity.AligenieHP;
import top.zeimao77.aligenie.entity.AligenieHeader;
import top.zeimao77.aligenie.entity.AligeniePayload;

public class AligenieHPJson {
	
	@Test
	public void test() {
		AligenieHP hp = new AligenieHP();
		AligenieHeader header = new AligenieHeader();
		AligeniePayload payload = new AligeniePayload();

		header.setMessageId("1bd5d003-31b9-476f-ad03-71d471922820");
		header.setName("TurnOn");
		header.setNamespace("AliGenie.Iot.Device.Control");
		header.setPayLoadVersion(1);
		payload.setAccessToken(UUID.randomUUID().toString());
		payload.setDeviceId("LIGHT_D7A1656513CE41278A8043EC6E70AECF");
		payload.setDeviceType("LIGHT");
		payload.setAttribute("powerstate");
		payload.setValue("on");
		hp.setHeader(header);
		hp.setPayload(payload);
		System.out.println(JSON.toJSONString(hp));
	}

	@Test
	public void test2() {
		System.out.println(UUID.randomUUID().toString().replace("-","").toUpperCase());
	}

}
