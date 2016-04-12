// Scala for impatient, by Cay S. Horstmann

// Solutions by Jeremy Wenxiao Gu
// 2016.4.10

// Reference1: parambirs/s4di_ch01_exercises.sc

// Reference2: https://github.com/BasileDuPlessis/scala-for-the-impatient/tree/master/src/main/scala/com/basile/scala/ch01

// Introduction: Chapter 1 introduces the basics of Scala.

// Solutions of Chap1 ex.

package src.exercises

import scala.math._
import BigInt.probablePrime
import util.Random

object chap01 {
// 1. In the Scala REPL, type 3. ("." is necessary) followed by the Tab key. What methods can be
// applied?
// Note that in Unix/Mac, we need to define $SCALA_HOME /usr/local/share/scala and $PATH $PATH:$SCALA_HOME/bin
  	  	
// 13.% 6  (residual is 1)

// 2. In the Scala REPL, compute the square root of 3, and then square that value.
// By how much does the result differ from 3? (Hint: The res variables are your
// friend.)

var res: Double = _
res = 3 - pow(sqrt(3),2)
println(res)
// 4.440892098500626E-16

// 3. Are the res variables val or var?
// val
  
// 4. Scala lets you multiply a string with a number - try out "crazy" * 3 in the REPL.
// What does this operation do? Where can you find it in Scaladoc?

// This can be found in the StringOps class, as shown below
// http://lampwww.epfl.ch/~hmiller/scaladoc/library/scala/collection/immutable/StringOps.html
"crazy" * 3
//> res0: String = crazycrazycrazy

// 5. What does 10 max 2 mean? In which class is the max method defined?
  10 max 2                                  //> res1: Int = 10
// Defined in the RichInt class

// 6. Using BigInt, compute 2^1024.

var powers: BigInt = _
powers =  BigInt(2) pow 1024                       
println(powers) //  too long :P


// 7. What do you need to import so that you can get a random prime as
// probablePrime(100, Random), without any qualifiers before probablePrime and Random?
import BigInt.probablePrime
import util.Random 


probablePrime(100, Random)

// Generating Random Numbers (more in scala5. scala cookbook)
val r = scala.util.Random
r.setSeed(1000L) //set seeds
r.nextInt //create random integers
r.nextInt(100)  //limit the random numbers to a maximum value 100
r.nextFloat // returns a value between 0.0 and 1.0
r.nextDouble // longer

// 8. One way to create random file or directory names is to produce a random
// BigInt and convert it to base 36, yielding a string such as "qsnvbevtomcj38o06kul".
// Poke around Scaladoc to find a way of doing this in Scala.

// Base36 is a binary-to-text encoding scheme that represents binary data in an ASCII string format by translating it into a radix-36 representation. 
// lower case base36
// java: String uniqueID = UUID.randomUUID().toString(); // unique id?


probablePrime(100, Random).toString(36)   //> res4: String = 2w2bxtp6lz08l502sg9h
	
// 9. How do you get the first character of a string in Scala? The last character?
  val s = "String"                          //> s  : String = String
  s.head                                    //> res5: Char = S
  s(0)                                      //> res6: Char = S
  s.last                                    //> res7: Char = g
  s(s.length - 1)                           //> res8: Char = g
  
// 10. What do the take, drop, takeRight, and dropRight string functions do? What
// advantage or disadvantage do they have over using substring?
  // take: Selects the first n elements
  s.take(2)                                 //> res9: String = St
  // drop: Selects all elements except first n ones
  s.drop(2)                                 //> res10: String = ring
  // takeRight: Selects the last n elements
  s.takeRight(2)                            //> res11: String = ng
  // dropRight: Selects all elements except last n ones
  s.dropRight(2)                            //> res12: String = Stri
  // advantage: they are much more concise and intuitive than substring
}