package com.mohuani.javacollectionexamples;

import com.mohuani.javacollectionexamples.data.TeacherDomain;
import com.mohuani.javacollectionexamples.entity.Teacher;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class JavaCollectionExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCollectionExamplesApplication.class, args);

        TeacherDomain teacherDomain = new TeacherDomain();
        List<Teacher> teacherList = teacherDomain.getTeacherList();
        System.out.println("\n" + "原始数据");
        System.out.println("teacherList = " + teacherList);

        // isEmpty/isNotEmpty
        System.out.println("\n" + "isEmpty/isNotEmpty");
        System.out.println(CollectionUtils.isEmpty(teacherList));
        System.out.println(CollectionUtils.isNotEmpty(teacherList));


        // keyBy to list：将list根据某个key排序，结果仍然是list
        System.out.println("\n" + "keyBy");
        System.out.println(teacherList.stream().sorted(Comparator.comparing(Teacher::getId)).collect(Collectors.toList()));


        // list to map: 将list根据某个key作为下标index，转化成一个map
        // 需要注意的是：比如teacher1，teacher2的name都是"老师2"，toMap 如果集合对象有重复的key，会报错Duplicate key，
        // 可以用 (k1,k2)->k1 来设置，如果有重复的key, 则保留key1,舍弃key2
        System.out.println("\n" + "list to map");
        Map<String, Teacher> teacherMapByName = teacherList.stream().collect(Collectors.toMap(Teacher::getName, o -> o, (k1, k2) -> k1));
        System.out.println(teacherMapByName);

        // map to list：将map剔除key，结果集是一个list
        System.out.println("\n" + "map to list");
        System.out.println(teacherMapByName.values());

        // groupBy to map: 将一个list根据某个key作为下标index，转化为一个map，结果集的map的value是个list
        System.out.println("\n" + "groupBy");
        Map<String, List<Teacher>> teachersMapByName =
            teacherList.stream().collect(Collectors.groupingBy(Teacher::getName));
        System.out.println(teachersMapByName);


        // unique to list：将一维的list去重
        System.out.println("\n" + "unique");
        List<Integer> teacherIdList = teacherList.stream().map(Teacher::getId).distinct().collect(Collectors.toList());
        System.out.println(teacherIdList);

        // min/max：一维的list获取min和max
        System.out.println("\n" + "min/max");
        System.out.println(Collections.min(teacherIdList));
        System.out.println(Collections.max(teacherIdList));

        // sum：一维的list获取sum
        System.out.println("\n" + "sum");
        System.out.println(teacherIdList.stream().mapToInt(i -> i).sum());

        // first: list根据筛选条件获取第1个element
        System.out.println("\n" + "first");
        System.out.println(teacherList.stream().findFirst());
        System.out.println(teacherList.stream().findFirst().get());

        // filter:
        System.out.println("\n" + "filter");


        // chunk: 根据根据分块大小将list进行切割
        System.out.println("\n" + "chunk");


        // whereIn:
        System.out.println("\n" + "whereIn");


    }

}
