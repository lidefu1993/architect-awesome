package com.ldf.architect.base;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lidefu
 * @date 2019/2/19 11:35
 */
public class StreamDemo {

    /**
     * stream不是数据结构，只是数据源（例如：集合）的视图
     * 常用操作
     * 中间操作：concat() distinct() filter() map() flatMap() limit() sorted() peek()
     *          skip() parallel() sequential() unordered() mapToInt()
     * 结束操作：allMatch() anyMatch() noneMatch() collect() count() findAny() findFirst()
     *         forEach() forEachOrdered() max() min() reduce() toArray()
     */

    public static void main(String[] args) {
        foreach();
        filter(1, 2, 3, 4);
        concat();
        distinct();
        map();
        sortLimit();
        peek();
        skip();
        parallel();
        sequential();
        unordered();
        match();
        collect();
        find();
        maxMin();
        reduce();
        mapToInt();
    }

    /**
     * foreach 遍历
     * forEach遍历流的每一个元素，执行指定的action。它是一个终点操作，和peek方法不同。
     * 这个方法不担保按照流的encounter order顺序执行，如果对于有序流按照它的encounter order顺序执行，你可以使用forEachOrdered方法。
     */
    public static void foreach(){
        System.out.println("-----------------foreach-----------------");
        System.out.println("forEach");
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        stream1.parallel().forEach(System.out::println);
        System.out.println("forEachOrdered:");
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        stream2.parallel().forEachOrdered(System.out::println);
    }

    /**
     * concat 合并
     */
    public static void concat(){
        System.out.println("-----------------concat-----------------");
        Stream<String> streamLow = Stream.of("a");
        Stream<String> streamUp = Stream.of("A");
        Stream.concat(streamLow, streamUp).forEach(System.out::println);
    }

    /**
     * distinct 去重
     */
    public static void distinct(){
        System.out.println("-----------------distinct-----------------");
        Stream<String> stream = Stream.of("a", "a", "c", "d");
        stream.distinct().forEach(System.out::println);
    }

    /**
     * filter 过滤
     * @param integers
     */
    public static void filter(Integer... integers){
        System.out.println("-----------------filter-----------------");
        Stream<Integer> stream = Stream.of(integers);
        stream.filter(integer -> integer>3).forEach(System.out::println);
    }

