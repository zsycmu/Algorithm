package AmazonOA;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * 卡车那道, 求K 个最近的距离的位置.
 * 
 * 亚麻建了个新warehouse，从多个地点运东西过去，选择最近的k个点。就是k closest points，用priorityqueue。但是我不确定每个点算出来的distance会不会超int，所以用了long，不知道对不对。
 * 
 * 
 * 把地里的题都准备了，但是却遇见了两个新题。题目都不难，但是题目好长啊，理解一下题意10min过去了
第一题，Amazon warehouse。。。其实就是给你x,y 然后算x,y 到原点的距离，输出最小的几个，java应该priorityqueue就够了，我用的python，也还可以。. 鐣欏鐢宠璁哄潧-涓

是 warehouse送卡车.  N个仓库, M个目的地, 一个N size的List表示坐标. 输出M个坐标.  算sqrt,输出最小的M个就好了.  我就算sqft然后sort一下就好. N个地点List<Integer> M<N 列出最近的M个位置
 *
 *
 * *
 * 
 * 
Amazon warehouse。。。其实就是给你x,y 然后算x,y 到原点的距离，输出最小的几个，java应该priorityqueue就够了，我用的python，也还可以。
第二题，golf event要砍树。。。每次只能砍所有树里面最矮的那颗。其实就是maze题的变形。2D-array. 0不能走，1可以走，>1 就是树，要求的输出就是从原点开始，走到每颗当前树里面最矮的那颗所需的步数+需要砍得树的高度的总和。方法我就是先找好所有的树，排好序，然后从一个点到另一个点做BFS。 找出最小步数。
举个例子 [[1,1,0,2],[3,1,1,1]], 从（0，0）走到 （0，3）--》2 这棵树，就是5步+2（树高），然后从（0，3）走到 （1，0）->3 这棵树 4步+3（树高）所以5+2+4+3返回14

 * @author Shengyi
 *
 */

//参数：
//int N, 代表总共有N 个地点
//List<List<Integer>> 地点的坐标
//int M,代表需要送的crate数量
//
//output：一个List<List<Integer>> 代表送货的地点坐标x,y
//其实就是让你计算距离卡车最近的M个地点.
//
//需要注意点是题目里面没有给卡车的位置，根据给的例子猜出是原点（0，0）
//例1：N = 3, M = 2, List<List<Ingeter>> 是 [[2,3][3,4],[1,-3]].鏈枃鍘熷垱鑷�1point3acres璁哄潧
//output: [[2,3],[1,-3]]
//. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
//例2： N=3， M=6， List<List<Integer>> 是[[1,8],[2,4],[8,9],[5,3],[2,7],[3,5]]
//output: [[2,4],[5,3],[3,5]]

public class Truck {
	private int findDistance(List<Integer> a) {
		return a.get(0) * a.get(0) + a.get(1) * a.get(1);
	}
	public static List<List<Integer>> closestPoint(List<List<Integer>> location, int N,  int M) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
 		if (location == null || N == 0 || M > N) {
			return result;
		}

		PriorityQueue<List<Integer>> q = new PriorityQueue<List<Integer>>(N, new Comparator<List<Integer>>() {
			public int compare(List<Integer> a, List<Integer> b){
				return findDistance(a) - findDistance(b);
			}
		});
		
		for (List<Integer> a : location) {
			q.offer(a);
		}
		
		for (int i = 0; i < M; i++) {
			result.add(q.poll());
		}
		
		return result;
	}
	
	
	public static Point[] closestPoint2(Point[] array, final Point origin, int k)
    {
        if(k > array.length) return array;
        Point[] res = new Point[k];
        PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>()
        {
            @Override
            public int compare(Point a, Point b)
            {
                return -Double.compare(distance(a, origin), distance(b, origin));//??????????????????????????????????
            }
        });
        for(Point p: array) queue.offer(p);
        while(queue.size() > k) queue.poll();
        for(int i = 0; i < k; i++) res[k - 1 - i] = queue.poll();//????????????????????????????????
        return res;
    }

}
