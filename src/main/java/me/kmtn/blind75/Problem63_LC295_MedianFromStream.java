package me.kmtn.blind75;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/find-median-from-data-stream/
public class Problem63_LC295_MedianFromStream {
    static class MedianFinder {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        public void addNum(int num) {
           max.add(num);
           min.add(max.poll());
           if(min.size() > max.size()){
               max.add(min.poll());
           }
        }

        public double findMedian() {
            if(min.size() == max.size()){
                return (double) (max.peek()+min.peek()) / 2;
            } else {
                return max.peek();
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        mf.addNum(-2);
        mf.addNum(-3);
        mf.addNum(-4);
        mf.addNum(-5);
        assertThat(mf.findMedian()).isEqualTo(-3);
    }
}
