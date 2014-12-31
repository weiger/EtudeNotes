#begin
Description:

Write a method that takes one argument as name and then greets that name, capitalized and ends with an exclamation point.

Example
greet("maya") # returns "Hello Maya!"
greet("JACK") # returns "Hello Jack!"
#end

def greet(name)
  "Hello " + name.to_s.capitalize + "!"
end

def greet(name)
"Hello #{name.capitalize}!"
end

def greet(name)
  "Hello %s!" % name.capitalize
end
