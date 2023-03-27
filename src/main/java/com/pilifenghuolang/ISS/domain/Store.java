package com.pilifenghuolang.ISS.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pilifenghuolang.ISS.schedule.Schedule;
import com.pilifenghuolang.ISS.schedule.Time;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@TableName("store")
public class Store {

    //店的id
    private Integer id;

    //用于展示的数据
    private String name;//店的名字
    private String address;//店的地址

    //用于计算的数据
    private Double size=200.0;//店的面积

    private Double preDivisorValue=100.0;//开店前准备除数的权值

    private Integer freePopulationNum=1;//店空闲时需要的人数

    private Double aftDivisorValue=80.0;//关店后准备除数的权值
    private Integer aftAddValue=1;//关店后准备加数的权值

    private Integer prePrepareHourNum=1;//开店之前需要做几小时准备工作
    private Integer aftPrepareHourNum=2;//关门之后需要做几小时准备工作

    private Double passFlowDivisorValue=3.8;//人流量对应店员数的除数权值
    @TableField(exist = false)
    private ArrayList<Stuff> stuffArr;//存放员工


    public Store() {
    }

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addStuff(Stuff stuff){
        stuffArr.add(stuff);
    }

    public void setStuffArr(ArrayList<Stuff> stuffArr) {
        this.stuffArr = stuffArr;
    }

    //设置店的面积
    public void setSize(Double size) {
        this.size = size;
    }

    //设置额外工作的时间数
    public void setExtraPrepareHourNum(Integer prePrepareHourNum,Integer aftPrepareHourNum){
        this.prePrepareHourNum=prePrepareHourNum;
        this.aftPrepareHourNum=aftPrepareHourNum;
    }

    //设置2个除数和1个加数
    public void setExtraPrepareParameter(Double preDivisorValue,Double aftDivisorValue,Integer aftAddValue){
        this.preDivisorValue=preDivisorValue;
        this.aftDivisorValue=aftDivisorValue;
        this.aftAddValue=aftAddValue;
    }

    //设置空闲时所需要的人数
    public void setFreePopulationNum(Integer freePopulationNum) {
        this.freePopulationNum = freePopulationNum;
    }

    //设置人流量的那个除数
    public void setPassFlowDivisorValue(Double passFlowDivisorValue) {
        this.passFlowDivisorValue = passFlowDivisorValue;
    }


    //从外部输入一周的人流量，调用Store自身的数据，返回一周的员工需求数Map
    public LinkedHashMap<String,ArrayList<Integer>> getStuffNeedWeekArr(LinkedHashMap<String,ArrayList<Double>> passFlowNumWeekMap){

        LinkedHashMap<String,ArrayList<Integer>> stuffNeedWeekMap=new LinkedHashMap<>();

        for(String dayOfTheWeek : passFlowNumWeekMap.keySet()){

            ArrayList<Integer> stuffNeedDayArr=new ArrayList<>();//一天的员工需求数数组

            for(int i=0; i<prePrepareHourNum; i++){
                stuffNeedDayArr.add((int)Math.ceil(size/preDivisorValue));//向上取整默认返回double，因此要转成int
            }
            int count=1;
            double hourPassFlowNum=0;
            for(Double passFlowNum : passFlowNumWeekMap.get(dayOfTheWeek)){
                if(count%2==1){
                    hourPassFlowNum+=passFlowNum;
                    count++;
                }else{
                    hourPassFlowNum+=passFlowNum;
                    hourPassFlowNum/=2.0;
                    if(hourPassFlowNum==0){
                        stuffNeedDayArr.add(freePopulationNum);//客流量为0，就设置freePopulationNum个店员
                    }else{
                        stuffNeedDayArr.add((int)Math.ceil(hourPassFlowNum/passFlowDivisorValue));
                    }
                    hourPassFlowNum=0;
                    count++;
                }
            }
            for(int i=0; i<aftPrepareHourNum; i++){
                stuffNeedDayArr.add((int)Math.ceil(size/aftDivisorValue) + aftAddValue);
            }

            stuffNeedWeekMap.put(dayOfTheWeek,stuffNeedDayArr);
        }


        return stuffNeedWeekMap;

    }


    //输入1~7字符，配合prePrepareHourNum，返回shopStartTime
    public Integer getShopStartTime(String dayOfTheWeek){

        Integer shopStartTime=0;
        if(dayOfTheWeek.equals("6") || dayOfTheWeek.equals("7")){
            shopStartTime=10-prePrepareHourNum;//周末是10点开始正式工作
        }else{
            shopStartTime=9-prePrepareHourNum;//非周末是9点开始正式工作
        }

        return shopStartTime;

    }


    private void setStuffsDayWorkingHoursReturnToZero(){
        for(Stuff stuff : stuffArr){
            stuff.setPersonalDayWorkingHoursReturnToZero();
        }
    }



    //仅从外部输入一周的客流量Map，智能排班处理，返回timeStuffMap
    public LinkedHashMap<String,LinkedHashMap<Time, Stuff>> intelligentScheduling(LinkedHashMap<String,ArrayList<Double>> passFlowNumWeekMap){

        //输入一周的客流量，结合店的情况进行判断，返回一周的店员需求数
        LinkedHashMap<String,ArrayList<Integer>> stuffNeedWeekMap=this.getStuffNeedWeekArr(passFlowNumWeekMap);

        //根据dayOfTheWeek和店的prePrepareHourNum获得shopStartTime，然后进行一天的排班并add进scheduleWeekMap
        LinkedHashMap<String,ArrayList<Time>> scheduleWeekMap=new LinkedHashMap<>();
        for(String dayOfTheWeek : stuffNeedWeekMap.keySet()){
            Integer shopStartTime=this.getShopStartTime(dayOfTheWeek);
            ArrayList<Time> scheduleArr= Schedule.schedulingStep1(dayOfTheWeek, shopStartTime,  stuffNeedWeekMap.get(dayOfTheWeek));
            scheduleWeekMap.put(dayOfTheWeek,scheduleArr);
        }

        LinkedHashMap<String,LinkedHashMap<Time, Stuff>> timeStuffWeekMap=new LinkedHashMap<>();
        for(String dayOfTheWeek : scheduleWeekMap.keySet()){
            LinkedHashMap<Time, Stuff> timeStuffMap=Schedule.schedulingStep2(scheduleWeekMap.get(dayOfTheWeek),this.stuffArr);
            timeStuffWeekMap.put(dayOfTheWeek,timeStuffMap);
            this.setStuffsDayWorkingHoursReturnToZero();
        }

        return timeStuffWeekMap;
    }

    public void showStuffArrSchedule(){
        for(Stuff stuff:stuffArr){
            stuff.showPersonalSchedule();
        }
    }

}
