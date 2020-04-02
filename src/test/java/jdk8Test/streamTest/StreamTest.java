package jdk8Test.streamTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void test(){

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);

        // 计算空字符串
        System.out.println("字符列表: " +strings);
        long count = strings.stream().filter(s -> s.isEmpty()).count();
        System.out.println("空字符数量为: " + count);
        count = strings.stream().filter(s -> s.length() == 3).count();
        System.out.println("字符串长度为 3 的数量为: " + count);
        //删除空字符串
        List<String> filtered = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选后的列表: " + filtered);
        // 删除空字符串，并使用逗号把它们合并起来
        String mergedString = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        System.out.println("合并字符串: " + mergedString);

        System.out.println("--------------------------------- ");
        System.out.println("数字列表: " +numbers);
        // 获取列表元素平方数
        List<Integer> squaresList = numbers.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println("平方数列表: " + squaresList);

        System.out.println("--------------------------------- ");
        System.out.println("数字列表: " +integers);

        IntSummaryStatistics statistics = integers.stream().mapToInt(x -> x).summaryStatistics();

        System.out.println("个数 : " + statistics.getCount());
        System.out.println("列表中最大的数 : " + statistics.getMax());
        System.out.println("列表中最小的数 : " + statistics.getMin());
        System.out.println("所有数之和 : " + statistics.getSum());
        System.out.println("平均数 : " + statistics.getAverage());

        // 输出10个随机数
        System.out.println("随机数: ");
        new Random().ints(10,100).limit(10).sorted().forEach(System.out::println);
    }
}
