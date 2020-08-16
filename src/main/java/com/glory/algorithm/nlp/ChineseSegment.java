package com.glory.algorithm.nlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.CustomDictionary;

/**
 * 中文分词
 *
 * @author Glory
 * @create 2020-04-01 17:16
 **/
public class ChineseSegment {

    public static void main(String[] args) {
        CustomDictionary.insert("广发卡");
        CustomDictionary.insert("联名卡");
        CustomDictionary.insert("银行");
        CustomDictionary.insert("信用卡");
        CustomDictionary.insert("电子账单");
        System.out.println(HanLP.segment("广州农商银行信用卡电子账单"));
    }
}
