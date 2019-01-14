public class Edge implements Comparable<Edge>
	{
		int distance;
		String v1 , v2;
		
		Edge(String s1 , String s2,int d)
		{
			this.v1 = s1;
			this.v2 = s2;
			this.distance = d;
		}
		public int compareTo(Edge e)
		{
			if (this.distance < e.distance)
				return -1;
			else if (this.distance > e.distance)
				return 1;
			
			else 
				return 0;
		}
	}