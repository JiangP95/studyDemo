package com.test;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2 {


    public static void main(String[] args) throws Exception{

        Map<String,Integer> map = new HashMap<>(); //统计同一天内发生动账交易的次数  key: userId;  value: 次数统计
        String filePath = "";
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {      //一行一行读取日志文件
                String line = sc.nextLine();
                //解析这一行日志文件，
                //          1 判断是否是用户动账交易的日志信息
                //          2 解析出userid
                // 这里省略解析line的步骤
                String userId = "user1"; //从日志中解析出userId
                Integer num = map.get(userId);
                if (null == num){
                    map.put(userId,1);          //初始化动账次数
                }else {
                    map.put(userId, num+1 );    //动账次数+1
                }
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
