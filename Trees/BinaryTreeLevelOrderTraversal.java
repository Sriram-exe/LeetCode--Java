class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> li = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return li;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> subli =  new LinkedList<>();
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right!= null) q.add(node.right);
                subli.add(node.val);
            }
            li.add(subli);
        }
        return li;
    }
}

//I Used a queue 
//TC : O(N)
//SC : O(N) - > for queue
