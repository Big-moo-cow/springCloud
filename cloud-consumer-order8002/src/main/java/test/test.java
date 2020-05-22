package test;


import com.alibaba.druid.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class test {
    @Resource
    private RestTemplate restTemplate;



    public static void main(String[] args){
        int[] redOne,blueOne;
        redOne = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
        blueOne = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};

        HashSet<Object> redResultList = new HashSet<>();
        HashSet<Object> blueResultList = new HashSet<>();


        Random random = new Random();

        while (redResultList.size()<5){
            redResultList.add(redOne[random.nextInt(35)]);
        }
        while (blueResultList.size()<2){
            blueResultList.add(blueOne[random.nextInt(12)]);
        }

        System.out.println(redResultList.toString()+":"+blueResultList.toString());
    }

    public void testOne(){
        File file  = new File("E:\\data.txt");
        try{
            FileOutputStream out = new FileOutputStream(file);
            for(int i = 2019; i < 2021; i++){
                for(int j = 1; j < 114; j++){
                    String str = "";
                    if(j<10){
                        str = String.valueOf(i)+"00"+String.valueOf(j);
                    }else if(j>=10&& j<100){
                        str = String.valueOf(i)+"0"+String.valueOf(j);
                    }else{
                        str = String.valueOf(i)+String.valueOf(j);
                    }
                    RestTemplate restTemplate =  new RestTemplate();
                    String result = restTemplate.postForObject("https://www.cjcp.com.cn/ajax_kj.php?jsoncallback=jsonp16318292&dlt_qs=" + str, null, String.class);
//                    String result =  util.post("https://www.cjcp.com.cn/ajax_kj.php?jsoncallback=jsonp16318292&dlt_qs="+str);
                    String[] tempStr = null;
                    if(!StringUtils.isEmpty(result)){
                        tempStr = result.split("\\*");
                    }
                    System.out.println("result:"+result);
                    if(tempStr != null && tempStr.length > 10){
                        String data = str+","+tempStr[4]+","+tempStr[5]+","+tempStr[6]+","+tempStr[7]+","+tempStr[8]+","+tempStr[9]+","+tempStr[10]+"\n";
                        out.write(data.getBytes());
                    }
                }
            }
        }catch (Exception e){
            System.out.println("异常："+e);
        }
    }
}
