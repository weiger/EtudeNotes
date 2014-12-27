/*
Remove Duplicates

You are to write a function called unique that takes an array of integers and returns the array with duplicates removed. It must return the values in the same order as first seen in the given array. Thus no sorting should be done, if 52 appears before 10 in the given array then it should also be that 52 appears before 10 in the returned array.

Assumptions

All values given are integers (they can be positive or negative).
You are given an array but it may be empty.
They array may have duplicates or it may not.
You cannot use the uniq method on Arrays (don't even try it).
Example

puts unique([1, 5, 2, 0, 2, -3, 1, 10]).inspect
[1, 5, 2, 0, -3, 10]

puts unique([]).inspect
[]

puts unique([5, 2, 1, 3]).inspect
[5, 2, 1, 3]
*/

def unique(integers)
  integers & integers
end

def unique(integers)
  integers.to_set.to_a
end

def unique(integers)
  uniq = []
  for i in integers
    if !uniq.include?i
      uniq.push(i)
    end
  end
  uniq
end

def unique(integers)
  array=[]
  for i in integers
      array<<i unless array.include?(i)
  end
  return array
end
