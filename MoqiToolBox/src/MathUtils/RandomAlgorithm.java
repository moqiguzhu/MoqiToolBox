package MathUtils;

import java.util.*;

public class RandomAlgorithm {

  public static int bigrand() {
    return new Random().nextInt(Integer.MAX_VALUE);
  }

  // <CLRS> p71
  // <programming> pearls p122
  public static int[] RandomizeInPlace(int[] A) {
    int len = A.length;
    Random rand = new Random();
    for (int i = 0; i < len; i++) {
      int j = rand.nextInt(len - i) % len + i; // nextInt(bound) from 0 to bound-1
      // swap
      swap(A, i, j);
    }
    return A;
  }

  // TreeSet
  // select m random numbers from 0,1,...,n-1
  public static int[] gensets(int m, int n) {
    if (m > n) {
      System.out.println("m must less than n!!!");
      System.exit(1);
    }
    Set<Integer> treeset = new TreeSet<>();
    while (treeset.size() < m) {
      treeset.add(bigrand() % n);
    }
    int[] result = new int[m];
    int index = 0;
    for (int x : treeset) {
      result[index++] = x;
    }

    return result;
  }
  
  // select m random numbers from 0,1,...,n-1
  public static int[] genknuth(int m, int n) {
    int[] result = new int[m];
    int index = 0;
    for(int i = 0; i < n; i++) {
      if(bigrand() % (n-i) < m) {
        result[index++] = i;
        m--;
      }
    }
    
    return result;
  }

  public static void swap(int[] a, int l, int r) {
    int temp = a[l];
    a[l] = a[r];
    a[r] = temp;
  }

  // 随机返回low,high之间的一个数，inclusive
  public static int random(int low, int high) {
    Random rand = new Random();
    return rand.nextInt(high - low + 1) + low;
  }

  public static void reserviorSample() {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入从流中抽取的样本个数：");
    int num_samples = sc.nextInt();
    System.out.println("从流中抽取 " + num_samples + " 样本！");
    int count = 0;
    Random rand = new Random();
    int[] result = new int[num_samples];

    // indefinite loop
    int num = -1;
    while ((num = sc.nextInt()) != -1) {
      if (count < num_samples) {
        result[count++] = num;
      } else {
        int temp = rand.nextInt(count + 1);
        count++;
        if (temp < num_samples) {
          result[temp] = num;
        }
      }
    }

    // close Scanner
    if (sc != null) {
      sc.close();
    }

    // print result
    System.out.println(Arrays.toString(result));

  }

  public static void main(String[] args) {
    // test RandomizeInPalace
    int[] test = {1, 2, 3, 4, 5, 6};
    System.out.println(Arrays.toString(RandomAlgorithm.RandomizeInPlace(test)));

    // test reserviorSample
    // RandomAlgorithm.reserviorSample();

    // test genset
    System.out.println(Arrays.toString(RandomAlgorithm.gensets(5, 10)));
    
    // test genknuth
    System.out.println(Arrays.toString(RandomAlgorithm.genknuth(5, 10)));

    // System.out.println("薛 晨 浩 \r\n马 凡 \r\n 雷  力 明 \r\n 侯 开 宇 \r\n 陈 世 阳 \r\n 朱 军");
  }
}
