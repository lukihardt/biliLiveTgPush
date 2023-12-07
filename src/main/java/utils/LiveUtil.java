package utils;

import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.List;

public class LiveUtil {
    public static JSONObject check(String roomid) {
        String s = HttpUtil.get("https://live.bilibili.com/"+roomid);
        List<String> allGroup0 = ReUtil.findAllGroup1( "<script>window.__NEPTUNE_IS_MY_WAIFU__=(.*?)</script>",s);
        // System.out.println("allGroup0.size():"+allGroup0.size());
        if (allGroup0.size()>0){
            JSONObject obj = JSONUtil.parseObj(allGroup0.get(0));
            // System.out.println(obj);
            JSONObject baseInfoRes = obj.getJSONObject("roomInitRes");
            return baseInfoRes.getJSONObject("data");
        }
        return null;
    }
}
