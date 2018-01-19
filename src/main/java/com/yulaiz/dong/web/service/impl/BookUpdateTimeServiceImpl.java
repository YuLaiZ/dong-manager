package com.yulaiz.dong.web.service.impl;

import com.yulaiz.dong.web.dao.BookUpdateTimeMapper;
import com.yulaiz.dong.web.model.entity.BookUpdateTimeInfo;
import com.yulaiz.dong.web.service.BookUpdateTimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * Created by YuLai on 2018/1/19.
 */
@Service
@Slf4j
public class BookUpdateTimeServiceImpl implements BookUpdateTimeService {

    @Autowired
    private BookUpdateTimeMapper bookUpdateTimeMapper;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public boolean addBookUpdateTime(String updateTime) {
        BookUpdateTimeInfo bookUpdateTimeInfo = new BookUpdateTimeInfo();
        try {
            bookUpdateTimeInfo.setUpdateTime(DATE_FORMAT.parse(updateTime));
        } catch (Exception e) {
            return false;
        }
        return bookUpdateTimeMapper.addBookUpdateTime(bookUpdateTimeInfo) == 1;
    }

    @Override
    public BookUpdateTimeInfo getNearestTime() {
        return bookUpdateTimeMapper.getNearestTime();
    }
}
