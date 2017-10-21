package AmazonOA;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * 相似的电影那道. 说白了就是找出一个图中K个有最高评价的结点
 * 
 * 用Heap就可以搞定, 所有测试例子都过了.
 * 
 * 
 * Q2: Movie network，是地里出现过的原题，BFS + PriorityQueue秒

再附上整理的地里出现过的新版Amcat 社招OA面经，希望能帮助到大家，攒人品，求店面求onsite求大米！


给一部电影，返回给这部电影相关的，排名最高的k部电影。如果不够k部，就有多少返回多少。 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
用bfs + 优先级队列做的。

注意k部电影不包含给的电影本身。


******
*
*
*题目如下：
假设有个Movie类，
public class Movie
{
   int movieId;.
   float rating;
   List<Movie> similarMovies
还有其他的getters. visit 1point3acres.com for more.
}
现在要求找到 k个和movie最相似 的movies。. visit 1point3acres.com for more.. Waral 鍗氬鏈夋洿澶氭枃绔�,
. visit 1point3acres.com for more.
函数的signature大概是这样的：
public static List<Movie> getNearest(Movie movie, int numSimilar)。 

举个栗子：.鏈枃鍘熷垱鑷�1point3acres璁哄潧
m0 <-->m1, similarity 2-google 1point3acres
mo <--> m2, similarity 3.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
m1 <--> m3, similarity 4 .鏈枃鍘熷垱鑷�1point3acres璁哄潧
m2 <--> m5, similaity 5

如果要返回和mo最相似的movie, 那么应该返回 m5 (只有有一条路径从 m1到 m5, 并且 5是最大的）； 如果返回3个最相似的就返回 m2, m3， m5（顺序不重要）； 如果需要返回10个，但是相似的只有9个，那么就返回9个。
source movie本身不能在返回结果里面。

可以的一个做法是 dfs + min-Heap(PriorityQueue)， 我们一直做dfs， 每次碰到一个新的movie，如果现在queue的size比 k小的话，直接加到queue里面； 如果新movie的rating比queue top movie的rating高的话， 把顶部movie
踢出队列，加上这个新的。


update: 应该返回 m5 (只有有一条路径从 m1到 m5, 并且 5是最大的） --> 应该返回 m5 (只要有一条路径从 m1到 m5, 并且 5是最大的）

**
*
*注意要抛出输入电影本身 ，compare rate时候 类型是float    PQ +BFS
 * @author Shengyi
 *
 */
//class Movie
//{
//   int movieId;
//   float rating;
//   List<Movie> similarMovies;
////还有其他的getters. visit 1point3acres.com for more.
//}
public class Movieh {
	public List<Movie> findTopK(Movie m, int k) {
		List<Movie> result = new ArrayList<Movie>();
		
		if (Movie == null) {
			return result;
		}
		//注意要抛出输入电影本身 ，compare rate时候 类型是float 
		PriorityQueue<Movie>  q = new PriorityQueue<Movie>(k, new Comparator<Movie>() {
			public float comare(Movie a, Movie b) {
				return a.rating - b.rating;
			}//从小到大
		});
		
		Queue<Movie> similar = new LinkedList<Movie>;
		similar.offer(m);
		
		while (!similar.isEmpty()) {
			Movie temp = similar.poll();
			
			for (int i = 0; i < temp.similarMovies.size(); i++) {
				Movie neigbor = temp.similarMovies.get(i);
				if (!similar.contains(neigbor)) {
					similar.offer(neigbor);
				}
				
				if (neigbor != m && !q.contains(neigbor)) {
					if (q.size() < k) {// mean not self 
						q.offer(neigbor);
					} else {
						if (neigbor.rating > q.peek().rating) {
							q.poll();
							q.offer(neigbor);
						}
					}
				}
				
			}
		}
		
		for (Movie m : q) {
			result.add(m);
		}
		
		return result;
	}
}
