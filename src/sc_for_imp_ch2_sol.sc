// Scala for impatient, by Cay S. Horstmann

// Solutions by Jeremy Wenxiao Gu
// 2016.4.10

// Reference1: parambirs/s4di_ch01_exercises.sc

// Reference2: https://github.com/BasileDuPlessis/scala-for-the-impatient/tree/master/src/main/scala/com/basile/scala/ch01

// Introduction: Chapter 2. Basics: Functions, Loops, etc.

// Solutions of Chap2


// 1. The signum of a number is 1 if the number is positive, -1 if it is negative, and
// 0 if it is zero. Write a function that computes this value.
  
def signum(x: Double) = {
	if (x>0) 1 else if (x==0) 0 else -1
}
val x: Int = 100
signum(x)

// 2. What is the value of an empty block expression {}? What is its type?
val blank = {}                                  //> blank  : Unit = ()
// Value is () and type is Unit

// 3. Come up with one situation where the assignment x = y = 1 is valid in Scala.

// (Hint: Pick a suitable type for x.)
var y: Int = 0                            //> y  : Int = 0
val x: Unit = y = 1                       //> x  : Unit = ()
// x should be of type Unit

// 4. Write a Scala equivalent for the Java loop
// for (int i = 10; i >= 0; i--) System.out.println(i);
for(i <- 10 to (0, -1)) println(i)        //> 10
                                          //| 9
                                          //| 8
                                          //| 7
                                          //| 6
                                          //| 5
                                          //| 4
                                          //| 3
                                          //| 2
                                          //| 1
                                          //| 0
(not completed)                                          
                                          
                                          
                                          
                                          
 // 5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.
 def countdown(n: Int) = {
 	for(i <- n to (0, -1)) println(i)
 }                                         //> countdown: (n: Int)Unit
countdown(5)                              //> 5
                                          //| 4
                                          //| 3
                                          //| 2
                                          //| 1
                                          //| 0
// 6. Write a for loop for computing the product of the Unicode codes of all letters
// in a string. For example, the product of the characters in "Hello" is 9415087488.
var prod = 1L                              //> prod  : Int = 1
for(c <- "Hello") prod *= c
prod                                      //> res3: Int = 9415087488
 
// 7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps
// Scaladoc.)
"Hello".foldLeft(1L)((a, b) => a * b)      //> res4: Int = 9415087488

// 8. Write a function product(s : String) that computes the product, as described
// in the preceding exercises.
def product(s: String) = s.foldLeft(1L)((a, b) => a * b)
                                          //> product: (s: String)Int
product("Hello")                                //> res5: Int = 9415087488

// 9. Make the function of the preceding exercise a recursive function.
def productRec(s: String):Long = {
	if(s.length == 0) 1
	else s(0) * productRec(s drop 1)
}                                         //> productRec: (s: String)Int
productRec("Hello")                       //> res6: Int = 9415087488

// 10. Write a function that computes x^n, where n is an integer. Use the following
// recursive definition
// xn = y2 if n is even and positive, where y = x ^ n / 2.
// xn = x * x ^ n - 1 if n is odd and positive.
// x0 = 1
// xn = 1 / x ^ -n if n is negative.
// Don't use a return statement.
def xpown(x: BigInt, n: Int): BigInt = {
	if(n > 0 && n % 2 == 0) xpown(x, n / 2) * xpown(x, n / 2)
	else if(n > 0) x * xpown(x, n - 1)
	else if(n == 0) 1
	else 1 / xpown(x, -n)
}                                         //> xpown: (x: BigInt, n: Int)BigInt
xpown(2, 1024)                            //> res7: BigInt = 179769313486231590772930519078902473361797697894230657273430
                                          //| 081157732675805500963132708477322407536021120113879871393357658789768814416
                                          //| 622492847430639474124377767893424865485276302219601246094119453082952085005
                                          //| 768838150682342462881473913110540827237163350510684586298239947245938479716
                                          //| 304835356329624224137216