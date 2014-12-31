#begin
Description:

Return an array containing the numbers from 1 to N, where N is the parametered value. N will never be less than 1.

Replace certain values however if any of the following conditions are met:

If the value is a multiple of 3: use the value 'Fizz' instead
If the value is a multiple of 5: use the value 'Buzz' instead
If the value is a multiple of 3 & 5: use the value 'FizzBuzz' instead
#end

def fizzbuzz(n)
  (1..n).map { |x| 
    y = ''
    y += 'Fizz' if x % 3 == 0
    y += 'Buzz' if x % 5 == 0
    y == '' ? x : y
  }
end

def fizzbuzz(n)
  (1..n).map { |x| x%15==0 ? "FizzBuzz" : x%5==0 ? "Buzz" : x%3==0 ? "Fizz" : x }
end

def fizzbuzz(n)
  (1..n).map { |x|
    if ( x % 3 == 0 and x % 5 == 0 ) then 'FizzBuzz'
    elsif ( x % 3 == 0 ) then 'Fizz'
    elsif ( x % 5 == 0 ) then 'Buzz'
    else x
    end
  }
end

def fizzbuzz(n)
  res = []
  x = 1
  while (x<=n)
    if( x%3 == 0 && x%5 ==0)
      res.push("FizzBuzz")
    elsif (x %3 ==0)
      res.push("Fizz")
    elsif (x%5 ==0)
      res.push("Buzz")
    else
      res << x
    end
    x = x + 1
  end
  res
end
