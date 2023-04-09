package com.pilifenghuolang.ISS.controller;

import com.pilifenghuolang.ISS.schedule.Time;
import com.pilifenghuolang.ISS.service.impl.PreferenceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stuffs/preference")
public class StuffsPreferenceController {

    @Autowired
    private PreferenceServiceImpl preferenceService;

    @PostMapping("/dayOfTheWeek")
    public Result saveDayOfTheWeek(@RequestBody Time time){

        time.setType(0);

        boolean flag=preferenceService.savePreference(time);
        Result result=new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR ,flag);

        return result;
    }

    @PostMapping("/timePeriod")
    public Result saveTimePeriod(@RequestBody Time time){

        time.setType(1);

        boolean flag=preferenceService.savePreference(time);
        Result result=new Result(flag ? Code.SAVE_OK: Code.SAVE_ERR ,flag );

        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){

        boolean flag=preferenceService.deletePreference(id);
        Result result=new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR ,flag );

        return result;
    }

    @GetMapping("/dayOfTheWeek/{stuffId}")
    public Result getDayOfTheWeek(@PathVariable int stuffId){

        List<Time> timeList1=preferenceService.getPreference(stuffId);
        List<Time> timeList2=new ArrayList<>();
        for(Time time:timeList1){
            if(time.getType()==0) timeList2.add(time);
        }

        int code=(!timeList2.equals(null)) ? Code.GET_OK :Code.GET_ERR;

        Result result=new Result(code,timeList2);

        return result;

    }

    @GetMapping("/timePeriod/{stuffId}")
    public Result getTimePeriod(@PathVariable int stuffId){

        List<Time> timeList1=preferenceService.getPreference(stuffId);
        List<Time> timeList2=new ArrayList<>();
        for(Time time:timeList1){
            if(time.getType()==1) timeList2.add(time);
        }

        int code=(!timeList2.equals(null)) ? Code.GET_OK :Code.GET_ERR;

        Result result=new Result(code,timeList2);

        return result;

    }

}
