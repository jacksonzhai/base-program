package linked.list;

public class TreeOperators {
    public static TreeNode construct(int[] pre,int[] in){
        if(pre==null||in == null){
            return null;
        }
        int length = pre.length;
        return constructCore(pre,0,length-1,in,0,length-1);



    }
    public static TreeNode constructCore(int[] pre,int start,int end,int[] in ,int istart,int iend){
        TreeNode root = new TreeNode(pre[start]);
        if(start ==end){
            if(istart == iend&&pre[start] == in[istart]){
                return root;
            }
            else{
                return null;
            }
        }

        int rootIndex = findRootIndex(in,istart ,iend,pre[start]);
        //左子树
        int leftLength = rootIndex-istart+1;
        if(leftLength>0){
            root.left = constructCore(pre,start+1,start+leftLength,in,istart,rootIndex-1);

        }
        int rightLength = iend-rootIndex+1;
        if(rightLength>0){
            root.right = constructCore(pre,end-rightLength,end,in,rootIndex+1,end);
        }
        return root;
    }
    public static int findRootIndex(int[] in,int start,int end,int root){
        if(in==null){
            return -1;
        }
        for(int i = start;i<=end;i++){
            if(root == in[i]){
                return i;
            }
        }
        return -1;
    }
}
