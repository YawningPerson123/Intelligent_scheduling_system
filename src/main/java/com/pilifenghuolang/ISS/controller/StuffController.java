package com.pilifenghuolang.ISS.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pilifenghuolang.ISS.domain.Stuff;
import com.pilifenghuolang.ISS.service.impl.StuffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stuffs")
public class StuffController {

    @Autowired
    private StuffServiceImpl stuffService;

    @PostMapping()
    public Result save(@RequestBody Stuff stuff){

        boolean flag=stuffService.save(stuff);
        Result result=new Result(flag ? Code.SAVE_OK :Code.SAVE_ERR, flag);

        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){

        boolean flag=stuffService.delete(id);
        Result result=new Result(flag ? Code.DELETE_OK :Code.DELETE_OK, flag);

        return result;
    }

    @PutMapping()
    public Result update(@RequestBody Stuff stuff){

        boolean flag=stuffService.update(stuff);
        Result result=new Result(flag ? Code.UPDATE_OK :Code.UPDATE_ERR, flag);

        return result;
    }

    @GetMapping("id/{id}")
    public Result getById(@PathVariable int id){

        Stuff stuff=stuffService.getById(id);
        int code= (!stuff.equals(null)) ? Code.GET_OK : Code.GET_ERR;
        Result result=new Result(code,stuff);

        return result;
    }

    @GetMapping("/name/{name}/currentPage/{currentPage}/pageSize/{pageSize}")
    public Result getByName(@PathVariable String name, @PathVariable int currentPage, @PathVariable int pageSize){

        IPage<Stuff> stuffs=stuffService.getByName(name,currentPage,pageSize);
        int code= (!stuffs.equals(null)) ? Code.GET_OK :Code.GET_ERR;
        Result result=new Result(code, stuffs);

        return result;
    }


//    @PostMapping()
//    public void test(@RequestBody Student student){
//        System.out.println(student);
//    }
}
