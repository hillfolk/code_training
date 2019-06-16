package main

type TreeNode struct  {
	label string
	parent TreeNode
	childrens []TreeNode
	
}

func printLabels(aTree TreeNode*) {
	fmt.println(aTree.label)

	for i,v := range aTree.label {
		printLabes(v)
	}
}
