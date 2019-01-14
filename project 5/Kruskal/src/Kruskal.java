import java.io.*;
import java.util.*;

public class Kruskal
{
	public void kruskal()
	{
    	
    	BufferedReader fileReader = null;
    	ArrayList<Edge> edgelist = new ArrayList<>();
		ArrayList<String> VertexList = new ArrayList<>();
        try
        {
            String line = "";
            int vertexCount = 0;
            fileReader = new BufferedReader(new FileReader("assn9_data.csv")); //hard coded this value! Please change it from here if required to test on another file
           
            while ((line = fileReader.readLine()) != null)
            {
                
                String[] tokens = line.split(",");
                //System.out.println("----------------------------------");
                //System.out.println(tokens[0]);
                //System.out.println(tokens[1]);
                //System.out.println(tokens[2]);
                //System.out.println(tokens.length);
                //System.out.println("----------------------------------");
                
                VertexList.add(tokens[0]);
                //System.out.println(VertexList);
                edgelist.add( new Edge(tokens[0],tokens[1],Integer.parseInt(tokens[2])));
                	for (int i=3 ; i<tokens.length ; i++)
                	{
                		edgelist.add(new Edge(tokens[0],tokens[i],Integer.parseInt(tokens[i+1])));
                		//System.out.println(tokens[0]+"----> "+tokens[i]+" = "+tokens[i+1]);
                		i++ ;
                	} 
                vertexCount++ ;             
            }
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }	 
        int totalDistance = 0;
		int foundEdge = 0 ;
		DisjSets ds = new DisjSets(VertexList.size());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for (Edge e : edgelist)
		{
			pq.add(e);	
		}
		
		while (foundEdge < VertexList.size()-1 )
		{
			Edge	e = pq.poll();	
         
         			
			int v1=ds.find(VertexList.indexOf(new String(e.v1)));
			int v2=ds.find(VertexList.indexOf(new String(e.v2)));
			if (v1 != v2)
			{
				foundEdge++ ;
				ds.union(v1,v2);
				System.out.println(e.v1 + " --> " + e.v2 );
				System.out.println("--------------------------------------");
				totalDistance = totalDistance + e.distance ;
				System.out.println("Distance = " + e.distance);
				
				
			}
		
		}
      
      System.out.println();
	  System.out.println("Total distance = " + totalDistance);
		

	}
}
