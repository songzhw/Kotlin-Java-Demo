package ca.six.algo.tree

class TreeNode(var data: Int, var left: TreeNode?, var right: TreeNode?) {
    override fun toString(): String {
        return "TreeNode($data) [left=${left?.data}, right=${right?.data}]"
    }
}

/*
              9
     5                 20
  3     7         15        24
1   4 6   8    12    18  22     28
 */
val n1 = TreeNode(1, null, null)
val n4 = TreeNode(4, null, null)
val n6 = TreeNode(6, null, null)
val n8 = TreeNode(8, null, null)
val n12 = TreeNode(12, null, null)
val n18 = TreeNode(18, null, null)
val n22 = TreeNode(22, null, null)
val n28 = TreeNode(28, null, null)

val n3 = TreeNode(3, n1, n4)
val n7 = TreeNode(7, n6, n8)
val n15 = TreeNode(15, n12, n18)
val n24 = TreeNode(24, n22, n28)

val n5 = TreeNode(5, n3, n7)
val n20 = TreeNode(20, n15, n24)
val n9 = TreeNode(9, n5, n20)


