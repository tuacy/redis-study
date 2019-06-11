package com.tuacy.redis.study.controller;

import com.google.common.collect.Lists;
import com.tuacy.redis.study.entity.response.ResponseData;
import com.tuacy.redis.study.param.*;
import com.tuacy.redis.study.service.impl.ObjectRedisTemplateServiceImpl;
import com.tuacy.redis.study.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * redis key:String value:customize
 */
@RestController
@RequestMapping("/redisStudy/objectRedisTemplate")
public class ObjectRedisTemplateController {

    private ObjectRedisTemplateServiceImpl objectRedisTemplateService;

    @Autowired
    public void setObjectRedisTemplateService(ObjectRedisTemplateServiceImpl objectRedisTemplateService) {
        this.objectRedisTemplateService = objectRedisTemplateService;
    }


    @RequestMapping(value = "setInteger", method = RequestMethod.POST)
    public ResponseData<String> redisIntegerSet(@RequestBody RedisIntegerSetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        objectRedisTemplateService.set(param.getRedisKey(), param.getRedisValue());
        return responseDataEntity;
    }

    @RequestMapping(value = "getInteger", method = RequestMethod.POST)
    public ResponseData<Integer> redisIntegerGet(@RequestBody RedisGetParam param) {
        ResponseData<Integer> responseDataEntity = new ResponseData<>();
        int value = ConvertUtil.convert(objectRedisTemplateService.get(param.getRedisKey()));
        responseDataEntity.setData(Lists.newArrayList(value));
        return responseDataEntity;
    }

    @RequestMapping(value = "setString", method = RequestMethod.POST)
    public ResponseData<String> redisStringSet(@RequestBody RedisStringSetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        objectRedisTemplateService.set(param.getRedisKey(), param.getRedisValue());
        return responseDataEntity;
    }

    @RequestMapping(value = "getString", method = RequestMethod.POST)
    public ResponseData<String> redisStringGet(@RequestBody RedisGetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        String value = ConvertUtil.convert(objectRedisTemplateService.get(param.getRedisKey()));
        responseDataEntity.setData(Lists.newArrayList(value));
        return responseDataEntity;
    }

    @RequestMapping(value = "setHash", method = RequestMethod.POST)
    public ResponseData<String> redisHashSet(@RequestBody RedisHashObjectSetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        objectRedisTemplateService.hmset(param.getRedisKey(), ConvertUtil.convert(param.getRedisValue()));
        return responseDataEntity;
    }

    @RequestMapping(value = "getHash", method = RequestMethod.POST)
    public ResponseData<Map<String, String>> redisHashGet(@RequestBody RedisGetParam param) {
        ResponseData<Map<String, String>> responseDataEntity = new ResponseData<>();
        Map<String, String> value = ConvertUtil.convert(objectRedisTemplateService.hmget(param.getRedisKey()));
        responseDataEntity.setData(Lists.newArrayList(value));
        return responseDataEntity;
    }

    @RequestMapping(value = "setList", method = RequestMethod.POST)
    public ResponseData<String> redisListSet(@RequestBody RedisListObjectSetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        objectRedisTemplateService.set(param.getRedisKey(), param.getRedisValue());
        return responseDataEntity;
    }

    @RequestMapping(value = "getList", method = RequestMethod.POST)
    public ResponseData<String> redisListGet(@RequestBody RedisGetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        List<String> value = ConvertUtil.convert(objectRedisTemplateService.get(param.getRedisKey()));
        responseDataEntity.setData(value);
        return responseDataEntity;
    }

    @RequestMapping(value = "setSet", method = RequestMethod.POST)
    public ResponseData<String> redisSetSet(@RequestBody RedisSetObjectSetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        // TODO:
        return responseDataEntity;
    }

    @RequestMapping(value = "getSet", method = RequestMethod.POST)
    public ResponseData<String> redisSetGet(@RequestBody RedisGetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        // TODO:
        return responseDataEntity;
    }

    @RequestMapping(value = "setObject", method = RequestMethod.POST)
    public ResponseData<String> redisSetObject(@RequestBody RedisObjectSetParam param) {
        ResponseData<String> responseDataEntity = new ResponseData<>();
        objectRedisTemplateService.set(param.getRedisKey(), param.getRedisValue());
        return responseDataEntity;
    }

    @RequestMapping(value = "getObject", method = RequestMethod.POST)
    public ResponseData<RedisObjectSetParam.ObjectParam> redisSetObject(@RequestBody RedisGetParam param) {
        ResponseData<RedisObjectSetParam.ObjectParam> responseDataEntity = new ResponseData<>();
        RedisObjectSetParam.ObjectParam value = ConvertUtil.convert(objectRedisTemplateService.get(param.getRedisKey()));
        responseDataEntity.setData(Lists.newArrayList(value));
        return responseDataEntity;
    }
}
