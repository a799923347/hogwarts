package com.bowen.hogwarts.controller

import com.alibaba.fastjson.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class KotlinDemoService {
    var logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun test(): ApiResponse<Any> {
        val currentTimeMillis = System.currentTimeMillis()
        logger.info("kotlin实现的api访问")
        val jsonObject = JSONObject()
        jsonObject["ts"] = currentTimeMillis
        return ApiResponse.ok(jsonObject)
    }

}

