package ca.six.algo.tree

import ca.six.algo.bisearch.TreeNode


/*

  3
2   5
  4   7
那这个树的最小高度就是2 (即3->2这一分支. 3->5这一分支的高度为3)
现在给定一个二叉树, 要求其的最小高度
 */

fun minHeight(root: TreeNode?): Int {
    if (root == null) return 0

    val leftHeight = minHeight(root.left)
    val rightHeight = minHeight(root.right);
    return if (leftHeight == 0 || rightHeight == 0) (leftHeight + rightHeight + 1)
    else Math.min(leftHeight, rightHeight) + 1
}

fun main() {
    val n7 = TreeNode(7, null, null)
    val n4 = TreeNode(4, null, null)
    val n5 = TreeNode(5, n4, n7)
    val n2 = TreeNode(2, null, null)
    val n3 = TreeNode(3, n2, n5)

    val minHeight = minHeight(n3)
    println("minHeight = $minHeight")
}