package com.tuacy.redis.study.controller;

import com.tuacy.redis.study.entity.response.ResponseData;
import com.tuacy.redis.study.param.RedisGetParam;
import com.tuacy.redis.study.param.RedisIntegerSetParam;
import com.tuacy.redis.study.service.ObjectRedisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis key:String value:customize
 */
@RestController
@RequestMapping("/redisStudy/objectRedisTemplate")
public class ObjectRedisTemplateController {

    private ObjectRedisTemplateService objectRedisTemplateService;

    @Autowired
    public void setObjectRedisTemplateService(ObjectRedisTemplateService objectRedisTemplateService) {
        this.objectRedisTemplateService = objectRedisTemplateService;
    }

    @RequestMapping(value = "setInteger", method = RequestMethod.POST)
    public ResponseData<String> redisIntegerSet(@RequestBody RedisIntegerSetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        return responseDataEntity;
    }

    @RequestMapping(value = "getInteger", method = RequestMethod.POST)
    public ResponseData<String> redisIntegerGet(@RequestBody RedisGetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        return responseDataEntity;
    }

    @RequestMapping(value = "setString", method = RequestMethod.POST)
    public ResponseData<String> redisStringSet(@RequestBody RedisIntegerSetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        return responseDataEntity;
    }

    @RequestMapping(value = "getString", method = RequestMethod.POST)
    public ResponseData<String> redisStringGet(@RequestBody RedisGetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        return responseDataEntity;
    }

    @RequestMapping(value = "setHash", method = RequestMethod.POST)
    public ResponseData<String> redisHashSet(@RequestBody RedisIntegerSetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        return responseDataEntity;
    }

    @RequestMapping(value = "getHash", method = RequestMethod.POST)
    public ResponseData<String> redisHashGet(@RequestBody RedisGetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        return responseDataEntity;
    }

    @RequestMapping(value = "setList", method = RequestMethod.POST)
    public ResponseData<String> redisListSet(@RequestBody RedisIntegerSetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        return responseDataEntity;
    }

    @RequestMapping(value = "getList", method = RequestMethod.POST)
    public ResponseData<String> redisListGet(@RequestBody RedisGetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        return responseDataEntity;
    }

    @RequestMapping(value = "setSet", method = RequestMethod.POST)
    public ResponseData<String> redisSetSet(@RequestBody RedisIntegerSetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        return responseDataEntity;
    }

    @RequestMapping(value = "getSet", method = RequestMethod.POST)
    public ResponseData<String> redisSetGet(@RequestBody RedisGetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        return responseDataEntity;
    }
}
