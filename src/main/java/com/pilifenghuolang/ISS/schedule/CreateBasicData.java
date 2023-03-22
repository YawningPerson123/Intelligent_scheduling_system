package com.pilifenghuolang.ISS.schedule;

import com.pilifenghuolang.ISS.Stuff;

import java.util.*;

public class CreateBasicData {
    // 创建20个员工对象，每个员工职位和偏好均不同
    public static ArrayList<Stuff> createStuffArr(){

        Time time01=new Time("1");
        Time time02=new Time("2");
        Time time03=new Time("3");
        Time time04=new Time("4");
        Time time05=new Time("5");
        Time time06=new Time("6");
        Time time07=new Time("7");

        ArrayList<Time> preference01=new ArrayList<>();//星期只喜欢非周末
        preference01.add(time01);
        preference01.add(time02);
        preference01.add(time03);
        preference01.add(time04);
        preference01.add(time05);

        ArrayList<Time> preference02=new ArrayList<>();//星期1357
        preference02.add(time01);
        preference02.add(time03);
        preference02.add(time05);
        preference02.add(time07);

        ArrayList<Time> preference03=new ArrayList<>();//星期246
        preference03.add(time02);
        preference03.add(time04);
        preference03.add(time06);

        ArrayList<Time> preference04=new ArrayList<>();//星期134
        preference04.add(time01);
        preference04.add(time03);
        preference04.add(time04);

        ArrayList<Time> preference05=new ArrayList<>();//星期4567
        preference05.add(time04);
        preference05.add(time05);
        preference05.add(time06);
        preference05.add(time07);

        ArrayList<Time> preference06=new ArrayList<>();//星期345
        preference06.add(time03);
        preference06.add(time04);
        preference06.add(time05);

        ArrayList<Time> preference07=new ArrayList<>();//星期67
        preference07.add(time06);
        preference07.add(time07);


        Time time11=new Time(8,11);//喜欢上午
        Time time12=new Time(11,13);//喜欢中午
        Time time13=new Time(13,17);//喜欢下午
        Time time14=new Time(17,20);//喜欢晚上
        Time time15=new Time(12,22);//起床起不来
        Time time16=new Time(10,19);//晚上班，早下班
        Time time17=new Time(8,17);//只想早下班

        ArrayList<Time> preference11=new ArrayList<>();
        preference11.add(time11);
        ArrayList<Time> preference12=new ArrayList<>();
        preference12.add(time12);
        ArrayList<Time> preference13=new ArrayList<>();
        preference13.add(time13);
        ArrayList<Time> preference14=new ArrayList<>();
        preference14.add(time14);
        ArrayList<Time> preference15=new ArrayList<>();
        preference15.add(time15);
        ArrayList<Time> preference16=new ArrayList<>();
        preference16.add(time16);
        ArrayList<Time> preference17=new ArrayList<>();
        preference17.add(time17);


        LinkedHashMap<Integer,ArrayList<Time>> preferenceMap;


        Stuff stuff1=new Stuff("员工1");

        Stuff stuff2=new Stuff("员工2");
        stuff2.setWorkingTimeUpperLimit(6,30);

        Stuff stuff3=new Stuff("员工3");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference01);
        stuff3.setPreferenceMap(preferenceMap);

