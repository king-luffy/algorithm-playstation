package com.kingluffy.playstation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DistinctTest {

    @Test
    public void distinct(){
        List<Device> deviceList = new ArrayList<>();
        Device device = new Device("4a","4a|");
        Device device2 = new Device("4a","4a|");
        Device device3 = new Device("4b","4b|");
        deviceList.add(device);
        deviceList.add(device2);
        deviceList.add(device3);

        List<Device> dup = new ArrayList<>();

        Map<String,Device> existMap = deviceList.stream().collect(
                Collectors.toMap(
                        Device::getSn,
                        d->d,
                        (v1, v2) -> {
                            dup.add(v1);
                            return v2;
                        }));
        deviceList = new ArrayList<>(existMap.values()) ;
        System.out.println("left");
        for (Device d : deviceList) {

            System.out.println(d.getMac());
        }
        System.out.println("dup");
        for (Device d:dup) {

            System.out.println(d.getSn());
        }



    }


    class Device{

        public Device() {
        }

        public Device(String mac, String sn) {
            this.mac = mac;
            this.sn = sn;
        }

        private String mac;
        private String sn;

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }
    }
}
