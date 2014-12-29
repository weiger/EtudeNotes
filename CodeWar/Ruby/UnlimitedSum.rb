#begin

Description:
Write a method sum that accepts an unlimited number of integer arguments, and adds all of them together.
The method should reject any arguments that are not integers, and sum the remaining integers.
sum(1,2,3)
# => 6

#end

def sum *n
  sum = 0
  n.each{|i| sum = sum + i if i.is_a?(Integer) }
  sum
end

def sum(*args)
  args.select { |x| x.is_a?(Integer) }.reduce(:+)
end
