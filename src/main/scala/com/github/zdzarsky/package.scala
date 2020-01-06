package com.github

package object zdzarsky {
  implicit class PipeForward[F](val value: F) extends AnyVal {
    def pipeForward[G](f: F => G): G = f(value)
  }
}
