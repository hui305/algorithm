package com.algo;

/**
 * Created by hui_stone on 2018/4/1 0001.
 * 小根堆
 */
public class MinPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;//1...N pq[0]没有使用

    public MinPQ(int maxN) {
        pq = (Key[])new Comparable[maxN+1];//?为什么要new comparable转化下
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return  N;
    }

    public void insert(Key v){

        pq[++N] = v;
        swim(N);
    }

    public Key delMin(){

        Key min = pq[1];  //get min
        exch(1,N);     //swap with the last one
        pq[N--] = null;
        sink(1);
        return min;
    }

    private void swim(int k){

        while(k>1 && less(k,k/2)){//和父节点比较，交换
            exch(k,k/2);
            k = k/2;
        }
    }

    private void sink(int k){//和子节点中较小的一个比较、交换

        while(2*k <= N){
            int j = 2*k;
            if(j<N && less(j+1,j))
                j++;
            if(less(k,j))
                break;
            exch(k,j);
            k = j;
        }
    }

    private boolean less(int i,int j){
       return pq[i].compareTo(pq[j]) <0;
    }

    private void exch(int i,int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public String toString(){
        String temp="";
        for(int i = 1;i<pq.length;i++){
            temp += pq[i]+" ";
        }
        return temp;
    }

    public static void main(String[] args) {

        MinPQ minPQ = new MinPQ(5);
        minPQ.insert(20);
        minPQ.insert(10);
        minPQ.insert(15);
        minPQ.insert(5);
        minPQ.insert(25);
        System.out.println(minPQ);
    }
}
