package com.pilifenghuolang.ISS.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PassFlow{
    /** 主键 */
    private Integer weekId ;
    /** 星期几 */
    private Integer dayOfWeek ;
    /** 具体日期*/
    private Date date;
    /** 客流量1 */
    private Double passFlow1 ;
    /** 客流量2 */
    private Double passFlow2 ;
    /** 客流量3 */
    private Double passFlow3 ;
    /** 客流量4 */
    private Double passFlow4 ;
    /** 客流量5 */
    private Double passFlow5 ;
    /** 客流量6 */
    private Double passFlow6 ;
    /** 客流量7 */
    private Double passFlow7 ;
    /** 客流量8 */
    private Double passFlow8 ;
    /** 客流量9 */
    private Double passFlow9 ;
    /** 客流量10 */
    private Double passFlow10 ;
    /** 客流量11 */
    private Double passFlow11 ;
    /** 客流量12 */
    private Double passFlow12 ;
    /** 客流量13 */
    private Double passFlow13 ;
    /** 客流量14 */
    private Double passFlow14 ;
    /** 客流量15 */
    private Double passFlow15 ;
    /** 客流量16 */
    private Double passFlow16 ;
    /** 客流量17 */
    private Double passFlow17 ;
    /** 客流量18 */
    private Double passFlow18 ;
    /** 客流量19 */
    private Double passFlow19 ;
    /** 客流量20 */
    private Double passFlow20 ;
    /** 客流量21 */
    private Double passFlow21 ;
    /** 客流量22 */
    private Double passFlow22 ;
    /** 客流量23 */
    private Double passFlow23 ;
    /** 客流量24 */
    private Double passFlow24 ;

    public Double getPassFlow(int index) {
        switch (index){
            case 1:return passFlow1;
            case 2:return passFlow2;
            case 3:return passFlow3;
            case 4:return passFlow4;
            case 5:return passFlow5;
            case 6:return passFlow6;
            case 7:return passFlow7;
            case 8:return passFlow8;
            case 9:return passFlow9;
            case 10:return passFlow10;
            case 11:return passFlow11;
            case 12:return passFlow12;
            case 13:return passFlow13;
            case 14:return passFlow14;
            case 15:return passFlow15;
            case 16:return passFlow16;
            case 17:return passFlow17;
            case 18:return passFlow18;
            case 19:return passFlow19;
            case 20:return passFlow20;
            case 21:return passFlow21;
            case 22:return passFlow22;
            case 23:return passFlow23;
            case 24:return passFlow24;
        }
        return null;
    }

    public void setPassFlow(int index,double num) {
        switch (index){
            case 1:setPassFlow1(num);break;
            case 2:setPassFlow2(num);break;
            case 3:setPassFlow3(num);break;
            case 4:setPassFlow4(num);break;
            case 5:setPassFlow5(num);break;
            case 6:setPassFlow6(num);break;
            case 7:setPassFlow7(num);break;
            case 8:setPassFlow8(num);break;
            case 9:setPassFlow9(num);break;
            case 10:setPassFlow10(num);break;
            case 11:setPassFlow11(num);break;
            case 12:setPassFlow12(num);break;
            case 13:setPassFlow13(num);break;
            case 14:setPassFlow14(num);break;
            case 15:setPassFlow15(num);break;
            case 16:setPassFlow16(num);break;
            case 17:setPassFlow17(num);break;
            case 18:setPassFlow18(num);break;
            case 19:setPassFlow19(num);break;
            case 20:setPassFlow20(num);break;
            case 21:setPassFlow21(num);break;
            case 22:setPassFlow22(num);break;
            case 23:setPassFlow23(num);break;
            case 24:setPassFlow24(num);break;
        }
    }
}