package AmazonOA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Movie
{
   int movieId;
   float rating;
   public List<Movie> similarMovies;
   
   public Movie(int id, float rating) {
	   this.movieId = id;
	   this.rating = rating;
   }
   //还有其他的getters. visit 1point3acres.com for more.
}

public class MovieNetwork {
	public List<Movie> findTopK(Movie m, int k) {
		List<Movie> result = new ArrayList<Movie>();
		
		if (m == null) {
			return result;
		}
		
		//注意要抛出输入电影本身 ，compare rate时候 类型是float 
		PriorityQueue<Movie>  q = new PriorityQueue<Movie>(k, new Comparator<Movie>() {
			public int compare(Movie a, Movie b) {
				return (int)(a.rating - b.rating);
			}//从小到大
			
		});
	
		Queue<Movie> similar = new LinkedList<Movie>();
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
		
		for (Movie movie : q) {
			result.add(movie);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		MovieNetwork test = new MovieNetwork();
		Movie a = new Movie(1,2.5f);
		Movie b = new Movie(1,2.5f);
		Movie c = new Movie(1,2.6f);
		Movie d = new Movie(1,2.1f);
		Movie e = new Movie(1,2.0f);
		Movie f = new Movie(1,2.7f);
		Movie g = new Movie(1,2.9f);
		Movie h = new Movie(1,2.3f);
		
		a.similarMovies.add(b);
		a.similarMovies.add(c);
		a.similarMovies.add(d);
		
		b.similarMovies.add(e);
		b.similarMovies.add(f);
		
		f.similarMovies.add(h);
		f.similarMovies.add(a);
		
		f.similarMovies.add(g);
		
		
		
		List<Movie> result = test.findTopK(a,5);
		
		for (Movie m : result) {
			System.out.print(m.movieId);
		}
		
	}
}
