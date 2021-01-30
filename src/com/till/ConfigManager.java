package com.till;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//配置文件类
public class ConfigManager {
    private static ConfigManager configManager;
    private static Properties properties;//java常用的配置文件所用的类
    private  ConfigManager(){
        String configFile="db.properties";//配置文件地址
        properties=new Properties();
        InputStream in=ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
        try {
            properties.load(in);//加载文件
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ConfigManager getInstance(){
        if(configManager==null){
            configManager=new ConfigManager();
        }
        return configManager;
    }

    public String getString(String key){
        return properties.getProperty(key);//获取属性
    }
}

