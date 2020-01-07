package com.github.zdzarsky.model

import play.api.libs.functional.syntax._
import play.api.libs.json._

final case class Node(id: Int, name: String, nodes: List[Node])

object Node {
  implicit lazy val nodeReads: Writes[Node] = (
    (__ \ "id").write[Int] and
      (__ \ "name").write[String] and
      (__ \ "nodes").lazyWrite(Writes.list[Node](nodeReads))
    ) (unlift(Node.unapply))
}
