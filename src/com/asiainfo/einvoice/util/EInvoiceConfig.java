package com.asiainfo.einvoice.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by huangjh on 16/3/24.
 */
public class EInvoiceConfig {
    private static Properties _config = null;

    static {
        _config = new Properties();
        try {
            _config.load(EInvoiceConfig.class.getResourceAsStream("/EInvoiceConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) throws Exception {
        return (String) _config.get(key);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(EInvoiceConfig.get("client.impl.sk"));
    }

}
