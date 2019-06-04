package com.tuacy.redis.study.controller;

import com.tuacy.redis.study.entity.param.ParamRedisSet;
import com.tuacy.redis.study.entity.response.ResponseData;
import com.tuacy.redis.study.service.StringRedisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis key-String value-String
 */
@RestController
@RequestMapping("/redisStudy/stringRedisTemplate")
public class StringRedisTemplateController {

    private StringRedisTemplateService redisService;

    @Autowired
    public void setRedisService(StringRedisTemplateService redisService) {
        this.redisService = redisService;
    }

    @RequestMapping(value = "set", method = RequestMethod.POST)
    public ResponseData<String> redisSet(@RequestBody ParamRedisSet param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        redisService.set("name", "tuacy");
        return responseDataEntity;
    }

}
