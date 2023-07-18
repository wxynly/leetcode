package com.wx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FeiZhu {
    public String[] findAndSort(String s) {
        if (s == null || s.length() <= 1) {
            return new String[]{s};
        }
        List<String> list = new ArrayList<>();
        int i = -1, j = 0;
        //字符串切割
        while (j < s.length()) {
            if (s.charAt(j) != 'w') {
                j++;
            } else {
                if (i != -1) {
                    if(j==i+1){
                        list.add("");
                    }else {
                        list.add(s.substring(i + 1, j));
                    }
                    i = j;
                    j++;
                } else {
                    i = j;
                }
            }
        }
        String[] strs = (String[]) list.toArray();
        mergeSort(strs, 0, strs.length);
        return strs;
    }

    public static void mergeSort(String[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid); //对左边序列进行归并排序
            mergeSort(arr, mid + 1, high);  //对右边序列进行归并排序
            merge(arr, low, mid, high);    //合并两个有序序列
        }
    }

    public static void merge(String[] arr, int low, int mid, int high) {
        String[] tmp = new String[high - low + 1];
        int i = 0;
        int j = low, k = mid + 1;  //左边序列和右边序列起始索引
        while (j <= mid && k <= high) {
            if (arr[j].compareTo(arr[k]) <= 0) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }
        //若右边序列还有剩余，则将其全部拷贝进tmp[]中
        while (k <= high) {
            tmp[i++] = arr[k++];
        }
        // 把最终的排序的结果复制给原数组
        for (int t = 0; t < i; t++) {
            arr[low + t] = tmp[t];
        }
    }

    public static void main(String[] args) {
        FeiZhu feizhu = new FeiZhu();
        String[] andSort = feizhu.findAndSort("yujwedjhccdskdsewirewrwsadm,fnsdklwweqpq");
        System.out.println(andSort);
    }




//    //每个代理人在每家航空公司的目的地国家覆盖度
//    select agent_id
//    airline num/
//    all_num as
//
//    cover_degree
//        //求出2018-01-01日 每个代理人在某个航空公司的目的地国家数量
//    from(select agent_id airline sum(country_code) as num
//
//    //求出2018-01-01日 每个代理人在某个航空公司的目的地国家记录
//    //distinct 去除每个代理人同一个航空、同一个国家的重复记录
//    from(select distinct agent_id airline country_code
//            from A left join B on A.dest_city_code=B.dest_city_code
//            Where time>=2018-01-01 00:00:00and time<=2018-01-01 00:00:00)
//
//    group by
//    agent_id airline)temp1
//
//    //求出2018-01-01日 每个航空公司的目的地国家数量
//    left join(select airline  sum(country_code) as all_num
//
//    //求出2018-01-01日 每个航空公司的目的地国家记录
//    //distinct 去除同一个航空、同一个国家的重复记录
//    from(select distinct airline country_code
//            from A left join B on A.dest_city_code=B.dest_city_code
//            Where time>=2018-01-01 00:00:00and time<=2018-01-01 00:00:00)
//
//    group by
//    airline)temp2
//    on temp1.airline =temp2.airline
//
//    //求出2018-01-01日 每个代理人在某个航空公司的目的地国家数量
//    select agent_id
//
//    airline sum(country_code) as num
//
//    from(select distinct agent_id airline country_code
//            from A left join B on A.dest_city_code=B.dest_city_code
//            Where time>=2018-01-01 00:00:00and time<=2018-01-01 00:00:00)
//
//    group by
//    agent_id airline
//
//    //求出2018-01-01日 每个航空公司的目的地国家数量
//    select airline
//
//    sum(country_code) as all_num
//
//    from(select distinct airline country_code
//            from A left join B on A.dest_city_code=B.dest_city_code
//            Where time>=2018-01-01 00:00:00and time<=2018-01-01 00:00:00)
//
//    group by
//    airline
}
