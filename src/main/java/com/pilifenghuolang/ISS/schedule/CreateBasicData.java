package com.pilifenghuolang.ISS.schedule;

import com.pilifenghuolang.ISS.domain.Stuff;

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

        ArrayList<Time> preference01=new ArrayList<>();//星期1234
        preference01.add(time01);
        preference01.add(time02);
        preference01.add(time03);
        preference01.add(time04);

        ArrayList<Time> preference02=new ArrayList<>();//星期567
        preference02.add(time05);
        preference02.add(time06);
        preference02.add(time07);

        ArrayList<Time> preference03=new ArrayList<>();//星期136
        preference03.add(time01);
        preference03.add(time03);
        preference03.add(time06);

        ArrayList<Time> preference04=new ArrayList<>();//星期2457
        preference04.add(time02);
        preference04.add(time04);
        preference04.add(time05);
        preference04.add(time07);


        Time time11=new Time(8,12);
        Time time12=new Time(12,16);
        Time time13=new Time(16,20);
        Time time14=new Time(20,24);

        ArrayList<Time> preference11=new ArrayList<>();
        preference11.add(time11);
        ArrayList<Time> preference12=new ArrayList<>();
        preference12.add(time12);
        ArrayList<Time> preference13=new ArrayList<>();
        preference13.add(time13);
        ArrayList<Time> preference14=new ArrayList<>();
        preference14.add(time14);


        LinkedHashMap<Integer,ArrayList<Time>> preferenceMap;

        Stuff stuff1=new Stuff("员工1");
        stuff1.setWorkingTimeUpperLimit(6,30);
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference01);
        preferenceMap.put(1,preference11);
        stuff1.setPreferenceMap(preferenceMap);

        Stuff stuff2=new Stuff("员工2");
        stuff2.setWorkingTimeUpperLimit(6,35);
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference01);
        preferenceMap.put(1,preference12);
        stuff2.setPreferenceMap(preferenceMap);

        Stuff stuff3=new Stuff("员工3");
        stuff3.setWorkingTimeUpperLimit(7,30);
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference01);
        preferenceMap.put(1,preference13);
        stuff3.setPreferenceMap(preferenceMap);

        Stuff stuff4=new Stuff("员工4");
        stuff4.setWorkingTimeUpperLimit(7,35);
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference01);
        preferenceMap.put(1,preference14);
        stuff4.setPreferenceMap(preferenceMap);

        Stuff stuff5=new Stuff("员工5");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference02);
        preferenceMap.put(1,preference11);
        stuff5.setPreferenceMap(preferenceMap);

        Stuff stuff6=new Stuff("员工6");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference02);
        preferenceMap.put(1,preference12);
        stuff6.setPreferenceMap(preferenceMap);

        Stuff stuff7=new Stuff("员工7");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference02);
        preferenceMap.put(1,preference13);
        stuff7.setPreferenceMap(preferenceMap);

        Stuff stuff8=new Stuff("员工8");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference02);
        preferenceMap.put(1,preference14);
        stuff8.setPreferenceMap(preferenceMap);

        Stuff stuff9=new Stuff("员工9");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference03);
        preferenceMap.put(1,preference11);
        stuff9.setPreferenceMap(preferenceMap);

        Stuff stuff10=new Stuff("员工10");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference03);
        preferenceMap.put(1,preference12);
        stuff10.setPreferenceMap(preferenceMap);

        Stuff stuff11=new Stuff("员工11");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference03);
        preferenceMap.put(1,preference13);
        stuff11.setPreferenceMap(preferenceMap);

        Stuff stuff12=new Stuff("员工12");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference03);
        preferenceMap.put(1,preference14);
        stuff12.setPreferenceMap(preferenceMap);

        Stuff stuff13=new Stuff("员工13");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference04);
        preferenceMap.put(1,preference11);
        stuff13.setPreferenceMap(preferenceMap);

        Stuff stuff14=new Stuff("员工14");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference04);
        preferenceMap.put(1,preference12);
        stuff14.setPreferenceMap(preferenceMap);

        Stuff stuff15=new Stuff("员工15");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference04);
        preferenceMap.put(1,preference13);
        stuff15.setPreferenceMap(preferenceMap);

        Stuff stuff16=new Stuff("员工16");
        preferenceMap=new LinkedHashMap<>();
        preferenceMap.put(0,preference04);
        preferenceMap.put(1,preference14);
        stuff16.setPreferenceMap(preferenceMap);


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
//        stuffArr.add(stuff15);
//        stuffArr.add(stuff16);


        return stuffArr;
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
