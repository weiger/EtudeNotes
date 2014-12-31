#begin
Description:

Complete the solution so that it returns a String in the format:
"Key (Value), Key (Value)"
From a hash for values within the given range, sorted by value lowest to highest.

For example:
food = {
  "Hamburger"=>1.99,
  "Cheese"=>0.99,
  "Steak"=>4.99,
  "Lobster"=>7.99,
  "Fries"=>1.49,
  "Sandwich"=>2.49
}
list_in_range(food, (0.99..1.99)) # should return "Cheese (0.99), Fries (1.49), Hamburger (1.99)"
#end

def list_in_range(hash, range)
  hash.select { |k, v| range.include? v }.sort_by { |k, v| v }.map { |k, v| "#{k} (#{v})" }.join ', '
end

def list_in_range(hash, range)
  string = ""
  hash.sort_by { |key, value| value }.each { |key, value| string += "#{key} (#{value}), " if range === value }
  string.chomp(', ')
end

def list_in_range(hash, range)
  # Return a string of the values from the hash within the given range
  # in the format Key (Value), Key (Value)
  hash.sort_by {|key, value| value}.select { |k, v| v >= range.min && v <= range.max}.to_a.map { |key, val| "#{key} (#{val})" }.join(", ")
end

