package OA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


class Movie
{
   private int movieId;
   private float rating;
   private List<Movie> similarMovies;
   
   public Movie(int id, float rating) {
	   this.movieId = id;
	   this.rating = rating;
	   this.similarMovies = new ArrayList<Movie>();
   }
   
   public int getId(){
	   return this.movieId;
   }
   public float getRating(){
	   return this.rating;
   }
   public List<Movie> getSimilar(){
	   return this.similarMovies;
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
				return Float.compare(a.getRating(), b.getRating());
			}
			
		});
	
		Queue<Movie> similar = new LinkedList<Movie>();
		similar.offer(m);
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(m.getId());
		
		while (!similar.isEmpty()) {
			
			Movie temp = similar.poll();
			
			for (int i = 0; i < temp.getSimilar().size(); i++) {
				Movie neigbor = temp.getSimilar().get(i);
				
				if (neigbor != m && !similar.contains(neigbor) && !visited.contains(neigbor.getId())) {
					similar.offer(neigbor);
					visited.add(neigbor.getId());
				}
				
				if (neigbor != m && !q.contains(neigbor)) {
					if (q.size() < k) {// mean not self 
						q.offer(neigbor);
					} else {
						if (neigbor.getRating() > q.peek().getRating()) {
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
		Movie b = new Movie(2,2.5f);
		Movie c = new Movie(3,2.6f);
		Movie d = new Movie(4,2.1f);
		Movie e = new Movie(5,2.0f);
		Movie f = new Movie(6,2.7f);
		Movie g = new Movie(7,2.9f);
		Movie h = new Movie(8,2.3f);
		
		a.getSimilar().add(b);
		a.getSimilar().add(c);
		a.getSimilar().add(d);
		
		b.getSimilar().add(e);
		b.getSimilar().add(f);
		
		f.getSimilar().add(h);
		f.getSimilar().add(a);
		f.getSimilar().add(b);
		f.getSimilar().add(g);
		
		
		
		List<Movie> result = test.findTopK(a,3);
		
		for (Movie m : result) {
			System.out.print(m.getId());
		}
		
	}
}
