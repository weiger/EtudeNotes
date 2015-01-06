#begin
Description:

In this kata, you must create a function powers that takes an array, and returns the number of subsets possible to create from that list. In other words, counts the power sets.

For instance

powers([1,2,3]) => 8
...due to...

powerSet([1,2,3]) =>
[[],
 [1],
 [2],
 [3],
 [1,2],
 [2,3],
 [1,3],
 [1,2,3]]
 #end
 
def powers(list)
  2 ** list.length
end

def powers(list)
  p list
  res = 0
  (list.size + 1).times do|i|
    res += list.combination(i).to_a.count
  end
  res
end
