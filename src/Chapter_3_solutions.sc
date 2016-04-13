// Scala for impatient, by Cay S. Horstmann

// Solutions by Jeremy Wenxiao Gu
// 2016.4.12

// Reference1: parambirs/s4di_ch01_exercises.sc

// Reference2: https://github.com/BasileDuPlessis/scala-for-the-impatient/tree/master/src/main/scala/com/basile/scala/ch01

// Introduction: Chapter 3.

// Quick Summary:
/**
 * In chapter 3, we will learn how to work with arrays in scala.
 * Fixed length and varying length.
 * Access the elements
 * Traverse the elements
 * Traverse the elements but also transform into a new array
 */

// Study Notes:
/**
 *
 */


// 3.1 Fixed-Length Arrays
// Initialization

// An array of ten integers, all initialized with zero
val nums = new Array[Int](10)

// A string array with ten elements, all initialized with null
var chars = new Array[String](10)
chars(0) = "haha"
println(chars) // print [Ljava.lang.String;@37091312
println(chars.toList) // List(haha, null, null, null, null, null, null, null, null, null)
chars.foreach(println) // print
println(chars.mkString("")) // print hahanullnullnullnullnullnullnullnullnull

var strs = Array("ABC","DEF")

// 3.2 Variable-Length Arrays: Array Buffers

import scala.collection.mutable.ArrayBuffer
val b = ArrayBuffer[Int]() // empty array!
val b2 = new ArrayBuffer[Int] // empty array!

b += 1
// ArrayBuffer(1)
// Add an element at the end with +=
b += (1, 2, 3, 5) // append
// ArrayBuffer(1, 1, 2, 3, 5)
// Add multiple elements at the end by enclosing them in parentheses
b ++= Array(8, 13, 21)
// ArrayBuffer(1, 1, 2, 3, 5, 8, 13, 21)
// You can append any collection with the ++= operator
b.trimEnd(5)
// ArrayBuffer(1, 1, 2)
// Removes the last five elements

b.insert(2, 6)
// ArrayBuffer(1, 1, 6, 2)
// Insert before index 2
b.insert(2, 7, 8, 9)
// ArrayBuffer(1, 1, 7, 8, 9, 6, 2)
// You can insert as many elements as you like
b.remove(2)
// ArrayBuffer(1, 1, 8, 9, 6, 2)
b.remove(2, 3)
// ArrayBuffer(1, 1, 2)
// The second parameter tells how many elements to remove

/**
 * array <> arraybuffer
 * Sometimes, you want to build up an Array, but you don’t yet know how many
elements you will need. In that case, first make an array buffer, then call
 */

var a = Array[Int]()
// a(0) = 10 // error because a is empty array
a = b.toArray // Array(1, 1, 2)
var c = ArrayBuffer[Int]()
// c = a.toBuffer // Conversely, convert the array a to an array buffer.

// a.toBuffer // [Q] How do we do assignment here? Posted on http://stackoverflow.com/questions/36586429/how-to-assign-the-arraybuffer-to-a-varaible-in-scala



// 3.3 Traversing Arrays and Array Buffers

//
val a = Array(1,3,5,7,9)
for (i <- 0 until a.length){
  println(a(i))
}

for (i <- 0 to (a.length-1)){
  println(a(i))
}

for(i <- (a.length-1) to (0, -1)) {
  println(i)
  println(a(i))
}

// If you don’t need the array index in the loop body,
// visit the array elements directly, like this:

for (elem <- a) println(elem)

// 3.4 Transforming Arrays
// New collection, in the same type as the original
// collection. If you started with an array, you get another array
val result = for (elem <- a) yield 2 * elem

//

a.filter( _ % 2 == 0).map(2 * _)

a filter { _ % 2 == 0 } map { 2 * _ }

/**
// Some programmers with experience in functional programming prefer filter
  and map to guards and yield. That’s just a matter of style—the for loop does
  exactly the same work. Use whichever you find easier.
*/

// 3.5 Common Algorithms


// Exercises:

