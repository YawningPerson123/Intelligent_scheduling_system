package com.pilifenghuolang.ISS.schedule;

import com.pilifenghuolang.ISS.Stuff;

import java.util.*;

public class CreateBasicData {
    // 创建20个员工对象，每个员工职位和偏好均不同
    public static ArrayList<Stuff> createStuffArr(){
        ArrayList<Stuff> stuffList = new ArrayList<>();
        for(int i = 1; i <= 20; i++){
            Stuff stuff = new Stuff();
            Random random = new Random();

            stuff.setName("员工" + i);
            if(i<=2)    stuff.setPosition("店员-库房");
            else if(i<=14)  stuff.setPosition("店员-导购");
            else if(i<=16)  stuff.setPosition("店员-收银");
            else if(i<=18)  stuff.setPosition("小组长");
            else if(i<=19)  stuff.setPosition("副经理");
            else    stuff.setPosition("门店经理");
            stuff.setTelephone("1" + ((Math.abs(random.nextInt())%100)+10)%100 + ((Math.abs(random.nextInt())%100000000)+10085846)%100000000);
            stuff.setMail(String.valueOf((random.nextInt(25)+'a')) + String.valueOf((random.nextInt(25)+'a')) +String.valueOf((random.nextInt(25)+'a')) + "@test.com");
            stuff.setStores("门店A");
            LinkedHashMap<Integer, ArrayList<Time>> map =  new LinkedHashMap<>();
            switch(i){
                case 1:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"1",0));
                    list1.add(new Time(0,0,"3",0));
                    list1.add(new Time(0,0,"5",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(9,11,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,8));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,30));
                    map.put(3,list4);
                    break;
                }
                case 2:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"2",0));
                    list1.add(new Time(0,0,"4",0));
                    list1.add(new Time(0,0,"6",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(9,11,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,6));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,30));
                    map.put(3,list4);
                    break;
                }
                case 3:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"1",0));
                    list1.add(new Time(0,0,"3",0));
                    list1.add(new Time(0,0,"5",0));
                    list1.add(new Time(0,0,"6",0));
                    list1.add(new Time(0,0,"7",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(8,20,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,8));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,35));
                    map.put(3,list4);
                    break;
                }
                case 4:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"1",0));
                    list1.add(new Time(0,0,"3",0));
                    list1.add(new Time(0,0,"5",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(13,17,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,8));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,40));
                    map.put(3,list4);
                    break;
                }
                case 5:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"2",0));
                    list1.add(new Time(0,0,"3",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(13,17,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,8));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,40));
                    map.put(3,list4);
                    break;
                }
                case 6:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"3",0));
                    list1.add(new Time(0,0,"4",0));
                    list1.add(new Time(0,0,"5",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(9,15,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,4));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,40));
                    map.put(3,list4);
                    break;
                }
                case 7:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"3",0));
                    list1.add(new Time(0,0,"4",0));
                    list1.add(new Time(0,0,"5",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(9,15,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,4));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,35));
                    map.put(3,list4);
                    break;
                }
                case 8:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"1",0));
                    list1.add(new Time(0,0,"2",0));
                    list1.add(new Time(0,0,"3",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(9,11,null,0));
                    list2.add(new Time(13,15,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,6));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,20));
                    map.put(3,list4);
                    break;
                }
                case 9:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"1",0));
                    list1.add(new Time(0,0,"3",0));
                    list1.add(new Time(0,0,"2",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(9,11,null,0));
                    list2.add(new Time(13,15,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,6));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,20));
                    map.put(3,list4);
                    break;
                }
                case 10:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"6",0));
                    list1.add(new Time(0,0,"7",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(9,11,null,0));
                    list2.add(new Time(13,15,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,5));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,35));
                    map.put(3,list4);
                    break;
                }
                case 11:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"6",0));
                    list1.add(new Time(0,0,"7",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(15,22,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,5));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,35));
                    map.put(3,list4);
                    break;
                }
                case 12:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"5",0));
                    list1.add(new Time(0,0,"6",0));
                    list1.add(new Time(0,0,"7",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(15,22,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,5));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,30));
                    map.put(3,list4);
                    break;
                }
                case 13:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"3",0));
                    list1.add(new Time(0,0,"4",0));
                    list1.add(new Time(0,0,"5",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(15,22,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,10));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,55));
                    map.put(3,list4);
                    break;
                }
                case 14:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"1",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(15,17,null,0));
                    list2.add(new Time(19,22,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,10));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,50));
                    map.put(3,list4);
                    break;
                }
                case 15:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"3",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(15,17,null,0));
                    list2.add(new Time(19,22,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,10));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,45));
                    map.put(3,list4);
                    break;
                }
                case 16:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"5",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(15,17,null,0));
                    list2.add(new Time(19,22,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,8));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,35));
                    map.put(3,list4);
                    break;
                }
                case 17:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"2",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(8,22,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,8));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,40));
                    map.put(3,list4);
                    break;
                }
                case 18:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"4",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(8,22,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,6));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,35));
                    map.put(3,list4);
                    break;
                }
                case 19:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"1",0));
                    list1.add(new Time(0,0,"2",0));
                    list1.add(new Time(0,0,"3",0));
                    list1.add(new Time(0,0,"4",0));
                    list1.add(new Time(0,0,"5",0));
                    list1.add(new Time(0,0,"6",0));
                    list1.add(new Time(0,0,"7",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(8,22,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,8));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,45));
                    map.put(3,list4);
                    break;
                }
                case 20:{
                    ArrayList<Time> list1 = new ArrayList<>();
                    list1.add(new Time(0,0,"1",0));
                    list1.add(new Time(0,0,"2",0));
                    list1.add(new Time(0,0,"3",0));
                    list1.add(new Time(0,0,"4",0));
                    list1.add(new Time(0,0,"5",0));
                    list1.add(new Time(0,0,"6",0));
                    list1.add(new Time(0,0,"7",0));
                    map.put(0,list1);
                    ArrayList<Time> list2 = new ArrayList<>();
                    list2.add(new Time(8,22,null,0));
                    map.put(1,list2);
                    ArrayList<Time> list3 = new ArrayList<>();
                    list3.add(new Time(0,0,null,8));
                    map.put(2,list3);
                    ArrayList<Time> list4 = new ArrayList<>();
                    list4.add(new Time(0,0,null,35));
                    map.put(3,list4);
                    break;
                }
            }
            stuff.setPreferenceMap(map);
            stuffList.add(stuff);
        }
        return stuffList;
    }
    //根据原始数据创建随机的一周客流量
    public static LinkedHashMap<String,ArrayList<Double>> passFlowNumWeekMap(){

        LinkedHashMap<String,ArrayList<Double>> passFlowNumWeekMap=new LinkedHashMap<String,ArrayList<Double>>();

        for(int dayOfTheWeek=1; dayOfTheWeek<=7; dayOfTheWeek++){

            Integer weekValue=1;
            if(dayOfTheWeek==6||dayOfTheWeek==7) weekValue=2;

            ArrayList<Double> passFlowNumArr = new ArrayList<>();
            Random r = new Random();
            double[] originList = {0,0.1,1.3,5.7,11.1,13.4,13.3,17.3,18.1,22.8,16.9,21.6,18.3,17.2,15.3,14.3,11.6,8.3,8.3,7.2,5.6,5.6,2.5,2.1,0.1,0.1};
            for (int i = 0; i < originList.length; i++){
                originList[i] += originList[i] * 0.2 * (r.nextDouble() - 0.5) * 2 *weekValue;
                passFlowNumArr.add(Math.round(originList[i] * 10) / 10.0);
                passFlowNumWeekMap.put(new String(String.valueOf(dayOfTheWeek)) , passFlowNumArr);
            }
        }

        return passFlowNumWeekMap;
    }
}
