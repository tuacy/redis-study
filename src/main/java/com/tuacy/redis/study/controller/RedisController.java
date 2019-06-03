package com.tuacy.redis.study.controller;

import com.tuacy.redis.study.entity.param.ParamRedisSet;
import com.tuacy.redis.study.entity.response.ResponseData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisStudy/")
public class RedisController {

    @RequestMapping(value = "set", method = RequestMethod.POST)
    public ResponseData<String> redisSet(@RequestBody ParamRedisSet param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();

        return responseDataEntity;
    }

}