        Stuff stuff4=new Stuff("员工4");
        stuff4.setWorkingTimeUpperLimit(6,30);
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference03);
        stuff4.setPreferenceMap(preferenceMap);

        Stuff stuff5=new Stuff("员工5");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference04);
        stuff5.setPreferenceMap(preferenceMap);

        Stuff stuff6=new Stuff("员工6");
        stuff6.setWorkingTimeUpperLimit(7,35);
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(1,preference15);
        stuff6.setPreferenceMap(preferenceMap);

        Stuff stuff7=new Stuff("员工7");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference16);
        stuff7.setPreferenceMap(preferenceMap);

        Stuff stuff8=new Stuff("员工8");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference17);
        stuff8.setPreferenceMap(preferenceMap);

        Stuff stuff9=new Stuff("员工9");
        stuff9.setWorkingTimeUpperLimit(7,35);
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference01);
        preferenceMap.put(1,preference11);
        stuff9.setPreferenceMap(preferenceMap);

        Stuff stuff10=new Stuff("员工10");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference01);
        preferenceMap.put(1,preference13);
        stuff10.setPreferenceMap(preferenceMap);

        Stuff stuff11=new Stuff("员工11");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference01);
        preferenceMap.put(1,preference15);
        stuff11.setPreferenceMap(preferenceMap);

        Stuff stuff12=new Stuff("员工12");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference01);
        preferenceMap.put(1,preference17);
        stuff12.setPreferenceMap(preferenceMap);

        Stuff stuff13=new Stuff("员工13");
        stuff13.setWorkingTimeUpperLimit(7,40);
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference02);
        preferenceMap.put(1,preference12);
        stuff13.setPreferenceMap(preferenceMap);

        Stuff stuff14=new Stuff("员工14");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference02);
        preferenceMap.put(1,preference14);
        stuff14.setPreferenceMap(preferenceMap);

        Stuff stuff15=new Stuff("员工15");
        stuff15.setWorkingTimeUpperLimit(7,40);
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference03);
        preferenceMap.put(1,preference16);
        stuff15.setPreferenceMap(preferenceMap);

        Stuff stuff16=new Stuff("员工16");
        stuff16.setWorkingTimeUpperLimit(6,40);
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference03);
        preferenceMap.put(1,preference17);
        stuff16.setPreferenceMap(preferenceMap);

        Stuff stuff17=new Stuff("员工17");
        stuff17.setWorkingTimeUpperLimit(6,40);
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference04);
        preferenceMap.put(1,preference13);
        stuff17.setPreferenceMap(preferenceMap);

        Stuff stuff18=new Stuff("员工18");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference05);
        preferenceMap.put(1,preference15);
        stuff18.setPreferenceMap(preferenceMap);

        Stuff stuff19=new Stuff("员工19");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference06);
        preferenceMap.put(1,preference12);
        stuff19.setPreferenceMap(preferenceMap);

        Stuff stuff20=new Stuff("员工20");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference07);
        preferenceMap.put(1,preference16);
        stuff20.setPreferenceMap(preferenceMap);


        ArrayList<Stuff> stuffArr = new ArrayList<>();
        stuffArr.add(stuff1);
        stuffArr.add(stuff2);
        stuffArr.add(stuff3);
        stuffArr.add(stuff4);
        stuffArr.add(stuff5);
        stuffArr.add(stuff6);
        stuffArr.add(stuff7);
        stuffArr.add(stuff8);
        stuffArr.add(stuff9);
        stuffArr.add(stuff10);
        stuffArr.add(stuff11);
        stuffArr.add(stuff12);
        stuffArr.add(stuff13);
        stuffArr.add(stuff14);
        stuffArr.add(stuff15);
        stuffArr.add(stuff16);
        stuffArr.add(stuff17);
        stuffArr.add(stuff18);
        stuffArr.add(stuff19);
        stuffArr.add(stuff20);


        return stuffArr;

