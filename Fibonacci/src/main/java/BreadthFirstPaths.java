
/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2023/11/17 18:20
 */
public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;  //到达该顶点的上一个节点
    private int s; //start vertex

    public BreadthFirstPaths(MyGraph G, int s) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }

    private void bfs(MyGraph G,int s){

        Queue<Integer> queue = new Queue<Integer>();
        marked[s] =true;//marked start
        queue.enqueue(s);//add to queue
        while(!queue.isEmpty()){
            int v = queue.dequeue();
            for(int w:G.adj(v)){
                if(!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;//标记，最短路径已知
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){

        Stack<Integer>  path = new Stack<>();
        for(int x = v;x !=s;x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return  path;
    }

    public static void main(String[] args) {

        MyGraph G = new MyGraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths search = new BreadthFirstPaths(G,s);
        for(int v=0;v<G.V();v++){
            System.out.print(s+" to "+ v + ":");
            if(search.hasPathTo(v)){
                for(int x : search.pathTo(v)){
                    if(x==s){
                        System.out.print(x);
                    } else{
                        System.out.print("-"+x);
                    }
                }
            }
            System.out.println();
        }
    }

}
