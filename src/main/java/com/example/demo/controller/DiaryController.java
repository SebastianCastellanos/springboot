package com.example.demo.controller;

import com.example.demo.entity.Diary;
import com.example.demo.entity.DiaryAttach;
import com.example.demo.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author XiongZiQi
 */
@RestController
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @RequestMapping(value = "/diary/addDiary")
    public void addDiary(Diary diary){
        diaryService.addDiary(diary);
    }

    @RequestMapping(value = "/diary/addDiaryAttach",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void addDiaryAttach(DiaryAttach diaryAttach){
        diaryService.addDiaryAttach(diaryAttach);
    }
}
