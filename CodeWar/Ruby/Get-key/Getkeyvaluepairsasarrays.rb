#begin
Complete the keysAndValues function so that it takes in an object and returns the keys and values as separate arrays.

Example:

keysAndValues({a: 1, b: 2, c: 3}) # should return [[:a, :b, :c], [1, 2, 3]]
Style Points (JS/CoffeeScript only): This kata only tests for data that uses object literal notation (simple objects). 
For extra style, can you get your method to check for objects that extend their prototype?
#end

def keysAndValues(data)
  [data.keys, data.values]
end

def keysAndValues(data)
  data.to_a.transpose
end

def keysAndValues(data)
  a = data.keys.to_a
  b = data.values.to_a
  return a, b
end
