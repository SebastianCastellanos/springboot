package com.example.demo.serviceImpl;

import com.example.demo.entity.Diary;
import com.example.demo.entity.DiaryAttach;
import com.example.demo.mapper.DiaryMapper;
import com.example.demo.service.DiaryService;
import com.example.demo.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiongZiQi
 */
@Service(value = "diaryService")
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryMapper diaryMapper;

    //声明存储路径常量
    private static final String path = "D:\\IdeaWorkbench\\MyProject\\【1】我的小程序\\image\\";

    @Override
    public void addDiary(Diary diary) {
        diaryMapper.addDiary(diary);
    }

    @Override
    public void addDiaryAttach(DiaryAttach diaryAttach) {
        String[] picBase64List = diaryAttach.getPicBase64List();
        String[] picNameList = diaryAttach.getPicNameList();

        List<DiaryAttach> list = new ArrayList<>();

        for (int i = 0; i < picBase64List.length; i++) {
            ImageUtils.base64CodeTobeImage(picBase64List[i],path,picNameList[i]);
            diaryAttach.setAttachUrl(path);
            diaryAttach.setAttachName(picNameList[i]);
            diaryAttach.setDiaryId(diaryAttach.getDiaryId());
            diaryAttach.setPicBase64List(null);
            diaryAttach.setPicNameList(null);
            diaryMapper.addDiaryAttach(diaryAttach);
        }

    }

}
