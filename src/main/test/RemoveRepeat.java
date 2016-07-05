import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.HttpPost;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * write Title here
 * <p>
 * write Description here
 * </p>
 *
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @copyright 2015-2016 sh.lianjia.com.
 * @date 16/5/13
 */

public class RemoveRepeat {

    private static final String  SEP = ",";

    public static void main(String[] args){
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(176030);
//        //list.add(108950);
//        //list.add(121294);
//        list.add(176030);
//        //list.add(94518);
//
//        System.out.println(list);
//        System.out.println(listToString(list));

//        String str = "121212,121212";
//        String[] arr = str.split(",");
//        System.out.println(arr.length);

//        boolean bool = 2 == 2 && 3 == 1;
//        System.out.println(bool);

//        stream();
//        jsonTest();
//        dateTest();
        System.out.println(new Date().getTime());

        HttpPost httpPost = new HttpPost();
    }



    public static void stream(){
        List<String> strings = new ArrayList<>();
        strings.add("true");
        strings.add("true");
        strings.add("true");
        strings.add("true");
        strings.add("true");
        strings.add("false");
        List<String> string2 = strings.stream().filter(string -> string.equals("true")).collect(Collectors.toList());
        System.out.println(string2);

    }

    public static void jsonTest(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Jade");
        jsonObject.put("age","14");
        System.out.println(jsonObject);
    }

    public static void dateTest(){

            Date date = new Date();
            // 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            long time = date.getTime();
            System.out.println(time);

    }
    public static String listToString(List<?> list){

        if(list.size()==1){
            return list.get(0).toString();
        }
        //去除重复
        for(int i=0; i<list.size(); i++){
            for(int j=list.size()-1; j>i; j--){
                if(list.get(i).equals(list.get(j))){
                    list.remove(j);
                }
            }
        }
        if(list.size()==1){
            return list.get(0).toString();
        }

        StringBuilder sb = new StringBuilder();
        if(list!=null && list.size()>1){
            for(int i=0; i<list.size()-1; i++){
                if(list.get(i)==null){
                    continue;
                }
                // 如果值是list类型则调用自己
                if (list.get(i) instanceof Integer) {
                    sb.append(list.get(i));
                    sb.append(SEP);
                }else if(list.get(i) instanceof List){
                    sb.append(listToString((List<?>) list.get(i)));
                    sb.append(SEP);
                }
            }
            sb.append(list.get(list.size()-1));
        }
        return sb.toString();
    }

    //TODO 字符串数组去重


    //TODO list去重

}
