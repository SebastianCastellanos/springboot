package com.example.demo.serviceImpl;

import com.example.demo.entity.Diary;
import com.example.demo.entity.DiaryAttach;
import com.example.demo.mapper.DiaryMapper;
import com.example.demo.service.DiaryService;
import com.example.demo.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        for (int i = 0; i < picBase64List.length; i++) {
            //使用自定义工具将图片存进服务器
            ImageUtils.base64CodeTobeImage(picBase64List[i],path,picNameList[i]);
            //将图片数据(图片数据ID,存储路径,图片名称,绑定的日记数据ID)存进数据库
            diaryAttach.setAttachUrl(path);
            diaryAttach.setAttachName(picNameList[i]);
            diaryAttach.setDiaryId(diaryAttach.getDiaryId());
            diaryAttach.setOperateTime(diaryAttach.getOperateTime());
            diaryAttach.setPicBase64List(null);
            diaryAttach.setPicNameList(null);
            diaryMapper.addDiaryAttach(diaryAttach);
        }

    }

}
