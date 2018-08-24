package com.web.chat.mapper;

import com.web.chat.model.Device;

public interface BaseMapper<T> {
    int delete(Long id);

    int insert(T record);

    int insertActive(t record);

    Device getOne(Long id);

    int updateActive(T record);

    int update(T record);
}