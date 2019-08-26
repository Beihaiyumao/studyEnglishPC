package com.neusoft.studyEnglish.controller;

import com.alibaba.fastjson.JSONObject;
import com.neusoft.studyEnglish.tool.Result;
import com.neusoft.studyEnglish.tool.ResultStateInfo;
import com.neusoft.studyEnglish.tool.baidufanyi.TransApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fanyi")
public class BaiduFanyiController {
    private static final String APP_ID = "20190825000329351";
    private static final String SECURITY_KEY = "HjhMSThpkywr05wnWaKN";

    /**
     * 百度实时翻译【汉译英】
     *
     * @param keyWord
     * @return
     * @throws Exception
     */
    @GetMapping("/zhToEn")
    public Result baiduFanyiZhToEn(@RequestParam("keyWord") String keyWord) throws Exception {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String result = api.getTransResult(keyWord, "auto", "en");
        //转成json对象
        JSONObject resultJsonObj = JSONObject.parseObject(result);
        return Result.ok(100, ResultStateInfo.SELECT_SUCCESS, resultJsonObj);
    }

    /**
     * 百度实时翻译【英译汉】
     *
     * @param keyWord
     * @return
     * @throws Exception
     */
    @GetMapping("/enToZh")
    public Result baiduFanyiEnToZh(@RequestParam("keyWord") String keyWord) throws Exception {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String result = api.getTransResult(keyWord, "auto", "zh");
        //转成json对象
        JSONObject resultJsonObj = JSONObject.parseObject(result);
        return Result.ok(100, ResultStateInfo.SELECT_SUCCESS, resultJsonObj);
    }
}
