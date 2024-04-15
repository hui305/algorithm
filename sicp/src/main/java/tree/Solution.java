package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2023/3/22 11:05
 */
public class Solution {

    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        TreeNode root=new TreeNode(preorder[0]);//前序数组的第一个就是根节点。
        Map<Integer, Integer> inorderMap=new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++)
        {
            inorderMap.put(inorder[i], i);//key：data value：array index
        }
        return buildTree(preorder,0,preorder.length-1, inorderMap,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, Map<Integer, Integer> inorderMap, int inStart, int inEnd) {

        if(preEnd<preStart||inEnd<inStart)
            return null;
        TreeNode node=new TreeNode(preorder[preStart]);
        
        //1）先通过前序数组第一个元素确定根节点在中序数组中的
        int midindex=inorderMap.get(preorder[preStart]);

        int leftlen=midindex-inStart;//左侧区域的长度
        node.left=buildTree(preorder, preStart+1, preStart+1+leftlen, inorderMap, inStart, midindex-1);
        node.right=buildTree(preorder, preStart+leftlen+1,preEnd, inorderMap, midindex+1, inEnd);
        return node;
    }
}
