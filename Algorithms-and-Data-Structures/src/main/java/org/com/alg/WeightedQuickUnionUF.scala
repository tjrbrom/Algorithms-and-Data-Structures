package org.com.alg


/**
 * {@code WeightedQuickUnionUF} class represents a <em>union–find data type</em>
 * (also known as the <em>disjoint-sets data type</em>)
 *
 * Worst-case order of growth of find(), connected(), and union() is log N
 *
 * @param parent original array of sites
 * @param size secondary array, used to determine the bigger component to replace the smaller one, and not the other way around
 * @param count number of components
 */
class WeightedQuickUnionUF (
  var parent: Array[Int],
  var size: Array[Int],
  var count: Int
) {

  /**
   * Initializes an empty union–find data structure with {@code n} sites
   * {@code 0} through {@code n-1}. Each site is initially in its own
   * component.
   *
   * @param  n the number of sites
   * @throws IllegalArgumentException if { @code n < 0}
   */
  def this(n: Int) {

    this(parent, size, count)

    count = n
    parent = new Array[Int](n)
    size = new Array[Int](n)

    for (i <- 0 until n) {
      parent(i) = i
      size(i) = 1
    }
  }

  /**
   * Returns the component identifier for the component containing site {@code p}.
   *
   * @param  pVal the integer representing one object
   * @return the component identifier for the component containing site { @code p}
   * @throws IllegalArgumentException unless { @code 0 <= p < n}
   */
  def find(pVal: Int): Int = {
    validate(pVal)
    var p = pVal
    while ({
      p != parent(p)
    }) p = parent(p)
    p
  }

  // validate that p is a valid index
  private def validate(p: Int): Unit = {
    val n = parent.length
    if (p < 0 || p >= n) throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1))
  }

  /**
   * Returns true if the the two sites are in the same component.
   *
   * @param  p the integer representing one site
   * @param  q the integer representing the other site
   * @return { @code true} if the two sites { @code p} and { @code q} are in the same component;
   *                 { @code false} otherwise
   * @throws IllegalArgumentException unless
   *                                  both { @code 0 <= p < n} and { @code 0 <= q < n}
   */
  def connected(p: Int, q: Int): Boolean = find(p) == find(q)

  /**
   * Merges the component containing site {@code p} with the
   * the component containing site {@code q}.
   *
   * @param  p the integer representing one site
   * @param  q the integer representing the other site
   * @throws IllegalArgumentException unless
   *                                  both { @code 0 <= p < n} and { @code 0 <= q < n}
   */
  def union(p: Int, q: Int): Unit = {
    val rootP = find(p)
    val rootQ = find(q)

    // if they belong to the same component already, return
    if (rootP == rootQ) return

    if (size(rootP) < size(rootQ)) {
      parent(rootP) = rootQ
      size(rootQ) += size(rootP)
    }
    else {
      parent(rootQ) = rootP
      size(rootP) += size(rootQ)
    }
    count -= 1
  }

}
