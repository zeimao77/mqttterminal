package com.zeimao77.test1;

import org.fusesource.hawtbuf.UTF8Buffer;
import org.fusesource.mqtt.client.FutureConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.junit.Test;

import java.net.URISyntaxException;

public class MqttTopicProducer {

    @Test
    public void test() {
        MQTT mqtt = new MQTT();
        try {
            mqtt.setHost("tcp://www.22cq.top:1883");
        } catch (
                URISyntaxException e) {
            e.printStackTrace();
        }
        mqtt.setClientId("RASPBERRY-Producer-CLIET");
        mqtt.setUserName("admin");
        mqtt.setPassword("admin");
        FutureConnection connection = mqtt.futureConnection();
        connection.connect();
        for(int i=0;i<30;i++) {
            connection.publish(UTF8Buffer.utf8("mqtt-topic-test1"), UTF8Buffer.utf8("{\"header\":{\"messageId\":\"1bd5d003-31b9-476f-ad03-71d471922820\",\"name\":\"TurnOn\",\"namespace\":\"AliGenie.Iot.Device.Control\",\"payLoadVersion\":1},\"payload\":{\"accessToken\":\"1ce1b362-70d3-4e18-a2ae-6bc77609a047\",\"attribute\":\"powerstate\",\"deviceId\":\"LIGHT_D7A1656513CE41278A8043EC6E70AECF\",\"deviceType\":\"LIGHT\",\"value\":\"on\"}}"), QoS.AT_MOST_ONCE,false);
        }
        connection.disconnect();
    }

}
