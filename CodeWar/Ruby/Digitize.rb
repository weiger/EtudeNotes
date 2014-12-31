#begin
Description:
Given a non-negative integer, return an array / a list of the individual digits in order.

Examples:
123 => [1,2,3]
1 => [1]
8675309 => [8,6,7,5,3,0,9]
#end

def digitize(n)
  res = []
  n.to_s.chars.each {|x| res.push(Integer(x))}
  res
end

def digitize(n)
  n.to_s.chars.map(&:to_i)
end

def digitize(n)
  n.to_s.split("").map(&:to_i)
end
