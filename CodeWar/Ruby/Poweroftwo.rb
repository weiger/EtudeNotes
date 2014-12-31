#begin
Description:
Write a body of function power_of_two?(x) (javascript isPowerOfTwo) which has to return true if the given natural number is 
power of 2 or false if the number is not power of 2. The given number is always greater than 0.
power_of_two?(4096) # true
power_of_two?(333) # false
#end

def power_of_two?(n)
  n & (n-1) == 0
end

def power_of_two?(x)
  Math.log2(x) % 1 == 0
end

def power_of_two?(x)
  while x%2==0 do
    x=x/2
  end
  x==1
end
