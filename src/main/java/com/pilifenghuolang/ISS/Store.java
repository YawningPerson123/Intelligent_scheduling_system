package com.pilifenghuolang.ISS;

import java.util.ArrayList;

public class Store {

    //用于展示的数据
    private String name;//店的名字
    private String address;//店的地址

    //用于计算的数据
    private Integer size;//店的面积
    private Integer preValue;//除数的权值
    private Integer prePopulationNum;//由Size和PreValue相除获得 店开工前清理需要的人数

    private Integer freePopulationNum;//店空闲时需要的人数

    private Integer aftValue;//也是除数的权值
    private Integer aftPopulationNum;//由Size和AftValue相除+1获得 店关门后需要的人数

    private ArrayList<Integer> passFlowNum;//每小时的人流量

    private ArrayList<Stuff> stuffArr;//存放员工

}
