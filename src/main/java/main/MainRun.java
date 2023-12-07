package main;

import cn.hutool.json.JSONObject;
import utils.LiveUtil;

public class MainRun {
    public static void main(String[] args) throws InterruptedException {
        String live_status="0";
        while (true){
            String roomId="528";
            JSONObject data = LiveUtil.check(roomId);

            if (data!=null){
                // String title=data.getStr("title");
                String live_status2=data.getStr("live_status");
                System.out.println("直播间"+roomId+("1".equals(live_status2)?"已开播":"未开播"));
                System.out.println(live_status2);

                if (!(live_status.equals(live_status2))){
                    // System.out.println("live_status not equal live_status2");
                    live_status=live_status2;

                    ITelegramBot bot=new ITelegramBot();
                    bot.botConnect();
                    bot.sendTextMessage(-1002117523401L, "直播间直播状态改变");
                }
            }

            Thread.sleep(57000);
        }
    }
}
