package com.leablogs.converter;

import cn.hutool.core.date.DateUtil;
import com.leablogs.user.entity.Users;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class StringToUserConverter implements Converter<String, Users> {
    @Override
    public Users convert(String userStr) {
        Users users = new Users();
        String[] strArr = userStr.split(",");
        users.setSex(Short.parseShort(strArr[3]));
//        DateUtil dateUtil = DateUtil.parse(strArr[2]);
        LocalDate localDate = LocalDate.parse(strArr[2]);
        users.setBrithday(localDate);
        users.setUserName(strArr[0]);
        users.setPassword(strArr[1]);
        return users;
    }
}
