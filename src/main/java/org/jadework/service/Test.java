package org.jadework.service;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

/**
 * write Title here
 * <p>
 * write Description here
 * </p>
 *
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @copyright 2015-2016 sh.lianjia.com.
 * @date 16/4/20
 */

public class Test {
    public static void main(String[] args) {
//        String[] testCase = new String[]{
//                "签约仪式前，秦光荣、李纪恒、仇和等一同会见了参加签约的企业家。",
//                "王国强、高峰、汪洋、张朝阳光着头、韩寒、小四",
//                "张浩和胡健康复员回家了",
//                "王总和小丽结婚了",
//                "编剧邵钧林和稽道青说",
//                "这里有关天培的有关事迹",
//                "龚学平等领导,邓颖超生前",
//        };
//        Segment segment = HanLP.newSegment().enableNameRecognize(true);
//        for (String sentence : testCase)
//        {
//            List<Term> termList = segment.seg(sentence);
//            System.out.println(termList);
//        }

        System.out.println(HanLP.segment("签约仪式前，秦光荣、李纪恒、仇和等一同会见了参加签约的企业家。"));
    }
}
