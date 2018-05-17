# Solutions

All solutions have implemented tests at the same package as the implamantation
at the *src/test* folder.

## Task 1

Given an unsorted integer array, place all zeros to the end of the array
without changing the sequence of non-zero elements.

Example:

list1 = [1,3,0,8,12,0,4,0,7]
return [1,3,8,12,4,7,0,0,0]

What is the algorithmic complexity ("big O") of your function?

#### Solution:

Solution is implemented at the *cz.xfabian.oracle.platformtest.solutions.taskone* package

#### Complexity

Array lookup complexity is always O(1).

The solution goes once through the given array and copys the non zero values to the new array so the complexity is:

**Worst-case:** O(n)

**Best-case:** Ω(n)

**Average-case:** Θ(n)

## Task 2

A palindrome is a word that reads the same backward or forward. Write a
function that checks if a given word is a palindrome. Character case is
significant.

Example:

word = "dabcbad"  returns true
word = "Deed"  returns false (character cases differ)

What is the algorithmic complexity ("big O") of your function?


#### Solution:

Solution is implemented at the *cz.xfabian.oracle.platformtest.solutions.tasktwo* package

#### Complexity

For String, charAt() is a constant-time operation.

The solution goes from the first letter and the last letter of the given word
at the same time and compers, if the letters are the same and if they are alphabetic characters,
until the indexes meet. Because the charAt() method is a constant-time operation
and at every case, when the given word is a palindrome, we need to go through the word's characters once,
the complexity is:

**Worst-case:** O(n)

**Best-case:** Ω(c)

The best-case is when we notice on the first and last letter that it's not the same so we can imediately return false.

**Average-case:** Θ(n)

## Task 3

Design a simple storage mechanism for sparse matrixes of integers (ie
matrixes that have only very few non-zero elements but can be potentially
large). Implement two methods on such matrixes:

  *update matrix value at a given row and column*

	void set(int row, int col, int val)

  *return the sum of values from the top left corner to the given row, column sub-matrix*

	int sum(int row, int col)


Assume all indices in the methods are zero-based.

Example:

Matrix A =
            ( 0  3  0  0 )
            ( 1  0  0  0 )
            ( 0  0  4  -1)
            ( 0  1  0  0 )

set(0,1,5) on A =
            ( 0  5  0  0 )
            ( 1  0  0  0 )
            ( 0  0  4  -1)
            ( 0  1  0  0 )

sum(2,2) on A = 8 /* =1+3+4 */



#### Solution:

Solution is implemented at the *cz.xfabian.oracle.platformtest.solutions.taskthree* package

The solution stores only positions, where the value is non zero. Not stored positions are
considered as zero. This means, that the matrix's sizes are unlimite (not set values are zeros),
so we can store potentially large matrixes. If we want to specify the exact size of the matrix,
it's enough to set the upper boundary of the *TreeMaps* sizes used in the solution.

The solution is built on the [TreeMap](https://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html)
data structure, which is sorting the key's of the map in a tree structure.
The matrix contains a *TreeMap* for storing the columns, where *key* is the column number
and the *value* is an another *TreeMap* with *key* as row and *value* as the persisted value.

The *TreeMap* makes it quick to sum the submatrixes of the matrix, becaust the keys are ordered
and to sum all the values limited by some row and column, we just need to take the keys smaller-equal then
the given row and column (it's log(n) because they are stored in a tree structure) and get their values.

#### Complexity

*n* - amount of non zero values in the matrix

*TreeMap*'s implementation of the *containsKey*, *put*, *get* and *remove* guaranteeds the log(n) time complexity.

##### set(int row, int col, int val)

In case we are setting the value to 0 (removing), we are calling at the worst case twice *get()* and twice *remove()*
(second time to remove the whole TreeSet if is empty) so the time complexity is log(4n)

In the best case, when we want to set value to 0 (remove), we just check that it doesn't exist by invoking *containsKey*
so the time complexity is log(n).

If the value is a non zero value, we call once *containsKey* and once *getKey* (if don't need to create a new column tree)
so the time complexity is log(2n).

**Worst-case:** O(4log(n))

**Best-case:** Ω(log(n))

**Average-case:** Θ(2log(n))

##### sum(int row, int col)

To sum the submatrix, we are taking the subtrees of the ordered trees and iterate through them.
This makes the time complexity log(n)^2.

**Worst-case:** O(log(n)^2)

**Best-case:** Ω(2log(n))

Best-case is, when we want to sum the submatrix of row and column equal 1. We just go through the
first tree to get the smallest key, then go through the second tree to get the smallest key and we have the value.
No more iterations are needed.

**Average-case:** Θ(log(n)^2)


#### Other possible solution:

In case we want to set the value very often but calling the sum just rarely,
we could use a [HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
to store the data where *key* is an object with *row* and *col* properties and the *value*
is the set value. In that case we can set a new value in a constant time but to sum the submatrix
would take a time complexity Θ(n).