    /**
     * map 对每个元素按照某种操作进行转换，转换前后Stream中元素的个数不会改变，但元素的类型取决于转换之后的类型
     * flatMap 把原stream中的所有元素都"摊平"之后组成的Stream，转换前后元素的个数和类型都可能会改变。
     */
    public static void map(){
        System.out.println("-----------------map-----------------");
        Stream<String> stream1 = Stream.of("hello", "ldf");
        List<String[]> collect = stream1.map(s -> s.split("")).collect(Collectors.toList());
        System.out.println(collect);
        Stream<String> stream2 = Stream.of("hello", "ldf");
        List<String> list = stream2.flatMap(s -> Stream.of(s.split(""))).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * sorted 排序
     * limit 限制结果集数量
     */
    public static void sortLimit(){
        System.out.println("-----------------sortLimit-----------------");
        Stream<Integer> stream = Stream.of(3, 1, 5, 4, 2);
        stream.sorted().limit(3).forEach(System.out::println);
    }

    /**
     * peek 使用一个Consumer消费流中的元素，但是返回的流还是包含原来的流中的元素。
     * 可以使用保存中间值
     * count:获取数量
     */
    public static void peek(){
        System.out.println("-----------------peek-----------------");
        Stream<Integer> stream = Stream.of(1, 2, 3);
        List<Integer> list = new ArrayList<>();
        long count = stream.peek(list::add).count();
        System.out.println("count:" + count);
        list.forEach(System.out::println);
    }

    /**
     * skip 返回丢弃了前n个元素的流
     */
    public static void skip(){
        System.out.println("-----------------skip-----------------");
        Stream<Integer> stream = Stream.of(4, 2, 3, 5);
        stream.sorted().skip(2).forEach(System.out::println);
    }

    /**
     * parallel 并行执行
     */
    public static void parallel(){
        System.out.println("-----------------parallel-----------------");
        Stream<Integer> stream = Stream.of(1, 2, 3);
        //并行执行会打乱打印顺序
        stream.parallel().forEach(System.out::println);
    }

    /**
     * sequential 顺序模式 保证源顺序执行
     */
    public static void sequential(){
        System.out.println("-----------------sequential-----------------");
        Stream<Integer> stream = Stream.of(5, 2, 3);
        stream.sequential().forEach(System.out::println);
    }

    /**
     * unordered 清除排序状态 对应sorted
     * 额...
     */
    public static void unordered(){
        System.out.println("-----------------unordered-----------------");
        System.out.println("sorted:");
        Stream<Integer> stream1 = Stream.of(5, 2, 3);
        stream1.map(i -> i*Math.random()).sorted().forEach(System.out::println);
        System.out.println("unordered:");
        Stream<Integer> stream2 = Stream.of(5, 2, 3);
        stream2.map(i -> i*Math.random()).sorted().unordered().forEach(System.out::println);
    }

    /**
     * match 检查流中的元素是否满足断言。
     * allMatch只有在所有的元素都满足断言时才返回true,否则flase,流为空时总是返回true
     * anyMatch只有在任意一个元素满足断言时就返回true,否则flase,
     * noneMatch只有在所有的元素都不满足断言时才返回true,否则flase,
     */
    public static void match(){
        System.out.println("-----------------match-----------------");
        Stream<String> stream1 = Stream.of("李三", "李四");
        boolean allMatch = stream1.allMatch(i -> i.startsWith("李"));
        System.out.println("allMatch:" + allMatch);
        Stream<String> stream2 = Stream.of("李三", "李四", "张三");
        boolean anyMatch = stream2.anyMatch(i -> i.startsWith("李"));
        System.out.println("anyMatch:" + anyMatch);
        Stream<String> stream3 = Stream.of("张三");
        boolean noneMatch = stream3.noneMatch(i -> i.startsWith("李"));
        System.out.println("noneMatch:" + noneMatch);
    }

    /**
     * collect
     */
    public static void collect(){
        System.out.println("-----------------collect-----------------");
        Stream<String> stream = Stream.of("ldf", "李德富");
        List<String> list = stream.map(s -> s + "1").collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    /**
     * findAny()返回任意一个元素，如果流为空，返回空的Optional，
     *  对于并行流来说，它只需要返回任意一个元素即可，所以性能可能要好于findFirst()，
     *  但是有可能多次执行的时候返回的结果不一样。
     * findFirst()返回第一个元素，如果流为空，返回空的Optional
     */
    public static void find(){
        System.out.println("-----------------find-----------------");
        Stream<Integer> stream1 = Stream.of(1, 23, 123, 124, 22, 311);
        Integer findAny = stream1.parallel().filter(integer -> integer>100).findAny().orElse(0);
        System.out.println("findAny:" + findAny);
        Stream<Integer> stream2 = Stream.of(1, 23, 123, 124, 22, 311);
        Integer findFirst = stream2.filter(integer -> integer > 100).findFirst().orElse(0);
        System.out.println("findFirst:" + findFirst);
    }

    /**
     * max:最大值
     * min:最小值
     */
    public static void maxMin(){
        System.out.println("-----------------maxMin-----------------");
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);
        Integer max = stream1.max((o1, o2) -> o2 >= o1 ? -1 : 1).orElse(0);
        System.out.println("max:" + max);
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4);
        Integer min = stream2.min((o1, o2) -> o2 >= o1 ? -1 : 1).orElse(0);
        System.out.println("min:" + min);
    }

    /**
     * reduce
     */
    public static void reduce(){
        System.out.println("-----------------reduce-----------------");
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);
        /**
         * a 第一次是为第一个元素 之后为每次的返回值 b下一个元素
         */
        Integer integer1 = stream1.reduce((a, b) -> {
            System.out.println("a:" + a);
            System.out.println("b:" + b);
            System.out.println("-------");
            return a + b;
        }).orElse(0);
        System.out.println(integer1);
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4);
        /**
         * a：第一次为0之后为每次的返回值
         * b：下一个元素
         */
        stream2.reduce(0, (a, b)->{
            System.out.println("a:" + a);
            System.out.println("b:" + b);
            System.out.println("-------");
            return a+b;
        });
    }

    public static void mapToInt(){
        Stream<Integer> stream = Stream.of(1, 2, 3);
        stream.mapToInt(i->i+10).forEach(System.out::println);
        User ldf = new User("ldf", 26);
        User ldy = new User("ldy", 12);
        Stream<User> users = Stream.of(ldf, ldy);
        int[] ints = users.mapToInt(User::getAge).toArray();
        Arrays.stream(ints).forEach(System.out::println);
    }

    static class User{
        private String name;
        private int age;
        public User(String name, int age){
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

}
