package com.github.zdzarsky

import com.github.zdzarsky.model.Node

object TestUtils {
  val aNode: Node = Node(1, "A", List(
    Node(2, "AA", List(
      Node(3, "AA1", List.empty),
      Node(4, "AA2", List.empty),
    )),
    Node(5, "AB", List())
  ))

  val bNode: Node = Node(6, "B", List())

  val cNode: Node = Node(7, "C", List(
    Node(8, "CA", List(
      Node(9, "CA1", List()),
      Node(10, "CA2", List())
    ))
  ))

  val dNode: Node = Node(11, "D", List(
    Node(12, "DA", List())
  ))

  val structure: List[Node] = List(
    aNode, bNode, cNode, dNode
  )
}