//        for(int i = 1; i <= 20; i++){
//            Stuff stuff = new Stuff();
//            Random random = new Random();
//
//            stuff.setName("员工" + i);
//            if(i<=2)    stuff.setPosition("店员-库房");
//            else if(i<=14)  stuff.setPosition("店员-导购");
//            else if(i<=16)  stuff.setPosition("店员-收银");
//            else if(i<=18)  stuff.setPosition("小组长");
//            else if(i<=19)  stuff.setPosition("副经理");
//            else    stuff.setPosition("门店经理");
//            stuff.setTelephone("1" + ((Math.abs(random.nextInt())%100)+10)%100 + ((Math.abs(random.nextInt())%100000000)+10085846)%100000000);
//            stuff.setMail(String.valueOf((random.nextInt(25)+'a')) + String.valueOf((random.nextInt(25)+'a')) +String.valueOf((random.nextInt(25)+'a')) + "@test.com");
//            stuff.setStores("门店A");
//            LinkedHashMap<Integer, ArrayList<Time>> map =  new LinkedHashMap<>();
//            switch(i){
//                case 1:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"1",0));
//                    list1.add(new Time(0,0,"3",0));
//                    list1.add(new Time(0,0,"5",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(9,11,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,8));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,30));
//                    map.put(3,list4);
//                    break;
//                }
//                case 2:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"2",0));
//                    list1.add(new Time(0,0,"4",0));
//                    list1.add(new Time(0,0,"6",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(9,11,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,6));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,30));
//                    map.put(3,list4);
//                    break;
//                }
//                case 3:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"1",0));
//                    list1.add(new Time(0,0,"3",0));
//                    list1.add(new Time(0,0,"5",0));
//                    list1.add(new Time(0,0,"6",0));
//                    list1.add(new Time(0,0,"7",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(8,20,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,8));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,35));
//                    map.put(3,list4);
//                    break;
//                }
//                case 4:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"1",0));
//                    list1.add(new Time(0,0,"3",0));
//                    list1.add(new Time(0,0,"5",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(13,17,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,8));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,40));
//                    map.put(3,list4);
//                    break;
//                }
//                case 5:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"2",0));
//                    list1.add(new Time(0,0,"3",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(13,17,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,8));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,40));
//                    map.put(3,list4);
//                    break;
//                }
//                case 6:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"3",0));
//                    list1.add(new Time(0,0,"4",0));
//                    list1.add(new Time(0,0,"5",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(9,15,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,4));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,40));
//                    map.put(3,list4);
//                    break;
//                }
//                case 7:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"3",0));
//                    list1.add(new Time(0,0,"4",0));
//                    list1.add(new Time(0,0,"5",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(9,15,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,4));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,35));
//                    map.put(3,list4);
//                    break;
//                }
//                case 8:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"1",0));
//                    list1.add(new Time(0,0,"2",0));
//                    list1.add(new Time(0,0,"3",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(9,11,null,0));
//                    list2.add(new Time(13,15,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,6));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,20));
//                    map.put(3,list4);
//                    break;
//                }
//                case 9:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"1",0));
//                    list1.add(new Time(0,0,"3",0));
//                    list1.add(new Time(0,0,"2",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(9,11,null,0));
//                    list2.add(new Time(13,15,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,6));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,20));
//                    map.put(3,list4);
//                    break;
//                }
//                case 10:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"6",0));
//                    list1.add(new Time(0,0,"7",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(9,11,null,0));
//                    list2.add(new Time(13,15,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,5));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,35));
//                    map.put(3,list4);
//                    break;
//                }
//                case 11:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"6",0));
//                    list1.add(new Time(0,0,"7",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(15,22,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,5));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,35));
//                    map.put(3,list4);
//                    break;
//                }
//                case 12:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"5",0));
//                    list1.add(new Time(0,0,"6",0));
//                    list1.add(new Time(0,0,"7",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(15,22,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,5));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,30));
//                    map.put(3,list4);
//                    break;
//                }
//                case 13:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"3",0));
//                    list1.add(new Time(0,0,"4",0));
//                    list1.add(new Time(0,0,"5",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(15,22,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,10));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,55));
//                    map.put(3,list4);
//                    break;
//                }
//                case 14:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"1",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(15,17,null,0));
//                    list2.add(new Time(19,22,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,10));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,50));
//                    map.put(3,list4);
//                    break;
//                }
//                case 15:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"3",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(15,17,null,0));
//                    list2.add(new Time(19,22,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,10));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,45));
//                    map.put(3,list4);
//                    break;
//                }
//                case 16:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"5",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(15,17,null,0));
//                    list2.add(new Time(19,22,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,8));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,35));
//                    map.put(3,list4);
//                    break;
//                }
//                case 17:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"2",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(8,22,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,8));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,40));
//                    map.put(3,list4);
//                    break;
//                }
//                case 18:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"4",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(8,22,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,6));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,35));
//                    map.put(3,list4);
//                    break;
//                }
//                case 19:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"1",0));
//                    list1.add(new Time(0,0,"2",0));
//                    list1.add(new Time(0,0,"3",0));
//                    list1.add(new Time(0,0,"4",0));
//                    list1.add(new Time(0,0,"5",0));
//                    list1.add(new Time(0,0,"6",0));
//                    list1.add(new Time(0,0,"7",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(8,22,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,8));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,45));
//                    map.put(3,list4);
//                    break;
//                }
//                case 20:{
//                    ArrayList<Time> list1 = new ArrayList<>();
//                    list1.add(new Time(0,0,"1",0));
//                    list1.add(new Time(0,0,"2",0));
//                    list1.add(new Time(0,0,"3",0));
//                    list1.add(new Time(0,0,"4",0));
//                    list1.add(new Time(0,0,"5",0));
//                    list1.add(new Time(0,0,"6",0));
//                    list1.add(new Time(0,0,"7",0));
//                    map.put(0,list1);
//                    ArrayList<Time> list2 = new ArrayList<>();
//                    list2.add(new Time(8,22,null,0));
//                    map.put(1,list2);
//                    ArrayList<Time> list3 = new ArrayList<>();
//                    list3.add(new Time(0,0,null,8));
//                    map.put(2,list3);
//                    ArrayList<Time> list4 = new ArrayList<>();
//                    list4.add(new Time(0,0,null,35));
//                    map.put(3,list4);
//                    break;
//                }
//            }
//            stuff.setPreferenceMap(map);
//            stuffList.add(stuff);
//        }
//        return stuffList;
    }
    //根据原始数据创建随机的一周客流量
    public static LinkedHashMap<String,ArrayList<Double>> passFlowNumWeekMap(){

        LinkedHashMap<String,ArrayList<Double>> passFlowNumWeekMap=new LinkedHashMap<>();

        for(int dayOfTheWeek=1; dayOfTheWeek<=7; dayOfTheWeek++){

            Integer weekValue=1;
            if(dayOfTheWeek==6||dayOfTheWeek==7) weekValue=2;

            ArrayList<Double> passFlowNumArr = new ArrayList<>();
            Random r = new Random();
            double[] originList = {1.3,5.7,11.1,13.4,13.3,17.3,18.1,22.8,26.9,21.6,18.3,17.2,15.3,14.3,11.6,8.3,8.3,7.2,5.6,5.6,2.5,2.1,0.1,0.1};
            for (int i = 0; i < originList.length; i++){
                originList[i] += originList[i] * 0.2 * (r.nextDouble() - 0.5) * 2 ;
                originList[i] *= weekValue;
                passFlowNumArr.add(Math.round(originList[i] * 10) / 10.0);
            }
            passFlowNumWeekMap.put(new String(String.valueOf(dayOfTheWeek)) , passFlowNumArr);
        }

        return passFlowNumWeekMap;
    }
}
