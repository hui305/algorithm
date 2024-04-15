import java.io.File;


/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2023/11/16 17:39
 */
public class DepthFirstPaths {

    private boolean[] marked;//标记，表示连通的，能够到达。
    private int[] edgeTo;
    private final int s;//start point

    public DepthFirstPaths(MyGraph G, int s) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }

    private void dfs(MyGraph G,int v){
        marked[v] =true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v;x !=s;x= edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {

//        Stack<Integer> stack = new Stack<>();
//        stack.push(5);
//        stack.push(4);
//        stack.push(3);
//        stack.push(2);
//        stack.push(1);
//        for(int x:stack){
//            if(x == 1){
//                System.out.print("1");
//            }else{
//                System.out.print(" - "+x);
//            }
//        }
//        System.out.println();
//        File file = new File("D:\\tinyG.txt");
//        In in = new In(file);

        MyGraph G = new MyGraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths search = new DepthFirstPaths(G,s);
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
