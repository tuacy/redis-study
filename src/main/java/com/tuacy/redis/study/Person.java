package com.tuacy.redis.study;

import com.google.common.base.Function;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @name: Person
 * @author: tuacy.
 * @date: 2019/6/13.
 * @version: 1.0
 * @Description:
 */
public class Person {

    /**
     * 对可排序类型做自然排序，如数字按大小，日期按先后排序 -- NaturalOrdering
     */
    public static <C extends Comparable> Ordering<C> natural();

    /**
     * 把给定的Comparator转化为排序器
     */
    public static <T> Ordering<T> from(Comparator<T> comparator);
    public static <T> Ordering<T> from(Ordering<T> ordering);

    /**
     * -- ExplicitOrdering
     */
    public static <T> Ordering<T> explicit(List<T> valuesInOrder);
    public static <T> Ordering<T> explicit(T leastValue, T... remainingValuesInOrder);

    /**
     *
     */
    public static Ordering<Object> allEqual();

    /**
     * 按对象的字符串形式做字典排序 -- UsingToStringOrdering
     */
    public static Ordering<Object> usingToString();

    /**
     *
     */
    public static Ordering<Object> arbitrary();

    public <S extends T> Ordering<S> reverse();

    public <S extends T> Ordering<S> nullsFirst();

    public <S extends T> Ordering<S> nullsLast();

    public <F> Ordering<F> onResultOf(Function<F, ? extends T> function);

    public <U extends T> Ordering<U> compound(Comparator<? super U> secondaryComparator);

    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> comparators);

    public <E extends T> E min(Iterator<E> iterator);
    public <E extends T> E min(Iterable<E> iterable);
    public <E extends T> E min(@Nullable E a, @Nullable E b);
    public <E extends T> E min(@Nullable E a, @Nullable E b, @Nullable E c, E... rest);

    public <E extends T> E max(Iterator<E> iterator);
    public <E extends T> E max(Iterable<E> iterable);
    public <E extends T> E max(@Nullable E a, @Nullable E b);
    public <E extends T> E max(@Nullable E a, @Nullable E b, @Nullable E c, E... rest);

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int k);
    public <E extends T> List<E> leastOf(Iterator<E> iterator, int k);

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int k);
    public <E extends T> List<E> greatestOf(Iterator<E> iterator, int k);

    public <E extends T> List<E> sortedCopy(Iterable<E> elements);

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> elements);

    public boolean isOrdered(Iterable<? extends T> iterable);

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable);

}
