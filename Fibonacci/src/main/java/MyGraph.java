

import java.io.File;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2023/8/17 19:47
 */
public class MyGraph {

    private final int V; //vertex nums
    private int E;       //edge nums
    private Bag<Integer>[] adj; //adjacency

    public MyGraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v= 0;v<V;v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public MyGraph(In in){
        this(in.readInt());    //读取V并将图初始化
        int E = in.readInt();  //读取E
        for(int i = 0;i<E;i++){
            //add a edge
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public static int degree(MyGraph G,int v){
        int degree= 0;
        for(int w:G.adj(v)){
            degree++;
        }
        return degree;
    }

    public String toString(){
        String s = V +" verteices, "+ E + " edges\n";
        for(int v= 0;v<V;v++){
            s += v+": ";
            for(int w:this.adj(v))
                s += w + " ";
            s +="\n";
        }
        return s;
    }

    public static void main(String[] args) {
//        InputStream stream = MyGraph.class.getClassLoader().getResourceAsStream("tinyG.txt");
//        File file = new File("D:\\tinyG.txt");
        File file = new File("tinyG.txt");
        In in = new In(file);
        MyGraph myGraph = new MyGraph(in);
        System.out.println(myGraph);
    }
}
