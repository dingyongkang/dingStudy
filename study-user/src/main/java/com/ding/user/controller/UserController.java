package com.ding.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @RequestMapping(value = "/discovery",method = RequestMethod.GET)
    public String discoveryService(){
        return restTemplate.getForObject("http://study-goods/goods/dis",String.class);

    }

    public static void main(String[] args) {
        int[] y= new int[]{9,2,19,6,1};
        InsertSort(y,5);
        for(int o=0; o<=4;o++){
            System.out.print(" "+y[o]);
        }

    }

    //插入排序
    static void InsertSort(int[] arr, int n)
    {
        for (int i = 0; i < n - 1; ++i)
        {
            //记录有序序列最后一个元素的下标
            int end = i;
            //待插入的元素
            int tem = arr[end + 1];
            //单趟排
            while (end >= 0)
            {
                //比插入的数大就向后移
                if (tem < arr[end])
                {
                    arr[end + 1] = arr[end];
                    end--;
                }
                //比插入的数小，跳出循环
                else
                {
                    break;
                }
            }
            //tem放到比插入的数小的数的后面
            arr[end  + 1] = tem;
            //代码执行到此位置有两种情况:
            //1.待插入元素找到应插入位置（break跳出循环到此）
            //2.待插入元素比当前有序序列中的所有元素都小（while循环结束后到此）
        }
    }
}
