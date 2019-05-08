package com.enjoy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class ConfigClientController {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;
    @Value("${spring.datasource.username}")
    private String userName;


    @RequestMapping("/config")
    public String getConfig() {
        System.out.println();
        return "ApplicationName = " + this.applicationName + "、EurekaServers = "
                + this.eurekaServers+"、 datasourceName="+userName;
    }

    public static void main(String[] args) {
        int arr[] = {1,4,2,5};
        //choose(arr,arr.length);
        insert(arr,arr.length);
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.println(i1);
        }
    }
    public static void choose(int arr[],int len){
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i; j < len; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }

    }

    public static void insert(int arr[],int len){
        for (int i = 1; i < len; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if(arr[j] > value){
                    arr[j+1] = arr[j];//数据移动
                }else {
                    break;
                }
            }
            arr[j+1] = value;
        }

    }

    public static void  insertSort(int arr[],int len){
        if(len<=1){return;}
        for (int i = 1; i < len;i++) {
            int val = arr[i];
            int j = i - 1;
            for(;j>=0;j--){
                if(arr[j] > val){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = val;
        }
    }
    /**
     * 归并排序
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }


}
