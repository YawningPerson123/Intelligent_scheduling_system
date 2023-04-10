package com.pilifenghuolang.ISS.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pilifenghuolang.ISS.domain.Schedule;
import com.pilifenghuolang.ISS.domain.Stuff;
import com.pilifenghuolang.ISS.service.impl.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleServiceImpl scheduleService;

    @PostMapping()
    public Result save(@RequestBody Schedule schedule){

        boolean flag=scheduleService.save(schedule);
        Result result=new Result(flag ? Code.SAVE_OK :Code.SAVE_ERR, flag);

        return result;
    }

    @PutMapping()
    public Result update(@RequestBody Schedule schedule){

        boolean flag=scheduleService.update(schedule);
        Result result = new Result(flag ? Code.UPDATE_OK :Code.UPDATE_ERR, flag);

        return result;
    }

    @GetMapping("/stuffId/{stuffId}/weekId/{weekId}")
    public Result getOneWeekByStuffId(@PathVariable Integer stuffId,@PathVariable Integer weekId) {
        List<Schedule> list = scheduleService.getOneWeekByStuffId(stuffId, weekId);
        int code= (!list.equals(null)) ? Code.GET_OK : Code.GET_ERR;
        Result result = new Result(code, list);
        return result;
    }

    @GetMapping("/week/{date}")
    public Result getOneDay(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Schedule> list = scheduleService.getOneDay(date);
        Result result = new Result(list.isEmpty()?Code.GET_OK :Code.GET_ERR, list);
        return result;
    }

    @GetMapping("/initPassFlow")
    public Result initPassFlow(){
        boolean flag = scheduleService.initPassFlow();
        Result result = new Result(flag?Code.GET_OK :Code.GET_ERR, null, flag?"成功生成35天的客流量数据":"操作失败");
        return result;
    }

    @GetMapping("/initSchedule")
    public Result initSchedule(){
        boolean flag = scheduleService.initSchedule();
        Result result = new Result(flag?Code.GET_OK :Code.GET_ERR, null, flag?"成功生成35天的排班表":"操作失败");
        return result;
    }

    @DeleteMapping("/deletePassFlow")
    public Result deletePassFlow(){
        boolean flag = scheduleService.deletePassFlow();
        Result result = new Result(flag?Code.DELETE_OK :Code.DELETE_ERR, null, flag?"成功删除所有客流量数据":"操作失败");
        return result;
    }

    @DeleteMapping("/deleteSchedule")
    public Result deleteSchedule(){
        boolean flag = scheduleService.deleteSchedule();
        Result result = new Result(flag?Code.DELETE_OK :Code.DELETE_ERR, null, flag?"成功删除所有排班数据":"操作失败");
        return result;
    }
}
