#begin
Description:

Write a function that flattens an Array of Array objects into a flat Array. Your function must only do one level of flattening.

flatten [1,2,3] # => [1,2,3]
flatten [[1,2,3],["a","b","c"],[1,2,3]]  # => [1,2,3,"a","b","c",1,2,3]
flatten [[[1,2,3]]] # => [[1,2,3]]
#end

def flatten(array)
  array.flatten 1
end

def flatten(array)
  array.reduce([]) do |a, e|
    if e.is_a? Array
      a + e
    else
      a + [e]
    end
  end
end

def flatten(array)
  result = []
  array.each do |i|
    if i.is_a? Array
      result.concat(i)
    else
      result << i
    end
  end
  result
end
