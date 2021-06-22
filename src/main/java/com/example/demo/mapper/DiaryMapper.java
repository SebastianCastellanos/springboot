package com.example.demo.mapper;

import com.example.demo.entity.Diary;
import com.example.demo.entity.DiaryAttach;

import java.util.List;

public interface DiaryMapper {

//    /**
//     * 信息列表
//     * @param userInfo
//     * @return
//     */
//    List<UserInfo> selectUserList(UserInfo userInfo);
//
//    /**
//     * 删除信息
//     * @param id
//     * @return
//     */
//    int deleteUserInfo(Integer id);
//
//    /**
//     * 根据姓名查询
//     * @param name
//     * @return
//     */
//    List<UserInfo> selectInfoByName(String name);
//
//    /**
//     * 根据地址查询
//     * @param address
//     * @return
//     */
//    List<UserInfo> selectInfoByAddress(String address);
//
//    /**
//     * 分页查询
//     * @param page
//     * @param size
//     * @return
//     */
//    List<UserInfo> selectPage(@Param("page") Integer page, @Param("size") Integer size);
//
//    /**
//     * 信息总数
//     * @return
//     */
//    Long getTotal();
//
    /**
     * 添加日记信息
     * @param diary
     */
    void addDiary(Diary diary);

    /**
     * 添加日记附件(图片、视频)
     * @param diaryAttach
     */
    void addDiaryAttach(DiaryAttach diaryAttach);

}
